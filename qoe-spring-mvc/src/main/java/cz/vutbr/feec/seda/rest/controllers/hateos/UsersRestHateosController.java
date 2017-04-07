package cz.vutbr.feec.seda.rest.controllers.hateos;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

import cz.vutbr.feec.seda.dto.user.UserCreateDTO;
import cz.vutbr.feec.seda.dto.user.UserDTO;
import cz.vutbr.feec.seda.enums.UserRoles;
import cz.vutbr.feec.seda.facade.UserFacade;
import cz.vutbr.feec.seda.rest.assemblers.UserResourceAssembler;
import cz.vutbr.feec.seda.rest.endpoints.ApiEndPoints;
import cz.vutbr.feec.seda.rest.exceptions.ResourceAlreadyExistingException;
import cz.vutbr.feec.seda.rest.exceptions.ResourceNotFoundException;
import cz.vutbr.feec.seda.rest.exceptions.ResourceNotModifiedException;

/**
 * REST Hateos Controller for Users
 * 
 * @author Pavel Šeda
 */
@RestController
@Api(value = ApiEndPoints.ROOT_URI_USERS_HATEOS, consumes="application/json")
@RequestMapping(ApiEndPoints.ROOT_URI_USERS_HATEOS)
public class UsersRestHateosController {

	@Inject
	private UserFacade userFacade;

	@Inject
	private UserResourceAssembler userResourceAssembler;

	/**
	 * returns all users according to a User View
	 * 
	 * @return list of UserDTOs
	 * @throws JsonProcessingException
	 */
	@ApiOperation(value = "Get information about specific users", 
			notes = "aditional notes",
			httpMethod = "GET",
			produces = "application/json",
			response = UserDTO.class)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resources<Resource<UserDTO>>> getUsers(
			@RequestParam(value = "search", required = false) String search)
			throws JsonProcessingException {

		Collection<UserDTO> userDTO = userFacade.getAllUsers(search);
		Collection<Resource<UserDTO>> mosResourceCollection = new ArrayList<Resource<UserDTO>>();
		for (UserDTO m : userDTO) {
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
	 * Create a new user by POST method curl -X POST -i -H
	 * "Content-Type: application/json" --data
	 * '{"email":"pavelseda@seznam.cz","password":"EncryptedPassword1234"}'
	 * http://localhost:8080/rest/hateos/users
	 * 
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
	 * get mos by id curl -i -X GET
	 * http://localhost:8080/qoe/rest/hateos/scenarioparameters/{id}
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@ApiOperation(value = "Get information about specific user", 
			notes = "aditional notes",
			httpMethod = "GET",
			response = UserDTO.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resource<UserDTO>> getUserById(
			@ApiParam(name = "id", 
					value = "the id of the users resource to be retrieved", 
					required = true) @PathVariable("id") long id,
			WebRequest webRequest) {
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

	/**
	 * get user roles by user id (with HTTP caching) curl -i -X GET
	 * http://localhost:8080/qoe/rest/users/{id}/roles
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<String> getUserRolesByUserId(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			return userFacade.getUserById(id).getRoles();
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}
}
