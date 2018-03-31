package Day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Orange {
	
	public static WebDriver driver = null;
	public static String vURL;
	
	public static String LeaveStatus = "Scheduled";
	
	public static void main(String[] args) {
	
		WebDriver driver = new FirefoxDriver();
		vURL = "http://ambhaskar.trials54.orangehrmlive.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("MO216Tgf");
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		
		driver.findElement(By.xpath("//*[@id='menu_leave_viewLeaveModule']/b")).click();
		driver.findElement(By.xpath("//*[@id='menu_leave_viewLeaveList']")).click();
		
		List<WebElement> chkboxlist = driver.findElements(By.xpath("//input[@name ='leaveList[chkSearchFilter][]']"));
		System.out.println(chkboxlist.size());
		
		for(int i = 0; i<chkboxlist.size(); i++){
			
			//List<WebElement> chkboxlisttext = chkboxlist.get(i).findElements(By.tagName("label"));
			String chkboxlisttext = chkboxlist.get(i).getAttribute("value");
			System.out.println(chkboxlisttext);
			
			/*String checkedchkboxlisttext = chkboxlist.get(i).getAttribute("checked");
			System.out.println(checkedchkboxlisttext);*/
			
			
		/*	for(WebElement cbox : chkboxlisttext){
				
				System.out.println("value in the list : " + cbox.getText());*/
				
/*				if(LeaveStatus.equalsIgnoreCase(cbox.getText())){
					
					cbox.click();
					break;
					
				}*/
			}
			
		}
	
	public void deselectchkbox(){
		WebElement checkbox = driver.findElement(By.xpath("//input[@name ='leaveList[chkSearchFilter][]']"));
		if(checkbox.isSelected()){
			checkbox.click();
		}
		
		
			}
	

	
	}
		
	
	





