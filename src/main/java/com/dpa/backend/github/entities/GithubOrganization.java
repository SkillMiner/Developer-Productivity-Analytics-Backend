package com.dpa.backend.github.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GithubOrganization {
    private String githubId;
    private String login;
    private String name;
    private String email;
    private String description;
    private String url;
    private String websiteUrl;
}
