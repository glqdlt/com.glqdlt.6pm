package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.persistence.tag.entity.Pm6TagEntity;
import com.glqdlt.pm6.webcms.web.model.form.tag.author.AuthorTag;
import com.glqdlt.pm6.webcms.web.model.form.tag.tag.TagTag;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jhun
 * 2019-11-15
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {MetaDataRestController.class})
public class MetaDataRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MetaDataStore store;

    @Test
    public void getAuthorTags() throws Exception {
        List<Pm6AuthorEntity> dummy = Arrays.asList(new Pm6AuthorEntity("kim"), new Pm6AuthorEntity("park"));
        for (int i = 0; i < dummy.size(); i++) {
            final Pm6AuthorEntity item = dummy.get(i);
            item.setNo((long) i);
        }

        List<AuthorTag> d = dummy.stream()
                .map(AuthorTag::new)
                .collect(Collectors.toList());
        Mockito.when(store.findAllAuthorTag()).thenReturn(d);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v0/metadata/tag/authors"))
                .andReturn();

        MockHttpServletResponse res = result.getResponse();
        Assert.assertEquals(200, res.getStatus());
        Assert.assertEquals("application/json;charset=UTF-8", res.getContentType());
        Assert.assertEquals("[{\"value\":\"0\",\"innerText\":\"kim\"},{\"value\":\"1\",\"innerText\":\"park\"}]", res.getContentAsString());
    }

    @Test
    public void getTagTags() throws Exception {
        List<Pm6TagEntity> dummy = Arrays.asList(Pm6TagEntity.of("자바"), Pm6TagEntity.of("프로그래밍"));
        for (int i = 0; i < dummy.size(); i++) {
            final Pm6TagEntity item = dummy.get(i);
            item.setNo((long) i);
        }

        List<TagTag> d = dummy.stream()
                .map(TagTag::new)
                .collect(Collectors.toList());
        Mockito.when(store.findAllTagTag()).thenReturn(d);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v0/metadata/tag/tags"))
                .andReturn();

        MockHttpServletResponse res = result.getResponse();
        Assert.assertEquals(200, res.getStatus());
        Assert.assertEquals("application/json;charset=UTF-8", res.getContentType());
        Assert.assertEquals("[{\"value\":\"0\",\"innerText\":\"자바\"},{\"value\":\"1\",\"innerText\":\"프로그래밍\"}]", res.getContentAsString());
    }
}