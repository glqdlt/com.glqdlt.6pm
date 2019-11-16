package com.glqdlt.pm6.persistence.author.repo;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
public interface Pm6AuthorRepo extends JpaRepository<Pm6AuthorEntity, Long> {

    List<Pm6AuthorEntity> findAllByNameIn(List<String> names);
}
