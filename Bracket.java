import java.io.*;
import java.util.Scanner;

public class Bracket {

	private Region[] bracket = new Region[4];

	public Bracket() {
		sortBracket();
	}

	public void sortBracket() {
		try {
			int count = 0;
			Scanner reader = new Scanner(new File("ncaa2014.csv"));
			bracket[count] = new Region();
			if (reader.hasNextLine()) {
				reader.nextLine();
				reader.nextLine();
			}

			while (reader.hasNextLine()) {
				String next = reader.nextLine();
				if (next.equals("")) {
					next = reader.nextLine();
				}

				if (next.equals("East") || next.equals("West") || next.equals("Midwest")) {
					count++;
					reader.nextLine();
					next = reader.nextLine();
					bracket[count] = new Region();
				}

				String[] values = next.split(",");
				bracket[count].newTeam(values);
			}

		} catch(IOException e) {
			System.out.println("Could not load file");
			System.exit(1);
		}
	}

	public void simulate(int simulations) {
		for (Region region : bracket) {
			region.simulateRegion();
		}
	}

	public void printResults() {

	}

}