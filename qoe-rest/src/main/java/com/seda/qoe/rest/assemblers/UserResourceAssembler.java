package com.seda.qoe.rest.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.seda.qoe.dto.user.UserDTO;
import com.seda.qoe.rest.controllers.UsersController;

/**
 * 
 * @author Pavel Šeda
 */
@Component
public class UserResourceAssembler implements ResourceAssembler<UserDTO, Resource<UserDTO>>{

	@Override
	public Resource<UserDTO> toResource(UserDTO userDTO) {
		Long id = userDTO.getId();
        Resource<UserDTO> scenarioResource = new Resource<UserDTO>(userDTO);

        try {
        	scenarioResource.add(linkTo(UsersController.class).slash(id).withSelfRel());
        	scenarioResource.add(linkTo(UsersController.class).slash(id).slash("questionary").withRel("questionary"));
        	scenarioResource.add(linkTo(UsersController.class).slash(id).withRel("DELETE"));
        	scenarioResource.add(linkTo(UsersController.class).slash("update").withRel("PUT"));

        } catch (Exception ex) {
        }
        
        return scenarioResource;
	}
}
