package utils;

import java.io.*;
import java.util.List;

public class FileUtils {
 public static void writeToFile(List<String> data, String filePath) 
 {
	 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
	 {
		 for (String line : data) 
		 {
			 writer.write(line);
			 writer.newLine();
		 }
	 } catch (IOException e) 
	 {
			 e.printStackTrace();
	 }
 }
}

