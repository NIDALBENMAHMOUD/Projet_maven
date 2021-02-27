package projet2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Nidal Ben Mahmoud Simple class that contains the main method to run
 *         both files: "symptoms.txt" and "result.out"
 */
public class AnalyticsCounter {
	/**
	 * @param Class variable: headacheCount,rashCount,dialatedPupilCount Example to
	 *              Count three symptoms names.
	 */
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int dialatedPupilCount = 0;

	public static void main(String args[]) {
		Path path = Paths.get("symptoms.txt");
/** 
 * reader :instance class BufferedReader. 
 */
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path.toString()));
		} catch (FileNotFoundException e) {
			// path.getFileName():allows to have what is present in last position.
			System.err.printf("le fichier %s est introuvable ! ", path.getFileName());

		}
		/*
		 * read symptoms.txt and write the number of occurrences
		 * of the three symptoms in result.out. 
		 */
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {

				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
				} else if (line.equals("rash")) {
					rashCount++;
					System.out.println("number of rash: " + rashCount);
				} else if (line.contains("dialated pupils")) {
					dialatedPupilCount++;
					System.out.println("dialated pupils: " + dialatedPupilCount);
				}

				try {
					line = reader.readLine();
				} catch (NullPointerException e) {

					System.err.println("\"reader\" is null");
				}
			}
		} catch (IOException e) {
			System.err.printf("Impossible de lire le fichier ! ");
		}

		// next generate output
		FileWriter writer = null;
		try {
			writer = new FileWriter("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + dialatedPupilCount + "\n");
		} catch (IOException e) {
			e.printStackTrace();

		} finally {// Closing resources
			try {
				reader.close();
				writer.close();
			} catch (NullPointerException e) {
				System.err.println("Cannot invoke \"java.io.BufferedReader.close()\" because \"reader\" is null");

			} catch (IOException e) {
				System.out.println("Impossible de fermer le fichier ! ");
			}
		}

	}
}
