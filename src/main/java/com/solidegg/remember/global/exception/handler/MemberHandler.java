package com.solidegg.remember.global.exception.handler;

import com.solidegg.remember.global.exception.BaseException;
import com.solidegg.remember.global.exception.status.ErrorStatus;

public class MemberHandler extends BaseException {
    public MemberHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}