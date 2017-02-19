package com.seda.qoe.rest.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.rest.controllers.ScenariosController;

/**
 * 
 * @author Pavel Šeda
 */
@Component
public class ScenarioResourceAssembler implements ResourceAssembler<ScenarioDTO, Resource<ScenarioDTO>>{

	@Override
	public Resource<ScenarioDTO> toResource(ScenarioDTO scenarioDTO) {
		Long id = scenarioDTO.getId();
        Resource<ScenarioDTO> scenarioResource = new Resource<ScenarioDTO>(scenarioDTO);

        try {
        	scenarioResource.add(linkTo(ScenariosController.class).slash(id).withSelfRel());
        	scenarioResource.add(linkTo(ScenariosController.class).slash(id).slash("video").withRel("video"));
        	scenarioResource.add(linkTo(ScenariosController.class).slash(id).slash("scenarioparameters").withRel("scenarioparameters"));
        	scenarioResource.add(linkTo(ScenariosController.class).slash(id).slash("mos").withRel("mos"));
        	scenarioResource.add(linkTo(ScenariosController.class).slash(id).withRel("DELETE"));
        	scenarioResource.add(linkTo(ScenariosController.class).slash("update").withRel("PUT"));

        } catch (Exception ex) {
        }
        
        return scenarioResource;
	}

}
