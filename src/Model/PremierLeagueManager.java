package Model;

//Maintains a number of Football Clubs which play in the Premier League
import Database.DatabaseManager;
import View.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.View;


public class PremierLeagueManager implements LeagueManager {

	static List<FootballClub> football = new ArrayList<FootballClub>();

	public void addTheClub(FootballClub club, String name, String location, int wins, int draws, int defeats,
			int goalsReceived, int defeatsScored, int points, int matches) {
		club = new FootballClub(name, location, wins, draws, defeats, goalsReceived, defeatsScored, points, matches);
		football.add(club);
	}

	public void addTheClub(FootballClub club, String name, String location) {
		club = new FootballClub(name, location);
		football.add(club);
		Serialize sendData = new Serialize();
		sendData.serialize(football);

	}


	public boolean deleteClub(String name) {
		for (int idx = 0; idx < football.size(); idx++) {
			if (football.get(idx).getNameOfTheClub().equals(name)) {
				football.remove(idx);
				return true;
			}
		}
		return false;
	}

	public void showTheClubs() {
		for (int idx = 0; idx < football.size(); idx++) {
			System.out.print(football.get(idx).getNameOfTheClub() + " | ");
		}
		System.out.println("");
	}

	public void showTheClubs(String name) {
		for (int idx = 0; idx < football.size(); idx++) {
			if (football.get(idx).getNameOfTheClub().equals(name)) {
				FootballClub index = football.get(idx);
				DisplayDetails send = new DisplayDetails();
				send.displayDetails(index);
			} else {
				System.out.println("Club not found!");
			}
		}

	}

	public void displayPremierLeague() {
		DisplayDetails send = new DisplayDetails();
		send.displayPremierLeagueTable(football);

	}

	public void updateScore(String name, int score) {
		for (int idx = 0; idx < football.size(); idx++) {
			if (football.get(idx).getNameOfTheClub().equals(name)) {
				FootballClub index = football.get(idx);
				int currentGoals = index.getGoalsScored();
				index.setGoalsScored(currentGoals += score);

			}
		}
	}
}
