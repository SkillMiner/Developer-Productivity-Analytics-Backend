package com.dsinnovators.devprofilesbackend.modules.profiles.entities;

import com.dsinnovators.devprofilesbackend.github.entities.GithubOrganization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organizations")
@Relation(value = "organization", collectionRelation = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizations_id_generator")
    @SequenceGenerator(name="organizations_id_generator", sequenceName = "organizations_id_seq", initialValue=101)
    private Long id;

    private String name;
    private String email;
    private String description;
    private String url;
    private String websiteUrl;

    @ManyToOne
    private Profile profile;

    public static Organization from(GithubOrganization githubOrganization) {
        return Organization.builder()
                .name(githubOrganization.getName())
                .email(githubOrganization.getEmail())
                .description(githubOrganization.getDescription())
                .url(githubOrganization.getUrl())
                .websiteUrl(githubOrganization.getWebsiteUrl())
                .build();
    }
}
