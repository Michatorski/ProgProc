package org.iesfm.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SenderTask implements Runnable {
    private Socket socket;
    private Scanner scanner;

    public SenderTask(Socket socket, Scanner scanner) {
        this.socket = socket;
        this.scanner = scanner;
    }

    @Override
    public void run() {

        try(PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            while (true) {
            String message = scanner.nextLine();
            writer.println(message);
            writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
