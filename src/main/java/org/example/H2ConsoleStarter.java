package org.example;

import org.h2.tools.Server;

public class H2ConsoleStarter {
    public static void main(String[] args) throws Exception {
        Server h2Server = Server.createWebServer("-web", "-webPort", "9090").start();
        System.out.println("H2 Console started at " + h2Server.getURL());
    }
}