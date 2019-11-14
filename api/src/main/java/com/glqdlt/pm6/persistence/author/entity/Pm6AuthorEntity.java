package com.glqdlt.pm6.persistence.author.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
@Entity
@Table(name = "tb_author")
public class Pm6AuthorEntity extends Pm6AuthorEntityBase {

    @Override
    public String getName() {
        return super.getName();
    }

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
}
