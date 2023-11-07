package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Basetest{
	
	//this is a class file with all the elements used in login.
	//all the details r defined in Homepage class file

	@FindBy(id="Email")
	static WebElement username;
	
	@FindBy(className="password")
	static WebElement password;
	
	@FindBy(xpath="//input[@value='Log in']")
	static WebElement login_button;
	
	public Loginpage()
	{
		PageFactory.initElements(dr, this);//this initialize all the elements defined in top
	}
	
	///////////methods 

	
	public void login_data(String u, String p)
	{
		username.sendKeys(u);
		password.sendKeys(p);
		login_button.click();
	}

}
