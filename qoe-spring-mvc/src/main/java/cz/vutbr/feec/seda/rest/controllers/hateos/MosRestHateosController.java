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

import cz.vutbr.feec.seda.dto.mos.MosCreateDTO;
import cz.vutbr.feec.seda.dto.mos.MosDTO;
import cz.vutbr.feec.seda.dto.questionary.QuestionaryDTO;
import cz.vutbr.feec.seda.dto.scenario.ScenarioDTO;
import cz.vutbr.feec.seda.dto.video.VideoDTO;
import cz.vutbr.feec.seda.facade.MosFacade;
import cz.vutbr.feec.seda.rest.assemblers.MosResourceAssembler;
import cz.vutbr.feec.seda.rest.endpoints.ApiEndPoints;
import cz.vutbr.feec.seda.rest.exceptions.InvalidParameterException;
import cz.vutbr.feec.seda.rest.exceptions.ResourceNotFoundException;
import cz.vutbr.feec.seda.rest.exceptions.ResourceNotModifiedException;

/**
 * REST Hateos Controller for MOS
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiEndPoints.ROOT_URI_MOS_HATEOS)
public class MosRestHateosController {

	@Inject
	private MosFacade mosFacade;

	@Inject
	private MosResourceAssembler mosResourceAssembler;

	/**
	 * returns all mos according to a Summary View
	 * 
	 * @return list of MosDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resources<Resource<MosDTO>>> getMos(
			@RequestParam(value = "search", required = false) String search)
			throws JsonProcessingException {

		Collection<MosDTO> mosDTO = mosFacade.getAllMos(search);
		Collection<Resource<MosDTO>> mosResourceCollection = new ArrayList<Resource<MosDTO>>();
		for (MosDTO m : mosDTO) {
			mosResourceCollection.add(mosResourceAssembler.toResource(m));
		}

		Resources<Resource<MosDTO>> mosResources = new Resources<Resource<MosDTO>>(
				mosResourceCollection);
		mosResources.add(linkTo(MosRestHateosController.class).withSelfRel());

		return new ResponseEntity<Resources<Resource<MosDTO>>>(mosResources,
				HttpStatus.OK);
	}

	/**
	 * POST ~/mos curl -X POST -i -H "Content-Type: application/json" --data
	 * '{"mosValue":"5"}'
	 * 
	 * or with entity referencies
	 * 
	 * {"mosValue":"2","questionary":{"id":"1"},
	 * "scenario":{"id":"2"},"video":{"id":"9"}}
	 * http://localhost:8080/rest/hateos/mos
	 * 
	 * @param mos
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final MosDTO createMos(@RequestBody MosCreateDTO mos) {

		// if(mosFacade.getMosById(mos.getId()) != null)
		// throw new ResourceAlreadyExistingException();
		MosDTO created = mosFacade.create(mos);
		if (created != null)
			return created;
		else
			throw new InvalidParameterException();
	}

	/**
	 * get mos by id curl -i -X GET
	 * http://localhost:8080/qoe/rest/hateos/mos/{id}
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resource<MosDTO>> getMosById(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			MosDTO mosDTO = mosFacade.getMosById(id);
			if (mosDTO == null)
				throw new ResourceNotFoundException();

			Resource<MosDTO> resource = mosResourceAssembler.toResource(mosDTO);

			final StringBuffer eTag = new StringBuffer("\"");
			eTag.append(Integer.toString(mosDTO.hashCode()));
			eTag.append('\"');

			if (webRequest.checkNotModified(eTag.toString())) {
				throw new ResourceNotModifiedException();
			}

			return ResponseEntity.ok().eTag(eTag.toString()).body(resource);
		} catch (Exception ex) {
			throw new ResourceNotFoundException(ex);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final void deleteMos(@PathVariable("id") long id) {

		MosDTO mosDTO = mosFacade.getMosById(id);
		if (mosDTO == null)
			throw new ResourceNotFoundException();

		Boolean deleted = mosFacade.deleteMos(mosDTO.getId());

		if (!deleted)
			throw new ResourceNotFoundException();
	}

	/**
	 * get questionary by mos id curl -i -X GET
	 * http://localhost:8080/qoe/rest/hateos/mos/{id}/questionaries
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/questionaries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final QuestionaryDTO getQuestionaryByMosId(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			return mosFacade.getMosById(id).getQuestionary();
		} catch (Exception ex) {
			throw new ResourceNotFoundException(ex);
		}
	}

	/**
	 * get videos mos by mos id curl -i -X GET
	 * http://localhost:8080/qoe/rest/hateos/mos/{id}/videos
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/videos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final VideoDTO getVideoByMosId(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return mosFacade.getMosById(id).getVideo();
		} catch (Exception ex) {
			throw new ResourceNotFoundException(ex);
		}
	}

	/**
	 * get scenario by mos id curl -i -X GET
	 * http://localhost:8080/qoe/rest/mos/{id}/scenarios
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/scenarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final ScenarioDTO getScenarioByMosId(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return mosFacade.getMosById(id).getScenario();
		} catch (Exception ex) {
			throw new ResourceNotFoundException(ex);
		}
	}

}
