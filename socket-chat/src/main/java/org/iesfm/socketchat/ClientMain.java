package org.iesfm.socketchat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        String serverIp = "localhost";
        int serverPort = 4000;

        try {
            Socket socket = new Socket(serverIp, serverPort);
            Thread readMessageTask = new Thread(new ReadMessageTask(socket));
            readMessageTask.start();

            Scanner scanner = new Scanner(System.in);

            Thread sendMessageTask = new Thread(new SendMessageTask(scanner, socket));
            sendMessageTask.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
