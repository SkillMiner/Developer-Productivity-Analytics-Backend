package com.dpa.backend.github.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RepositoryTopic {
    private Topic topic;
}
