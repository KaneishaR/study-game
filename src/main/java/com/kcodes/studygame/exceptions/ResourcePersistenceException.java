package com.kcodes.studygame.exceptions;

public class ResourcePersistenceException extends StudyGameException {

    public ResourcePersistenceException() {
        super("Resource not persisted");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }

    public ResourcePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
