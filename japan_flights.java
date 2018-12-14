package test;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class japan_flights {
	public static void screenshot(String save_loc, RemoteWebDriver driver) {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//takes a screenshot of entire page
	    
	    try {
			FileUtils.copyFile(src, new File(save_loc));//saves screenshot
		} 
	    catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String args[]) {
		//long startTime = System.nanoTime();
		//System.out.println("start of webdriver");
	    System.setProperty("webdriver.gecko.driver", "c:/selenium/webdrivers/geckodriver.exe");
	    RemoteWebDriver driver = new FirefoxDriver();
	    boolean whileloop = true;
	    while(whileloop = true) {
		    System.out.println("start of flight checker");

		    driver.get("http://www.justairticket.com");//takes forever here
		    //System.out.println("end of finding website");
		    try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    driver.findElement(By.xpath("//input[@value='flightRoundTrip']")).click();
		    //System.out.println("found raido buttons");
		    driver.findElement(By.xpath("//input[@id='fromFlight']")).sendKeys("LAX - Los Angeles Intl, Los Angeles, USA");
	
		    driver.findElement(By.xpath("//input[@id='toFlight']")).sendKeys("HND - Haneda Airport, Tokyo, Japan");
		    
		    driver.findElement(By.xpath("//input[@name='flightFromDate']")).click();
		    WebDriverWait wait = new WebDriverWait(driver, 15);
		    //System.out.println("start visibilityOfElements");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")));
		    //System.out.println("start click1");
		    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		    //System.out.println("start click2");
		    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		    //System.out.println("start click3");
		    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		    //System.out.println("start click4");
		    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		    //System.out.println("start click5");
		    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		    //System.out.println("start click6");
		    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		    //System.out.println("start click7");
		    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		    //System.out.println("start click8");
		    driver.findElement(By.xpath("//a[text()='18']")).click();
		    //System.out.println("start click9");
		    driver.findElement(By.xpath("//a[text()='25']")).click();
			new Select(driver.findElement(By.xpath("//select[@id='flightAdt']"))).selectByValue("5");
			//System.out.println("waiting 10 seconds");
		    try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    driver.findElement(By.xpath("//div[@class='closeSign']")).click();
	
		    driver.findElement(By.xpath("//input[@value='20001406']")).click();
	
		    driver.findElement(By.xpath("//input[@value='20001843']")).click();
		    try {
			    driver.findElement(By.xpath("//input[@value='20002914']")).click();
			} catch (NoSuchElementException e){
				// TODO Auto-generated catch block
	
			}
	
		    driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		    String parentHandle = driver.getWindowHandle(); //get the current window handle
		    //System.out.println(parentHandle);
		    int count = 1;
	
		    //System.out.println("waiting 30 seconds");
		    try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    //System.out.println("starting for loop");
		    for (String winHandle : driver.getWindowHandles()) {
		    	driver.switchTo().window(winHandle); //switch focus of WebDriver to the next found window handle (newly opened window)
		    	//System.out.println(winHandle);
		    	//expedia
		    	if( count == 3) {
		    		System.out.println("expedia: " + driver.findElement(By.xpath("//span[@class='full-bold no-wrap'][@data-test-id='listing-price-dollars']")).getText());
		    		
		    		
		    		
		    	}
		    	if(count == 4) {
		    		
	
		    		System.out.println("justfly: " + driver.findElement(By.xpath(".//*[@id='c2274c0b284494faf4b57022bb1e20af_price']/div/span[5]/span[2]")).getText());
		    		
		    	}
		    	
		    	
		    	

	
		    	//screenshot("C:/selenium/1test_scrape2 " + count + ".png", driver);
		    	if(!winHandle.equals(parentHandle)) {
		    		driver.close(); // close newly opened window when done with it
		    	}
		    	//System.out.println("finished loop" + (count));
		    	count++;
		    }
		    //System.out.println("ending for loop");
	
		    
		    
		    driver.switchTo().window(parentHandle); // switch back to the original window
	
		    driver.get("http://www.justairticket.com");//takes forever here
		    driver.findElement(By.xpath("//div[@class='closeSign']")).click();
		    
		    
	
		}
	}
}
