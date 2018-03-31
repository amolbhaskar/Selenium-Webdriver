package Day4;

import java.util.List;


public class ArrayList {

	public static void main(String[] args) {
		
		List<String>data = new java.util.ArrayList<>();
	
		
		data.add("india");
		data.add("usa");
		data.add("uk");
		data.add("aus");
		
		
		System.out.println(data.size());
		
		System.out.println("-----------------");
		
		for(String temp : data){
			System.out.println(temp);
		}

	}

}
