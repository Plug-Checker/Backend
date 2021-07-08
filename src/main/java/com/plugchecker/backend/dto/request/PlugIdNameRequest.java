package com.plugchecker.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlugIdNameRequest {
    private int id;
    private String name;
}
