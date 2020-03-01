package com.glqdlt.pm6.jpapersistence.user.entity;

import com.glqdlt.general.api.model.EntityModel;
import com.glqdlt.pm6.api.model.authencation.Pm6Grant;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Date 2019-11-30
 *
 * @author glqdlt
 */
@Entity
@Table(name = "TB_GRANT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)    // 상속 전략
@DiscriminatorColumn(name = "grant_type")
public abstract class Pm6GrantEntity extends Pm6Grant implements EntityModel {
    private LocalDateTime regDate;

    @Id
    @Column(name = "id")
    @Override
    public Long getNo() {
        return no;
    }

    @Column(name = "value")
    @Override
    public String getValue() {
        return super.getValue();
    }

    private Long no;

    public void setNo(Long no) {
        this.no = no;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Transient
    @Override
    public abstract String getAttributeName();

    @Transient
    @Override
    public String getEvaluationPattern() {
        return (getAttributeName() + "_" + getValue()).toUpperCase();
    }

    @Column(name = "regDate")
    @Override
    public LocalDateTime getRegDate() {
        return regDate;
    }
}
