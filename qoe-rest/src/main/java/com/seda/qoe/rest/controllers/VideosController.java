package com.seda.qoe.rest.controllers;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.facade.VideoFacade;
import com.seda.qoe.rest.ApiUris;

/**
 * REST Controller for Videos
 * 
 * @author Pavel Šeda
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_VIDEOS)
public class VideosController {

	@Inject
	private VideoFacade videoFacade;

	/**
	 * returns all videos according to a Summary View
	 * 
	 * @return list of VideoDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<VideoDTO> getUsers() throws JsonProcessingException {

		// logger.debug("rest getUsers()");
		return videoFacade.getAllVideo();
	}
}
