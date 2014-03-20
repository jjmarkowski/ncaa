public class Region {

	private Team[] regionTeams = new Team[16];
	private int count = 0;

	public Region() {

	}

	public void newTeam(String[] values) {
		int seed = Integer.parseInt(values[1]);
		double wp = Double.parseDouble(values[2]);
		regionTeams[count] = new Team(values[0], seed, wp);
		count++;
	}

	public void simulateRegion() {
		// for (Team team: regionTeams) {
		// 	System.out.println(team.name());
		// }
		secondRound();
		
	}

	public void secondRound() {
		for (int i=0; i<=15; i+=2) {
			Game game = new Game(regionTeams[i], regionTeams[i+1]);
			if(game.simulateGame()) {
				regionTeams[i].win();
				System.out.println(regionTeams[i].name());
			} else {
				regionTeams[i+1].win();
				System.out.println(regionTeams[i+1].name());
			}
		}
	}

}