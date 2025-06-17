package com.assemblers;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel; 
import org.springframework.stereotype.Component;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import com.example.controllers.UserControllerv2;
import com.example.models.entities.User;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user,
                linkTo(methodOn(UserControllerv2.class).obtenerUno(user.getId())).withSelfRel(),
                linkTo(methodOn(UserControllerv2.class).obtenerTodos()).withRel("usuario")
                );
    }



    
}
