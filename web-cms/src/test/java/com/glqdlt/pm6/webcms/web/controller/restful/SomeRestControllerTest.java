package com.glqdlt.pm6.webcms.web.controller.restful;

import com.glqdlt.pm6.webcms.web.app.SomeRestController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public class SomeRestControllerTest {


    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(SomeRestController.class)
                .build();
    }

    @Test
    public void healthCheck() throws Exception {
        MvcResult z = mockMvc.perform(MockMvcRequestBuilders.get("/api/health"))
                .andReturn();
        Assert.assertEquals(200,z.getResponse().getStatus());

    }
}