package com.fintech.monopostspr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class –°reateInDbException extends RuntimeException {

    public –°reateInDbException(String message) {
        super(message);
    }

}
