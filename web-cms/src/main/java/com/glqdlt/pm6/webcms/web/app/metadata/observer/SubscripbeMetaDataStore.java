package com.glqdlt.pm6.webcms.web.app.metadata.observer;

import com.glqdlt.general.api.model.NameWithNo;
import com.glqdlt.pm6.webcms.web.app.metadata.MetaDataStore;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface SubscripbeMetaDataStore<E extends NameWithNo> extends MetaDataStore, SaveEvent<E> {
}
