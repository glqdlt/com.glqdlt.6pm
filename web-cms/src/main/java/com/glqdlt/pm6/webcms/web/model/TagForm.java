package com.glqdlt.pm6.webcms.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glqdlt.general.api.model.NameWithNo;
import com.glqdlt.general.api.model.TextPairForm;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public abstract class TagForm<T extends NameWithNo> implements TextPairForm {
    private T ref;

    public TagForm(T ref) {
        this.ref = ref;
    }

    @JsonIgnore
    public T getRef() {
        return ref;
    }
}
