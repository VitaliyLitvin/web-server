package org.study.server;

import org.study.server.entity.Request;
import org.study.server.exception.IncorrectMethodException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;

public class RequestHandler {
    private BufferedReader reader;
    private OutputStream writer;
    private ResourceReader resourceReader;

    public void handle() {
        ResponceWriter responceWriter = new ResponceWriter();
        try {
            RequestParser requestParser = new RequestParser();
            Request request = requestParser.parseRequest(reader);
            InputStream resourceIS = resourceReader.readContent(request.getUri());
            responceWriter.writeSuccessResponce(resourceIS, writer);
        } catch(IncorrectMethodException e){

        }



    }
}
