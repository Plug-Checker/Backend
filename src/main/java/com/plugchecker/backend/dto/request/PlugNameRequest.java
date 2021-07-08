package com.plugchecker.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class PlugNameRequest {
    @NotNull
    private final String name;
}
