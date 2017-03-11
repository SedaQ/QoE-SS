package com.seda.qoe.rest.assemblers;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.rest.controllers.hateos.VideosRestHateosController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author Pavel Šeda (441048)
 *
 */
@Component
public class VideoResourceAssembler implements ResourceAssembler<VideoDTO, Resource<VideoDTO>>{

	@Override
	public Resource<VideoDTO> toResource(VideoDTO videoDTO) {
		Long id = videoDTO.getId();
        Resource<VideoDTO> videoResource = new Resource<VideoDTO>(videoDTO);

        try {
        	videoResource.add(linkTo(VideosRestHateosController.class).slash(id).withSelfRel());
        	videoResource.add(linkTo(VideosRestHateosController.class).slash(id).slash("scenario").withRel("scenario"));
        	videoResource.add(linkTo(VideosRestHateosController.class).slash(id).slash("mos").withRel("mos"));
        	videoResource.add(linkTo(VideosRestHateosController.class).slash(id).withRel("DELETE"));
        	videoResource.add(linkTo(VideosRestHateosController.class).slash("update").withRel("PUT"));

        } catch (Exception ex) {

        }

        return videoResource;

	}

}
