package com.glqdlt.pm6.api.model.author;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public abstract class AuthorImpl implements Author {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
