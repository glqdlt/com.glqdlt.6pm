package com.glqdlt.pm6.jpapersistence.tag.repo;

import com.glqdlt.pm6.jpapersistence.tag.entity.Pm6TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
public interface Pm6TagRepo extends JpaRepository<Pm6TagEntity, Long> {
    List<Pm6TagEntity> findAllByTagNameIsIn(String... tag);

    List<Pm6TagEntity> findAllByTagNameStartsWith(String tag);
}
