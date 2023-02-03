package com.example.RealEstateCommunity.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.RealEstateCommunity.common.error.ResponseCode;
import com.example.RealEstateCommunity.common.response.CommonApiResponse;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class CommonHandlerException {

    private static final Logger log = LoggerFactory.getLogger(CommonHandlerException.class);

    @ResponseStatus
    @ExceptionHandler(Exception.class)
    public CommonApiResponse<Object> onException(Exception e) {
        log.error("SystemError: ", e);
        return CommonApiResponse.fail(ResponseCode.SYSTEM_ERROR);
    }
}


