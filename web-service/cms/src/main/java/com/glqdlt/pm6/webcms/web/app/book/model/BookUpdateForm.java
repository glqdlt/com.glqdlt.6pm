package com.glqdlt.pm6.webcms.web.app.book.model;

/**
 * @author Jhun
 * 2019-11-21
 */
public class BookUpdateForm extends BookCreateForm {
    private Long no;

    public Long getNo() {
        return no;
    }

    public BookUpdateForm(String title, String authors, String tags, String description, String thumbnail, Long no) {
        super(title, authors, tags, description, thumbnail);
        this.no = no;
    }
}
