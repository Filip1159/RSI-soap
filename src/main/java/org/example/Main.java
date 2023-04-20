package org.example;

import jakarta.xml.ws.Endpoint;

import java.io.IOException;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Web Service PersonService is running ...");

        PersonServiceImpl psi = new PersonServiceImpl();
        Endpoint.publish("http://localhost:8081/personservice", psi);
        System.out.println("Press ENTER to STOP PErsonService ...");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        exit(0);
    }
}