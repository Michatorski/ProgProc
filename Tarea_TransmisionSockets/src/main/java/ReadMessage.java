import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ReadMessage implements Runnable {
    private Socket socket;

    public ReadMessage(Socket socket) {
        this.socket = socket;
    }

//C:\Users\OmegaKnight\Documents\Prueba\test.txt

    @Override
    public void run() {

        try (BufferedReader reader = new BufferedReader(
                new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))
        )) {
            String line;

            System.out.println("Introduce la ruta para nuevo archivo a escribir:");
            File newFile = FileUtils.askPath();
            if (!newFile.exists()) {
                while ((line = reader.readLine()) != null) {
                    FileUtils.writeFile(newFile, line + "\n");

                }
                System.out.println("Se ha creado nuevo archivo.");
            } else {
                System.out.println("Ya existe este fichero. Intentalo de nuevo:");
                FileUtils.askPath();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
