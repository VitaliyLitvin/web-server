package org.study.server;

import org.study.server.entity.Request;

import org.study.server.exception.ServerException;
import org.study.server.utils.RequestParser;
import org.study.server.utils.ResourceReader;
import org.study.server.utils.ResponseWriter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;


public class RequestHandler {
    private BufferedReader reader;
    private BufferedOutputStream writer;
    private ResourceReader resourceReader;

    public RequestHandler(BufferedReader reader, BufferedOutputStream writer, ResourceReader resourceReader) {
        this.reader = reader;
        this.writer = writer;
        this.resourceReader = resourceReader;
    }

    public void handle() {
        ResponseWriter responseWriter = new ResponseWriter();
        try {
            RequestParser requestParser = new RequestParser();
            Request request = requestParser.parseRequest(reader);
            BufferedInputStream resourceReaderBufferedInputStream = resourceReader.readContent(request.getUri());
            responseWriter.writeSuccessResponse(resourceReaderBufferedInputStream, writer);
        } catch (ServerException e) {
            responseWriter.writeErrorResponse(e.getHttpResponseStatus(), writer);
        }


    }
}
