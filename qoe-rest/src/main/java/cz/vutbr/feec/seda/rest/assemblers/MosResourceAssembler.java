package cz.vutbr.feec.seda.rest.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;


import cz.vutbr.feec.seda.dto.mos.MosDTO;
import cz.vutbr.feec.seda.rest.controllers.hateos.MosRestHateosController;

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
        	mosResource.add(linkTo(MosRestHateosController.class).slash(id).withSelfRel());
        	mosResource.add(linkTo(MosRestHateosController.class).slash(id).slash("questionaries").withRel("questionaries"));
        	mosResource.add(linkTo(MosRestHateosController.class).slash(id).slash("videos").withRel("videos"));
        	mosResource.add(linkTo(MosRestHateosController.class).slash(id).slash("scenarios").withRel("scenarios"));
        	mosResource.add(linkTo(MosRestHateosController.class).slash(id).withRel("DELETE"));
        	mosResource.add(linkTo(MosRestHateosController.class).slash("update").withRel("PUT"));

        } catch (Exception ex) {
        }
        
        return mosResource;
	}

}
