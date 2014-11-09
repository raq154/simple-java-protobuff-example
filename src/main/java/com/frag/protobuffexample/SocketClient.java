package com.frag.protobuffexample;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.frag.protobuffexample.Config.*;

/**
 * Created by raheel on 11/9/2014.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        try {
            sendSimpleMessage();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendSimpleMessage() throws IOException {
        Socket socket = null;
        DataOutputStream os = null;

        socket = new Socket(hostname, portNumber);
        os = new DataOutputStream(socket.getOutputStream());

        System.out.println("Sending message");

        AddressBookProtos.AddressBook addressBook = getAddressBook();
        addressBook.writeTo(os);

        System.out.println("Message Sent");

        os.flush();
        os.close();
        socket.close();
    }


    static AddressBookProtos.AddressBook getAddressBook() {
        return AddressBookProtos.AddressBook.newBuilder()
                .addPerson(AddressBookProtos.Person.newBuilder()
                        .setEmail("raq154@gmail.com")
                        .setName("raheel")
                        .addPhone(AddressBookProtos.Person.PhoneNumber.newBuilder()
                                .setNumber("090078601")
                                .build())
                        .setId(1)
                        .build())
                .addPerson(AddressBookProtos.Person.newBuilder()
                        .setEmail("line47.0@gmail.com")
                        .setName("talha")
                        .addPhone(AddressBookProtos.Person.PhoneNumber.newBuilder()
                                .setNumber("090078601")
                                .build())
                        .setId(2)
                        .build())

                .build();

    }
}
