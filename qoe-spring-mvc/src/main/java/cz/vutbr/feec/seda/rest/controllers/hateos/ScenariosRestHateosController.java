package cz.vutbr.feec.seda.rest.controllers.hateos;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

import cz.vutbr.feec.seda.dto.mos.MosDTO;
import cz.vutbr.feec.seda.dto.scenario.ScenarioCreateDTO;
import cz.vutbr.feec.seda.dto.scenario.ScenarioDTO;
import cz.vutbr.feec.seda.dto.scenarioparameters.ScenarioParametersDTO;
import cz.vutbr.feec.seda.dto.video.VideoDTO;
import cz.vutbr.feec.seda.facade.ScenarioFacade;
import cz.vutbr.feec.seda.rest.assemblers.ScenarioResourceAssembler;
import cz.vutbr.feec.seda.rest.endpoints.ApiEndPoints;
import cz.vutbr.feec.seda.rest.exceptions.ResourceAlreadyExistingException;
import cz.vutbr.feec.seda.rest.exceptions.ResourceNotFoundException;
import cz.vutbr.feec.seda.rest.exceptions.ResourceNotModifiedException;

/**
 * REST Hateos Controller for Scenario
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiEndPoints.ROOT_URI_SCENARIOS_HATEOS)
public class ScenariosRestHateosController {
	@Inject
	private ScenarioFacade scenarioFacade;

	@Inject
	private ScenarioResourceAssembler scenarioResourceAssembler;

	/**
	 * returns all scenarioparameters according to a Summary View
	 * 
	 * @return list of ScenarioDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resources<Resource<ScenarioDTO>>> getScenarios(@RequestParam(value = "search", required = false) String search)
			throws JsonProcessingException {
		try {
			Collection<ScenarioDTO> ScenarioDTO = scenarioFacade
					.getAllScenario(search);
			Collection<Resource<ScenarioDTO>> mosResourceCollection = new ArrayList<Resource<ScenarioDTO>>();
			for (ScenarioDTO m : ScenarioDTO) {
				mosResourceCollection.add(scenarioResourceAssembler
						.toResource(m));
			}

			Resources<Resource<ScenarioDTO>> scenarioResources = new Resources<Resource<ScenarioDTO>>(
					mosResourceCollection);
			scenarioResources.add(linkTo(ScenariosRestHateosController.class)
					.withSelfRel());

			return new ResponseEntity<Resources<Resource<ScenarioDTO>>>(
					scenarioResources, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResourceNotFoundException(ex);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final ScenarioDTO createScenario(
			@RequestBody ScenarioCreateDTO scenario) throws Exception {
		try {
			return scenarioFacade.create(scenario);
		} catch (Exception ex) {
			throw new ResourceAlreadyExistingException(ex);
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
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resource<ScenarioDTO>> getScenarioById(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			ScenarioDTO ScenarioDTO = scenarioFacade.getScenarioById(id);
			if (ScenarioDTO == null)
				throw new ResourceNotFoundException();

			Resource<ScenarioDTO> resource = scenarioResourceAssembler
					.toResource(ScenarioDTO);

			final StringBuffer eTag = new StringBuffer("\"");
			eTag.append(Integer.toString(ScenarioDTO.hashCode()));
			eTag.append('\"');

			if (webRequest.checkNotModified(eTag.toString())) {
				throw new ResourceNotModifiedException();
			}

			return ResponseEntity.ok().eTag(eTag.toString()).body(resource);
		} catch (Exception ex) {
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
	public final Collection<ScenarioParametersDTO> getScenarioParametersByScenarioId(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			System.out.println();
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
	public final Collection<VideoDTO> getVideoByScenarioId(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			return scenarioFacade.getScenarioById(id).getVideo();
		} catch (Exception ex) {
			throw new ResourceNotFoundException(ex);
		}
	}

	/**
	 * get mos by scenario id curl -i -X GET
	 * http://localhost:8080/qoe/rest/hateos/scenarios/{id}/mos
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/mos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final MosDTO getMosByScenarioId(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return scenarioFacade.getScenarioById(id).getMos();
		} catch (Exception ex) {
			throw new ResourceNotFoundException(ex);
		}
	}
}
