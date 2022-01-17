import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SendMessage implements Runnable {

    private Socket socket;

    public SendMessage( Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        String line;

        System.out.println("Introduce la ruta del fichero a leer:");

        File filePath = FileUtils.askPath();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            if(filePath.exists()){
                try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
                    while ((line = reader.readLine()) != null) {

                        printWriter.write(line + " " + "\n");

                    }
                    printWriter.write(":end");
                    printWriter.flush();

                    System.out.println("Enviado");
                }
            } else {
                System.out.println("Archivo no existe. Escribe otra ruta:");
                FileUtils.askPath();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
