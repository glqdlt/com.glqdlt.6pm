package com.glqdlt.pm6.persistence.book.entity;

import com.glqdlt.general.api.model.EntityModel;
import com.glqdlt.pm6.api.model.book.Pm6Book;
import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntityBase;
import com.glqdlt.pm6.persistence.tag.entity.Pm6TagEntityBase;

import java.time.LocalDateTime;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public abstract class Pm6BookEntityBase<B extends Pm6TagEntityBase, A extends Pm6AuthorEntityBase> extends Pm6Book<B, A> implements EntityModel {
    private LocalDateTime regDate;
    private Long no;

    private String thumbnailUrl;

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

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
