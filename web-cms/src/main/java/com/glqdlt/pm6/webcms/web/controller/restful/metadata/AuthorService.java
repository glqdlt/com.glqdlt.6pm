package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.webcms.web.model.form.tag.author.AuthorTag;

import java.util.List;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface AuthorService extends DuplicateFindOrPersist<Pm6AuthorEntity> {
    List<AuthorTag> findAllAuthorTags();
}
