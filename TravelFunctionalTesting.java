import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.*;


public class TravelFunctionalTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_Learning\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://jt-dev.azurewebsites.net/#/SignUp");
		Thread.sleep(10000);
		driver.findElement(By.id("language")).click();
		Thread.sleep(3000);
		List<WebElement> allOptions = driver.findElements(By.cssSelector("div[class='ng-binding ng-scope']"));
	    int size = allOptions.size();
	    List <String> menuItem = new ArrayList<String>(); 
	    for(int i =0; i<size ; i++){
	         String options = allOptions.get(i).getText();
	         //System.out.println(options);
	         menuItem.add(options);
	      }
	    Assert.assertTrue(menuItem.get(0).contentEquals("English"));
	    Assert.assertTrue(menuItem.get(1).contentEquals("Dutch"));
		System.out.println("English and Dutch is present in dropdown");

		driver.findElement(By.id("name")).sendKeys("Priyanka Dhamal");
		driver.findElement(By.id("orgName")).sendKeys("Priyanka Dhamal");
		driver.findElement(By.id("singUpEmail")).sendKeys("dpriyanka643@gmail.com");
		driver.findElement(By.cssSelector("span[class='black-color ng-binding']")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);
		WebElement msg = driver.findElement(By.cssSelector("div[class='alert alert-danger alert-custom']"));
		System.out.println(msg.getText());
		Assert.assertEquals(msg.getText(),"A welcome email has been sent. Please check your email.");
		System.out.println("Mail Sent");
		driver.quit();
		
		
		
	}

}
