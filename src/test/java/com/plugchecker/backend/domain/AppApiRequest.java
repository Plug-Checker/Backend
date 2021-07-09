package com.plugchecker.backend.domain;

import com.plugchecker.backend.ApiTest;
import com.plugchecker.backend.dto.request.PlugIdNameRequest;
import com.plugchecker.backend.dto.request.PlugIdRequest;
import com.plugchecker.backend.dto.request.PlugNameRequest;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

public class AppApiRequest extends ApiTest {

    protected ResultActions requestGetPlugAll() throws Exception {
        return requestMvc(get("/plug"));
    }

    protected ResultActions requestGetPlugOn() throws Exception {
        return requestMvc(get("/plug/on"));
    }

    protected ResultActions requestGetPlugOff() throws Exception {
        return requestMvc(get("/plug/off"));
    }

    protected ResultActions requestRegistPlug(PlugNameRequest request) throws Exception {
        return requestMvc(post("/plug"), request);
    }

    protected ResultActions requestChangePlug(PlugIdNameRequest request) throws Exception {
        return requestMvc(patch("/plug"), request);
    }

    protected ResultActions requestDeletePlug(PlugIdRequest request) throws Exception {
        return requestMvc(delete("/plug"), request);
    }
}
