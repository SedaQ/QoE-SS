package com.seda.qoe.rest.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.rest.controllers.MosController;

/**
 * 
 * @author Pavel Šeda
 */
@Component
public class MosResourceAssembler implements ResourceAssembler<MosDTO, Resource<MosDTO>>{

	@Override
	public Resource<MosDTO> toResource(MosDTO mosDTO) {
		Long id = mosDTO.getId();
        Resource<MosDTO> mosResource = new Resource<MosDTO>(mosDTO);

        try {
        	mosResource.add(linkTo(MosController.class).slash(id).withSelfRel());
        	mosResource.add(linkTo(MosController.class).slash(id).slash("questionary").withRel("questionary"));
        	mosResource.add(linkTo(MosController.class).slash(id).slash("video").withRel("video"));
        	mosResource.add(linkTo(MosController.class).slash(id).slash("scenario").withRel("scenario"));
        	mosResource.add(linkTo(MosController.class).slash(id).withRel("DELETE"));
        	mosResource.add(linkTo(MosController.class).slash("update").withRel("PUT"));

        } catch (Exception ex) {
        }
        
        return mosResource;
	}

}
