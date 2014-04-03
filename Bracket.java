import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Bracket {

	private Region[] regions = new Region[4];
	private ArrayList<Team> allTeams = new ArrayList<Team>();

	public Bracket() {
		sortBracket();
	}

	public void sortBracket() {
		int index = 0;
		try {
			int count = 0;
			Scanner reader = new Scanner(new File("ncaa2014.csv"));
			regions[count] = new Region();
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
					reader.nextLine();
					next = reader.nextLine();
					count++;
					regions[count] = new Region();
				}

				String[] values = next.split(",");
				int seed = Integer.parseInt(values[1]);
				double wp = Double.parseDouble(values[2]);
				Team team = new Team(values[0], seed, wp, index);
				regions[count].addTeam(team);
				allTeams.add(team);
				index++;
			}

		} catch(IOException e) {
			System.out.println("Could not load file");
			System.exit(1);
		}
	}

	public void simulate(int simulations) {
		for (int j = 0; j<simulations; j++) {
			for (int i=0; i<regions.length; i++) {
				regions[i].simulateRegion();
			}

			Team south = regions[0].returnFinalTeam();
			//System.out.println(south.name());
			Team east = regions[1].returnFinalTeam();
			//System.out.println(east.name());
			Team west = regions[2].returnFinalTeam();
			//System.out.println(west.name());
			Team midwest = regions[3].returnFinalTeam();
			//System.out.println(midwest.name());

			Game game = new Game(south, east);
			Team championshipTeam1 = game.simulateGame();

			game = new Game(west, midwest);
			Team championshipTeam2 = game.simulateGame();

			game = new Game(championshipTeam1, championshipTeam2);
			Team champions = game.simulateGame();
			champions.win();
			//allTeams.set(champions.index(), champions);
		}
	}

	public void printResults() {
		for (Team team : allTeams) {
			System.out.println(team.name() + " - " + team.wins());
		}
	}

}