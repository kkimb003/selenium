package test;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class bitcoin {
	public static void main(String args[]) {
		//long startTime = System.nanoTime();
		//System.out.println("start of webdriver");
	    System.setProperty("webdriver.gecko.driver", "c:/selenium/webdrivers/geckodriver.exe");
	    RemoteWebDriver driver = new FirefoxDriver();
	    //System.out.println("start of finding website");
	    driver.get("https://www.coindesk.com/price/");//takes forever here
	    //System.out.println("end of finding website");
	    int count = 0;
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
	    while(count <=100) {

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
		    else if(int_bitcoin <= 6000 && bitcoin_emailed.equals("wait")) {
		    	
		    	final_bitcoin = "BUY BITCOIN!!!!";
		    	bitcoin_emailed = "sent";
		    }
		    else if(int_bitcoin <9050 && int_bitcoin > 6050 && bitcoin_emailed == "sent"){
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
		    else if(int_eth <= 350 && eth_emailed.equals("wait")) {
		    	//System.out.println("inside else if");
		    	final_eth = "BUY ETHERIUM!!!!";
		    	eth_emailed = "sent";
		    }
		    else if(int_eth <675 && int_eth > 3755 && eth_emailed == "sent"){
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
		    if(int_bch >=800 && bch_emailed.equals("wait")) {
		    	//System.out.println("inside if");
		    	final_bch ="SELL BCH!!!!";
		    	bch_emailed = "sent";
		    }
		    else if(int_bch <= 500 && bch_emailed.equals("wait")) {
		    	//System.out.println("inside else if");
		    	final_bch = "BUY BCH!!!!";
		    	bch_emailed = "sent";
		    }
		    else if(int_bch <875 && int_bch > 525 && bch_emailed == "sent"){
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
		    else if(int_xrp <= .4 && xrp_emailed.equals("wait")) {
		    	//System.out.println("inside else if");
		    	final_xrp = "BUY XRP!!!!";
		    	xrp_emailed = "sent";
		    }
		    else if(int_xrp <.95 && int_xrp > .45 && xrp_emailed == "sent"){
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
		    System.out.println(final_bitcoin + "     " +  final_eth + "     " +  final_bch + "     " + final_lite + "     " + final_xrp + "     " + "count: " + count);
		    //System.out.format(format, args)
		    old_bitcoin = int_bitcoin;
		    old_eth = int_eth;
		    old_bch = int_bch;
		    old_lite = int_lite;
		    old_xrp = int_xrp;
		    //System.out.println("start of refresh");
		    driver.navigate().refresh();//takes forever here
		    //System.out.println("end of refresh");
		    count++;
		    //long time2 = System.nanoTime();
		    //System.out.println("time: " + (time2-startTime));
	    }
	    
	    
	    
	}

}
