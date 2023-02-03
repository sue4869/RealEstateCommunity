package com.example.RealEstateCommunity.writing.domain.exception;

import com.example.RealEstateCommunity.common.error.DomainException;
import com.example.RealEstateCommunity.common.error.ResponseCode;

public class UnAuthorizedUserException extends DomainException {

    public UnAuthorizedUserException() {
        super(ResponseCode.UNAUTHORIZED);
    }

    public UnAuthorizedUserException(String message, ResponseCode errorCode) {
        super(message, ResponseCode.UNAUTHORIZED);
    }
}


