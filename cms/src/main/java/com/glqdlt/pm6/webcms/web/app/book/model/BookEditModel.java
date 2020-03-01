package com.glqdlt.pm6.webcms.web.app.book.model;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.persistence.book.entity.Pm6BookEntity;
import com.glqdlt.pm6.persistence.tag.entity.Pm6TagEntity;

/**
 * Date 2019-11-19
 *
 * @author glqdlt
 */
public class BookEditModel implements StreamToJoinCommaString {

    private Pm6BookEntity book;

    public BookEditModel(Pm6BookEntity pm6BookEntity) {
        book = pm6BookEntity;
    }

    public Pm6BookEntity getBook() {
        return book;
    }

    public String getAuthors() {
        return joinArrayToCommaString(getBook().getAuthors().stream().map(Pm6AuthorEntity::getName));
    }

    public String getTags() {
        return joinArrayToCommaString(getBook().getTags().stream().map(Pm6TagEntity::getName));
    }

    public String getLocation() {
        return String.format("/v1/api/book/%s/edit", getBook().getNo());
    }
}
