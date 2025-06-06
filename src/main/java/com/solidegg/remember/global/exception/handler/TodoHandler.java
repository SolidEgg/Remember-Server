package com.solidegg.remember.global.exception.handler;

import com.solidegg.remember.global.exception.BaseException;
import com.solidegg.remember.global.exception.status.ErrorStatus;

public class TodoHandler extends BaseException {
    public TodoHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}