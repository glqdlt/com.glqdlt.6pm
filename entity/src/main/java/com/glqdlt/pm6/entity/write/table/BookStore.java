package com.glqdlt.pm6.entity.write.table;

import com.glqdlt.pm6.entity.book.Pm6Book;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
@Deprecated
public class BookStore extends DataTable {
    private Pm6Book book;

    public Pm6Book getBook() {
        return book;
    }

    public void setBook(Pm6Book book) {
        this.book = book;
    }
}
