package org.study.server.exception;

public class IncorrectMethodException extends RuntimeException {

    public IncorrectMethodException(String message, Throwable cause) {
        super(message, cause);
    }
}
