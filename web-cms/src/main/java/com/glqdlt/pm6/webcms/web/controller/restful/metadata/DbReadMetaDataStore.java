package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.webcms.web.model.form.tag.TagForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
@Service
public class DbReadMetaDataStore implements MetaDataStore<MetaCriteria> {
    private AuthorService authorService;
    private TagService tagService;

    public DbReadMetaDataStore(AuthorService authorService, TagService tagService) {
        this.authorService = authorService;
        this.tagService = tagService;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<TagForm> findAllTag() {
        return mergeStream(superTypeChange(tagService.findAllTagTags()),
                superTypeChange(authorService.findAllAuthorTags()));
    }

    @Override
    public List<TagForm> findByTagType(MetaCriteria criteria) {
        switch (criteria) {
            case TAG:
                return superTypeChange(tagService.findAllTagTags());
            case AUTHOR:
                return superTypeChange(authorService.findAllAuthorTags());
        }
        throw new IllegalArgumentException(String.format("not supported criteria %s", criteria.name()));
    }

    private <T extends TagForm> List<TagForm> superTypeChange(List<T> tag) {
        return tag.stream().map(x -> (TagForm) x).collect(Collectors.toList());
    }

}
