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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;
import com.seda.qoe.facade.ScenarioParametersFacade;
import com.seda.qoe.rest.assemblers.ScenarioParametersResourceAssembler;
import com.seda.qoe.rest.endpoints.ApiEndPoints;
import com.seda.qoe.rest.exceptions.ResourceNotFoundException;
import com.seda.qoe.rest.exceptions.ResourceNotModifiedException;

/**
 * REST Hateos Controller for ScenarioParameters
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiEndPoints.ROOT_URI_SCENARIO_PARAMETERS_HATEOS)
public class ScenarioParametersRestHateosController {
	@Inject
	private ScenarioParametersFacade scenarioParametersFacade;

	@Inject
	private ScenarioParametersResourceAssembler scenarioParametersResourceAssembler;

	/**
	 * returns all scenarioparameters according to a Summary View
	 * 
	 * @return list of ScenarioParametersDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resources<Resource<ScenarioParametersDTO>>> getQuestionary(@RequestParam(value = "search", required = false) String search)
			throws JsonProcessingException {

		Collection<ScenarioParametersDTO> ScenarioParametersDTO = scenarioParametersFacade
				.getAllScenarioParameters(search);
		Collection<Resource<ScenarioParametersDTO>> mosResourceCollection = new ArrayList<Resource<ScenarioParametersDTO>>();
		for (ScenarioParametersDTO m : ScenarioParametersDTO) {
			mosResourceCollection.add(scenarioParametersResourceAssembler
					.toResource(m));
		}

		Resources<Resource<ScenarioParametersDTO>> scenarioParametersResources = new Resources<Resource<ScenarioParametersDTO>>(
				mosResourceCollection);
		scenarioParametersResources.add(linkTo(
				ScenarioParametersRestHateosController.class).withSelfRel());

		return new ResponseEntity<Resources<Resource<ScenarioParametersDTO>>>(
				scenarioParametersResources, HttpStatus.OK);
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
	public final HttpEntity<Resource<ScenarioParametersDTO>> getMosById(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			ScenarioParametersDTO ScenarioParametersDTO = scenarioParametersFacade
					.getScenarioParametersById(id);
			if (ScenarioParametersDTO == null)
				throw new ResourceNotFoundException();

			Resource<ScenarioParametersDTO> resource = scenarioParametersResourceAssembler
					.toResource(ScenarioParametersDTO);

			final StringBuffer eTag = new StringBuffer("\"");
			eTag.append(Integer.toString(ScenarioParametersDTO.hashCode()));
			eTag.append('\"');

			if (webRequest.checkNotModified(eTag.toString())) {
				throw new ResourceNotModifiedException();
			}

			return ResponseEntity.ok().eTag(eTag.toString()).body(resource);
		} catch (Exception ex) {
			throw new ResourceNotFoundException(ex);
		}
	}

}
