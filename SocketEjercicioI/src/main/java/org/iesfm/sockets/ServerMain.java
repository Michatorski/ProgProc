package org.iesfm.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

    public static void main(String[] args) {
        int port = 4000;

        Scanner scanner = new Scanner(System.in);

        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Esperando conexion...");
            Socket socket = ss.accept();
            System.out.println("Conexion estableciad!");

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
