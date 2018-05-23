package org.study.server;

import org.study.server.exception.InternalServerErrorException;

import java.io.*;

public class ResponceWriter {

    public void writeSuccessResponse(InputStream resourceIS, OutputStream writer) {
        byte[] buffer = new byte[8 * 1024];
        int i;
        try {
            while ((i = resourceIS.read(buffer))!= -1 ) {
                writer.write(buffer, 0, i);
            }
        } catch (IOException e ){
            throw new InternalServerErrorException("Exception during the reading  resource", e);
        }

    }

    public void writeInternaServerErrorResponse(OutputStream writer){
        try {
            BufferedWriter bufferedReader = new BufferedWriter(new OutputStreamWriter(writer));
            bufferedReader.write("500 Internal Server Error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeIncorrectMethodResponse(OutputStream writer){
        try {
            BufferedWriter bufferedReader = new BufferedWriter(new OutputStreamWriter(writer));
            bufferedReader.write("400 Bad Request");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeResourceNotFoundResponse(OutputStream writer){
        try {
            BufferedWriter bufferedReader = new BufferedWriter(new OutputStreamWriter(writer));
            bufferedReader.write("404 Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
