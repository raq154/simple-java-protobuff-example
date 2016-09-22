package com.frag.protobuffexample;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.frag.protobuffexample.Config.*;

/**
 * Created by raheel
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
        Socket socket;
        DataOutputStream os;

        socket = new Socket(hostname, portNumber);
        os = new DataOutputStream(socket.getOutputStream());

        System.out.println("Sending message");

        DTOs.Request selectHeroRequest = getSelectHeroRequest();
        selectHeroRequest.writeTo(os);

        System.out.println("Message Sent");

        os.flush();
        os.close();
        socket.close();
    }

    static DTOs.Request getSelectHeroRequest() {
        DTOs.SelectHeroRequest req = DTOs.SelectHeroRequest.newBuilder().addHeroId("DrowRanger").addHeroId("zews").build();
        return DTOs.Request.newBuilder().setM1(req).setRequestId("0001").build();
    }
}
