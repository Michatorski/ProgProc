import java.io.IOException;
import java.net.Socket;


public class ClientMain {

    public static void main(String[] args) {
        String serverIp = "localhost";
        int serverPort = 4000;
        try {
            Socket socket = new Socket(serverIp, serverPort);
            Thread readMessageTask = new Thread(new ReadMessage(socket));
            readMessageTask.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
