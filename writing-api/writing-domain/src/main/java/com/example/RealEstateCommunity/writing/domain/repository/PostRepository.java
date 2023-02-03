package com.example.RealEstateCommunity.writing.domain.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.RealEstateCommunity.writing.domain.Post;

public interface PostRepository {
    Post save(Post post);

    void deleteById(Long postId);
    Page<Post> findByActivedIsTrue(Pageable pageable);
    Optional<Post> findById(Long postId);


}


