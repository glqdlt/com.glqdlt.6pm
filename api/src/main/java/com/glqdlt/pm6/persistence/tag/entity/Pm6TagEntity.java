package com.glqdlt.pm6.persistence.tag.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
@Entity
@Table(name = "tb_tag")
public class Pm6TagEntity extends Pm6TagEntityBase {
    @Override
    public LocalDateTime getRegDate() {
        return super.getRegDate();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Override
    public Long getNo() {
        return super.getNo();
    }

    @Override
    public String getTagName() {
        return super.getTagName();
    }
}
