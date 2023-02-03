package com.example.RealEstateCommunity.writing.application.processor;

import javax.transaction.Transactional;

import com.example.RealEstateCommunity.writing.domain.DTO.UserDTO;
import com.example.RealEstateCommunity.writing.domain.Post;
import com.example.RealEstateCommunity.writing.domain.ReadUserModel;
import com.example.RealEstateCommunity.writing.domain.UserReader;
import com.example.RealEstateCommunity.writing.domain.repository.PostRepository;

public class PostCreateProcessor {

    private final PostRepository postRepository;
    private final UserReader userReader;

    public PostCreateProcessor(PostRepository postRepository,
        UserReader userReader) {
        this.postRepository = postRepository;
        this.userReader = userReader;
    }

    @Transactional
    public Post execute(Command command, UserDTO userDTO ) {
        ReadUserModel userModel = userReader.getUserByAccountId(userDTO.getAccountId());
        Post newPost = new Post(command.title, userDTO.getAccountId(),userModel.getAccountType(),
            userModel.getNickname(), command.contents);
        postRepository.save(newPost);
        return newPost;
    }

    public static class Command {
        private final String title;
        private final String contents;

        public Command(String title, String contents) {
            this.title = title;
            this.contents = contents;
        }
    }
}


