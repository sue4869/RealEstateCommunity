package com.example.RealEstateCommunity.common.error;

public class DomainException extends RuntimeException {

    private final ResponseCode errorCode;

    public DomainException(ResponseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public DomainException(String message, ResponseCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public ResponseCode getErrorCode() {
        return errorCode;
    }
}


