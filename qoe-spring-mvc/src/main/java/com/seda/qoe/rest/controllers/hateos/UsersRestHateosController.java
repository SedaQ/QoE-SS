package com.seda.qoe.rest.controllers.hateos;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.user.UserCreateDTO;
import com.seda.qoe.dto.user.UserDTO;
import com.seda.qoe.facade.UserFacade;
import com.seda.qoe.rest.assemblers.UserResourceAssembler;
import com.seda.qoe.rest.endpoints.ApiHateosEndPoints;
import com.seda.qoe.rest.exceptions.ResourceAlreadyExistingException;
import com.seda.qoe.rest.exceptions.ResourceNotFoundException;
import com.seda.qoe.rest.exceptions.ResourceNotModifiedException;

/**
 * REST Hateos Controller for Users
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiHateosEndPoints.ROOT_URI_USERS_HATEOS)
public class UsersRestHateosController {

	@Inject
	private UserFacade userFacade;

	@Inject
	private UserResourceAssembler userResourceAssembler;

	/**
	 * returns all scenarioparameters according to a Summary View
	 * 
	 * @return list of UserDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resources<Resource<UserDTO>>> getUsers()
			throws JsonProcessingException {

		Collection<UserDTO> UserDTO = userFacade.getAllUsers();
		Collection<Resource<UserDTO>> mosResourceCollection = new ArrayList<Resource<UserDTO>>();
		for (UserDTO m : UserDTO) {
			mosResourceCollection.add(userResourceAssembler.toResource(m));
		}

		Resources<Resource<UserDTO>> userResources = new Resources<Resource<UserDTO>>(
				mosResourceCollection);
		userResources
				.add(linkTo(UsersRestHateosController.class).withSelfRel());

		return new ResponseEntity<Resources<Resource<UserDTO>>>(userResources,
				HttpStatus.OK);
	}

	/**
	 * get mos by id curl -i -X GET
	 * http://localhost:8080/qoe/rest/hateos/scenarioparameters/{id}
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resource<UserDTO>> getUserById(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			UserDTO UserDTO = userFacade.getUserById(id);
			if (UserDTO == null)
				throw new ResourceNotFoundException();

			Resource<UserDTO> resource = userResourceAssembler
					.toResource(UserDTO);

			final StringBuffer eTag = new StringBuffer("\"");
			eTag.append(Integer.toString(UserDTO.hashCode()));
			eTag.append('\"');

			if (webRequest.checkNotModified(eTag.toString())) {
				throw new ResourceNotModifiedException();
			}

			return ResponseEntity.ok().eTag(eTag.toString()).body(resource);
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Boolean createUser(@RequestBody UserCreateDTO user)
			throws Exception {
		try {
			return userFacade.registerUser(user, user.getPassword());
		} catch (Exception ex) {
			throw new ResourceAlreadyExistingException();
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
