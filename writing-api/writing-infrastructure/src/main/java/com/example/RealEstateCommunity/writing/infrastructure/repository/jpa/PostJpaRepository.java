package com.example.RealEstateCommunity.writing.infrastructure.repository.jpa;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RealEstateCommunity.writing.domain.Post;

@Repository
public interface PostJpaRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByAccountId(Long AccountId);
    Optional<Post> findById(Long postId);
    void deleteById(Long postId);
    Page<Post> findByActivedIsTrue(Pageable pageable);

}
