package com.hemebiotech.analytics;

import java.util.List;

public class FileTesteur {

	public static void main(String[] args) {
		ISymptomReader isr = new ReadSymptomDataFromFile("symptoms.txt");
		
		List<String> listAReturn = isr.GetSymptoms();
		ISymptomWriter isw = new WriteSymptomDataFromFile("symptoms.txt","premier test"); 
		isw.WriteSymptoms(listAReturn);
		
		
		
		
		

	}

}
