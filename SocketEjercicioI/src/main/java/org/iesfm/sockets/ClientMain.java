package org.iesfm.sockets;

import java.io.BufferedReader;
import java.io.IOException;

import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        String serverIp = "localhost";
        int serverPort = 4000;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Conectado!");
        try {
            Socket socket = new Socket(serverIp, serverPort);

            Thread reader = new Thread(new ReaderTask(socket));

            Thread sender = new Thread(new SenderTask(socket, scanner));

            reader.start();
            sender.start();

            try {
                reader.join();
                sender.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}



