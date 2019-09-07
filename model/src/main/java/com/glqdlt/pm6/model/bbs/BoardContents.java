package com.glqdlt.pm6.model.bbs;

import java.time.LocalDateTime;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
public class BoardContents {

    private String title;
    private String writer;
    private LocalDateTime regDate;
    private Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}