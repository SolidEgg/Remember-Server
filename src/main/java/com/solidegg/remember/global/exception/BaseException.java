package com.solidegg.remember.global.exception;

import com.solidegg.remember.global.response.ErrorReason;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BaseException extends RuntimeException {
    private final BaseErrorCode errorCode;

    public ErrorReason getErrorReason() {
        return errorCode.getErrorReason();
    }
}