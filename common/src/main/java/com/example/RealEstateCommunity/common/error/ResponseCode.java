package com.example.RealEstateCommunity.common.error;

public enum ResponseCode {

    UNAUTHORIZED(400,"권한이 없는 사용자의 접근입니다"),
    ALREADY_LIKE(400,"이미 좋아요 표시하였습니다"),
    ALREADY_DELETED_POST(400,"이미 삭제처리된 게시물입니다"),
    SYSTEM_ERROR(500,"알수 없는 오류가 발생했습니다. 잠시 후 다시 시도해주세요");

    private final int status;
    private final String message;

    ResponseCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}


