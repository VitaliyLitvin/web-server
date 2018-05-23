package org.study.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private ResourceReader resourceReader;


    public void start() {


        try(ServerSocket serverSocket = new ServerSocket(port)){
            while(true){
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(
                        new BufferedReader(new InputStreamReader(socket.getInputStream())),
                        socket.getOutputStream(),
                        resourceReader
                );
                requestHandler.handle();
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
