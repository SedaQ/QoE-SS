package com.seda.qoe.rest.controllers.representational;

import com.seda.qoe.dto.user.UserCreateDTO;
import com.seda.qoe.dto.user.UserDTO;
import com.seda.qoe.facade.UserFacade;
import com.seda.qoe.rest.endpoints.ApiEndPoints;
import com.seda.qoe.rest.exceptions.ResourceAlreadyExistingException;
import com.seda.qoe.rest.exceptions.ResourceNotFoundException;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 * REST Controller for Users
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiEndPoints.ROOT_URI_USERS)
public class UsersRestController {

	@Inject
	private UserFacade userFacade;

	/**
	 * returns all users according to a Summary View
	 * 
	 * @return list of UserDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<UserDTO> getUsers() throws JsonProcessingException {
		// logger.debug("rest getUsers()");
		try {
			return userFacade.getAllUsers();
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}
	
	/**
	 * Create a new user by POST method
     * curl -X POST -i -H "Content-Type: application/json" --data 
     * '{"email":"pavelseda@seznam.cz","password":"EncryptedPassword1234"}' 
     * http://localhost:8080/rest/users

	 * @param user
	 * @return Boolean if user is created
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Boolean createUser(@RequestBody UserCreateDTO user)
			throws Exception {
		try {
			return userFacade.registerUser(user, user.getPassword());
		} catch (Exception ex) {
			throw new ResourceAlreadyExistingException();
		}
	}

	/**
	 * get user by id (with HTTP caching) curl -i -X GET
	 * http://localhost:8080/qoe/rest/users/{id}
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final UserDTO getUserById(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return userFacade.getUserById(id);
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}

	/**
	 * get user roles by user id (with HTTP caching) curl -i -X GET
	 * http://localhost:8080/qoe/rest/users/{id}/roles
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final String getUserRolesByUserId(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return userFacade.getUserById(id).getRoles();
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}

}
