package com.example.RealEstateCommunity.writing.presentation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RealEstateCommunity.writing.domain.DTO.UserDTO;
import com.example.RealEstateCommunity.common.response.CommonApiResponse;
import com.example.RealEstateCommunity.writing.application.processor.PostCreateProcessor;
import com.example.RealEstateCommunity.writing.application.processor.PostDeleteProcessor;
import com.example.RealEstateCommunity.writing.application.processor.PostModifyProcessor;
import com.example.RealEstateCommunity.writing.application.processor.PostingListFetchProcessor;
import com.example.RealEstateCommunity.writing.application.processor.UserCheckProcessor;
import com.example.RealEstateCommunity.writing.domain.DTO.PageDTO;
import com.example.RealEstateCommunity.writing.domain.DTO.PageResultDTO;
import com.example.RealEstateCommunity.writing.domain.DTO.WritingDTO;
import com.example.RealEstateCommunity.writing.domain.Post;
import com.example.RealEstateCommunity.writing.presentation.request.PostCreateRequest;
import com.example.RealEstateCommunity.writing.presentation.request.PostDeleteRequest;
import com.example.RealEstateCommunity.writing.presentation.request.PostModifyRequest;

@RestController
@RequestMapping("/posting")
public class PostingController {

    private final PostCreateProcessor postCreateProcessor;
    private final PostModifyProcessor postModifyProcessor;
    private final PostDeleteProcessor postDeleteProcessor;
    private final PostingListFetchProcessor postingListFetchProcessor;
    private final UserCheckProcessor userCheckProcessor;

    public PostingController(PostCreateProcessor postCreateProcessor,
        PostModifyProcessor postModifyProcessor,
        PostDeleteProcessor postDeleteProcessor,
        PostingListFetchProcessor postingListFetchProcessor,
        UserCheckProcessor userCheckProcessor) {
        this.postCreateProcessor = postCreateProcessor;
        this.postModifyProcessor = postModifyProcessor;
        this.postDeleteProcessor = postDeleteProcessor;
        this.postingListFetchProcessor = postingListFetchProcessor;
        this.userCheckProcessor = userCheckProcessor;
    }

    @PostMapping("/createPost")
    public CommonApiResponse<Post> createPost(@RequestBody PostCreateRequest request, HttpServletRequest httpServletRequest) {
        UserDTO userDTO = userCheckProcessor.execute(httpServletRequest, true);
        Post post = postCreateProcessor.execute(request.toCommand(), userDTO);
        return CommonApiResponse.success(post);
    }

    @PostMapping("/modifyPost")
    public CommonApiResponse<Post> modifyPost(@RequestBody PostModifyRequest request, HttpServletRequest httpServletRequest) {
        UserDTO userDTO = userCheckProcessor.execute(httpServletRequest, true);
        Post post = postModifyProcessor.execute(request.toCommand(), userDTO);
        return CommonApiResponse.success(post);
    }

    @PostMapping("/deletePost")
    public CommonApiResponse<Post> deletePost(@RequestBody PostDeleteRequest request, HttpServletRequest httpServletRequest) {
        UserDTO userDTO = userCheckProcessor.execute(httpServletRequest, true);
        Post post = postDeleteProcessor.execute(request.toCommand(),userDTO);
       return CommonApiResponse.success(post);
    }

    @GetMapping("/getWritingList")
    public CommonApiResponse<PageResultDTO<WritingDTO>> getWritingList(PageDTO pageDTO, HttpServletRequest httpServletRequest) {
        UserDTO userDTO = userCheckProcessor.execute(httpServletRequest, false);
        PageResultDTO<WritingDTO> writingList =  postingListFetchProcessor.execute(pageDTO,userDTO);
        return CommonApiResponse.success(writingList);
    }
}


