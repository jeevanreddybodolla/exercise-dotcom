package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotFactory {
	
	public static void captureScreenshot(WebDriver driver, String screenshotName){
		String destinationPath = null;
		try{
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			destinationPath = "./screenshots/" + screenshotName + timeStamp + ".png";
			FileUtils.copyFile(source, new File(destinationPath));
			System.out.println("Screenshot placed in root /screenshots folder!" + destinationPath);
	    }catch (Exception e){
	    	System.out.println("Exception while taking screenshot " + e.getMessage());
	    }
	  }
}