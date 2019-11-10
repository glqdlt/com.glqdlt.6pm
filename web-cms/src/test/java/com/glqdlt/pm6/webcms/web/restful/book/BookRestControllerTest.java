package com.glqdlt.pm6.webcms.web.restful.book;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public class BookRestControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(BookRestController.class)
                .build();
    }

    @Test
    public void postNewBook() throws Exception {
        MvcResult a = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/book/new")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .param("title", "clean code")
                .param("author", "martin,홍길동")
        )
                .andReturn();
        Assert.assertEquals(200, a.getResponse().getStatus());
    }
}