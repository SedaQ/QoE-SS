package com.seda.qoe.rest.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;
import com.seda.qoe.rest.controllers.hateos.ScenarioParametersRestHateosController;


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
        	scenarioParametersResource.add(linkTo(ScenarioParametersRestHateosController.class).slash(id).withSelfRel());
        	scenarioParametersResource.add(linkTo(ScenarioParametersRestHateosController.class).slash(id).slash("scenarios").withRel("scenarios"));
        	scenarioParametersResource.add(linkTo(ScenarioParametersRestHateosController.class).slash(id).withRel("DELETE"));
        	scenarioParametersResource.add(linkTo(ScenarioParametersRestHateosController.class).slash("update").withRel("PUT"));

        } catch (Exception ex) {
        }
        
		return scenarioParametersResource;
	}

}
