public class Game {

	private Team team1;
	private Team team2;

	public Game(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
	}

	public double winPercent() {
		return (team1.wp() - (team1.wp() * team2.wp())) / ((team1.wp() + team2.wp()) - (2 * team1.wp() * team2.wp()));
	}

	public Team simulateGame() {
		if (Math.random() <= winPercent()) {
			//System.out.println(team1.name());
			return team1;
		} else {
			//System.out.println(team2.name());
			return team2;
		}

	}



}