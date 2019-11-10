package com.glqdlt.pm6.api.model.tag;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public class TagImpl implements Tag {
    private String tagName;

    @Override
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
