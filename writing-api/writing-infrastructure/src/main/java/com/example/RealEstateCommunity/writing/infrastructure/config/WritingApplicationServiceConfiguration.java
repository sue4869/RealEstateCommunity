package com.example.RealEstateCommunity.writing.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.RealEstateCommunity.writing.application.processor.HeartCreateProcessor;
import com.example.RealEstateCommunity.writing.application.processor.MyHeartFetchProcessor;
import com.example.RealEstateCommunity.writing.application.processor.PostCreateProcessor;
import com.example.RealEstateCommunity.writing.application.processor.PostDeleteProcessor;
import com.example.RealEstateCommunity.writing.application.processor.PostModifyProcessor;
import com.example.RealEstateCommunity.writing.application.processor.PostingListFetchProcessor;
import com.example.RealEstateCommunity.writing.domain.UserReader;
import com.example.RealEstateCommunity.writing.domain.repository.HeartRepository;
import com.example.RealEstateCommunity.writing.domain.repository.PostRepository;

@Configuration
public class WritingApplicationServiceConfiguration {

    @Bean
    public PostCreateProcessor postCreateProcessor(PostRepository postRepository, UserReader userReader) {
        return new PostCreateProcessor(postRepository, userReader);
    }

    @Bean
    public PostDeleteProcessor postDeleteProcessorProcessor(PostRepository postRepository) {
        return new PostDeleteProcessor(postRepository);
    }

    @Bean
    public PostModifyProcessor userModifyProcessor(PostRepository postRepository) {
        return new PostModifyProcessor(postRepository);
    }

    @Bean
    public HeartCreateProcessor heartCreateProcessor(HeartRepository heartRepository) {
        return new HeartCreateProcessor(heartRepository);
    }

    @Bean
    public MyHeartFetchProcessor myHeartFetchProcessor(HeartRepository heartRepository) {
        return new MyHeartFetchProcessor(heartRepository);
    }

    @Bean
    public PostingListFetchProcessor postingListFetchProcessor(HeartRepository heartRepository, PostRepository postRepository) {
        return new PostingListFetchProcessor(postRepository,heartRepository);
    }
}


