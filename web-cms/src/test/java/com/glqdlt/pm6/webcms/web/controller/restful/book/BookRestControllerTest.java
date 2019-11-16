package com.glqdlt.pm6.webcms.web.controller.restful.book;

import com.glqdlt.pm6.persistence.book.entity.Pm6BookEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
public class BookRestControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BookRestController(bookService))
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

    @Test
    public void getBooks() throws Exception {
        List<Pm6BookEntity> zzz = IntStream.rangeClosed(1, 10).boxed()
                .map(x -> {
                    Pm6BookEntity pm6BookEntity = new Pm6BookEntity();
                    pm6BookEntity.setNo((long) x);
                    pm6BookEntity.setTitle("title" + x);
                    return pm6BookEntity;
                })
                .collect(Collectors.toList());
        Mockito.when(bookService.findAllBooks()).thenReturn(zzz);
        MvcResult z = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        Assert.assertEquals(200, z.getResponse().getStatus());
        Assert.assertEquals("[{\"title\":\"title1\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":null,\"no\":1},{\"title\":\"title2\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":null,\"no\":2},{\"title\":\"title3\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":null,\"no\":3},{\"title\":\"title4\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":null,\"no\":4},{\"title\":\"title5\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":null,\"no\":5},{\"title\":\"title6\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":null,\"no\":6},{\"title\":\"title7\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":null,\"no\":7},{\"title\":\"title8\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":null,\"no\":8},{\"title\":\"title9\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":null,\"no\":9},{\"title\":\"title10\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":null,\"no\":10}]", z.getResponse().getContentAsString());
    }
}