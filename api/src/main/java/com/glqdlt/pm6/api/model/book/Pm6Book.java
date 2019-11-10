package com.glqdlt.pm6.api.model.book;

import com.glqdlt.api.general.model.Description;
import com.glqdlt.pm6.api.model.author.AuthorImpl;
import com.glqdlt.pm6.api.model.tag.Tag;

import java.util.List;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public class Pm6Book<T extends Tag, A extends AuthorImpl> extends BookImpl<A> implements Description {
    private String description;
    private List<T> tags;

    public List<T> getTags() {
        return tags;
    }

    public void setTags(List<T> tags) {
        this.tags = tags;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
