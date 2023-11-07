package utility;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pagefactory.Basetest;

public class Screenshot extends Basetest{
//need to extend testbase for the driver object
	public String screenst( )throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) dr;// since TakesScreenshot is an interface need to do type casting
		File f= ts.getScreenshotAs(OutputType.FILE);// mentioning the output we want is to be file type
		//for adding the screenshot in report we must use only .PNG type
		File target= new File("C:\\Users\\MANU\\Pictures\\Screenshots\\Automation_"+System.currentTimeMillis()+".png");//passing the currenttime in milisec to make the naming unique
		FileUtils.copyFile(f,target);// saving the screenshot to target file and need to add depency for fileutils in pom.xml
		String path=target.getAbsolutePath();
		return path;//need to return the path so that the report can use this path to take screenshot
		
	}
}
