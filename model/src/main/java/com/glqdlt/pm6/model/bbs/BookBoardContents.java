package com.glqdlt.pm6.model.bbs;

import com.glqdlt.pm6.model.book.Bookable;

import java.util.Set;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
public class BookBoardContents extends BoardContents implements Bookable {
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
        return null;
    }
}
