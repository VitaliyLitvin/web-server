package org.study.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private ResourceReader resourceReader;


    public void start() {
        try(ServerSocket serverSocket = new ServerSocket()){
            while(true){
                Socket socket = serverSocket.accept();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setPort(int port) {
        this.port = port;
    }

    private void setWebAppPath(String webAppPath) {
        resourceReader = new ResourceReader(webAppPath);
    }
}
