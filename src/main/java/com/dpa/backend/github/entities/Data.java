package com.dpa.backend.github.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Data {
    private GithubUser user;
    private RateLimit rateLimit;
}
