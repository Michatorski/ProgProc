import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        int serverPort = 4000;

        try{
            ServerSocket ss = new ServerSocket(serverPort);
            Socket socket = ss.accept();
            Scanner scanner = new Scanner(System.in);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
