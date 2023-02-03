package com.example.RealEstateCommunity.writing.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.RealEstateCommunity.writing.domain.Post;
import com.example.RealEstateCommunity.writing.domain.repository.PostRepository;
import com.example.RealEstateCommunity.writing.infrastructure.repository.jpa.PostJpaRepository;

public class PostRepositoryAdaptor implements PostRepository {

    private final PostJpaRepository postJpaRepository;

    public PostRepositoryAdaptor(PostJpaRepository postJpaRepository) {
        this.postJpaRepository = postJpaRepository;
    }

    @Override
    public Post save(Post post) {
        return postJpaRepository.save(post);
    }

    @Override
    public void deleteById(Long postId) {
        postJpaRepository.deleteById(postId);
    }

    @Override
    public Page<Post> findByActivedIsTrue(Pageable pageable) {
        return postJpaRepository.findByActivedIsTrue(pageable);
    }

    @Override
    public Optional<Post> findById(Long postId) {
        return postJpaRepository.findById(postId);
    }
}


