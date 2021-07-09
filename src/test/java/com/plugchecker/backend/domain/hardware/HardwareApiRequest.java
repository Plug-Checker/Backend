package com.plugchecker.backend.domain.hardware;

import com.plugchecker.backend.ApiTest;
import com.plugchecker.backend.dto.request.PlugIdRequest;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class HardwareApiRequest extends ApiTest {

    protected ResultActions requestPlugOn(PlugIdRequest request) throws Exception {
        return requestMvc(post("/plug/on"), request);
    }

    protected ResultActions requestPlugOff(PlugIdRequest request) throws Exception {
        return requestMvc(post("/plug/off"), request);
    }
}
