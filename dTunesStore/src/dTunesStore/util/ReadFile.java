/**
 * Subject : CS542 - Programming Design Pattern
 * Homework : 1
 * Author : Chetan Badhe, Yash Desai.
 * File Name : GenerateDataFile.java
 * Description : Read File
 */
package dTunesStore.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile{

	/**
	 * 
	 * @return : String
	 */
	public String readfile(BufferedReader br) {
		String readline = null;
		try {
			readline = br.readLine();
		} catch (IOException e) {
			System.err.println(e.toString());
			System.exit(1);
		}
		finally{
			
		}
		return readline;
	}
	
	/**
	 * 
	 * @return : String
	 */
	public String toString() {
		return "ReadFile [toString()=" + super.toString() + "]";
	}

	/**
	 * 
	 * @return : int
	 */
	public int countRecords(String fname){
		int count = 0;
		try {

			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"//"+fname));
			while(br.readLine()!=null){
				count++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.toString());
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e.toString());
			System.exit(1);
		}
		finally{

		}
		return count;
	}
}
