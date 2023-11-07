package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Basetest

{
	
	//this is a class file with home page elements details and will be extending the basetest class since driver is defined in there
	//@findby is known as findby hook which should be intaialized by page factory
	
	@FindBy(linkText="Log in") 
	static WebElement logl;
	
	//this is is constructor with findby getting initialized, but doesn't allocate memory. allocation of memory only happen when the element is used
	public HomePage()
	{
		PageFactory.initElements(dr, this);//this means here passing Homepage class as parameter
	}
	
	/*
	 * // instead of using @findby hook and page factory we can also define like
	 * this. But using hook & page factory much more faster & lesser memory
	 * allocation 
	 * 
	 * public WebElement loginl() 
	 * { WebElement logl=dr.findElement(By.linkText("Log in")); return logl; }
	 */
	
	//will be creating methods with elements above. so we only call this methods in main 
	public void login_link()
	{
		logl.click();
	}
}
