package cl.ccla.managetxtfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TxtFile {
	
	private final static String STR_EXCEPTION = "Exception found >>>>> "; 

	/**
	 * 
	 * @param nameFile
	 * @throws IOException
	 */
	public static void removeContentOfFile(String nameFile) throws IOException {
		
		try {
			PrintWriter writer = new PrintWriter(nameFile);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException ex) {
			throw new IOException(STR_EXCEPTION.concat(ex.getMessage()));
		}
		
	}
	
	/**
	 * 
	 * @param nameFile
	 * @param text
	 * @throws IOException
	 */
	public static void writeText(String nameFile, String text) throws IOException {
		
		try {
			File file = new File(nameFile);
			FileWriter fw = new FileWriter(file);
			PrintWriter writer = new PrintWriter(fw);
	        writer.print(text);

	        writer.close();
		} catch (FileNotFoundException ex) { 
			throw new IOException(STR_EXCEPTION.concat(ex.getMessage()));
		} 
	}
	
	public static void writeArrayText(String nameFile, ArrayList<String> lstText) throws IOException {
		
		try {
			File file = new File(nameFile);
			FileWriter fw = new FileWriter(file);
			PrintWriter writer = new PrintWriter(fw);
			
			for (String text : lstText) {
				writer.println(text);
			}
			
	        writer.close();
		} catch (FileNotFoundException ex) { 
			throw new IOException(STR_EXCEPTION.concat(ex.getMessage()));
		} 
	}
	
	/**
	 * 
	 * @param nameFile
	 * @return
	 * @throws IOException
	 */
	public static String readText(String nameFile) throws IOException {
		
		String response = "";
		try {
			FileReader reader = new FileReader(nameFile);
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        
	        String line;
	        

	        while ((line = bufferedReader.readLine()) != null) {
	            response = response.concat(line);
	        }
	        reader.close();
		} catch (FileNotFoundException ex) {
			throw new IOException(STR_EXCEPTION.concat(ex.getMessage()));
		}
		
		return response;
	}
	
	/**
	 * 
	 * @param nameFile
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String> readListText(String nameFile) throws IOException {
		
		ArrayList<String> response = new ArrayList<String>();
		
		try {
			FileReader reader = new FileReader(nameFile);
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        
	        String line;

	        while ((line = bufferedReader.readLine()) != null) {
	            response.add(line);
	        }
	        reader.close();
		} catch (FileNotFoundException ex) {
			throw new IOException(STR_EXCEPTION.concat(ex.getMessage()));
		}
		
		return response;
	}
	
	public static void createFile(String nameFile) throws IOException  {
		File file = new File(nameFile);
		
		if (!file.exists()) {
            file.createNewFile();
        }
	}
	
	public static void deleteFile(String nameFile) throws IOException  {
		File file = new File(nameFile);
		
		if (file.exists()) {
            file.delete();
        }
	}
	
	public static boolean existFile(String nameFile) throws IOException  {
		File file = new File(nameFile);
		
		if (file.exists()) {
            return true;
        }else {
        	return false;
        }
	}

}
