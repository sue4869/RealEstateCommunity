package com.example.RealEstateCommunity.writing.application.processor;

import java.util.List;

import javax.transaction.Transactional;

import com.example.RealEstateCommunity.writing.domain.DTO.UserDTO;
import com.example.RealEstateCommunity.writing.domain.Heart;
import com.example.RealEstateCommunity.writing.domain.repository.HeartRepository;

public class MyHeartFetchProcessor {

    private final HeartRepository heartRepository;

    public MyHeartFetchProcessor(HeartRepository heartRepository) {
        this.heartRepository = heartRepository;
    }

    @Transactional
    public List<Heart> execute(UserDTO userDTO) {
        return heartRepository.findByAccountId(userDTO.getAccountId());
    }

}


