package com.glqdlt.pm6.model.article;

import com.glqdlt.pm6.model.author.Author;
import com.glqdlt.pm6.model.book.Bookable;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
public class BookArticle implements Bookable {
    private Author[] authors;

    @Override
    public Integer getBookId() {
        return null;
    }

    @Override
    public String getBookTitle() {
        return null;
    }

    @Override
    public Set<String> getAuthors() {
        return Arrays.stream(authors)
                .map(Author::getName)
                .collect(Collectors.toSet());
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }
}
