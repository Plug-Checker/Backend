package com.plugchecker.backend.controller;

import com.plugchecker.backend.dto.request.PlugIdNameRequest;
import com.plugchecker.backend.dto.request.PlugIdRequest;
import com.plugchecker.backend.dto.request.PlugNameRequest;
import com.plugchecker.backend.dto.response.PlugAllResponse;
import com.plugchecker.backend.dto.response.PlugIdNameResponse;
import com.plugchecker.backend.dto.response.PlugIdResponse;
import com.plugchecker.backend.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plug")
public class PlugController {

    private final AppService plugService;

    @GetMapping
    public List<PlugAllResponse> getPlugAll() {
        return plugService.getPlugAll();
    }

    @GetMapping("/on")
    public List<PlugIdNameResponse> getPlugOn() {
        return plugService.getPlugOn();
    }

    @GetMapping("/off")
    public List<PlugIdNameResponse> getPlugOff() {
        return plugService.getPlugOff();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlugIdResponse registPlug(@RequestBody PlugNameRequest request) {
        return plugService.registPlug(request.getName());
    }

    @PatchMapping
    public void changePlug(@RequestBody PlugIdNameRequest request) {
        plugService.changePlug(request);
    }

    @DeleteMapping
    public void deletePlug(@RequestBody PlugIdRequest request) {
        plugService.deletePlug(request.getId());
    }
}
