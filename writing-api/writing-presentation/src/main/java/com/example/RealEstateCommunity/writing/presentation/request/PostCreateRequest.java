package com.example.RealEstateCommunity.writing.presentation.request;

import javax.validation.constraints.NotNull;

import com.example.RealEstateCommunity.writing.application.processor.PostCreateProcessor;


public class PostCreateRequest {

    @NotNull
    private String title;
    @NotNull
    private String contents;

    public PostCreateRequest(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public PostCreateProcessor.Command toCommand() {
        return new PostCreateProcessor.Command(
            this.getTitle(),
            this.getContents()
        );
    }

}
