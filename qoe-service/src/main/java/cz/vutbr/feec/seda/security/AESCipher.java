package cz.vutbr.feec.seda.security;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Named;
import javax.xml.bind.DatatypeConverter;

/**
 * @author Pavel Šeda (441048)
 */
@Named
public class AESCipher {

	private static final String ALGORITMO = "AES/CBC/PKCS5Padding";
	private static final String CODIFICACION = "UTF-8";
	private static final String PRIVATE_KEY = "E1BB465D57CAE7ACDBBE8091F9CE83DF";

	public String encrypt(String plaintext) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		byte[] raw = DatatypeConverter.parseHexBinary(PRIVATE_KEY);
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance(ALGORITMO);
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] cipherText = cipher.doFinal(plaintext.getBytes(CODIFICACION));
		byte[] iv = cipher.getIV();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		outputStream.write(iv);
		outputStream.write(cipherText);
		byte[] finalData = outputStream.toByteArray();
		String encodedFinalData = DatatypeConverter
				.printBase64Binary(finalData);
		return encodedFinalData;
	}

	public String decrypt(String encodedInitialData)
			throws InvalidKeyException, InvalidAlgorithmParameterException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		byte[] encryptedData = DatatypeConverter
				.parseBase64Binary(encodedInitialData);
		byte[] raw = DatatypeConverter.parseHexBinary(PRIVATE_KEY);
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance(ALGORITMO);
		byte[] iv = Arrays.copyOfRange(encryptedData, 0, 16);
		byte[] cipherText = Arrays.copyOfRange(encryptedData, 16,
				encryptedData.length);
		IvParameterSpec iv_specs = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv_specs);
		byte[] plainTextBytes = cipher.doFinal(cipherText);
		String plainText = new String(plainTextBytes);
		return plainText;
	}

	public boolean validatePassword(String password, String userPasswordHash)
			throws InvalidKeyException, InvalidAlgorithmParameterException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		return password.equals(decrypt(userPasswordHash));
	}

}
