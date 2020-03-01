package com.glqdlt.pm6.jpapersistence.book.repo;

import com.glqdlt.pm6.jpapersistence.book.entity.Pm6BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
public interface Pm6BookRepo extends JpaRepository<Pm6BookEntity, Long> {
    Optional<Pm6BookEntity> findByTitle(String title);
    List<Pm6BookEntity> findAllByTitleLike(String title);
    List<Pm6BookEntity> findAllByOrderByNoDesc();
}
