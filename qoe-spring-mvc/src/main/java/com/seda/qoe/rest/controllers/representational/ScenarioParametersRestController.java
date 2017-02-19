package com.seda.qoe.rest.controllers.representational;

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
import com.seda.qoe.dto.scenarioparameters.ScenarioParametersCreateDTO;
import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;
import com.seda.qoe.facade.ScenarioParametersFacade;
import com.seda.qoe.rest.endpoints.ApiEndPoints;
import com.seda.qoe.rest.exceptions.ResourceAlreadyExistingException;
import com.seda.qoe.rest.exceptions.ResourceNotFoundException;

/**
 * REST Controller for ScenarioParameters
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiEndPoints.ROOT_URI_SCENARIO_PARAMETERS)
public class ScenarioParametersRestController {

	@Inject
	private ScenarioParametersFacade scenarioParametersFacade;

	/**
	 * returns all scenarioparameters according to a Summary View
	 * 
	 * @return list of ScenarioParametersDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<ScenarioParametersDTO> getScenarioParameters()
			throws JsonProcessingException {
		try {
			// logger.debug("rest getUsers()");
			return scenarioParametersFacade.getAllScenarioParameters();
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}
	
	/**
	 * get scenarioparameters by id (with HTTP caching) curl -i -X GET
	 * http://localhost:8080/qoe/rest/scenarioparameters/{id}
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final ScenarioParametersDTO getScenarioParametersById(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return scenarioParametersFacade.getScenarioParametersById(id);
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final ScenarioParametersDTO createScenarioParameters(
			@RequestBody ScenarioParametersCreateDTO scenarioParameters)
			throws Exception {
		try {
			return scenarioParametersFacade.create(scenarioParameters);
		} catch (Exception ex) {
			throw new ResourceAlreadyExistingException();
		}
	}

}
