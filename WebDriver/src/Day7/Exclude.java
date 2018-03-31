package Day7;

import org.testng.annotations.Test;

public class Exclude {

	//Disabled software test methods will be excluded automatically during execution.
	
	@Test(enabled = false)
    public void LogOut() {
  System.out.println("LogOut Test code."); 
    }
	
	@Test
	public void login(){
		System.out.println("logged in");
	}

}
