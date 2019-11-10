package com.glqdlt.pm6.api.model.book;

import com.glqdlt.pm6.api.model.author.AuthorImpl;

import java.util.List;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public class BookImpl<T extends AuthorImpl> implements Book<T> {
    private String title;
    private List<T> authors;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<T> getAuthors() {
        return authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<T> authors) {
        this.authors = authors;
    }
}
