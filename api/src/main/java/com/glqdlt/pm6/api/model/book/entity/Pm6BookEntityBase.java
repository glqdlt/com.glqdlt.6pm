package com.glqdlt.pm6.api.model.book.entity;

import com.glqdlt.api.general.model.EntityModel;
import com.glqdlt.pm6.api.model.author.entity.Pm6AuthorEntityBase;
import com.glqdlt.pm6.api.model.book.Pm6Book;
import com.glqdlt.pm6.api.model.tag.entity.Pm6TagEntityBase;

import java.time.LocalDateTime;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public class Pm6BookEntityBase extends Pm6Book<Pm6TagEntityBase, Pm6AuthorEntityBase> implements EntityModel {
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
