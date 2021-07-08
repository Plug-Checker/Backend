package com.plugchecker.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class PlugIdRequest {
    @NotNull
    private int id;
}
