package com.example.RealEstateCommunity.writing.presentation.request;

import javax.validation.constraints.NotNull;

import com.example.RealEstateCommunity.writing.application.processor.HeartCreateProcessor;


public class HeartCreateRequest {

    @NotNull
    private Long postId;

    protected HeartCreateRequest() { }

    public HeartCreateRequest(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }

    public HeartCreateProcessor.Command toCommand() {
        return new HeartCreateProcessor.Command(
            this.getPostId()
        );
    }
}
