package com.solidegg.remember.global.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final int status;
    private final String message;
    private final T results;

    @Builder
    public ApiResponse(int status, String message, T results) {
        this.status = status;
        this.message = message;
        this.results = results;
    }

    public static <T> ApiResponse<T> onSuccess(int status, String message, T results) {
        return ApiResponse.<T>builder()
                .status(status)
                .message(message)
                .results(results)
                .build();
    }

    public static <T> ApiResponse<T> onFailure(ErrorResponse errorResponse) {
        return ApiResponse.<T>builder()
                .status(errorResponse.getStatus())
                .message(errorResponse.getMessage())
                .results(null)
                .build();
    }
}