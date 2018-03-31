package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Explicit wait --
/*
 * There are pages which get displayed with the JavaScript, 
 * the elements are already present in the browser DOM, but are not visible. 
 * The implicit wait only waits for an element to appear in the DOM, so it returns immediately, 
 * but when you try to interact with the element you get a NoSuchElementException. You could test 
 * this hypothesis by writing a helper method that explicit wait for an element to be visible or clickable.
 * The Document Object
	When an HTML document is loaded into a web browser, it becomes a document object.

	The document object is the root node of the HTML document and the "owner" of all other nodes:
	(element nodes, text nodes, attribute nodes, and comment nodes).

	The document object provides properties(attributes) and methods(actions) to access all node objects, 
	from within JavaScript.
 */

public class Wait {
	
	public static WebDriver driver = null;
	
	public static WebElement getwhenvisible(By locator, int timeout)
	{
		WebElement element = null;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}
	
	public static WebElement elementClickable(By locator, int timeout)
	{
	WebElement element = null;
	WebDriverWait wait = new WebDriverWait(driver,10);
	element=wait.until(ExpectedConditions.elementToBeClickable(locator));
	element.click();
	return element;
	}

	public static void main(String[] args) {

		
		Wait.elementClickable(By.id("//@class[(value = 'ab')]"), 5);
		Wait.getwhenvisible(By.id("//@class[(value = 'ab')]"), 5);
	}

}
