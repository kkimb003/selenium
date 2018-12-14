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
import org.openqa.selenium.support.ui.WebDriverWait;

public class all_automation {
	public static void screenshot(String save_loc, RemoteWebDriver driver) {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//takes a screenshot of entire page
	    
	    try {
			FileUtils.copyFile(src, new File(save_loc));//saves screenshot
		} 
	    catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static boolean isElementPresent(By by, RemoteWebDriver driver) {
		  try {
		    driver.findElement(by);
		    return true;
		  }
		catch (NoSuchElementException e) {
		    return false;
		  }
		}
	public static void main(String args[]) {


	    String bitcoin_emailed = "wait";
	    String eth_emailed = "wait";
	    String bch_emailed = "wait";
	    String lite_emailed = "wait";
	    String xrp_emailed = "wait";
	    double old_bitcoin = 0;
	    double old_eth = 0;
	    double old_bch = 0;
	    double old_lite = 0;
	    double old_xrp = 0;
	    String final_bitcoin = "bitcoin error";
	    String final_eth = "eth error";
	    String final_bch = "bch error";
	    String final_lite = "lite error";
	    String final_xrp = "xrp error";
	    int singleLoop = 1;
	    while(true) {
	    	
		    System.setProperty("webdriver.gecko.driver", "c:/selenium/webdrivers/geckodriver.exe");
		    RemoteWebDriver driver = new FirefoxDriver();
		    
		    	
	    	String from = "LAX";
	    	String to = "HND";
		    int months_until_flight = 7; //how many months until the first flight eg today is april 16 and flight leaves november 18 = 7
		    int months_until_return = 0; //how may months are you staying before returning home, eg arriving november 18 coming back december 4 = 1
	    	String leave_day = "18";
	    	String return_day = "25";
	    	int number_of_people = 5;
	    	System.out.println("start of flight checker to " + to);
	    	//expedia
	    	
	    	for(int temp =0; temp <singleLoop; temp++) {
		    	driver.get("https://www.expedia.com/");
				try {
						driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']")).click();
				    
				}
				catch (NoSuchElementException e) {
					break;
				}
			    	//driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']")).click();
			    //driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']")).click();
		    	driver.findElement(By.xpath("//label[@id='flight-type-roundtrip-label-hp-flight']")).click();
		    	driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']")).sendKeys(from);
		    	driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']")).sendKeys(to);
		    	driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']")).click();
			    //driver.findElement(By.xpath("//button[@class='datepicker-cal-date'][@data-day='21'][@data-month='9'][@data-year='2018']")).click();

			    for(int i = 0; i < months_until_flight; i++ ) {
			    	driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();
			    }
		    	driver.findElement(By.xpath("//button[text()='"+leave_day+"']")).click();
		    	driver.findElement(By.xpath("//input[@id='flight-returning-hp-flight']")).click();
			    for(int i = 0; i < months_until_return; i++ ) {
			    	driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();
			    }
			    driver.findElement(By.xpath("//button[text()='"+return_day+"']")).click();
		    	driver.findElement(By.xpath("//button[@class='trigger-utility menu-trigger btn-utility btn-secondary dropdown-toggle theme-standard pin-left menu-arrow gcw-component gcw-traveler-amount-select gcw-component-initialized']")).click();
		    
		    	for(int i = 0; i < number_of_people - 1; i++ ) {
			    	driver.findElement(By.xpath("//button[@class='uitk-step-input-button uitk-step-input-plus']")).click();
		    	}
		    	driver.findElement(By.xpath("//button[@class='btn-primary btn-action gcw-submit']")).click();
			    try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			    String parentHandle = driver.getWindowHandle(); //get the current window handle
			    for (String winHandle : driver.getWindowHandles()) {
			    	driver.switchTo().window(winHandle);
			    	
			    	if(!winHandle.equals(parentHandle)) {
			    		driver.close(); // close newly opened window when done with it
			    	}
			    }
			    driver.switchTo().window(parentHandle);
			    
			    
			    
			    
	    		System.out.println("Expedia: " + driver.findElement(By.xpath("//span[@class='full-bold no-wrap'][@data-test-id='listing-price-dollars']")).getText());
	    	}
		    //justfly
	    	for(int temp =0; temp <singleLoop; temp++) {
	    		driver.get("https://www.justfly.com/");
		    	driver.findElement(By.xpath("//div[@class='search-selection-tab flights active']")).click();
		    	driver.findElement(By.xpath("//a[@id='toggle-roundtrip']")).click();
		    	driver.findElement(By.xpath("//input[@placeholder='Leaving from']")).sendKeys(from);
		    	driver.findElement(By.xpath("//input[@placeholder='Going to']")).sendKeys(to);
		    	try {
		    	driver.findElement(By.xpath("//input[@id='date-picker-1']")).click();
		    	}
				catch (Exception e) {
					break;
				}
//throws an error and crashes instead of hitting the break.
				try {
					for(int i = 0; i < months_until_flight; i++ ) {
						driver.findElement(By.xpath("//span[@class = 'ui-icon ui-icon-circle-triangle-e']")).click();
				    }
				}
				catch (Exception e) {
					//add message
					break;
				}
////
		    	driver.findElement(By.xpath("//a[text()='"+leave_day+"']")).click();
		    	driver.findElement(By.xpath("//input[@id='date-picker-2']")).click();
			    for(int i = 0; i < months_until_return; i++ ) {
			    	driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();
			    }
		    	driver.findElement(By.xpath("//a[text()='"+return_day+"']")).click();
		    	driver.findElement(By.xpath("//div[@class='passenger-toggle search-dropdown-toggle']")).click();
//so does this////			    	
				try {
					for(int i = 0; i < number_of_people - 1; i++ ) {
				    	driver.findElement(By.xpath("//div[@class='column picker-button add ']")).click();
				    }		 
				}
				catch (Exception e) {
					break;
				}
////				        
		    	driver.findElement(By.xpath("//div [@class='close-passenger-picker']")).click();
		    	String parentHandle = driver.getWindowHandle(); //get the current window handle
		    	driver.findElement(By.xpath("//a[@class='form-field-submit-button']")).click();
			    try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			    for (String winHandle : driver.getWindowHandles()) {
			    	driver.switchTo().window(winHandle);
			    	
			    	if(winHandle.equals(parentHandle)) {
			    		driver.close(); // close newly opened window when done with it
			    		
			    	}
			    	if(!winHandle.equals(parentHandle)) {
			    		try {
				    		WebDriverWait wait = new WebDriverWait(driver, 15);
						    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='total-price']/span[@class='integer']")));
						    System.out.println("Justfly: " + driver.findElement(By.xpath("//span[@class='total-price']/span[@class='integer']")).getText());
						}
						catch (Exception e) {
							break;
						}
//			    		
//					    try {
//							Thread.sleep(10000);
//						} catch (InterruptedException e) {
//							
//							e.printStackTrace();
//						}
			    		//Exception
			    		//TimeoutException
			    		//
			    		
			    	}
			    }
	    	}
		    
	    	/*
		    //cheapoair
		    driver.get("https://www.cheapoair.com/");
		    driver.findElement(By.xpath("//label[@id='rtFlight1']")).click();
		    driver.findElement(By.xpath("//input[@id='ember761']")).sendKeys(from);
		    driver.findElement(By.xpath("//input[@id='ember766']")).sendKeys(to);
		    driver.findElement(By.xpath("//input[@id='departCalendar_0']")).click();
		    //driver.findElement(By.xpath("//button[@class='datepicker-cal-date'][@data-day='21'][@data-month='9'][@data-year='2018']")).click();

		    for(int i = 0; i < months_until_flight; i++ ) {

		    	driver.findElement(By.xpath(".//div[@id='calendarCompId']/section/nav/a[@data-month = 'next']")).click();
		    }

		    driver.findElement(By.xpath("//li[text()='"+leave_day+"']")).click();
		    */
		    
		    
		    
		    
		    
		    
//		    driver.findElement(By.xpath("//input[@id='date-picker-2']")).click();
//
//		    for(int i = 0; i < months_until_return; i++ ) {
//		    	driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();
//		    }
//		    driver.findElement(By.xpath("//a[text()='"+return_day+"']")).click();
//		    driver.findElement(By.xpath("//div[@class='passenger-toggle search-dropdown-toggle']")).click();
//		    for(int i = 0; i < number_of_people - 1; i++ ) {
//		    	driver.findElement(By.xpath("//div[@class='column picker-button add ']")).click();
//		    }
//	    	driver.findElement(By.xpath("//div [@class='close-passenger-picker']")).click();
//		    parentHandle = driver.getWindowHandle(); //get the current window handle
//	    	driver.findElement(By.xpath("//a[@class='form-field-submit-button']")).click();
//		    
		    
		    //driver.switchTo().window(parentHandle);
    		//System.out.println("Justfly: " + driver.findElement(By.xpath(".//*[@id='c2274c0b284494faf4b57022bb1e20af_price']/div/span[5]/span[2]")).getText());

/*
		    driver.get("http://www.justairticket.com");
		    //System.out.println("end of finding website");
		    try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		    driver.findElement(By.xpath("//input[@value='flightRoundTrip']")).click();
		    //System.out.println("found raido buttons");
		    driver.findElement(By.xpath("//input[@id='fromFlight']")).sendKeys(from);
	
		    driver.findElement(By.xpath("//input[@id='toFlight']")).sendKeys(to);
		    
		    driver.findElement(By.xpath("//input[@name='flightFromDate']")).click();
		    WebDriverWait wait = new WebDriverWait(driver, 15);
		    //System.out.println("start visibilityOfElements");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")));
		    
		    for(int i = 0; i < months_until_flight; i++ ) {

		    	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		    }


		    driver.findElement(By.xpath("//a[text()='"+leave_day+"']")).click();

		    for(int i = 0; i < months_until_return; i++ ) {
		    	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		    }
		    
		    driver.findElement(By.xpath("//a[text()='"+return_day+"']")).click();
			new Select(driver.findElement(By.xpath("//select[@id='flightAdt']"))).selectByValue(number_of_people);
			//System.out.println("waiting 10 seconds");
		    try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    driver.findElement(By.xpath("//div[@class='closeSign']")).click();
	
		    driver.findElement(By.xpath("//input[@value='20001406']")).click();
	
		    driver.findElement(By.xpath("//input[@value='20001843']")).click();
		    //sometimes expedia does not exist as a check box for some reason
			driver.findElement(By.xpath("//input[@value='20002914']")).click();

	
		    driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		    String parentHandle = driver.getWindowHandle(); //get the current window handle
		    //System.out.println(parentHandle);
		    int count = 1;
	
		    //System.out.println("waiting 30 seconds");
		    try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		    //System.out.println("starting for loop");
		    for (String winHandle : driver.getWindowHandles()) {
		    	driver.switchTo().window(winHandle); //switch focus of WebDriver to the next found window handle (newly opened window)
		    	//System.out.println(winHandle);
		    	boolean expedia_isPresent = driver.findElements(By.xpath("//span[@class='full-bold no-wrap'][@data-test-id='listing-price-dollars']")).size() > 0;
		    	boolean justFly_isPresent = driver.findElements(By.xpath(".//*[@id='c2274c0b284494faf4b57022bb1e20af_price']/div/span[5]/span[2]")).size() > 0;
		    	
		    	if(expedia_isPresent) {
		    		System.out.println("Expedia: " + driver.findElement(By.xpath("//span[@class='full-bold no-wrap'][@data-test-id='listing-price-dollars']")).getText());
		    	}

		    	if(justFly_isPresent) {
		    		System.out.println("Justfly: " + driver.findElement(By.xpath(".//*[@id='c2274c0b284494faf4b57022bb1e20af_price']/div/span[5]/span[2]")).getText());
		    	}

		    	
		    	
		    	
//		    	//expedia
//		    	if( count == 3) {
//		    		System.out.println("Expedia: " + driver.findElement(By.xpath("//span[@class='full-bold no-wrap'][@data-test-id='listing-price-dollars']")).getText());
//		    	}
//		    	//justFly
//		    	if(count == 4) {
//				    try {
//						Thread.sleep(10000);
//					} catch (InterruptedException e) {
//						
//						e.printStackTrace();
//					}
//		    		System.out.println("Justfly: " + driver.findElement(By.xpath(".//*[@id='c2274c0b284494faf4b57022bb1e20af_price']/div/span[5]/span[2]")).getText());
//		    		
//		    	}
		    	
		    	
		    	

	
		    	//screenshot("C:/selenium/1test_scrape2 " + count + ".png", driver);
		    	if(!winHandle.equals(parentHandle)) {
		    		driver.close(); // close newly opened window when done with it
		    	}
		    	//System.out.println("finished loop" + (count));
		    	count++;
		    }
		    //System.out.println("ending for loop");
	
		    
		    
		    driver.switchTo().window(parentHandle); // switch back to the original window
	*/
		    
		    //bitcoin checker//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    System.out.println("start of bitcoin checker");

		    driver.get("https://www.coindesk.com/price/");//takes forever here
		    //System.out.println("end of finding website");
		    int count = 0;

		    

		    //System.out.println("finding elements bitcoin");
	    	String str_bitcoin = driver.findElement(By.xpath(".//*[@id='sidebar-price-widget']/div[1]/div[1]/span[3]")).getText().substring(1).replaceAll(",",  "");
	    	double int_bitcoin = Double.parseDouble(str_bitcoin);

		    //System.out.println("finding elements eth");
	    	String str_eth = driver.findElement(By.xpath(".//*[@id='sidebar-price-widget']/div[2]/div[1]/span[3]")).getText().substring(1).replaceAll(",",  "");
	    	double int_eth = Double.parseDouble(str_eth);

		    //System.out.println("finding elements bch");
	    	String str_bch = driver.findElement(By.xpath(".//*[@id='sidebar-price-widget']/div[3]/div[1]/span[3]")).getText().substring(1).replaceAll(",",  "");
	    	double int_bch = Double.parseDouble(str_bch);
	    	//System.out.println("finding elements lite");
	    	
	    	String str_lite = driver.findElement(By.xpath(".//*[@id='sidebar-price-widget']/div[4]/div[1]/span[3]")).getText().substring(1).replaceAll(",",  "");
	    	double int_lite = Double.parseDouble(str_lite);

		    //System.out.println("finding elements xrp");
	    	String str_xrp = driver.findElement(By.xpath(".//*[@id='sidebar-price-widget']/div[5]/div[1]/span[3]")).getText().substring(1).replaceAll(",",  "");
	    	double int_xrp = Double.parseDouble(str_xrp);
		    //System.out.println("bitcoin: " + driver.findElement(By.xpath(".//*[@id='quote_price']/span[1]")).getText().substring(1));
	    	//long time2 = System.nanoTime();
	    	//System.out.println("start of bitcoin");
	    	//bitcoin
		    if(int_bitcoin >=10000 && bitcoin_emailed.equals("wait")) {
		    	
		    	final_bitcoin ="SELL BITCOIN!!!!";
		    	bitcoin_emailed = "sent";
		    }
		    else if(int_bitcoin <= 7500 && bitcoin_emailed.equals("wait")) {
		    	
		    	final_bitcoin = "BUY BITCOIN!!!!";
		    	bitcoin_emailed = "sent";
		    }
		    else if(int_bitcoin <9850 && int_bitcoin > 7650 && bitcoin_emailed == "sent"){
		    	bitcoin_emailed = "wait";
		    	System.out.println("reset to wait");

		    }
		    else {
		        if(int_bitcoin > old_bitcoin) {
		        	final_bitcoin = "bitcoin: " + int_bitcoin + " ^";
		        }
		        else if(int_bitcoin < old_bitcoin) {
		        	final_bitcoin = "bitcoin: " + int_bitcoin + " v";
		        }
		    	//System.out.println("bitcoin: " + int_price);
		        else {

		        	final_bitcoin = "bitcoin: " + int_bitcoin + " =";
		        }
		    }
		    
		    //eth
	    	//System.out.println("start of eth");
		    if(int_eth >=700 && eth_emailed.equals("wait")) {
		    	//System.out.println("inside if");
		    	final_eth ="SELL ETHERIUM!!!!";
		    	eth_emailed = "sent";
		    }
		    else if(int_eth <= 450 && eth_emailed.equals("wait")) {
		    	//System.out.println("inside else if");
		    	final_eth = "BUY ETHERIUM!!!!";
		    	eth_emailed = "sent";
		    }
		    else if(int_eth <675 && int_eth > 475 && eth_emailed == "sent"){
		    	eth_emailed = "wait";
		    	System.out.println("reset to wait");

		    }
		    else {
		        if(int_eth > old_eth) {
		        	final_eth = "eth: " + int_eth + " ^";
		        }
		        else if(int_eth < old_eth) {
		        	final_eth = "eth: " + int_eth + " v";
		        }
		    	//System.out.println("bitcoin: " + int_price);
		        else {

		        	final_eth = "eth: " + int_eth + " =";
		        }
		    }
		    
		    //bch
	    	//System.out.println("start of bch");
		    if(int_bch >=1500 && bch_emailed.equals("wait")) {
		    	//System.out.println("inside if");
		    	final_bch ="SELL BCH!!!!";
		    	bch_emailed = "sent";
		    }
		    else if(int_bch <= 650 && bch_emailed.equals("wait")) {
		    	//System.out.println("inside else if");
		    	final_bch = "BUY BCH!!!!";
		    	bch_emailed = "sent";
		    }
		    else if(int_bch <1450 && int_bch > 675 && bch_emailed == "sent"){
		    	bch_emailed = "wait";
		    	System.out.println("reset to wait");

		    }
		    else {
		        if(int_bch > old_bch) {
		        	final_bch = "bch: " + int_bch + " ^";
		        }
		        else if(int_bch < old_bch) {
		        	final_bch = "bch: " + int_bch + " v";
		        }
		    	//System.out.println("bitcoin: " + int_price);
		        else {

		        	final_bch = "bch: " + int_bch + " =";
		        }
		    }
		    
		    //lite
	    	//System.out.println("start of lite");
		    if(int_lite >=175 && lite_emailed.equals("wait")) {
		    	//System.out.println("inside if");
		    	final_lite ="SELL LITE!!!!";
		    	lite_emailed = "sent";
		    }
		    else if(int_lite <= 100 && lite_emailed.equals("wait")) {
		    	//System.out.println("inside else if");
		    	final_lite = "BUY LITE!!!!";
		    	lite_emailed = "sent";
		    }
		    else if(int_lite <170 && int_lite > 110 && lite_emailed == "sent"){
		    	lite_emailed = "wait";
		    	System.out.println("reset to wait");

		    }
		    else {
		        if(int_lite > old_lite) {
		        	final_lite = "lite: " + int_lite + " ^";
		        }
		        else if(int_lite < old_lite) {
		        	final_lite = "lite: " + int_lite + " v";
		        }
		    	//System.out.println("bitcoin: " + int_price);
		        else {

		        	final_lite = "lite: " + int_lite + " =";
		        }
		    }
		    
		    //xrp
	    	//System.out.println("start of xrp");
		    if(int_xrp >=1 && xrp_emailed.equals("wait")) {
		    	//System.out.println("inside if");
		    	final_xrp ="SELL XRP!!!!";
		    	xrp_emailed = "sent";
		    }
		    else if(int_xrp <= .5 && xrp_emailed.equals("wait")) {
		    	//System.out.println("inside else if");
		    	final_xrp = "BUY XRP!!!!";
		    	xrp_emailed = "sent";
		    }
		    else if(int_xrp <.95 && int_xrp > .55 && xrp_emailed == "sent"){
		    	xrp_emailed = "wait";
		    	System.out.println("reset to wait");

		    }
		    else {
		        if(int_xrp > old_xrp) {
		        	final_xrp = "xrp: " + int_xrp + " ^";
		        }
		        else if(int_xrp < old_xrp) {
		        	final_xrp = "xrp: " + int_xrp + " v";
		        }
		    	//System.out.println("bitcoin: " + int_price);
		        else {

		        	final_xrp = "xrp: " + int_xrp + " =";
		        }
		    }

	    	//System.out.println("start of total");
		    System.out.println(final_bitcoin + "     " +  final_eth + "     " +  final_bch + "     " + final_lite + "     " + final_xrp);
		    //System.out.format(format, args)
		    old_bitcoin = int_bitcoin;
		    old_eth = int_eth;
		    old_bch = int_bch;
		    old_lite = int_lite;
		    old_xrp = int_xrp;
		    count++;
		    
		    //be our guest//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		    //int months_from_today = 4; //change this number to how many months away it is e.g today is april 18 date wanted is august 1 = 4 months away
		    String month = "August";//change this to which month you want to eat on
		    String day = "1";//Change this to the day you wish to eat on eg first = 1
		    String time = "7:00 PM";//Change this to desired time (this must be one of the available times for that date)
		    String num_of_people = "2";// how many people in your party (1-49)
		    
		    System.out.println("checking table availability for " + num_of_people + " people on " + month + " " + day + " at " + time);
		    driver.get("https://disneyworld.disney.go.com/dining/magic-kingdom/be-our-guest-restaurant/");
		    try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		    //Date
		    WebDriverWait wait1 = new WebDriverWait(driver, 10);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='diningAvailabilityForm-searchDate']")));//waits for element to appear
		    driver.findElement(By.xpath("//input[@id='diningAvailabilityForm-searchDate']")).click();
		    boolean disney_next_isPresent = driver.findElements(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).size() > 0;
		    if(disney_next_isPresent) {
		    	
			    while(!driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals(month)) {
			    	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			    }
			    driver.findElement(By.xpath("//a[contains(text(), '"+day+"')]")).click();
		    	/*
			    for (int i = 0; i < months_from_today; i++){
			    	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			    }
			    */
		    }
		    //driver.findElement(By.xpath("//a[@title='" + Date + "']")).click();
		    //time
		    driver.findElement(By.xpath("//div[@aria-owns='diningAvailabilityForm-searchTime-dropdown-list']")).click();
		    boolean isPresent = driver.findElements(By.xpath("//span[text()='" + time + "']")).size() >0;
		    //System.out.println(isPresent);
		    if(isPresent) {
		    	driver.findElement(By.xpath("//span[text()='" + time + "']")).click();
		    }
		    //party size
		    driver.findElement(By.xpath("//div[@aria-owns='partySize-dropdown-list']")).click();
		    driver.findElement(By.xpath("//li[@data-value='" + number_of_people+ "']")).click();
		    try {
		    	driver.findElement(By.xpath("//button[@name='findTableButton']")).click();//find path and click
		    	wait1 = new WebDriverWait(driver, 10);
		    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='timesContainer']/div[2]/span[1]")));
			} catch(TimeoutException e) {
				System.out.println("[ERROR] Timeout Exception");//always hits
			}
		    //driver.findElement(By.xpath("//button[@name='findTableButton']")).click();
		    
		    //System.out.println(driver.findElement(By.xpath(".//*[@id='timesContainer']/div[2]/span[1]")).getSize());
		    
		    if(driver.findElements(By.xpath(".//*[@id='timesContainer']/div[2]/span[1]")).size() > 0) {
		    	System.out.println("no tables available");
		    }
		    else if(driver.findElement(By.xpath(".//*[@id='timesContainer']/span[1]")).getText().equals("Available Times")) {
		    	System.out.println("open tables");

		    }
		    else {
		    	System.out.println("fail");

		    }
		    
		    
		    driver.close();
		}
	}
}
