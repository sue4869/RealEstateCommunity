package com.example.RealEstateCommunity.writing.application.processor;

import com.example.RealEstateCommunity.writing.domain.DTO.UserDTO;
import com.example.RealEstateCommunity.writing.domain.Post;
import com.example.RealEstateCommunity.writing.domain.exception.UnAuthorizedUserException;
import com.example.RealEstateCommunity.writing.domain.repository.PostRepository;

public class PostModifyProcessor {

    private final PostRepository postRepository;

    public PostModifyProcessor(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

   public Post execute(Command command, UserDTO userDTO){
        Post post = postRepository.findById(command.postId).get();
        if(!post.getAccountId().equals(userDTO.getAccountId())) {
            throw new UnAuthorizedUserException();
        }

        post.setContents(command.contents);
        post.setTitle(command.title);
        postRepository.save(post);

        return post;
    }

    public static class Command {
        private final String title;
        private final Long postId;
        private final String contents;

        public Command(String title, Long postId, String contents) {
            this.title = title;
            this.postId = postId;
            this.contents = contents;
        }
    }
}


