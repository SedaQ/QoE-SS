package com.seda.qoe.rest.controllers;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.facade.QuestionaryFacade;
import com.seda.qoe.rest.ApiUris;

/**
 * REST Controller for Questionaries
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_QUESTIONARY)
public class QuestionariesController {

	@Inject
	private QuestionaryFacade questionaryFacade;
	
	/**
	 * returns all questionaries according to a Summary View
	 * 
	 * @return list of QuestionaryDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<QuestionaryDTO> getQuestionaries() throws JsonProcessingException {

		// logger.debug("rest getUsers()");
		return questionaryFacade.getAllQuestionary();
	}
}
