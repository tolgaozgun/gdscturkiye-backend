package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class ConnectionErrorException extends BaseException {

    public ConnectionErrorException() {
        super("Connection error!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
