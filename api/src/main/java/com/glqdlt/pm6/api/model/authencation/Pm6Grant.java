package com.glqdlt.pm6.api.model.authencation;

import com.glqdlt.pm6.api.model.authencation.GrantAttribute;

/**
 * Date 2019-11-30
 *
 * @author glqdlt
 */
public abstract class Pm6Grant implements GrantAttribute {

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public String getAttributeValue() {
        return getValue();
    }

    public void setValue(String value) {
        this.value = value;
    }

}
