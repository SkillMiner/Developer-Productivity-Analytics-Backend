package com.dpa.backend.configurations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class AppProperties {
    @Value("${github_client_id}")
    private String githubClientId;

    @Value("${github_client_secret}")
    private String githubClientSecret;

    @Value("${client-id}")
    private String clientId;

    @Value("${client-secret}")
    private String clientSecret;

    @Value(
       "#{T(com.dpa.backend.utils.ResourceReader).readAsString('classpath:github/profile.graphql')}"
    )
    private String github_gpl_profile_query;

    @Value(
            "#{T(com.dpa.backend.utils.ResourceReader).readAsString('classpath:github/public_profile.graphql')}"
    )
    private String github_gpl_public_profile_query;
}
