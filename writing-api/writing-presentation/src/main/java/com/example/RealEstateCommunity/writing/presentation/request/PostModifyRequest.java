package com.example.RealEstateCommunity.writing.presentation.request;

import javax.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

import com.example.RealEstateCommunity.writing.application.processor.PostModifyProcessor;

public class PostModifyRequest {

    @Nullable
    private String title;
    @NotNull
    private Long postId;
    @Nullable
    private String contents;


    public PostModifyRequest(@Nullable String title, Long postId, @Nullable String contents) {
        this.title = title;
        this.postId = postId;
        this.contents = contents;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public Long getPostId() {
        return postId;
    }

    @Nullable
    public String getContents() {
        return contents;
    }

    public PostModifyProcessor.Command toCommand() {
        return new PostModifyProcessor.Command(
            this.getTitle(),
            this.getPostId(), this.getContents()
        );

    }


}
