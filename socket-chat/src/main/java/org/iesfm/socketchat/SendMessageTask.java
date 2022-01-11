package org.iesfm.socketchat;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SendMessageTask implements Runnable {

    private Scanner scanner;
    private Socket socket;

    public SendMessageTask(Scanner scanner, Socket socket) {
        this.scanner = scanner;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream())){
           while (true) {
               String message = scanner.nextLine();
               printWriter.println(message);
               printWriter.flush();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
