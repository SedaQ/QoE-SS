package com.seda.qoe.rest.controllers;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.questionary.QuestionaryCreateDTO;
import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.dto.user.UserDTO;
import com.seda.qoe.facade.QuestionaryFacade;
import com.seda.qoe.rest.ApiEndPoints;
import com.seda.qoe.rest.exceptions.ResourceAlreadyExistingException;
import com.seda.qoe.rest.exceptions.ResourceNotFoundException;

/**
 * REST Controller for Questionaries
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiEndPoints.ROOT_URI_QUESTIONARY)
public class QuestionariesRestController {

	@Inject
	private QuestionaryFacade questionaryFacade;

	/**
	 * returns all questionaries according to a Summary View
	 * 
	 * @return list of QuestionaryDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<QuestionaryDTO> getQuestionaries()
			throws JsonProcessingException {
		try {
			// logger.debug("rest getUsers()");
			return questionaryFacade.getAllQuestionary();
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}

	/**
	 * get questionaries by id (with HTTP caching) curl -i -X GET
	 * http://localhost:8080/qoe/rest/questionaries/{id}
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final QuestionaryDTO getQuestionaryById(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return questionaryFacade.getQuestionaryById(id);
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}

	/**
	 * get user by id of specific questionary(with HTTP caching) curl -i -X GET
	 * http://localhost:8080/qoe/rest/questionaries/{id}/users
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final UserDTO getQuestionaryUser(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return questionaryFacade.getQuestionaryById(id).getUser();
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}

	/**
	 * get mos by id of specific questionary (with HTTP caching) curl -i -X GET
	 * http://localhost:8080/qoe/rest/questionaries/{id}/mos
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/mos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final MosDTO getQuestionaryMos(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return questionaryFacade.getQuestionaryById(id).getMos();
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}

	/**
	 * Create a new questionary by POST method curl -X POST -i -H
	 * "Content-Type: application/json" --data
	 * 
	 * http://localhost:8080/qoe/questionaries/create
	 * 
	 * @param product
	 *            ProductCreateDTO with required fields for creation
	 * @return the created product ProductDTO
	 * @throws ResourceAlreadyExistingException
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final QuestionaryDTO createQuestionary(
			@RequestBody QuestionaryCreateDTO questionary) throws Exception {
		try {
			return questionaryFacade.create(questionary);
		} catch (Exception ex) {
			throw new ResourceAlreadyExistingException();
		}
	}

}
