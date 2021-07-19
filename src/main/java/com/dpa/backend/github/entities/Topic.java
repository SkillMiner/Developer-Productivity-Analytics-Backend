package com.dpa.backend.github.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Topic {
    private String name;
    private String stargazers;
}
