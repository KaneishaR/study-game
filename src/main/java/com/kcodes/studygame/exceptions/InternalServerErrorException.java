package com.kcodes.studygame.exceptions;

public class InternalServerErrorException extends StudyGameException {

    public InternalServerErrorException() {
    }

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
