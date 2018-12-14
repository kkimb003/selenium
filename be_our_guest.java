package test;

//import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class be_our_guest {
	public static void main(String args[]) {
	    System.setProperty("webdriver.gecko.driver", "c:/selenium/webdrivers/geckodriver.exe");
	    RemoteWebDriver driver = new FirefoxDriver();
	    driver.get("https://disneyworld.disney.go.com/dining/magic-kingdom/be-our-guest-restaurant/");
	    //Date
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='diningAvailabilityForm-searchDate']")));//waits for element to appear
	    driver.findElement(By.xpath("//input[@id='diningAvailabilityForm-searchDate']")).click();
	    while(!driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals("August")) {
	    	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	    }
	    driver.findElement(By.xpath("//a[contains(text(), '18')]")).click();
	    
	    /*
	    driver.findElement(By.xpath("//input[@id='diningAvailabilityForm-searchDate']")).click();
	    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	    driver.findElement(By.xpath("//a[@title='Wednesday, August 1, 2018']")).click();
	    */
	    //time
	    driver.findElement(By.xpath("//div[@aria-owns='diningAvailabilityForm-searchTime-dropdown-list']")).click();
	    driver.findElement(By.xpath("//span[text()='7:00 PM']")).click();
	    //party size
	    driver.findElement(By.xpath("//div[@aria-owns='partySize-dropdown-list']")).click();
	    driver.findElement(By.xpath("//li[@data-value='2']")).click();
	    try {
	    	driver.findElement(By.xpath("//button[@name='findTableButton']")).click();//find path and click
	    	wait = new WebDriverWait(driver, 10);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='timesContainer']/div[2]/span[1]")));//waits until visible(will never be visible)
		} catch(TimeoutException e) {
			System.out.println("[ERROR] Timeout Exception");//always hits
		}
	    //driver.findElement(By.xpath("//button[@name='findTableButton']")).click();
	    
	    //System.out.println(driver.findElement(By.xpath(".//*[@id='timesContainer']/div[2]/span[1]")).getSize());
	    
	    if(driver.findElements(By.xpath(".//*[@id='timesContainer']/div[2]/span[1]")).size() > 0) {
	    	System.out.println("no tables");
	    }
	    else if(driver.findElement(By.xpath(".//*[@id='timesContainer']/span[1]")).getText().equals("Available Times")) {
	    	System.out.println("open tables");

	    }
	    else {
	    	System.out.println("fail");

	    }

	}
	    
}
