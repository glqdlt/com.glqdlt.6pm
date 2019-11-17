package com.glqdlt.pm6.webcms.web.controller.restful.metadata;

import com.glqdlt.pm6.webcms.web.model.form.tag.TagForm;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface MetaDataStore<C extends MetaDataStore.MetaDataCriteria> {
    List<TagForm> findAllTag();

    List<TagForm> findByTagType(C criteria);

    default List<TagForm> mergeStream(List<TagForm>... forms) {
        return Stream.of(forms).flatMap(Collection::stream).collect(Collectors.toList());
    }


    interface MetaDataCriteria {
        String getType();
    }
}
