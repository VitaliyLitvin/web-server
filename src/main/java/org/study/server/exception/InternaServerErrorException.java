package org.study.server.exception;

public class InternaServerErrorException extends RuntimeException  {
    public InternaServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
