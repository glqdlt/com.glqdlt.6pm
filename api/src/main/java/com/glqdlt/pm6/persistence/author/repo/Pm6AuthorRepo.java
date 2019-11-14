package com.glqdlt.pm6.persistence.author.repo;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
public interface Pm6AuthorRepo extends JpaRepository<Pm6AuthorEntity, Long> {
}
