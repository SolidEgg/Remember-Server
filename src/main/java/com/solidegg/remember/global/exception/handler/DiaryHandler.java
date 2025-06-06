package com.solidegg.remember.global.exception.handler;

import com.solidegg.remember.global.exception.BaseException;
import com.solidegg.remember.global.exception.status.ErrorStatus;

public class DiaryHandler extends BaseException {
    public DiaryHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}