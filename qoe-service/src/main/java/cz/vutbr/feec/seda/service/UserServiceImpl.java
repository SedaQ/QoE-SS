package cz.vutbr.feec.seda.service;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.inject.Inject;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import cz.vutbr.feec.seda.dao.UserRepository;
import cz.vutbr.feec.seda.entity.User;
import cz.vutbr.feec.seda.enums.UserRoles;
import cz.vutbr.feec.seda.exceptions.ServiceLayerException;
import cz.vutbr.feec.seda.security.AESCipher;
import cz.vutbr.feec.seda.specification.RsqlVisitor;


/**
 * @author Pavel Šeda (441048)
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userDao;

	private AESCipher encryptDecrypt;
	//private UserPasswordEncryption userPasswordEncryption;
	
	@Inject
	public UserServiceImpl(UserRepository userDao, AESCipher encryptDecrypt) {
		this.userDao = userDao;
		this.encryptDecrypt = encryptDecrypt;
	}

	@Override
	public void registerUser(User u, String unencryptedPassword) {
		if (u == null)
			throw new IllegalArgumentException("User u parameter is null");
		if (unencryptedPassword == null)
			throw new IllegalArgumentException("String unencryptedPassword parameter is null");
		try {
			// u.setPasswordHash(userPasswordEncryption.createHash(unencryptedPassword)); // was with UserPasswordEncryption
			u.setPasswordHash(encryptDecrypt.encrypt(unencryptedPassword));
			userDao.save(u);
		} catch (RuntimeException ex) {
			throw new ServiceLayerException("Problem with registering LS-User, see inner exception.", ex);
		} catch (InvalidKeyException e) {
			throw new ServiceLayerException("Problem with registering LS-User, see inner exception.", e);
		} catch (NoSuchAlgorithmException e) {
			throw new ServiceLayerException("Problem with registering LS-User, see inner exception.", e);
		} catch (NoSuchPaddingException e) {
			throw new ServiceLayerException("Problem with registering LS-User, see inner exception.", e);
		} catch (IllegalBlockSizeException e) {
			throw new ServiceLayerException("Problem with registering LS-User, see inner exception.", e);
		} catch (BadPaddingException e) {
			throw new ServiceLayerException("Problem with registering LS-User, see inner exception.", e);
		} catch (IOException e) {
			throw new ServiceLayerException("Problem with registering LS-User, see inner exception.", e);
		}
	}

	@Override
	public boolean authenticate(User u, String password) {
		if (u == null)
			throw new IllegalArgumentException("User u parameter is null");
		if (password == null)
			throw new IllegalArgumentException("String password parameter is null");

		try {
			//return userPasswordEncryption.validatePassword(password, u.getPasswordHash()); // was with UserPasswordEncryption
			return encryptDecrypt.validatePassword(password, u.getPasswordHash());
		} catch (RuntimeException e) {
			throw new ServiceLayerException("Problem with authenticating User, see inner exception.", e);
		} catch (InvalidKeyException e) {
			throw new ServiceLayerException("Problem with authenticating User, see inner exception.", e);
		} catch (InvalidAlgorithmParameterException e) {
			throw new ServiceLayerException("Problem with authenticating User, see inner exception.", e);
		} catch (NoSuchAlgorithmException e) {
			throw new ServiceLayerException("Problem with authenticating User, see inner exception.", e);
		} catch (NoSuchPaddingException e) {
			throw new ServiceLayerException("Problem with authenticating User, see inner exception.", e);
		} catch (IllegalBlockSizeException e) {
			throw new ServiceLayerException("Problem with authenticating User, see inner exception.", e);
		} catch (BadPaddingException e) {
			throw new ServiceLayerException("Problem with authenticating User, see inner exception.", e);
		}
	}

	@Override
	public User findById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Long id parameter is null");

		try {
			return userDao.findOne(id);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding User, see inner exception.", ex);
		}
	}

	@Override
	public User update(User c) {
		if (c == null)
			throw new IllegalArgumentException("User c parameter is null");

		try {
			return userDao.save(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with updating User, see inner exception.", ex);
		}
	}

	@Override
	public void remove(User c) {
		if (c == null)
			throw new IllegalArgumentException("User c parameter is null");
		try {
			userDao.delete(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with deleting User, see inner exception.", ex);
		}
	}

	@Override
	public List<User> findAll(String search) {
		try {
			if(search !=null && !search.isEmpty()){
				final Node rootNode = new RSQLParser().parse(search);
	            Specification<User> spec = rootNode.accept(new RsqlVisitor<User>());
	            return userDao.findAll(spec);
			} else{
				return userDao.findAll();
			}
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding User, see inner exception.", ex);
		}
	}

	@Override
	public User findByEmail(String email) {
		if (email == null)
			throw new IllegalArgumentException("String email parameter is null");

		try {
			return userDao.findByEmail(email);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding User, see inner exception.", ex);
		}
	}

	@Override
	public boolean isAdmin(User u) {
		if (u == null)
			throw new IllegalArgumentException("User u parameter is null");
		try {
			return userDao.findByEmail(u.getEmail()).getRoles().equals(UserRoles.ROLE_ADMIN.name());
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding User, see inner exception.", ex);
		}
	}

}
