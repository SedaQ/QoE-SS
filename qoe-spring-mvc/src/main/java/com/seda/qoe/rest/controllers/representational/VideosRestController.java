package com.seda.qoe.rest.controllers.representational;

import java.util.Collection;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.facade.VideoFacade;
import com.seda.qoe.rest.endpoints.ApiEndPoints;
import com.seda.qoe.rest.exceptions.ResourceNotFoundException;

/**
 * REST Controller for Videos
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiEndPoints.ROOT_URI_VIDEOS)
public class VideosRestController {

	@Inject
	private VideoFacade videoFacade;

	/**
	 * returns all videos according to a Summary View
	 * 
	 * @return list of VideoDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<VideoDTO> getVideos()
			throws JsonProcessingException {
		try {
			// logger.debug("rest getUsers()");
			return videoFacade.getAllVideo();
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}

	/**
	 * get videos by id curl -i -X GET
	 * http://localhost:8080/qoe/rest/videos/{id}
	 * 
	 * @param id
	 * @param webRequest
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final VideoDTO getVideoById(@PathVariable("id") long id,
			WebRequest webRequest) {
		try {
			return videoFacade.getVideoById(id);
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
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
	public final Collection<ScenarioDTO> getVideoScenariosByVideoId(@PathVariable("id") long id,
			WebRequest webRequest) {
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
