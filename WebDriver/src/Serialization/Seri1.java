package Serialization;

//Also called Marshaling
//Mechanism of writing state of an object into byte stream.
//Reverse is de-serialization.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Seri1 {
	
	//public static Player p = null;
	
	public static void main(String[] args) throws IOException {
		
		/*ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");*/
		
		
		Player p = new Player();
		p.setName("Kohli");
		p.setAge(28);
		p.setPosition("Batsman");
		p.setNationality("Indian");
		//p.setCourses(courses);

		File file = new File("Player.txt");

		try {
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream objout = new ObjectOutputStream(fout);

			objout.writeObject(p);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream objin = new ObjectInputStream(fis);
		
		
		try {
			Player p1 = (Player) objin.readObject();
			System.out.println(p1);
			/*Output
					name = Kohli, 
					age = 28, 
					position = Batsman, 
					Nationality = Indian*/
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		
	}

}

class Player implements Serializable {

	String name;
	int age;
	String position = "Batsman";
	transient String sponsor = "Sahara"; //will not serialized..also static variables
	String Nationality = "Indian";
	//List<String> courses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	
	/*public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
*/
	// print the Object directly using toString method.
	@Override
	public String toString() {
		return "name = " + getName() + ", " + "\n" + "age = " + getAge() + ", " + "\n" + "position = "
				+ getPosition() + ", " + "\n" + "Nationality = " + getNationality();
	}
}
