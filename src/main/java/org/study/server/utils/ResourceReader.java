package org.study.server.utils;

import org.study.server.entity.HttpResponseStatus;
import org.study.server.exception.ServerException;

import java.io.*;

public class ResourceReader {
    private String webAppPath;
    BufferedInputStream bufferedInputStream;

    public ResourceReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public BufferedInputStream readContent(String uri) {
//        String path = webAppPath + File.separator + uri;
        try {
            File file = new File(webAppPath, uri);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new ServerException(HttpResponseStatus.NOT_FOUND, "Resource not found", e);
        }
        return bufferedInputStream;
    }
}
