import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientMain {

    //C:\Users\OmegaKnight\Documents\Prueba\test.txt
    // home/Micho/test.txt

    public static void main(String[] args) {


        String serverIp = "localhost";
        int serverPort = 4000;
        try {
            Socket socket = new Socket(serverIp, serverPort);

            System.out.println("Introduce la ruta para nuevo archivo a escribir:");
            File newFile = FileUtils.askPath();
            if (!newFile.exists()) {
                try (BufferedReader reader = new BufferedReader(
                        new BufferedReader(
                                new InputStreamReader(socket.getInputStream()))
                )) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        FileUtils.writeFile(newFile, line + "\n");

                    }
                    System.out.println("Se ha creado nuevo archivo.");


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Ya existe este fichero. Intentalo de nuevo:");
                FileUtils.askPath();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
