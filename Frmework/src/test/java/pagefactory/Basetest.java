package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utility.Driverlisten;

public class Basetest {

	//this is a class file with all the setup details and need to extend this class to all other classes since setup details r defined in here like driver dr
	
	public static WebDriver dr=null;
	public void browser()
	{
		System.setProperty("webdriver gecko driver", "src//test//resources//geckodriver.exe");
		 dr=new FirefoxDriver();
		 dr.get("https://demowebshop.tricentis.com/");
		
		 //following lines r for connecting webdriver listener to driver object. if we don't want to connect then comment the below codes
		 EventFiringWebDriver ew=new EventFiringWebDriver(dr);
		 Driverlisten dl=new Driverlisten();//we created this class in utility
		 ew.register(dl);
		 dr=ew;// assigning dr with listner, so whenever dr is called it goes to listener as well.
		 
	}
	
	public void close() {
		dr.close();
	}
	
}
