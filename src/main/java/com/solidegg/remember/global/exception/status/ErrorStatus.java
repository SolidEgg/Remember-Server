package com.solidegg.remember.global.exception.status;

import com.solidegg.remember.global.exception.BaseErrorCode;
import com.solidegg.remember.global.response.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // Common
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "COMMON_400", "잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_500", "서버 오류가 발생했습니다."),

    // Auth
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "AUTH_401", "인증이 필요합니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH_402", "유효하지 않은 토큰입니다."),

    // Member
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_404", "해당 유저를 찾을 수 없습니다."),
    EMAIL_DUPLICATE(HttpStatus.CONFLICT, "MEMBER_409", "이미 존재하는 이메일입니다."),

    // Diary
    DIARY_NOT_FOUND(HttpStatus.NOT_FOUND, "DIARY_404", "다이어리를 찾을 수 없습니다."),

    // Todo
    TODO_ALREADY_EXISTS(HttpStatus.CONFLICT, "TODO_409", "이미 등록된 할 일입니다."),

    // Letter
    LETTER_EMPTY_CONTENT(HttpStatus.BAD_REQUEST, "LETTER_400", "편지 내용이 비어있습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(httpStatus.value(), code, message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}