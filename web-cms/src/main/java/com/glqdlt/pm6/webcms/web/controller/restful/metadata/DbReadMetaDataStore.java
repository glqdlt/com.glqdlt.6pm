package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.webcms.web.model.form.tag.author.AuthorTag;
import com.glqdlt.pm6.webcms.web.model.form.tag.tag.TagTag;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
@Service
public class DbReadMetaDataStore implements MetaDataStore<AuthorTag, TagTag> {
    private AuthorService authorService;
    private TagService tagService;

    public DbReadMetaDataStore(AuthorService authorService, TagService tagService) {
        this.authorService = authorService;
        this.tagService = tagService;
    }

    @Override
    public List<AuthorTag> findAllAuthorTag() {
        return authorService.findAllAuthorTags();
    }

    @Override
    public List<TagTag> findAllTagTag() {
        return tagService.findAllTagTags();
    }
}
