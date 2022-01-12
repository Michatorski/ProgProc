import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ReadMessage implements Runnable {
    private Socket socket;

    public ReadMessage(Socket socket) {
        this.socket = socket;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new BufferedReader(new InputStreamReader(socket.getInputStream())))) {
            String line;
            String path = scanner.nextLine();
            File file = new File(path);

            while ((line = reader.readLine()) != null) {
                FileUtils.writeFile(file, line + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
