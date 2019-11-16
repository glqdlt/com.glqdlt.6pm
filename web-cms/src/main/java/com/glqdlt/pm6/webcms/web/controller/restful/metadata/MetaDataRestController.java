package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.webcms.web.model.form.tag.TagForm;
import com.glqdlt.pm6.webcms.web.model.form.tag.author.AuthorTag;
import com.glqdlt.pm6.webcms.web.model.form.tag.tag.TagTag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jhun
 * 2019-11-15
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/api/v0")
public class MetaDataRestController {

    private MetaDataStore metaDataStore;

    public MetaDataRestController(MetaDataStore metaDataStore) {
        this.metaDataStore = metaDataStore;
    }

    @GetMapping(value = "/metadata/tag/authors", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AuthorTag> getAuthorTags() {
        return metaDataStore.findAllAuthorTag();
    }

    @GetMapping(value = "/metadata/tag/tags", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TagForm> getTagTags() {
        return metaDataStore.findAllTagTag();
    }

}
