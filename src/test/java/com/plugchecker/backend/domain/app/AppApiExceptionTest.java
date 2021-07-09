package com.plugchecker.backend.domain.app;

import com.plugchecker.backend.domain.Plug;
import com.plugchecker.backend.domain.PlugRepository;
import com.plugchecker.backend.dto.request.PlugIdNameRequest;
import com.plugchecker.backend.dto.request.PlugNameRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AppApiExceptionTest extends AppApiRequest {

    @Autowired
    private PlugRepository plugRepository;

    @Test
    @DisplayName("멀티탭 등록하기_AlreadyExistException")
    void registPlug_AlreadyExistException() throws Exception {
        // given
        Plug plug = Plug.builder()
                .name("테스트 멀티탭")
                .build();
        plugRepository.save(plug);
        PlugNameRequest request = new PlugNameRequest("테스트 멀티탭");

        // when
        ResultActions resultActions = requestRegistPlug(request);

        // then
        resultActions.andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    @DisplayName("멀티탭 변경하기_NotFoundException")
    void changePlug_NotFoundException() throws Exception {
        // given
        int id = -1;
        PlugIdNameRequest request = new PlugIdNameRequest(id, "이름이름");
        // when
        ResultActions resultActions = requestChangePlug(request);

        // then
        resultActions.andExpect(status().is4xxClientError())
                .andDo(print());

    }
}
