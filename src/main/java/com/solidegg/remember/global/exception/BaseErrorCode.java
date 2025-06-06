package com.solidegg.remember.global.exception;

import com.solidegg.remember.global.response.ErrorReason;
import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    ErrorReason getErrorReason();
    HttpStatus getHttpStatus();
}