package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    public static String writeToFile(List<String> data, String fileName) {
        String filePath = System.getProperty("user.dir") + "/" + fileName;
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String line : data) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
