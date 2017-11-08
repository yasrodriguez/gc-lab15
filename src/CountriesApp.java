import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int userInput = 0;

		System.out.println("Welcome to the Countries Maintenance Application!");

		while (userInput != 3) {
			System.out.println("1 - See the list of countries");
			System.out.println("2 - Add a country");
			System.out.println("3 - Exit");
			System.out.println();

			userInput = Validator.getInt(scan, "Enter menu number: ", 1, 3);
			System.out.println();

			if (userInput == 1) {
				CountriesTextFile.readFromFile();
			} else if (userInput == 2) {
				String country = Validator.getString(scan, "Enter country: ");
				CountriesTextFile.writeToFile(country);
			}
		}
		scan.close();
		System.out.println("Goodbye!");




	}

}
