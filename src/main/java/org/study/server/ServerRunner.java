package org.study.server;

public class ServerRunner {

    public static void main(String[] args) {
        Server  server = new Server();
        server.setPort(3000);
        server.start();


    }

}
