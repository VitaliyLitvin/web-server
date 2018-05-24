package org.study.server.exception;

import org.study.server.entity.HttpResponseStatus;

public class ServerException extends RuntimeException {

    HttpResponseStatus httpResponseStatus;

    public ServerException(HttpResponseStatus httpResponseStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpResponseStatus = httpResponseStatus;
    }

    public HttpResponseStatus getHttpResponseStatus() {
        return httpResponseStatus;
    }
}
