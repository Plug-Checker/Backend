package com.plugchecker.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class PlugIdNameRequest {
    @NotNull
    private int id;
    @NotNull
    private String name;
}
