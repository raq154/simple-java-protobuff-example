package com.frag.protobuffexample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;

import static com.frag.protobuffexample.Config.*;

/**
 * Created by raheel
 * 11/9/2014.
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {

        ServerSocket echoServer;
        Socket socket;

        echoServer = new ServerSocket(portNumber);
        socket = echoServer.accept();

        try {
            receiveMessage(socket);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void receiveMessage(Socket socket) throws IOException {

        DataInputStream is = new DataInputStream(socket.getInputStream());
        DTOs.Request catFromFile = DTOs.Request.parseFrom(is);

        switch (catFromFile.getMsgCase()) {
            case M1:
                System.out.println(catFromFile);
                break;
            default:
                System.out.println("unable to get m1 message");

        }
    }
}
