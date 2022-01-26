import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {

    public static Scanner scanner = new Scanner(System.in);


    public static File askPath (){

        return new File(scanner.nextLine());
    }
}
