package com.example.RealEstateCommunity.writing.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import com.example.RealEstateCommunity.writing.domain.Heart;
import com.example.RealEstateCommunity.writing.domain.repository.HeartRepository;
import com.example.RealEstateCommunity.writing.infrastructure.repository.jpa.HeartJpaRepository;

public class HeartRepositoryAdaptor implements HeartRepository {

    private final HeartJpaRepository heartJpaRepository;

    public HeartRepositoryAdaptor(HeartJpaRepository heartJpaRepository) {
        this.heartJpaRepository = heartJpaRepository;
    }

    @Override
    public Heart save(Heart like) {
        return heartJpaRepository.save(like);
    }

    @Override
    public Optional<Heart> findByAccountIdAndPostId(Long accountId, Long postId) {
        return heartJpaRepository.findByAccountIdAndPostId(accountId,postId);
    }

    @Override
    public List<Heart> findByAccountId(Long accountId) {
        return heartJpaRepository.findByAccountId(accountId);
    }

    @Override
    public List<Heart> findByChecked(Boolean checked) {
        return heartJpaRepository.findByChecked(checked);
    }
}


