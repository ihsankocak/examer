package com.bekdik.examer.controller;

import com.bekdik.examer.service.domain.solvable.SolvableController;
import com.bekdik.examer.service.domain.solvable.SolvableProvider;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.reset;

@WebMvcTest(SolvableController.class)
public class SolvableControllerTest {
    @MockBean
    SolvableProvider solvableProvider;
    @Autowired
    MockMvc mockMvc;

    /*@Test
    public void testGetDefaultSolvables() throws Exception {

        StringStringSolvableChoosable stringSolvableChoosable = getDummyStringStringSolvableChoosable();
        given(solvableProvider.getSolvables()).willReturn(Arrays.asList(stringSolvableChoosable));

        mockMvc.perform(get("/solvables")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(1)));
        then(solvableProvider).should().getSolvables();
    }
    @Test
    public void testIfAnswerCorrect() throws Exception {
        final String correctAnswer="test cevabı";
        StringStringSolvableChoosable stringSolvableChoosable = getDummyStringStringSolvableChoosable();
        given(solvableProvider.getSolvables()).willReturn(Arrays.asList(stringSolvableChoosable));

        mockMvc.perform(put("/solvables/"+stringSolvableChoosable.getId()+"/answer/"+correctAnswer)).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(content().string("true"));
        then(solvableProvider).should().getSolvables();
    }*/

    @AfterEach
    void tearDown() {
        reset(solvableProvider);
    }
}
