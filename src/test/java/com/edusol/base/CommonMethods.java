package com.edusol.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
   public static WebDriver driver;
   public static SoftAssert softassert;
   public static String homepath= System.getProperty("user.dir");
   public static ExtentTest test;
   
   
   public static void browserLaunch(String browserName) {
	   switch (browserName) {
	   case "chrome" :
		   WebDriverManager.chromedriver().setup();
		   ChromeOptions option= new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			DesiredCapabilities cp= new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, option);
			option.merge(cp);
		   driver= new ChromeDriver(option);
		   break;
		   
	   case "edge" :
		   WebDriverManager.edgedriver().setup();
		   driver= new EdgeDriver();
		   break;
		   
	   case "firefox" :
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
		   break;
		   
		   default :
			   WebDriverManager.chromedriver().setup();
			   driver= new ChromeDriver();			 
	   }
	   driver.manage().window().maximize();
   }
   
   public  void repeatable() {
	    driver.navigate().back();
     	hardwait(2000);
     	driver.navigate().refresh();
   	    WebElement google_apps= driver.findElement(By.xpath("//div//a[contains(@aria-label, 'Google')]"));
        google_apps.click();
        driver.switchTo().frame(0);
   }
   public static void waitForClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
   public static void waitForDisplay(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
   
   public static void hardwait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
   static int num=0;
	public static int sentuniquenunmebr() {
		num++;
		return num;
		
	}
	public static  int randomnumbergenerator()
	{
		int num=(int) Math.random();
		return num;				
	}
	
	public static void getScreenshot(WebElement element, String screenshotName) {
		File src=element.getScreenshotAs(OutputType.FILE);
	
		File des=new File(homepath+"\\src\\test\\resources\\ScreenShot\\"+getDateTime()+"\\"+screenshotName+".png");
		try {
			FileUtils.copyFile(src,des );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getScreenshot( String screenshotName) {
		TakesScreenshot ts=(TakesScreenshot)driver; //downcasting
		File src=ts.getScreenshotAs(OutputType.FILE);		
		File des=new File(homepath+"\\src\\test\\resources\\ScreenShot\\"+getDateTime()+"\\"+screenshotName+".png");
		try {
			FileUtils.copyFile(src,des );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String desitination=des.getAbsolutePath();
		return desitination;
	}
	
	public static String getDateTime() {
		Date date =new Date();
		SimpleDateFormat format=new SimpleDateFormat("dd-M-yyyy hh");
		String datetime=format.format(date);
		System.out.println(datetime);
		return datetime;
	}
	
	public static String getDateTimeinMins() {
		Date date =new Date();
		SimpleDateFormat format=new SimpleDateFormat("dd-M-yyyy hh_mm");
		String datetime=format.format(date);
		System.out.println(datetime);
		return datetime;
	}
	public String stringValue(Map<Object, Object> data,String key) {
		return data.get(key).toString();
	}
}
