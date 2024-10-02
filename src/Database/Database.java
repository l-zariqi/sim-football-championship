package Database;

import javax.swing.*;
import java.sql.*;

public class Database {

	Connection conn = null;

	public static Connection ConnecrDb() { //Connects to the Database

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/PremierLeague", "root", "w1712905");
			return conn;
                //Handles exceptions
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;

		}
	}

}