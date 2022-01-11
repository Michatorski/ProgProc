package org.iesfm.socketchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

    public static void main(String[] args) {
        int serverPort = 4000;
        try {
            ServerSocket ss = new ServerSocket(serverPort);
            Socket socket = ss.accept();
            Scanner scanner = new Scanner(System.in);
            Thread sendTask = new Thread(new SendMessageTask(scanner, socket));
            sendTask.start();
            Thread readTask = new Thread(new ReadMessageTask(socket));
            readTask.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
