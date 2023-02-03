package com.example.RealEstateCommunity.writing.application.processor;

import java.util.Optional;

import javax.transaction.Transactional;
import com.example.RealEstateCommunity.writing.domain.DTO.UserDTO;
import com.example.RealEstateCommunity.writing.domain.Heart;
import com.example.RealEstateCommunity.writing.domain.repository.HeartRepository;
import com.example.RealEstateCommunity.writing.domain.exception.AlreadyHeartException;

public class HeartCreateProcessor {

    private final HeartRepository heartRepository;

    public HeartCreateProcessor(HeartRepository heartRepository) {
        this.heartRepository = heartRepository;
    }

    @Transactional
    public Heart execute(Command command, UserDTO userDTO){
        Optional<Heart> checkHeart = heartRepository.findByAccountIdAndPostId(userDTO.getAccountId(), command.postId);

        if (checkHeart.isPresent())
            throw new AlreadyHeartException();

        Heart newHeart = new Heart(null, command.postId, userDTO.getAccountId());
        heartRepository.save(newHeart);

       return newHeart;
    }

    public static class Command {

        private final Long postId;

        public Command(Long postId) {
            this.postId = postId;
        }
    }
}


