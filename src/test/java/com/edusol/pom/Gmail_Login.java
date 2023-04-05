package com.edusol.pom;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edusol.base.CommonMethods;

public class Gmail_Login extends CommonMethods{
	@FindBy(xpath="//a[text()='Gmail']")
	WebElement gmail_btn;

	@FindBy(xpath="//a[text()='Sign in']")
	WebElement signIn;

	@FindBy(id="identifierId")
	WebElement userid;
	
	//@FindBy(xpath="//span[text()='Next']")
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/span")
	WebElement next_btn;

	//@FindBy(xpath="//div[text()='Enter your password']")
	@FindBy(xpath="//input[contains(@type, 'password')]")
	WebElement password;

	@FindBy(xpath="//span[text()='Next']")
	WebElement pass_btn;
	
	@FindBy(xpath = "//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/img")
	WebElement profile_btn;
	
	@FindBy(xpath = "//div[text()='Pradip ']")
    WebElement profile_Name;
	
	@FindBy(xpath = "//div[text()='Sign out']")
	WebElement sign_out;
	
	@FindBy(xpath = "//div[text()='Remove an account']")
	WebElement remove_Acc;
	
	@FindBy(css = "svg[fill='currentColor']")
	List<WebElement> red_Btn;
	
	@FindBy(xpath = "//span[text()='Yes, remove']")
	List<WebElement> remove_btn;
	public Gmail_Login() {
		PageFactory.initElements(driver, this);
		}
	public void gmail_Login(Map<Object, Object> data,ExtentTest test) {
		softassert=new SoftAssert();
		hardwait(2000);
		gmail_btn.click();
		hardwait(3000);
		signIn.click();
		hardwait(3000);
		userid.sendKeys(data.get("userID").toString());
		test.log(Status.INFO, "userID enterd");
		hardwait(2000);
		next_btn.click();
		hardwait(3000);
		waitForDisplay(password);
		password.sendKeys(data.get("Password").toString());
		test.log(Status.INFO, "Password entered");
		pass_btn.click();
		hardwait(4000);
		test.log(Status.INFO, "login is successfull");
		//test.addScreenCaptureFromPath(getScreenshot("login is successfull"));
		getScreenshot("LoginSuccess");
		System.out.println(driver.getTitle());
		softassert.assertTrue(profile_btn.isDisplayed());
		profile_btn.click();
		hardwait(4000);
		driver.switchTo().frame("account");
		hardwait(2000);
		System.out.println(profile_Name.getText());
		softassert.assertEquals(profile_Name.getText(), "Pradip");
		sign_out.click();
		hardwait(4000);
		remove_Acc.click();
		hardwait(2000);
		red_Btn.get(0).click();
		hardwait(2000);
		remove_btn.get(1).click();
		softassert.assertAll();
	}
}
