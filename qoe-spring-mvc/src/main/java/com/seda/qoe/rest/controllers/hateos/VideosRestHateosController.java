package com.seda.qoe.rest.controllers.hateos;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.video.VideoCreateDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.facade.VideoFacade;
import com.seda.qoe.rest.assemblers.VideoResourceAssembler;
import com.seda.qoe.rest.endpoints.ApiHateosEndPoints;
import com.seda.qoe.rest.exceptions.ResourceAlreadyExistingException;
import com.seda.qoe.rest.exceptions.ResourceNotFoundException;
import com.seda.qoe.rest.exceptions.ResourceNotModifiedException;

/**
 * REST Hateos Controller for Videos
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiHateosEndPoints.ROOT_URI_VIDEOS_HATEOS)
public class VideosRestHateosController {

	@Inject
	private VideoFacade videoFacade;

	@Inject
	private VideoResourceAssembler videoResourceAssembler;

	/**
	 * returns all video according to a Summary View
	 * 
	 * @return list of VideosDTO
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resources<Resource<VideoDTO>>> getVideos()
			throws JsonProcessingException {

		Collection<VideoDTO> videosDTO = videoFacade.getAllVideo();
		Collection<Resource<VideoDTO>> videosResourceCollection = new ArrayList<Resource<VideoDTO>>();
		for (VideoDTO v : videosDTO) {
			videosResourceCollection.add(videoResourceAssembler.toResource(v));
		}

		Resources<Resource<VideoDTO>> videoResource = new Resources<Resource<VideoDTO>>(
				videosResourceCollection);
		videoResource.add(linkTo(VideosRestHateosController.class)
				.withSelfRel());

		return new ResponseEntity<Resources<Resource<VideoDTO>>>(videoResource,
				HttpStatus.OK);
	}

	/**
	 * get mos by id curl -i -X GET
	 * http://localhost:8080/qoe/rest/hateos/videos/{id}
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final HttpEntity<Resource<VideoDTO>> getVideoById(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			VideoDTO videoDTO = videoFacade.getVideoById(id);
			if (videoDTO == null)
				throw new ResourceNotFoundException();

			Resource<VideoDTO> resource = videoResourceAssembler
					.toResource(videoDTO);

			final StringBuffer eTag = new StringBuffer("\"");
			eTag.append(Integer.toString(videoDTO.hashCode()));
			eTag.append('\"');

			if (webRequest.checkNotModified(eTag.toString())) {
				throw new ResourceNotModifiedException();
			}

			return ResponseEntity.ok().eTag(eTag.toString()).body(resource);
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final VideoDTO createVideo(@RequestBody VideoCreateDTO video)
			throws Exception {
		try {
			return videoFacade.create(video);
		} catch (Exception ex) {
			throw new ResourceAlreadyExistingException();
		}
	}

	/**
	 * get scenario associated with video by video id curl -i -X GET
	 * http://localhost:8080/qoe/rest/videos/{id}/scenarios
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/scenarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<ScenarioDTO> getVideoScenariosByVideoId(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			return videoFacade.getVideoById(id).getScenario();
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}

	/**
	 * get mos associated with video by video id curl -i -X GET
	 * http://localhost:8080/qoe/rest/videos/{id}/scenarios
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}/mos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Set<MosDTO> getVideoMosByVideoId(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return videoFacade.getVideoById(id).getMos();
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}
}
