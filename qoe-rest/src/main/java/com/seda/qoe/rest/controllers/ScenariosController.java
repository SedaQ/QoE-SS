package com.seda.qoe.rest.controllers;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.facade.ScenarioFacade;
import com.seda.qoe.rest.ApiUris;

/**
 * REST Controller for Scenarios
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_SCENARIOS)
public class ScenariosController {

	@Inject
	private ScenarioFacade scenarioFacade;

	/**
	 * returns all scenarios according to a Summary View
	 * 
	 * @return list of ScenarioDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<ScenarioDTO> getUsers() throws JsonProcessingException {

		// logger.debug("rest getUsers()");
		return scenarioFacade.getAllScenario();
	}
	
}
