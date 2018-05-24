package org.study.server.utils;

import org.study.server.entity.HttpResponseStatus;
import org.study.server.exception.ServerException;

import java.io.*;

public class ResponseWriter {

    public void writeSuccessResponse(InputStream resourceIS, OutputStream writer) {
        String responseLine = "HTTP/1.1 " + HttpResponseStatus.OK.getCode() + " " + HttpResponseStatus.OK.getMessage() + " \r\n\r\n";
        byte[] buffer = new byte[8 * 1024];
        int i;
        try (InputStream is = resourceIS) {
            writer.write(responseLine.getBytes());
            while ((i = is.read(buffer)) != -1) {
                writer.write(buffer, 0, i);
            }
            writer.close();
        } catch (IOException e) {
            throw new ServerException(HttpResponseStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
        }
    }


    public void writeErrorResponse(HttpResponseStatus httpResponseStatus, BufferedOutputStream writer) {
        String responseLine = "HTTP/1.1 " + httpResponseStatus.getCode() + " " + httpResponseStatus.getMessage() + " \r\n\r\n";
        try {
            writer.write(responseLine.getBytes());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
