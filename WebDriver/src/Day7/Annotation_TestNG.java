package Day7;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation_TestNG {
	
	 @BeforeTest
	  public void beforeTest() {
		 System.out.println("beforeTest");
	  }
	 

  @BeforeMethod
  public void beforeClass() {
	  System.out.println("beforemethod");
  }

  @Test
  public void testAnnotation1() {
	  System.out.println("testAnnotation1");
  }
  
  
  @Test
  public void testAnnotation2() {
	  System.out.println("testAnnotation2");
  }
  
  @AfterMethod
  public void afterClass() {
	  System.out.println("aftermethod");
  }

 

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");
  }

}
