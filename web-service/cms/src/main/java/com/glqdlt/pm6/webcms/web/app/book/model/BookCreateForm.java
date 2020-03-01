package com.glqdlt.pm6.webcms.web.app.book.model;

import com.glqdlt.pm6.webcms.functions.CommaStringListMappers;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jhun
 * 2019-11-21
 */
public class BookCreateForm {
    public BookCreateForm(String title, String authors, String tags, String description, String thumbnail) {
        this.title = title;
        this.authors = authors;
        this.tags = tags;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    private List<String> parsingComma(String str) {
        if (str == null || str.equals("")) {
            return new LinkedList<>();
        }
        return CommaStringListMappers.STRING_BYPASS.parsing(str);
    }

    private String title;
    private String authors;
    private String tags;
    private String description;
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return parsingComma(authors);
    }


    public List<String> getTags() {
        return parsingComma(tags);
    }


    public String getDescription() {
        return description;
    }


    public String getThumbnail() {
        return thumbnail;
    }
}
