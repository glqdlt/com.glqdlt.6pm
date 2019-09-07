package com.glqdlt.pm6.entity.write;

import com.glqdlt.pm6.entity.user.User;

import java.time.LocalDateTime;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class Write {
    private Long id;
    private String text;
    private LocalDateTime regDate;
    private Boolean viewable;
    private User writer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public Boolean getViewable() {
        return viewable;
    }

    public void setViewable(Boolean viewable) {
        this.viewable = viewable;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }
}
