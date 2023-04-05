package com.edusol.runner;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edusol.base.CommonMethods;
import com.edusol.base.Constants;
import com.edusol.pom.Gmail_Login;
import com.edusol.pom.GoogleHomepage;
import com.edusol.pom.Google_Search;
import com.edusol.pom.Google_languages;
import com.edusol.utilities.PropertyReader;
import com.edusol.utilities.ExcelReader;
import com.edusol.runner.TestNGRunner;
import com.edusol.utilities.ExtentReporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class TestNGRunner extends CommonMethods {
	GoogleHomepage hp;
	Gmail_Login gm;
	Google_Search sch;
	Google_languages gl;
	static Logger log=LogManager.getLogger(TestNGRunner.class);
	 ExtentReports report;

	
	@BeforeTest
	public void beforeTest() {
		report=ExtentReporter.initReport();
		log.info("Execution has started");
		
	}
  @BeforeMethod
  public void beforeMethod()  {
	  hardwait(5000);
	  browserLaunch(PropertyReader.getPropValue(Constants.BROWSER));
	  driver.get(PropertyReader.getPropValue(Constants.URL));
	  hardwait(2000);
	  System.out.println("test has started");
	  System.out.println(driver.getTitle());
	  
  }
  
  @Test(enabled= false)
  public void login()  {
	  System.out.println("test is started");
	  hp = new GoogleHomepage();
	  hp.get_HomePage();
  }
  
  @DataProvider(name="dp")
	public Object[][] dataSupplier()
	{
		Object[][] finaldata=ExcelReader.readExcel();  	
	//	Object[][] finaldata=DBHelper.getDBdata(); 
		return finaldata;		
	}
  @Test(dataProvider= "dp",enabled = true)
  public void gmail(Map<Object, Object> data) {
  
  test=report.createTest(stringValue(data, "TestCaseObjective"));
	if(stringValue(data, "Execute").equals("Yes")){
		gm=new Gmail_Login();
       gm.gmail_Login(data,test);
  }else {
	  test.log(Status.SKIP, "test has been skipped");
	  throw new SkipException("test case not run");
  }
  }
  @Test(enabled= false)
  public void search() {
	  sch= new Google_Search();
	  sch.searching_Google();
  }
  
  @Test(enabled = false)
  public void language_test() {
	  gl= new Google_languages();
	  gl.get_language();
  }
  
  @AfterMethod
  public void afterMethod() {
	//driver.quit();
	driver.close();
  }

  @AfterTest
  public void afterTest() {
	report.flush();
  }
  
}
