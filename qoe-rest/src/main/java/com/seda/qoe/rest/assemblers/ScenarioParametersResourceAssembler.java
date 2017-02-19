package com.seda.qoe.rest.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;
import com.seda.qoe.rest.controllers.ScenarioParametersController;


/**
 * 
 * @author Pavel Šeda
 */
@Component
public class ScenarioParametersResourceAssembler implements ResourceAssembler<ScenarioParametersDTO, Resource<ScenarioParametersDTO>>{

	@Override
	public Resource<ScenarioParametersDTO> toResource(ScenarioParametersDTO scenarioParametersDTO) {
		Long id = scenarioParametersDTO.getId();
        Resource<ScenarioParametersDTO> scenarioParametersResource = new Resource<ScenarioParametersDTO>(scenarioParametersDTO);

        try {
        	scenarioParametersResource.add(linkTo(ScenarioParametersController.class).slash(id).withSelfRel());
        	scenarioParametersResource.add(linkTo(ScenarioParametersController.class).slash(id).slash("scenario").withRel("scenario"));
        	scenarioParametersResource.add(linkTo(ScenarioParametersController.class).slash(id).withRel("DELETE"));
        	scenarioParametersResource.add(linkTo(ScenarioParametersController.class).slash("update").withRel("PUT"));

        } catch (Exception ex) {
        }
        
		return scenarioParametersResource;
	}

}
