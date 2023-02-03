package com.example.RealEstateCommunity.writing.domain.exception;

import com.example.RealEstateCommunity.common.error.DomainException;
import com.example.RealEstateCommunity.common.error.ResponseCode;

public class AlreadyHeartException extends DomainException {

    public AlreadyHeartException() {
        super(ResponseCode.ALREADY_LIKE);
    }

    public AlreadyHeartException(String message, ResponseCode errorCode) {
            super(message, ResponseCode.ALREADY_LIKE);
    }
}


