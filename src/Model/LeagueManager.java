package Model;

//Extended interface for PremierLeagueManager
public interface LeagueManager {
	
    public boolean deleteClub(String name);

	public void addTheClub(FootballClub club, String name, String location, int wins, int draws, int defeats,
			int goalsReceived, int defeatsScored, int points, int matches);

	public void addTheClub(FootballClub club, String name, String location);

	public void showTheClubs();

	public void showTheClubs(String name);

	public void displayPremierLeague();

	public void updateScore(String name, int score);

}
