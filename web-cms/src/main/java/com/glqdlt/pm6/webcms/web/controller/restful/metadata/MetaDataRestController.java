package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.persistence.author.repo.Pm6AuthorRepo;
import com.glqdlt.pm6.webcms.web.model.author.AuthorTag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Jhun
 * 2019-11-15
 */
@RestController
@RequestMapping("/api/v0")
public class MetaDataRestController {

    private Pm6AuthorRepo pm6AuthorRepo;

    public MetaDataRestController(Pm6AuthorRepo pm6AuthorRepo) {
        this.pm6AuthorRepo = pm6AuthorRepo;
    }

    @GetMapping(value = "/metadata/tag/authors", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AuthorTag> getAuthorTags() throws InterruptedException {
        List<Pm6AuthorEntity> originTags = pm6AuthorRepo.findAll();
        return originTags.stream().map(AuthorTag::new)
                .collect(Collectors.toList());
    }

}
