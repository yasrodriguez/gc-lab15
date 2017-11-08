import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {

	public static void readFromFile() {
		String fileName = "countries.txt";
		createFile(fileName);

		Path writeFile = Paths.get(fileName);
		File file = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			System.out.println();
			reader.close();
		} catch (IOException e) {
			System.out.println("There was an error when reading the file.");
			e.printStackTrace();
		}
	}

	public static void writeToFile(String country) {
		Path writeFile = Paths.get("countries.txt"); // if the file doesn't exist it's automatically created
		File file = writeFile.toFile();

		try {
			// the true parameter appends to the end of the file
			PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
			out.println(country);

			System.out.println("This country has been saved!");
			System.out.println();

			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found.");
			e.printStackTrace();
		}
	}

	public static void createFile(String fileString) {
		Path filePath = Paths.get(fileString);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Your file was created successfully.");
			} catch (IOException e) {
				System.out.println("Error while creating file.");
				e.printStackTrace();
			}
		}
	}
}
