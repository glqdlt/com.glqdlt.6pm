package com.glqdlt.pm6.api.model.book;

import com.glqdlt.pm6.api.model.author.Author;

import java.util.List;


/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public interface Book<A extends Author> {

    String getTitle();

    List<A> getAuthors();

}
