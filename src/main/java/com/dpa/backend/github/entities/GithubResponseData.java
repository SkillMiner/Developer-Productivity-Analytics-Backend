package com.dpa.backend.github.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GithubResponseData {
    private Data data;
}
