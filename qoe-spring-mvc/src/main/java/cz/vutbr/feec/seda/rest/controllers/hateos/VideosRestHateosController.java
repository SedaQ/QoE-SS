package cz.vutbr.feec.seda.rest.controllers.hateos;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import cz.vutbr.feec.seda.dto.scenario.ScenarioDTO;
import cz.vutbr.feec.seda.dto.video.VideoCreateDTO;
import cz.vutbr.feec.seda.dto.video.VideoDTO;
import cz.vutbr.feec.seda.facade.VideoFacade;
import cz.vutbr.feec.seda.rest.assemblers.VideoResourceAssembler;
import cz.vutbr.feec.seda.rest.endpoints.ApiEndPoints;
import cz.vutbr.feec.seda.rest.exceptions.ResourceAlreadyExistingException;
import cz.vutbr.feec.seda.rest.exceptions.ResourceNotFoundException;
import cz.vutbr.feec.seda.rest.exceptions.ResourceNotModifiedException;

/**
 * REST Hateos Controller for Videos
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiEndPoints.ROOT_URI_VIDEOS_HATEOS)
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
	public final HttpEntity<Resources<Resource<VideoDTO>>> getVideos(@RequestParam(value = "search", required = false) String search)
			throws JsonProcessingException {

		Collection<VideoDTO> videosDTO = videoFacade.getAllVideo(search);
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

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final VideoDTO createVideo(@RequestBody VideoCreateDTO video)
			throws Exception {
		try {
			return videoFacade.create(video);
		} catch (Exception ex) {
			throw new ResourceAlreadyExistingException(ex);
		}
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
			throw new ResourceNotFoundException(ex);
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
			throw new ResourceNotFoundException(ex);
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
	public final Collection<MosDTO> getVideoMosByVideoId(
			@PathVariable("id") long id, WebRequest webRequest) {
		try {
			return videoFacade.getVideoById(id).getMos();
		} catch (Exception ex) {
			throw new ResourceNotFoundException(ex);
		}
	}
}
