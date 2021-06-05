package com.kcodes.studygame.exceptions;

public class StudyGameException extends RuntimeException {

    public StudyGameException() {
    }

    public StudyGameException(String message) {
        super(message);
    }

    public StudyGameException(String message, Throwable cause) {
        super(message, cause);
    }


}
