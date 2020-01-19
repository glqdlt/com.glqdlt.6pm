package com.glqdlt.pm6.api.model.book;

import java.time.LocalDateTime;

public abstract class BookReview {
    private String title;
    private String targetBookTitle;
    private String writeUrl;
    private String writer;
    private LocalDateTime regDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTargetBookTitle() {
        return targetBookTitle;
    }

    public void setTargetBookTitle(String targetBookTitle) {
        this.targetBookTitle = targetBookTitle;
    }

    public String getWriteUrl() {
        return writeUrl;
    }

    public void setWriteUrl(String writeUrl) {
        this.writeUrl = writeUrl;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public abstract Integer reviewType();
}
