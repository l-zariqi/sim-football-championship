package Model;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

//Serialize the objects and write it in the file.io and the DB
public class Serialize implements Serializable {

	public void serialize(List<FootballClub> football) {

		try {
			FileOutputStream fileOut = new FileOutputStream("w1712905.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(football);
			out.close();
			fileOut.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Deserialize the object
		try {
			FileInputStream fileIn = new FileInputStream("w1712905.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			List<FootballClub> iis = new ArrayList<FootballClub>();

			iis = (List<FootballClub>) in.readObject();

			for (FootballClub is : iis) {
				System.out.println(is);
			}
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
