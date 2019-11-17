package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.general.api.model.NameWithNo;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface SubscripbeMetaDataStore<E extends NameWithNo> extends MetaDataStore, SaveEvent<E> {
}
