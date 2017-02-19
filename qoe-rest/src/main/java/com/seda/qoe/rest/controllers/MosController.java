package com.seda.qoe.rest.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.facade.MosFacade;
import com.seda.qoe.rest.ApiUris;
import com.seda.qoe.rest.assemblers.MosResourceAssembler;
import com.seda.qoe.rest.exceptions.ResourceNotFoundException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.http.ResponseEntity;

/**
 * REST Controller for MOS
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_MOS)
public class MosController {

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
	public final HttpEntity<Resources<Resource<MosDTO>>> getMos()
			throws JsonProcessingException {

		Collection<MosDTO> mosDTO = mosFacade.getAllMos();
		Collection<Resource<MosDTO>> mosResourceCollection = new ArrayList<Resource<MosDTO>>();
		for (MosDTO m : mosDTO) {
			mosResourceCollection.add(mosResourceAssembler.toResource(m));
		}

		Resources<Resource<MosDTO>> mosResources = new Resources<Resource<MosDTO>>(
				mosResourceCollection);
		mosResources.add(linkTo(MosController.class).withSelfRel());

		return new ResponseEntity<Resources<Resource<MosDTO>>>(mosResources,
				HttpStatus.OK);
	}

	/**
	 * get mos by id curl -i -X GET http://localhost:8080/qoe/rest/mos/{id}
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final MosDTO getMosById(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return mosFacade.getMosById(id);
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResourceNotFoundException(ex);
		}
	}

	/**
	 * get questionary by mos id curl -i -X GET
	 * http://localhost:8080/qoe/rest/mos/{id}/questionaries
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
			System.out.println(ex);
			throw new ResourceNotFoundException(ex);
		}
	}

	/**
	 * get videos mos by mos id curl -i -X GET
	 * http://localhost:8080/qoe/rest/mos/{id}/videos
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
			System.out.println(ex);
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
			System.out.println(ex);
			throw new ResourceNotFoundException(ex);
		}
	}

}
