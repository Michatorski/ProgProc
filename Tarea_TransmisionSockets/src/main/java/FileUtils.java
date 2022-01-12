import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void writeFile(File file, String conntent) throws IOException{
        try (FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.write(conntent);
            fileWriter.write(":end");
        }
    }

    public static boolean fileExists (File filePath, String filename){
        String path = filePath.getAbsolutePath() + "/" + filename;
        return  new File(path).exists();
    }
}
