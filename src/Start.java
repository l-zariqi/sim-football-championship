import java.util.Scanner;
import View.Menu;


public class Start {

	//Main class implemented for protection
        //Username and Password = w1712905
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Username: ");
		String name = sc.nextLine();
		System.out.print("Enter Password: ");
		String password = sc.nextLine();
		
		if(name.equalsIgnoreCase("w1712905") && password.equalsIgnoreCase("w1712905")){
			Menu start = new Menu();
			start.start();
		}else{
			System.out.println("Username or Password is incorrect. Please try again.");
			main(args);
		}
	}

}
