package com.example.RealEstateCommunity.writing.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.RealEstateCommunity.writing.domain.repository.PostRepository;
import com.example.RealEstateCommunity.writing.infrastructure.repository.PostRepositoryAdaptor;
import com.example.RealEstateCommunity.writing.infrastructure.repository.jpa.PostJpaRepository;

@Configuration
public class PostRepositoryConfig {

    @Bean
    public PostRepository postRepository(PostJpaRepository postJpaRepository) {
        return new PostRepositoryAdaptor(postJpaRepository);
    }
}


