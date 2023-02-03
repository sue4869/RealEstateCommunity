package com.example.RealEstateCommunity.writing.domain.DTO;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageDTO {

    private int page;
    private int contentsAmount;

    public PageDTO() {
        this.page = 1;
        this.contentsAmount = 9;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, contentsAmount, sort);

    }
}


