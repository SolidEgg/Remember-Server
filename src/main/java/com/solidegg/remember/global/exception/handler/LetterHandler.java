package com.solidegg.remember.global.exception.handler;

import com.solidegg.remember.global.exception.BaseException;
import com.solidegg.remember.global.exception.status.ErrorStatus;

public class LetterHandler extends BaseException {
    public LetterHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}