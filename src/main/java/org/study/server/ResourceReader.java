package org.study.server;

import org.study.server.exception.ResourceNotFoundException;

import java.io.*;

public class ResourceReader {
    private String webAppPath;

    public ResourceReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    BufferedInputStream readContent(String uri) {
        String path = webAppPath + File.separator + uri;
        BufferedInputStream reader = null;
        try {
            reader = new BufferedInputStream(new FileInputStream(path));
        }
        catch (FileNotFoundException e) {
            throw new ResourceNotFoundException("", e);
        }

        return reader;
    }
}
