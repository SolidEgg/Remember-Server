package com.solidegg.remember.global.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private final int status;
    private final String code;
    private final String message;

    @Builder
    public ErrorResponse(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public static ErrorResponse from(ErrorReason reason) {
        return ErrorResponse.builder()
                .status(reason.getStatus())
                .code(reason.getCode())
                .message(reason.getReason())
                .build();
    }
}