package com.example.RealEstateCommunity.writing.presentation.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.RealEstateCommunity.common.response.CommonApiResponse;
import com.example.RealEstateCommunity.writing.domain.exception.AlreadyDeletedPostException;
import com.example.RealEstateCommunity.writing.domain.exception.AlreadyHeartException;
import com.example.RealEstateCommunity.writing.domain.exception.UnAuthorizedUserException;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WritingExceptionHandler {


    @ExceptionHandler(UnAuthorizedUserException.class)
    public CommonApiResponse<Object> UnAuthorizedUserExceptionHandler(UnAuthorizedUserException exception) {
        return CommonApiResponse.fail(exception.getErrorCode().name(),exception.getMessage());
    }

    @ExceptionHandler(AlreadyDeletedPostException.class)
    public CommonApiResponse<Object> AlreadyDeletedPostExceptionHandler(AlreadyDeletedPostException exception) {
        return CommonApiResponse.fail(exception.getErrorCode().name(),exception.getMessage());
    }

    @ExceptionHandler(AlreadyHeartException.class)
    public CommonApiResponse<Object>AlreadyLikedExceptionHandler(AlreadyHeartException exception) {
        return CommonApiResponse.fail(exception.getErrorCode().name(),exception.getMessage());
    }
}


