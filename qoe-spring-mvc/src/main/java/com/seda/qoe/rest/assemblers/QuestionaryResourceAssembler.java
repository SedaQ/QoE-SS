package com.seda.qoe.rest.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.rest.controllers.hateos.QuestionariesRestHateosController;

/**
 * 
 * @author Pavel Šeda
 */
@Component
public class QuestionaryResourceAssembler implements ResourceAssembler<QuestionaryDTO, Resource<QuestionaryDTO>>{

	@Override
	public Resource<QuestionaryDTO> toResource(QuestionaryDTO questionaryDTO) {
		Long id = questionaryDTO.getId();
        Resource<QuestionaryDTO> questionaryResource = new Resource<QuestionaryDTO>(questionaryDTO);

        try {
        	questionaryResource.add(linkTo(QuestionariesRestHateosController.class).slash(id).withSelfRel());
        	questionaryResource.add(linkTo(QuestionariesRestHateosController.class).slash(id).slash("users").withRel("users"));
        	questionaryResource.add(linkTo(QuestionariesRestHateosController.class).slash(id).slash("mos").withRel("mos"));
        	questionaryResource.add(linkTo(QuestionariesRestHateosController.class).slash(id).withRel("DELETE"));
        	questionaryResource.add(linkTo(QuestionariesRestHateosController.class).slash("update").withRel("PUT"));

        } catch (Exception ex) {
        }
        
        return questionaryResource;
	}

}
