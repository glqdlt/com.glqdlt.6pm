package com.glqdlt.pm6.webcms.web.controller.view;

import com.glqdlt.pm6.webcms.web.app.ErrorController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public class ErrorControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(ErrorController.class)
                .build();
    }


    @Test
    public void notSupportBrowserView() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/error/browser/notsupport"))
                .andExpect(mvcResult -> Assert.assertEquals(415, mvcResult.getResponse().getStatus()))
                .andExpect(mvcResult -> Assert.assertEquals("/error/not-support-browser",mvcResult.getModelAndView().getViewName()));
    }
}