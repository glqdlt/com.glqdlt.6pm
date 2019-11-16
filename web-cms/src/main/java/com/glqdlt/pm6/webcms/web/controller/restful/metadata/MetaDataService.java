package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.webcms.web.model.author.AuthorTag;

import java.util.List;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface MetaDataService {
    List<AuthorTag> findAllAuthorTags();
}
