package com.example.RealEstateCommunity.writing.presentation.request;

import javax.validation.constraints.NotNull;

import com.example.RealEstateCommunity.writing.application.processor.PostDeleteProcessor;

public class PostDeleteRequest {

    @NotNull
    private Long postId;

    protected PostDeleteRequest() {

    }

    public PostDeleteRequest(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }

    public PostDeleteProcessor.Command toCommand() {
        return new PostDeleteProcessor.Command(
            this.getPostId()
        );

    }
}
