package ObjectClass;

//equals()

public class Student {
	
	String name;
	int rollno;
	
	public Student(String name, int rollno){
		
		this.name = name;
		this.rollno = rollno;
	}
	
	public static void main(String[] args) {
		
		Student s1 = new Student("Durga", 101);
		Student s2 = new Student("Ravi", 102);
		Student s3 = new Student("Durga", 101);
		Student s4 = s1;
		
		System.out.println(s1.equals(s2)); //false
		System.out.println(s1.equals(s3)); //false...true
		System.out.println(s1.equals(s4)); //true
	}
	
	public boolean equals(Object obj){
		//String name1 = this.name;
		//int rollno1 = this.rollno;
		try{
		Student s = (Student)obj;
		//String name2 = s.name;
		//int rollno2 = s.rollno;
		
		if(name.equals(s.name) && rollno ==s.rollno){
			return true;
		}
		else{
			return false;
		}
		}
		catch(NullPointerException e){
			return false;
		}
	}
	

}
