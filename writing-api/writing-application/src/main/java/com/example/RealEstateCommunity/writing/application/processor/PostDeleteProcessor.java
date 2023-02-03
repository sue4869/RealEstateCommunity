package com.example.RealEstateCommunity.writing.application.processor;

import java.time.Instant;

import javax.transaction.Transactional;

import com.example.RealEstateCommunity.writing.domain.DTO.UserDTO;
import com.example.RealEstateCommunity.writing.domain.Post;
import com.example.RealEstateCommunity.writing.domain.exception.AlreadyDeletedPostException;
import com.example.RealEstateCommunity.writing.domain.repository.PostRepository;
import com.example.RealEstateCommunity.writing.domain.exception.UnAuthorizedUserException;

public class PostDeleteProcessor {

    private final PostRepository postRepository;

    public PostDeleteProcessor(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Post execute(Command command, UserDTO userDTO){

        Post post = postRepository.findById(command.postId).get();
        if(!post.isActived()) {
            throw new AlreadyDeletedPostException();
        }

        if(!post.getAccountId().equals(userDTO.getAccountId())) {
            throw new UnAuthorizedUserException();
        }

        post.setActived(false);
        post.setDeletedAt(Instant.now());
        postRepository.save(post);

        return post;
    }

    public static class Command {

        private final Long postId;

        public Command( Long postId) {
            this.postId = postId;
        }
    }
}


