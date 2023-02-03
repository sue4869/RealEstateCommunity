package com.example.RealEstateCommunity.writing.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.RealEstateCommunity.writing.domain.repository.HeartRepository;
import com.example.RealEstateCommunity.writing.infrastructure.repository.HeartRepositoryAdaptor;
import com.example.RealEstateCommunity.writing.infrastructure.repository.jpa.HeartJpaRepository;

@Configuration
public class HeartRepositoryConfig {

    @Bean
    public HeartRepository HeartRepository(HeartJpaRepository heartJpaRepository) {
        return new HeartRepositoryAdaptor(heartJpaRepository);
    }

}


