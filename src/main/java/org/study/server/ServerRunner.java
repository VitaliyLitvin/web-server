package org.study.server;

public class ServerRunner {

    public static void main(String[] args) {
        Server  server = new Server();
        server.setPort(8081);
        server.setWebAppPath("webapp");
        server.start();


    }

}
