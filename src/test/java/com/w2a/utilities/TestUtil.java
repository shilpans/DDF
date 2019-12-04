package com.w2a.utilities;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import org.openqa.selenium.io.FileHandler;


//import com.google.common.io.Files;
import com.w2a.base.TestBase;

public class TestUtil extends TestBase {
	
	public static String screenshotPath;
	public static String screenshotName;
	
	public static void captureScreenshot() throws IOException{

//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		

		
//		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
//		FileUtils.(scrFile,new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
		
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File src= ts.getScreenshotAs(OutputType.FILE);	
		  
//		 File dest = new File("E:/selenium screen shot/"+date2+" error.png");
		 Date d=new Date();
		 screenshotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		 FileHandler.copy(src, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName+".jpg"));
		
	}
	

}
