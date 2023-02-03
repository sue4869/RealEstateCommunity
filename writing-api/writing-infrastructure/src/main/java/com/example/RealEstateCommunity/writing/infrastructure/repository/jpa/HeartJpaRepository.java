package com.example.RealEstateCommunity.writing.infrastructure.repository.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.RealEstateCommunity.writing.domain.Heart;


@Repository
public interface HeartJpaRepository extends JpaRepository<Heart, Long> {

    Optional<Heart> findByAccountIdAndPostId(Long accountId, Long postId);
    List<Heart> findByAccountId(Long accountId);
    List<Heart> findByChecked(Boolean checked);
}
