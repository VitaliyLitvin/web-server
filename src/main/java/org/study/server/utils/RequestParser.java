package org.study.server.utils;

import org.study.server.entity.HttpMethod;
import org.study.server.entity.HttpResponseStatus;
import org.study.server.entity.Request;
import org.study.server.exception.ServerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class RequestParser {

    public Request parseRequest(BufferedReader reader) {
        Request request = new Request();
        request.setHeaders(new HashMap<String, String>());
        try {
            injectUriAndMethod(request, reader.readLine());
            injectHeaders(request, reader);
        } catch (IOException e) {
            throw new ServerException(HttpResponseStatus.INTERNAL_SERVER_ERROR, "Exception during the reading  request", e);
        }
        return request;
    }

    private void injectUriAndMethod(Request request, String requestLine) {
        String[] requestLineParts = requestLine.split(" ");
        request.setMethod(HttpMethod.getByName(requestLineParts[0]));
        request.setUri(requestLineParts[1]);
    }

    private void injectHeaders(Request request, BufferedReader reader) throws IOException {
        String header;
        while ((header = reader.readLine()).isEmpty()) {
            String[] headerParts = header.split(":", 2);
            request.getHeaders().put(headerParts[0], headerParts[1]);
        }
    }
}
