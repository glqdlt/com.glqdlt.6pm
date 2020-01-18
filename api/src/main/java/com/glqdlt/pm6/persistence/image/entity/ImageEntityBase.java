package com.glqdlt.pm6.persistence.image.entity;

import com.glqdlt.general.api.model.EntityModel;

import java.time.LocalDateTime;

/**
 * @author Jhun
 * 2019-11-19
 */
public class ImageEntityBase implements EntityModel {

    private Long no;
    private LocalDateTime regDate;
    private String uri;
    private ImageStoreType type;

    @Override
    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    @Override
    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }
}
