package com.plugchecker.backend.dto.response;

import com.plugchecker.backend.domain.Plug;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class PlugIdNameResponse {

    private int id;
    private String name;

    public static PlugIdNameResponse from(Plug plug) {
        return PlugIdNameResponse.builder()
                .id(plug.getId())
                .name(plug.getName())
                .build();
    }
}