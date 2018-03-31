package Day7;

import org.testng.annotations.Test;

public class RegisterTest {
	
	@Test(dataProviderClass=Dataprovider.class,dataProvider="regTestDataProvider" )
	public void doRegister(String username, String password, String email){
		
	}

}
