package com.glqdlt.pm6.webcms.web.app.author;


import com.glqdlt.pm6.jpapersistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.webcms.web.app.DuplicateFindOrPersist;

import java.util.List;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface AuthorService extends DuplicateFindOrPersist<Pm6AuthorEntity> {
    List<AuthorTag> findAllAuthorTags();
}
