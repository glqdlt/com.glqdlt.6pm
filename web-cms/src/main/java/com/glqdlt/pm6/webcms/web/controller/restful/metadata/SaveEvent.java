package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.general.api.model.NameWithNo;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
public interface SaveEvent<E extends NameWithNo> {
    void event(E e);
}
