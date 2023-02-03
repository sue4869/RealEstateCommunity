package com.example.RealEstateCommunity.writing.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.RealEstateCommunity.writing.domain.Heart;

public interface HeartRepository {

    Heart save(Heart like);
    Optional<Heart> findByAccountIdAndPostId(Long accountId, Long postId);
    List<Heart> findByAccountId(Long accountId);
    List<Heart> findByChecked(Boolean checked);
}


