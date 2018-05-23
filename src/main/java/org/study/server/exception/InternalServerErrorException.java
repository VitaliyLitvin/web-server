package org.study.server.exception;

public class InternalServerErrorException extends RuntimeException  {
    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
