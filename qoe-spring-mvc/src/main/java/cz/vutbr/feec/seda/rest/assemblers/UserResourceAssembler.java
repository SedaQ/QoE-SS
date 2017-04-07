package cz.vutbr.feec.seda.rest.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;


import cz.vutbr.feec.seda.dto.user.UserDTO;
import cz.vutbr.feec.seda.rest.controllers.hateos.UsersRestHateosController;

/**
 * @author Pavel Šeda (441048)
 *
 */
@Component
public class UserResourceAssembler implements ResourceAssembler<UserDTO, Resource<UserDTO>>{

	@Override
	public Resource<UserDTO> toResource(UserDTO userDTO) {
		Long id = userDTO.getId();
        Resource<UserDTO> scenarioResource = new Resource<UserDTO>(userDTO);

        try {
        	scenarioResource.add(linkTo(UsersRestHateosController.class).slash(id).withSelfRel());
        	scenarioResource.add(linkTo(UsersRestHateosController.class).slash(id).slash("questionaries").withRel("questionaries"));
        	scenarioResource.add(linkTo(UsersRestHateosController.class).slash(id).withRel("DELETE"));
        	scenarioResource.add(linkTo(UsersRestHateosController.class).slash("update").withRel("PUT"));

        } catch (Exception ex) {
        }
        
        return scenarioResource;
	}
}
