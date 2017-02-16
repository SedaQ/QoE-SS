package com.seda.qoe.rest.controllers;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;
import com.seda.qoe.facade.ScenarioParametersFacade;
import com.seda.qoe.rest.ApiUris;

/**
 * REST Controller for ScenarioParameters
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_SCENARIO_PARAMETERS)
public class ScenarioParametersController {

	@Inject
	private ScenarioParametersFacade scenarioParametersFacade;
	
	/**
	 * returns all scenarioparameters according to a Summary View
	 * 
	 * @return list of ScenarioParametersDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<ScenarioParametersDTO> getScenarioParameters() throws JsonProcessingException {

		// logger.debug("rest getUsers()");
		return scenarioParametersFacade.getAllScenarioParameters();
	}	
	
}
