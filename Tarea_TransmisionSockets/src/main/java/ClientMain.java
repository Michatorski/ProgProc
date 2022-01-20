import java.io.*;
import java.net.Socket;


public class ClientMain {

    //C:\Users\OmegaKnight\Documents\Prueba\test.txt
    // /home/micho/Capeta/test.txt

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

                    try (FileWriter fileWriter = new FileWriter(newFile)) {
                        while ((line = reader.readLine()) != null) {
                            if(line.equals(":end")) {
                                break;
                            }
                            fileWriter.write(line + "\n");
                        }

                        System.out.println("Hecho");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Ya existe este fichero. Intentalo de nuevo:");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
