package org.study.server;

import java.io.*;

public class ResponceWriter {

    public void writeSuccessResponce(InputStream resourceIS, OutputStream writer) {
        byte[] buffer = new byte[8 * 1024];
        int i;
        try {
            while ((i = resourceIS.read(buffer))!= -1 ) {
                writer.write(buffer, 0, i);
            }
        } catch (IOException e ){

        }

    }


}
