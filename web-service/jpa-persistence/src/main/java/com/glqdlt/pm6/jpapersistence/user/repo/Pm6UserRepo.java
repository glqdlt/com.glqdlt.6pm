package com.glqdlt.pm6.jpapersistence.user.repo;

import com.glqdlt.pm6.jpapersistence.user.entity.Pm6UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
public interface Pm6UserRepo extends JpaRepository<Pm6UserEntity, Long> {
    Optional<Pm6UserEntity> findByUserId(String userId);
}
