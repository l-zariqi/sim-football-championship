package View;


import java.util.Scanner;
import Model.FootballClub;
import Model.PremierLeagueManager;

public class Menu {

	//Starting menu with all options
	public void start() {

		Scanner sc = new Scanner(System.in);
                System.out.println("");
                System.out.println("- - - -");
		System.out.println("M E N U");
                System.out.println("- - - -");
		System.out.println("");
		System.out.println("• Press 1: Create a new Football Club and add it in the Premier League");
		System.out.println("• Press 2: Delete (relegate) an exisiting Football Club from the Premier League");
		System.out.println("• Press 3: Display the various statistics for a selected Club");
		System.out.println("• Press 4: Display the Premier League Table");
		System.out.println("• Press 5: Display the Calendar and Events");
		System.out.println("• Press 6: Update Score");
		System.out.println("• Press 7: Set Match Dates");
		System.out.println("• Press 8: Exit");
                System.out.println(" ");

		//Switch case to send user to desired method
		System.out.print("Enter your choice: ");
		String choice;
		choice = sc.next();
		switch (choice) {
		case "1":
			addFootballClub();
			break;
		case "2":
			deleteFootballClub();
			break;
		case "3":
			DisplayTheVariousStatistics();
			break;
		case "4":
			DisplayTheTimeTable();
			break;
		case "5":
			calenderAndEvents();
			break;
		case "6":
			updateScore();
			break;
		case "7":
			setMatchScore();
			break;
		case "8":
			exit();
			break;
		default:
			System.out.println("• Invalid input! Please input again!");
			start();
		}

	}

	//Method for adding object to arraylist
	public void addFootballClub() {
		Scanner sc1 = new Scanner(System.in);
		FootballClub football = new FootballClub("", "", 0, 0, 0, 0, 0, 0, 0);
		System.out.println("");
                System.out.println("- - - - - - - - -");
                System.out.println("A D D  A  C L U B");
                System.out.println("- - - - - - - - -");
		System.out.println("");
		System.out.print("• Enter the Name of your Football Club: ");
		String name = (sc1.nextLine());
		System.out.print("• Enter the Location of your Football Club:");
		String location = (sc1.nextLine());


		//Whether the user wants more details for their club
		System.out.println("Do you want to add any more details to your Club? (Y/N)");
		String choices = sc1.nextLine();
		PremierLeagueManager club = new PremierLeagueManager();
		if (choices.equalsIgnoreCase("Y")) {
			System.out.print("• How many wins in the season?: ");
			int wins = sc1.nextInt();
			System.out.print("• How many draws in the season?: ");
			int draws = sc1.nextInt();
			System.out.print("• How many defeats in the season?: ");
			int defeats = sc1.nextInt();
			System.out.print("• How many goals conceded in the season?: ");
			int goalsReceived = sc1.nextInt();
			System.out.print("• How many goals scored in the season?: ");
			int defeatsScored = sc1.nextInt();
			System.out.print("• How many points your Club currently has?: ");
			int points = sc1.nextInt();
			System.out.print("• How many matches played in the season?: ");
			int matches = sc1.nextInt();
			//sends object with details to Football class
			club.addTheClub(football, name, location, wins, draws, defeats, goalsReceived, defeatsScored, points,
					matches);
                        
                        System.out.println("");
			System.out.println("• Do you want to add another? (Y/N)");
			String choice1 = sc1.nextLine();
			String choice = sc1.nextLine();

			if (choice.equalsIgnoreCase("Y")) {
				addFootballClub();
			} else if (choice.equalsIgnoreCase("N")) {
				start();
			} else {
				System.out.println("• Please enter a valid input!");
				start();
			}

			start();

		} else if (choices.equalsIgnoreCase("N")) {
			club.addTheClub(football, name, location);
			start();
		} else {
			System.err.print("• Please input a valid character!");
			start();
		}
	}

