import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    //C:\Users\OmegaKnight\Documents\Prueba\test.txt
    // home/micho/Capeta/test.txt

    public static void main(String[] args) {
        int serverPort = 4000;

        try{
            ServerSocket ss = new ServerSocket(serverPort);
            Socket socket = ss.accept();

            String line;

            System.out.println("Introduce la ruta del fichero a leer:");

            File filePath = FileUtils.askPath();

            if (filePath.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

                    try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
                        while ((line = reader.readLine()) != null) {

                            printWriter.println(line);
                            printWriter.flush();

                        }
                        printWriter.println(":end");
                        printWriter.flush();

                        System.out.println("Enviado");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Archivo no existe. Escribe otra ruta:");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
