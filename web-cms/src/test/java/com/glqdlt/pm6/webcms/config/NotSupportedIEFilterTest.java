package com.glqdlt.pm6.webcms.config;

import com.glqdlt.pm6.webcms.web.app.book.BookService;
import com.glqdlt.pm6.webcms.web.app.metadata.MetaDataStore;
import com.glqdlt.pm6.webcms.web.filter.NotSupportedIEFilter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.glqdlt.pm6.webcms.config.FilterConfig.API_PATH_PREFIX_PATTERN;
import static com.glqdlt.pm6.webcms.web.app.ErrorController.NOT_SUPPORTED_IE_PATH;

/**
 * @author glqdlt
 * @see <a href='https://spring.io/guides/gs/testing-web/'>https://spring.io/guides/gs/testing-web/</a>
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class NotSupportedIEFilterTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private BookService bookService;

    @MockBean
    private MetaDataStore metaDataStore;

    @Test
    public void urlMatcher() {
        String url = "/qweqwe-qweqweq.html";
        Assert.assertFalse(url.matches(API_PATH_PREFIX_PATTERN));
        String url2 = "/api/asdasd";
        Assert.assertTrue(url2.matches(API_PATH_PREFIX_PATTERN));
    }

    @Test
    public void redirectNotSupportedIe() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(new NotSupportedIEFilter(NOT_SUPPORTED_IE_PATH,
                        API_PATH_PREFIX_PATTERN))
                .build();
        MvcResult r = mockMvc.perform(MockMvcRequestBuilders.get("/").header("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko"))
                .andReturn();

        Assert.assertEquals(HttpStatus.FOUND.value(), r.getResponse().getStatus());
        Assert.assertEquals(NOT_SUPPORTED_IE_PATH, r.getResponse().getRedirectedUrl());
    }
}

