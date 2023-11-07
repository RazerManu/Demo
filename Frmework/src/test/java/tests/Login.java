package tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pagefactory.Basetest;
import pagefactory.HomePage;
import pagefactory.Loginpage;
import utility.Excel;
import utility.Listen;

@Listeners(value=Listen.class)//this will connect this class to the Listener class
public class Login {
	
	//this is the main file which is n testng and will be calling all the method to here
	Basetest bt;
	HomePage hp;
	Loginpage lo;
	Excel ex;
  @Test
  public void log() throws InterruptedException, IOException 
  {
   hp.login_link();
    Thread.sleep(1000);
    //reading it from excel file defined in excel class of utility package
    String u=ex.read("X:\\mphasis\\Selenium Training- 2023\\login data.xlsx", 0, 0, 0);
    String p=ex.read("X:\\mphasis\\Selenium Training- 2023\\login data.xlsx", 0, 0, 1);
    lo.login_data(u,p);
    
    //writing to excel file 
   ex.write("X:\\mphasis\\Selenium Training- 2023\\login data.xlsx", "Sheet1", 0, 2,"Passedd");
    
  }
  
  @BeforeTest
  void setup()
  {
	  bt=new Basetest();
	  bt.browser();// first call the method since its initializing driver dr, which is used in other methods
	  
	  hp=new HomePage();
	  lo=new Loginpage();
	  ex=new Excel();
  }
  
  @AfterTest
  void end() 
  {
	  bt.close();
  }
}
