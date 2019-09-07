package com.glqdlt.pm6.model.book;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
public abstract class Book {
    private Integer id;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract String[] getAuthors();
}
