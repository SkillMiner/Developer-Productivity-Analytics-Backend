package com.dpa.backend.modules.developers;

import com.dpa.backend.modules.developers.entities.Developer;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Getter
@Relation(value = "profile", collectionRelation = "profiles")
public class DeveloperResource extends RepresentationModel<DeveloperResource> {
    // TODO: place Profile with filtered attributes
    private final Developer developer;

    public DeveloperResource(Developer developer) {
        this.developer = developer;
        add(linkTo(DeveloperController.class).withRel("developers"));
        add(linkTo(DeveloperController.class).slash(developer.getId()).withSelfRel());
    }
}
