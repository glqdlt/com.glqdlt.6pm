package com.glqdlt.pm6.persistence.tag.entity;

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

    @Column(unique = true)
    @Override
    public String getTagName() {
        return super.getTagName();
    }

    public static Pm6TagEntity of(String name) {
        Pm6TagEntity pm6TagEntity = new Pm6TagEntity();
        pm6TagEntity.setTagName(name);
        pm6TagEntity.setRegDate(LocalDateTime.now());
        return pm6TagEntity;
    }

    public static List<Pm6TagEntity> of(List<String> tags) {
        return tags.stream().map(Pm6TagEntity::of).collect(Collectors.toList());
    }

    @Transient
    @Override
    public String getName() {
        return getTagName();
    }
}
