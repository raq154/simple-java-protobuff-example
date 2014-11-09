package com.frag.protobuffexample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;

import static com.frag.protobuffexample.Config.*;

/**
 * Created by raheel on 11/9/2014.
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        try {
            receiveMessage();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void receiveMessage() throws IOException {
        ServerSocket echoServer = null;
        String line;
        DataInputStream is;
        Socket clientSocket = null;

        echoServer = new ServerSocket(portNumber);
        clientSocket = echoServer.accept();
        is = new DataInputStream(clientSocket.getInputStream());
        AddressBookProtos.AddressBook catFromFile = AddressBookProtos.AddressBook.parseFrom(is);
        System.out.println(catFromFile);


    }
}
