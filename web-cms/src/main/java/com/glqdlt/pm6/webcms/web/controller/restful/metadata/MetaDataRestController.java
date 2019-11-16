package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.webcms.web.model.author.AuthorTag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jhun
 * 2019-11-15
 */
@RestController
@RequestMapping("/api/v0")
public class MetaDataRestController {

    private MetaDataService metaDataService;

    public MetaDataRestController(MetaDataService service) {
        this.metaDataService = service;
    }

    @GetMapping(value = "/metadata/tag/authors", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AuthorTag> getAuthorTags() throws InterruptedException {
        return metaDataService.findAllAuthorTags();
    }

}
