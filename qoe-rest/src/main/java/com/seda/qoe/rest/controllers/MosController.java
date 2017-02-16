package com.seda.qoe.rest.controllers;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.facade.MosFacade;
import com.seda.qoe.rest.ApiUris;

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
	
	/**
	 * returns all mos according to a Summary View
	 * 
	 * @return list of MosDTOs
	 * @throws JsonProcessingException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<MosDTO> getMos() throws JsonProcessingException {

		// logger.debug("rest getUsers()");
		return mosFacade.getAllMos();
	}
	
}
