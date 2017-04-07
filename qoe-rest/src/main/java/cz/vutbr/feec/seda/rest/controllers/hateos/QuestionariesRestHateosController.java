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
import cz.vutbr.feec.seda.dto.questionary.QuestionaryCreateDTO;
import cz.vutbr.feec.seda.dto.questionary.QuestionaryDTO;
import cz.vutbr.feec.seda.dto.user.UserDTO;
import cz.vutbr.feec.seda.facade.QuestionaryFacade;
import cz.vutbr.feec.seda.rest.assemblers.QuestionaryResourceAssembler;
import cz.vutbr.feec.seda.rest.endpoints.ApiHateosEndPoints;
import cz.vutbr.feec.seda.rest.exceptions.ResourceAlreadyExistingException;
import cz.vutbr.feec.seda.rest.exceptions.ResourceNotFoundException;
import cz.vutbr.feec.seda.rest.exceptions.ResourceNotModifiedException;


/**
 * REST Hateos Controller for Questionary
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiHateosEndPoints.ROOT_URI_QUESTIONARY_HATEOS)
public class QuestionariesRestHateosController {

	@Inject
	private QuestionaryFacade questionaryFacade;

	@Inject
	private QuestionaryResourceAssembler questionaryResourceAssembler;

	/**
	 * returns all mos according to a Summary View
	 * 
	 * @return list of QuestionaryDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resources<Resource<QuestionaryDTO>>> getQuestionary(@RequestParam("search") String search)
			throws JsonProcessingException {
		Collection<QuestionaryDTO> questionaryDTO = questionaryFacade.getAllQuestionary(search);
		Collection<Resource<QuestionaryDTO>> mosResourceCollection = new ArrayList<Resource<QuestionaryDTO>>();
		for (QuestionaryDTO m : questionaryDTO) {
			mosResourceCollection.add(questionaryResourceAssembler.toResource(m));
		}
		Resources<Resource<QuestionaryDTO>> questionaryResources = new Resources<Resource<QuestionaryDTO>>(
				mosResourceCollection);
		questionaryResources.add(linkTo(QuestionariesRestHateosController.class).withSelfRel());

		return new ResponseEntity<Resources<Resource<QuestionaryDTO>>>(questionaryResources,
				HttpStatus.OK);
	}
	
	/**
	 * Create a new questionary by POST method curl -X POST -i -H
	 * "Content-Type: application/json" --data '{"age":"24","gender":"muz","school":"stredni_skola","userConnection":"mobilni_data"}'
	 * 
	 * http://localhost:8080/qoe/questionaries
	 * 
	 * or with entity references:
	 * 
	 *  {"age":"29","gender":"muze","school":"stredni_skolaa","userConnection":"mobilnieee_data","user":{"id":"1"}}
	 *
	 * @param questionary
	 *            QuestionaryCreateDTO with required fields for creation
	 * @return the created questionary QuestionaryCreateDTO
	 * @throws ResourceAlreadyExistingException
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final QuestionaryDTO createQuestionary(
			@RequestBody QuestionaryCreateDTO questionary) throws Exception {
		try {
			return questionaryFacade.create(questionary);
		} catch (Exception ex) {
			throw new ResourceAlreadyExistingException(ex);
		}
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
	public final HttpEntity<Resource<QuestionaryDTO>> getMosById(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			QuestionaryDTO QuestionaryDTO = questionaryFacade.getQuestionaryById(id);
			if (QuestionaryDTO == null)
				throw new ResourceNotFoundException();

			Resource<QuestionaryDTO> resource = questionaryResourceAssembler.toResource(QuestionaryDTO);

			final StringBuffer eTag = new StringBuffer("\"");
			eTag.append(Integer.toString(QuestionaryDTO.hashCode()));
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
			throw new ResourceNotFoundException(ex);
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
			throw new ResourceNotFoundException(ex);
		}
	}

}
