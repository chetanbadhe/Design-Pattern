/**
 * Subject : CS542 - Programming Design Pattern
 * Homework : 1
 * Author : Chetan Badhe, Yash Desai.
 * File Name : GenerateDataFile.java
 * Description : Generates datafile
 */
package dTunesStore.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GenerateDataFile {

	/**
	 * 
	 * Constructor
	 */
	public GenerateDataFile(String fname) {
		FileWriter fw = null;
		BufferedWriter writer = null;
		try
		{
			File file = new File(System.getProperty("user.dir")+"//"+fname);
			fw = new FileWriter(file);
			writer = new BufferedWriter(fw);
			for (int i = 0 ; i < 200; i++ )
			{
				writer.write("song"+i+" "+"album"+i+" "+"Singer"+i+" "+i+"\n");
			}
			writer.close();
			fw.close();
		}
		catch (Exception ex)
		{	
			System.err.println(ex.toString());
			System.exit(1);
		}
		finally
		{

		}
		Debug.println(4, "[GenerateDataFile()]: File Genereated :"+fname);
	}

	/**
	 * 
	 * @return : String
	 */
	public String toString() {
		return "GenerateDataFile [toString()=" + super.toString() + "]";
	}
}
