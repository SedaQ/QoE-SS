package cz.vutbr.feec.seda.service;

import java.util.List;

import cz.vutbr.feec.seda.entity.User;


/**
 * @author Pavel Šeda (441048)
 *
 */
public interface UserService {
	
	/**
	 * finds specific user by id
	 * 
	 * @param id
	 *            of a user that would be returned
	 * @return specific user by id
	 */
	public User findById(Long id);

	/**
	 * Returns all user in language school
	 * 
	 * @return List of user which are in language school
	 */
	public List<User> findAll(String search);

	/**
	 * Find specific user by his email
	 * 
	 * @param email
	 *            email to search in String format
	 * @return return specific user by his email
	 */
	public User findByEmail(String email);

	/**
	 * updates given user
	 * 
	 * @param c
	 *            user that has to be updated
	 * @return updated user
	 */
	public User update(User c);

	/**
	 * removes given user
	 * 
	 * @param c
	 *            user that has to be removed
	 */
	public void remove(User c);

	/**
	 * Register the given user with the given unencrypted password.
	 */
	public void registerUser(User u, String unencryptedPassword);

	/**
	 * Try to authenticate a user. Return true only if the hashed password
	 * matches the records.
	 */
	public boolean authenticate(User u, String password);

	/**
	 * Check if the given user is admin.
	 */
	public boolean isAdmin(User u);

}
