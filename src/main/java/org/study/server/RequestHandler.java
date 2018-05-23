package org.study.server;

import org.study.server.entity.Request;
import org.study.server.exception.IncorrectMethodException;
import org.study.server.exception.InternalServerErrorException;
import org.study.server.exception.ResourceNotFoundException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;

public class RequestHandler {
    private BufferedReader reader;
    private OutputStream writer;
    private ResourceReader resourceReader;

    public RequestHandler(BufferedReader reader, OutputStream writer, ResourceReader resourceReader) {
        this.reader = reader;
        this.writer = writer;
        this.resourceReader = resourceReader;
    }

    public void handle() {
        ResponceWriter responceWriter = new ResponceWriter();
        try {
            RequestParser requestParser = new RequestParser();
            Request request = requestParser.parseRequest(reader);
            InputStream resourceIS = resourceReader.readContent(request.getUri());
            responceWriter.writeSuccessResponse(resourceIS, writer);
        } catch(IncorrectMethodException e){
            responceWriter.writeIncorrectMethodResponse(writer);
        } catch (InternalServerErrorException e ){
            responceWriter.writeInternaServerErrorResponse(writer);
        } catch (ResourceNotFoundException e){
            responceWriter.writeResourceNotFoundResponse(writer);
        }



    }
}
