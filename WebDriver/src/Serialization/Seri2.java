package Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
	
	String name;
	int age;
	
	public Student(String name,int age){
		
		this.name = name;
		this.age = age;
		
	}
	
}

public class Seri2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Student student = new Student("Ammo",12);
		
		try {
			FileOutputStream fout = new FileOutputStream("Student.txt");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(student);
			oout.flush();
			System.out.println("success");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		FileInputStream fis = new FileInputStream("Student.txt");
		ObjectInputStream iis = new ObjectInputStream(fis);
		Student student1 = (Student)iis.readObject();
		System.out.println(student1.name + ", "+ student1.age);
		iis.close();
	}

}
