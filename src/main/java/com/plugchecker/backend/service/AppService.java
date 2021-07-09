package com.plugchecker.backend.service;

import com.plugchecker.backend.domain.Plug;
import com.plugchecker.backend.domain.PlugRepository;
import com.plugchecker.backend.dto.request.PlugIdNameRequest;
import com.plugchecker.backend.dto.response.PlugAllResponse;
import com.plugchecker.backend.dto.response.PlugIdNameResponse;
import com.plugchecker.backend.dto.response.PlugIdResponse;
import com.plugchecker.backend.global.error.exception.AlreadyExistException;
import com.plugchecker.backend.global.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppService {

    private final PlugRepository plugRepository;

    public List<PlugAllResponse> getPlugAll() {
        List<Plug> plugs = plugRepository.findAll();
        return plugs.stream()
                .map(PlugAllResponse::from)
                .collect(Collectors.toList());
    }

    public List<PlugIdNameResponse> getPlugOn() {
        List<Plug> plugs = plugRepository.findByElectricity(true);
        return plugs.stream()
                .map(PlugIdNameResponse::from)
                .collect(Collectors.toList());
    }

    public List<PlugIdNameResponse> getPlugOff() {
        List<Plug> plugs = plugRepository.findByElectricity(false);
        return plugs.stream()
                .map(PlugIdNameResponse::from)
                .collect(Collectors.toList());
    }

    public PlugIdResponse registPlug(String name) {
        if(plugRepository.findByName(name).isPresent()) {
            throw new AlreadyExistException(name);
        }

        Plug plug = Plug.builder()
                .name(name)
                .build();
        plugRepository.save(plug);
        return new PlugIdResponse(plug.getId());
    }

    public void changePlug(PlugIdNameRequest request) {
        String name = request.getName();
        int id = request.getId();
        if(plugRepository.findByName(name).isPresent()) {
            throw new AlreadyExistException(name);
        }
        Plug plug = plugRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(id));

        plug.setName(name);
        plugRepository.save(plug);
    }

    public void deletePlug(int id) {
        plugRepository.deleteById(id);
    }
}
