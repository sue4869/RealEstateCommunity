package com.example.RealEstateCommunity.writing.domain.DTO;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.RealEstateCommunity.writing.domain.Post;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PageResultDTO<DTO> {

    private List<DTO> contentList;

    private int totalPageNumber;

    private int pageNumber;

    private int listSize;

    private int pageStartNumber, pageEndNumber;

    private boolean prev, next;

    private List<Integer> pageNumberList;

    public PageResultDTO(Page<Post> result , Function<Post, DTO> fn){

        contentList = result.stream().map(fn).collect(Collectors.toList());
        totalPageNumber = result.getTotalPages();
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable) {

        this.pageNumber = pageable.getPageNumber() + 1;
        this.listSize = pageable.getPageSize();

        int pageLinkAmount = (int)(Math.ceil(pageNumber/5.0))*5;

        pageStartNumber = pageLinkAmount - 4;

        prev = pageStartNumber > 1;

        pageEndNumber = Math.min(totalPageNumber, pageLinkAmount);

        next = totalPageNumber > pageLinkAmount;

        pageNumberList = IntStream.rangeClosed(pageStartNumber, pageEndNumber).boxed().collect(Collectors.toList());

    }

}


