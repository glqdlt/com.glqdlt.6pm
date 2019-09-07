package com.glqdlt.pm6.model.book;

import java.util.Set;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
public interface Bookable {
    Integer getBookId();

    String getBookTitle();

    public abstract Set<String> getAuthors();
}
