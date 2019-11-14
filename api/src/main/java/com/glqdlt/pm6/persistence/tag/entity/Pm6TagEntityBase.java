package com.glqdlt.pm6.persistence.tag.entity;

import com.glqdlt.general.api.model.EntityModel;
import com.glqdlt.general.api.model.RegDateAble;
import com.glqdlt.pm6.api.model.tag.TagImpl;

import java.time.LocalDateTime;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public class Pm6TagEntityBase extends TagImpl implements RegDateAble, EntityModel {
    private LocalDateTime regDate;
    private Long no;

    @Override
    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Override
    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }
}
