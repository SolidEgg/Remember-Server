package com.solidegg.remember.global.exception.handler;

import com.solidegg.remember.global.exception.BaseException;
import com.solidegg.remember.global.exception.status.ErrorStatus;
import com.solidegg.remember.global.response.ApiResponse;
import com.solidegg.remember.global.response.ErrorReason;
import com.solidegg.remember.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // BaseException 처리
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<Object>> handleBaseException(BaseException e) {
        ErrorResponse errorResponse = ErrorResponse.from(e.getErrorReason());
        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(ApiResponse.onFailure(errorResponse));
    }

    // 유효성 검사 실패 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(" | "));

        ErrorReason reason = ErrorReason.of(
                HttpStatus.BAD_REQUEST.value(),
                ErrorStatus.INVALID_REQUEST.getCode(),
                message
        );

        ErrorResponse errorResponse = ErrorResponse.from(reason);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.onFailure(errorResponse));
    }

    // 예상하지 못한 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception e) {
        log.error("Unexpected Exception", e);
        ErrorReason reason = ErrorStatus.INTERNAL_SERVER_ERROR.getErrorReason();
        ErrorResponse errorResponse = ErrorResponse.from(reason);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.onFailure(errorResponse));
    }
}