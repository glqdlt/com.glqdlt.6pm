package com.glqdlt.pm6.webservice.entity.write.table;

import com.glqdlt.pm6.webservice.entity.book.Book;
import com.glqdlt.pm6.webservice.entity.upload.ThumbnailImage;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public class BookStore extends DataTable {
    private Book book;
    private ThumbnailImage thumbnailImage;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
