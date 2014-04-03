import java.util.ArrayList;
public class Region {

	private ArrayList<Team> regionTeams = new ArrayList<Team>();
	private ArrayList<Team> regionTeamsUnAlt = new ArrayList<Team>();

	public Region() {

	}

	public void addTeam(Team team) {
		regionTeamsUnAlt.add(team);
	}

	public void simulateRegion() {
		for(Team team: regionTeamsUnAlt) {
			regionTeams.add(team);
		}
		//System.out.println("Second Round");
		simulateRound(16);
		//System.out.println();
		//System.out.println("Third Round");
		simulateRound(8);
		//System.out.println();
		//System.out.println("Regional Semifinals");
		simulateRound(4);
		//System.out.println();
		//System.out.println("Regional Finals");
		simulateRound(2);
		//System.out.println();
	}

	public void simulateRound(int numberOfTeams) {
		for (int i=0; i<numberOfTeams/2; i++) {
			Game game = new Game(regionTeams.get(i), regionTeams.get(i+1));
			regionTeams.set(i, game.simulateGame());
			regionTeams.remove(i+1);
		}
	}

	public Team returnFinalTeam() {
		return regionTeams.get(0);
	}
}