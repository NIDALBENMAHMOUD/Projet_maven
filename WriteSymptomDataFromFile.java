package com.hemebiotech.analytics;

import java.io.*;

import java.util.*;
/** 
 * Simple implementation
 **/

public class WriteSymptomDataFromFile implements ISymptomWriter {
	private String WriteFile ;
	private String filePath ;
	/**
	 * @param WriteFile Symptom of type String entered by a user
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
    //Constructor
	public WriteSymptomDataFromFile(String filePath,String WriteFile){ 
		this.WriteFile = WriteFile;
		setFilePath(filePath);
	}
	/** 
	 * method that allows you to add a new string line to a file 
	 * and displays a result in the console 
	 * that consists of Counting the number of occurrences of a symptom.
	 * @param addSymptom The name of a list array contains the symptoms add to a file 
	 * without taking repetitions into account.
	 **/
	public void WriteSymptoms(List<String> addSymptom) { 
/*The try-with-resources Statement:
 * the resource declared in the try-with-resources statement is a BufferedReader. 
 * The declaration statement appears within parentheses immediately after the try.*/
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath),true))) {
			bw.newLine();
			bw.write(WriteFile);
			//addSymptom:WriteSymptoms method argument of list type
			Set <String> uniqueSet =  new  HashSet <String> (addSymptom);  
	        for  (String i: uniqueSet) { 
	        	/*
	        	 * int frequency(Collection c, Object o):
	        	 * To obtain the number of the repetition or the frequency 
	        	 * of appearance of an existing element in ArrayList
	        	 */
System.out.println ("number syptoms "+i +  ": "  + Collections.frequency (addSymptom, i));  
	             
	        } 
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	//get Method
	public String getFilePath() {
		return filePath;
	}
	//set Method
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
