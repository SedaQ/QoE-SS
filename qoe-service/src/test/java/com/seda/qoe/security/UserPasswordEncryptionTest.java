package com.seda.qoe.security;

import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

import com.seda.qoe.config.BeanMappingConfiguration;


/**
 * @author Pavel Šeda (441048)
 *
 */
@ContextConfiguration(classes = BeanMappingConfiguration.class)
public class UserPasswordEncryptionTest extends AbstractTestNGSpringContextTests{

	@Inject
	private UserPasswordEncryption userPwdEncryption;

	private String password;
	private String passwordHash;

	@BeforeClass()
	public void init() {
		password = "testPassword";
	}

//	@Test
//	public void testCreateHash() {
//		passwordHash = userPwdEncryption.createHash(password);
//		Assert.assertNotEquals(password, passwordHash);
//	}
//
//	@Test
//	public void testValidatePassword() {
//		Assert.assertTrue(userPwdEncryption.validatePassword(password, passwordHash));
//	}

}
