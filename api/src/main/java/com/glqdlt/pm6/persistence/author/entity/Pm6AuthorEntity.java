package com.glqdlt.pm6.persistence.author.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
@Entity
@Table(name = "tb_author")
public class Pm6AuthorEntity extends Pm6AuthorEntityBase {

    public Pm6AuthorEntity() {
    }

    public Pm6AuthorEntity(String name) {
        this.setName(name);
        this.setRegDate(LocalDateTime.now());
    }

    @Column(unique = true)
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

    public static Pm6AuthorEntity of(String name) {
        Pm6AuthorEntity pm6AuthorEntity = new Pm6AuthorEntity();
        pm6AuthorEntity.setName(name);
        pm6AuthorEntity.setRegDate(LocalDateTime.now());
        return pm6AuthorEntity;
    }

    public static List<Pm6AuthorEntity> of(List<String> name) {
        return name.stream().map(Pm6AuthorEntity::of).collect(Collectors.toList());
    }
}
