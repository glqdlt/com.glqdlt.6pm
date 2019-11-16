package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.webcms.web.model.form.tag.TagForm;

import java.util.List;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface MetaDataStore<A extends TagForm, T extends TagForm> {
    List<A> findAllAuthorTag();

    List<T> findAllTagTag();
}
