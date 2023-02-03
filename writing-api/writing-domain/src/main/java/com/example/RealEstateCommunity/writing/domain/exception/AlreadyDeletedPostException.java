package com.example.RealEstateCommunity.writing.domain.exception;

import com.example.RealEstateCommunity.common.error.DomainException;
import com.example.RealEstateCommunity.common.error.ResponseCode;

public class AlreadyDeletedPostException extends DomainException {
    public AlreadyDeletedPostException() {
        super(ResponseCode.ALREADY_DELETED_POST);
    }

    public AlreadyDeletedPostException(String message, ResponseCode errorCode) {
        super(message, ResponseCode.ALREADY_DELETED_POST);
    }
}


