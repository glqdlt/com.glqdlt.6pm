package com.glqdlt.pm6.webcms.web.controller.restful.book;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.persistence.book.entity.Pm6BookEntity;
import com.glqdlt.pm6.webcms.web.app.book.BookRestController;
import com.glqdlt.pm6.webcms.web.app.book.BookService;
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

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1차원적인 컨트롤러 테스트, 대상 컨트롤러를 내가 직접 이니셜라이징 해줌
 * 2차원적인 테스트는 아래 BookRestControllerTest 를 참고
 *
 * @author glqdlt
 * @see com.glqdlt.pm6.webcms.web.app.metadata.MetaDataRestControllerTest
 */
@RunWith(SpringRunner.class)
public class BookRestControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BookRestController(bookService))
                .build();
    }

    @Test
    public void postDeleteBook() throws Exception {
        Mockito.doNothing().when(bookService).deleteBook(Mockito.anyLong());
        MvcResult z = mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/book/1/delete"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        Assert.assertEquals(200, z.getResponse().getStatus());
    }

    @Test
    public void failPostDeleteBook() throws Exception {
        Mockito.doNothing().when(bookService).deleteBook(Mockito.anyLong());
        MvcResult z = mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/book/r/delete"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        Assert.assertEquals(400, z.getResponse().getStatus());
    }

    @Test
    public void postNewBook() throws Exception {
        Pm6BookEntity dummy = new Pm6BookEntity();
        dummy.setTitle("clean code");
        dummy.setAuthors(Pm6AuthorEntity.of(Arrays.asList("martin", "홍길동")));
        dummy.setTags(new LinkedList<>());
        dummy.setDescription("테스트");
        Mockito.when(bookService.createNewBook(Mockito.anyString(), Mockito.anyList(), Mockito.anyList(), Mockito.any()))
                .thenReturn(dummy);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/book/new")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", "clean code")
                .param("authors", "martin,홍길동")
                .param("description", "테스트")
        )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        Assert.assertEquals(302, result.getResponse().getStatus());
        Assert.assertEquals("/v1/view/book", result.getResponse().getHeader("location"));
    }

    @Test
    public void updateBook() throws Exception {
        Pm6BookEntity dummy = new Pm6BookEntity();
        dummy.setNo(1L);
        dummy.setTitle("clean code");
        dummy.setAuthors(Pm6AuthorEntity.of(Arrays.asList("martin", "홍길동")));
        dummy.setTags(new LinkedList<>());
        dummy.setDescription("테스트");
        Mockito.when(bookService.updateBook(Mockito.anyLong(), Mockito.anyString(), Mockito.anyList(), Mockito.anyList(), Mockito.any()))
                .thenReturn(dummy);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/book/1/edit")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", "clean code")
                .param("authors", "martin,홍길동")
                .param("description", "테스트")
        )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        Assert.assertEquals(302, result.getResponse().getStatus());
        Assert.assertEquals("/v1/view/book", result.getResponse().getHeader("location"));
    }

    @Test
    public void getBooks() throws Exception {
        List<Pm6BookEntity> zzz = IntStream.rangeClosed(1, 10).boxed()
                .map(x -> {
                    Pm6BookEntity pm6BookEntity = new Pm6BookEntity();
                    pm6BookEntity.setNo((long) x);
                    pm6BookEntity.setTitle("title" + x);
                    pm6BookEntity.setRegDate(LocalDateTime.of(2019, 1, 1, 1, 1));
                    return pm6BookEntity;
                })
                .collect(Collectors.toList());
        Mockito.when(bookService.findAllBooks()).thenReturn(zzz);
        MvcResult z = mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/books"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        Assert.assertEquals(200, z.getResponse().getStatus());
        Assert.assertEquals("[{\"title\":\"title1\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":[2019,1,1,1,1],\"no\":1,\"regDateFormatString\":\"2019-01-01 01:01:00\"},{\"title\":\"title2\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":[2019,1,1,1,1],\"no\":2,\"regDateFormatString\":\"2019-01-01 01:01:00\"},{\"title\":\"title3\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":[2019,1,1,1,1],\"no\":3,\"regDateFormatString\":\"2019-01-01 01:01:00\"},{\"title\":\"title4\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":[2019,1,1,1,1],\"no\":4,\"regDateFormatString\":\"2019-01-01 01:01:00\"},{\"title\":\"title5\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":[2019,1,1,1,1],\"no\":5,\"regDateFormatString\":\"2019-01-01 01:01:00\"},{\"title\":\"title6\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":[2019,1,1,1,1],\"no\":6,\"regDateFormatString\":\"2019-01-01 01:01:00\"},{\"title\":\"title7\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":[2019,1,1,1,1],\"no\":7,\"regDateFormatString\":\"2019-01-01 01:01:00\"},{\"title\":\"title8\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":[2019,1,1,1,1],\"no\":8,\"regDateFormatString\":\"2019-01-01 01:01:00\"},{\"title\":\"title9\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":[2019,1,1,1,1],\"no\":9,\"regDateFormatString\":\"2019-01-01 01:01:00\"},{\"title\":\"title10\",\"authors\":null,\"description\":null,\"tags\":null,\"regDate\":[2019,1,1,1,1],\"no\":10,\"regDateFormatString\":\"2019-01-01 01:01:00\"}]", z.getResponse().getContentAsString());
    }
}