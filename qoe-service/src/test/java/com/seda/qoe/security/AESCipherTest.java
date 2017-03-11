package com.seda.qoe.security;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seda.qoe.config.BeanMappingConfiguration;


/**
 * @author Pavel Šeda (441048)
 *
 */
@ContextConfiguration(classes = BeanMappingConfiguration.class)
public class AESCipherTest extends AbstractTestNGSpringContextTests {

	@Inject
	private AESCipher userPwdEncryption;

	private String password;
	private String passwordHash;

	@BeforeClass()
	public void init() {
		password = "testPassword";
	}
	
	@Test
	public void testCreateHash() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
		passwordHash = userPwdEncryption.encrypt(password);
		Assert.assertNotEquals(password, passwordHash);
	}

	@Test
	public void testValidatePassword() throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Assert.assertTrue(userPwdEncryption.validatePassword(password, passwordHash));
	}
}