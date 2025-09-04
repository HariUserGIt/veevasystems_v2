package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSVUtils {
	 public static void writeLinksToCSV(List<String> links, String filePath) throws IOException 
	 {
		 Set<String> uniqueLinks = new HashSet<>();
		 Set<String> duplicateLinks = new HashSet<>();
	
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
		 {
			 for (String link : links) 
			 {
				 if (!uniqueLinks.add(link)) 
				 {
					 duplicateLinks.add(link);
				 }
				 writer.write(link);
				 writer.newLine();
			 }
		 }
	
		 if (!duplicateLinks.isEmpty()) 
		 {
			 System.out.println("Duplicate links found:");
			 duplicateLinks.forEach(System.out::println);
		 } else 
		 {
			 System.out.println("No duplicate links found.");
		 }
		 }
	}