	//Deleting Club from arraylist 
	public void deleteFootballClub() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
                System.out.println("- - - - - - - - - - - -");
		System.out.println("D E L E T E  A  C L U B");
                System.out.println("- - - - - - - - - - - -");
                System.out.println("");
		System.out.println("• Available Clubs:");
		PremierLeagueManager football = new PremierLeagueManager();
		football.showTheClubs();
		System.out.println("• Enter the Name of the Football Club you want to delete: ");
		String name = sc.nextLine();
		PremierLeagueManager club = new PremierLeagueManager();
		boolean result = club.deleteClub(name);
		if (result == true) {
			System.out.println("• Club successfully deleted");
		} else {
			System.out.println("• Club not found! Please try again");
		}
                System.out.println("");
		System.out.println("• Do you want to delete another? (Y/N)");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Y")) {
			deleteFootballClub();
		} else if (choice.equalsIgnoreCase("N")) {
			start();
		} else {
			System.out.println("• Please enter a valid input!");
		}

	}

	//Add statistics to a Club
	public void DisplayTheVariousStatistics() {
		System.out.println("");
                System.out.println("- - - - - - - - - -");
                System.out.println("S T A T I S T I C S");
                System.out.println("- - - - - - - - - -");
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		System.out.println("• Available Clubs:");
		PremierLeagueManager football = new PremierLeagueManager();
		football.showTheClubs();
		System.out.println("• Select the club that you want to display the statistics:");
		String name = sc.nextLine();
		football.showTheClubs(name);
                
                System.out.println("");
		System.out.println("• Would you like to repeat the process? (Y/N)");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Y")) {
			DisplayTheVariousStatistics();
		} else if (choice.equalsIgnoreCase("N")) {
			start();
		} else {
			System.out.println("• Please enter a valid input!");
		}
		sc.close();
	}

	//League Timetable method
	public void DisplayTheTimeTable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
                System.out.println("- - - - - - - - - - - -");
                System.out.println("L E A G U E  T A B L E");
		System.out.println("- - - - - - - - - - - -");
                System.out.println("");
		PremierLeagueManager football = new PremierLeagueManager();
		football.displayPremierLeague();
                
                System.out.println("");
		System.out.println("• Would you like to repeat the process? (Y/N)");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Y")) {
			DisplayTheTimeTable();
		} else if (choice.equalsIgnoreCase("N")) {
			start();
		} else {
			System.out.println("• Please enter a valid input!");
		}
		sc.close();
	}

	//Calendar & Events display, requires valid Year, Month and Date
	public void calenderAndEvents() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
                System.out.println("- - - - - - - - - - - - - - - -");
                System.out.println("C A L E N D A R  &  E V E N T S");
                System.out.println("- - - - - - - - - - - - - - - -");
		System.out.println("");
		System.out.print("• Please enter the Year: ");
		String year = sc.nextLine();
		System.out.print("• Please enter the Month: ");
		MyCalendar sendData = new MyCalendar();
		String month = sc.nextLine();
		sendData.Calendar(month, year);
		System.out.print("• Please choose a Date: ");
		String date = sc.nextLine();
		sendData.displayEvents(date);
                
                System.out.println("");
		System.out.println("• Would you like to repeat the process? (Y/N)");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Y")) {
			calenderAndEvents();
		} else if (choice.equalsIgnoreCase("N")) {
			start();
		} else {
			System.out.println("• Please enter a valid input!");
		}
	}

	//Update the score of a match
	public void updateScore() {
		System.out.println("");
                System.out.println("- - - - - - - - - - - -");
                System.out.println("U P D A T E  S C O R E");
                System.out.println("- - - - - - - - - - - -");
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		PremierLeagueManager club = new PremierLeagueManager();
		club.showTheClubs();
		System.out.println("");
		System.out.print("• Please choose a Club: ");
		String name = sc.nextLine();
		System.out.print("• Enter the score: ");
		int score = sc.nextInt();
		club.updateScore(name, score);
 
		System.out.print("• Would you like to repeat the process? (Y/N)");
		System.out.println(sc.nextLine());
		String choice = sc.nextLine();

		if (choice.equalsIgnoreCase("Y")) {
			updateScore();
		} else if (choice.equalsIgnoreCase("N")) {
			start();
		} else {
			System.out.println("• Please enter a valid input!");
		}

	}

	//Exit program
	public void exit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
                System.out.println("- - - -");
		System.out.println("E X I T");
                System.out.println("- - - -");
                System.out.println("");
		System.out.println("• Are you sure you want to Exit? (Y/N)");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Y")) {
			System.out.println("Program ended.");
		} else if (choice.equalsIgnoreCase("N")) {
			start();
		} else {
			System.out.println("• Please enter a valid input!");
		}

		System.exit(0);
	}

	//Set the match dates
	private void setMatchScore() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("S E T  M A T C H  D A T E");
                System.out.println("- - - - - - - - - - - - -");
		System.out.println("");
		System.out.println("• Available Clubs");
		PremierLeagueManager club = new PremierLeagueManager();
		club.showTheClubs();
		System.out.println("");
		System.out.print("• Select the first Club:");
		String club1 = sc.nextLine();
		System.out.print("• Select the second Club:");
		String club2 = sc.nextLine();
		System.out.print("• Choose the scheduled Date:");
		String date = sc.nextLine();
		System.out.printf("Result : %s vs %s", club1, club2);
		System.out.println("");
		System.out.println("• Would you like to repeat the process? (Y/N)");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Y")) {
			setMatchScore();
		} else if (choice.equalsIgnoreCase("N")) {
			start();
		} else {
			System.out.println("• Please enter a valid input!");
		}

	}

}
