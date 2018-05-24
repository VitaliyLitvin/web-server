package org.study.server;

import org.study.server.utils.ResourceReader;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private ResourceReader resourceReader;

    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream())) {
                    RequestHandler requestHandler = new RequestHandler(bufferedReader, bufferedOutputStream, resourceReader);
                    requestHandler.handle();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setWebAppPath(String webAppPath) {
        resourceReader = new ResourceReader(webAppPath);
    }
}
