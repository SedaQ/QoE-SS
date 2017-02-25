package com.seda.qoe.rest.controllers;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.facade.ScenarioFacade;
import com.seda.qoe.rest.ApiUris;
import com.seda.qoe.rest.exceptions.ResourceNotFoundException;

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
	public final Collection<ScenarioDTO> getUsers()
			throws JsonProcessingException {
		try {
			// logger.debug("rest getUsers()");
			Collection<ScenarioDTO> scenario = scenarioFacade.getAllScenario();
			for(ScenarioDTO s : scenario){
			}
			
			return scenarioFacade.getAllScenario();
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResourceNotFoundException(ex);
		}

	}
	
	/**
	 * get scenario by id (with HTTP caching) curl -i -X GET
	 * http://localhost:8080/qoe/rest/scenarios/{id}
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final ScenarioDTO getScenarioById(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return scenarioFacade.getScenarioById(id);
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResourceNotFoundException(ex);
		}
	}
	
	/**
	 * get scenarioparameters by scenario id curl -i -X GET
	 * http://localhost:8080/qoe/rest/scenarios/{id}/scenarioparameters
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/scenarioparameters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<ScenarioParametersDTO> getScenarioParametersByScenarioId(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return scenarioFacade.getScenarioById(id).getScenarioparameters();
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResourceNotFoundException(ex);
		}
	}
	
	/**
	 * get videos by scenario id curl -i -X GET
	 * http://localhost:8080/qoe/rest/scenarios/{id}/videos
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/videos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<VideoDTO> getVideoByScenarioId(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return scenarioFacade.getScenarioById(id).getVideo();
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResourceNotFoundException(ex);
		}
	}

}
