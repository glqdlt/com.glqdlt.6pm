package com.glqdlt.pm6.jpapersistence.author.entity;

import com.glqdlt.general.api.model.EntityModel;
import com.glqdlt.general.api.model.NameWithNo;
import com.glqdlt.pm6.api.model.author.AuthorImpl;

import java.time.LocalDateTime;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public abstract class Pm6AuthorEntityBase extends AuthorImpl implements EntityModel, NameWithNo {
    private LocalDateTime regDate;

    private Long no;

    @Override
    public LocalDateTime getRegDate() {
        return regDate;
    }

    @Override
    public Long getNo() {
        return no;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public void setNo(Long no) {
        this.no = no;
    }
}
