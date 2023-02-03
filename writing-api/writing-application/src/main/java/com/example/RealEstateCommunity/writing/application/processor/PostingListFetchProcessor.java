package com.example.RealEstateCommunity.writing.application.processor;

import java.util.Optional;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.RealEstateCommunity.writing.domain.DTO.UserDTO;
import com.example.RealEstateCommunity.writing.domain.DTO.PageDTO;
import com.example.RealEstateCommunity.writing.domain.DTO.PageResultDTO;
import com.example.RealEstateCommunity.writing.domain.DTO.WritingDTO;
import com.example.RealEstateCommunity.writing.domain.Heart;
import com.example.RealEstateCommunity.writing.domain.Post;
import com.example.RealEstateCommunity.writing.domain.repository.HeartRepository;
import com.example.RealEstateCommunity.writing.domain.repository.PostRepository;


public class PostingListFetchProcessor {

    private final PostRepository postRepository;
    private final HeartRepository heartRepository;
    private final String pageCriterion = "id";
    private Boolean existedMyHeart = false;

    public PostingListFetchProcessor(
        PostRepository postRepository,
        HeartRepository heartRepository) {
        this.postRepository = postRepository;
        this.heartRepository = heartRepository;
    }

    @Transactional
    public PageResultDTO<WritingDTO> execute(PageDTO pageDTO, UserDTO userDTO) {

        Pageable pageable = pageDTO.getPageable(Sort.by(pageCriterion).descending());
        Page<Post> result =  postRepository.findByActivedIsTrue(pageable);
        Function<Post, WritingDTO> fn = (entity -> entityToWritingDto(entity,userDTO));

        return new PageResultDTO<>(result,fn);
    }

    public WritingDTO entityToWritingDto(Post post,UserDTO userDTO) {

        if(userDTO.getAccountId() != null) {
            Optional<Heart> heart = heartRepository.findByAccountIdAndPostId(userDTO.getAccountId(), post.getId());
            existedMyHeart = heart.isPresent();
        }
        String writer = post.getAccountNickname() + "(" + post.getAccountType().getRole()+")";
        return new WritingDTO(post.getTitle(), post.getHeartNumber(), writer , existedMyHeart);
    }
}


