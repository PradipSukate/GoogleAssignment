package com.edusol.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.edusol.base.CommonMethods;

public class Google_Search extends CommonMethods {
	@FindBy(css="input[autocomplete='off']")
	WebElement search_box;
	@FindBy(xpath="//span[text()='Amitabh Bachchan']")
	WebElement search_news;
	@FindBy(xpath="//h3[text()='Amitabh Bachchan'] ")
	List<WebElement> amitabhbacchan_wikipidia;
	@FindBy(id="dimg_25")
	WebElement amitabh_img;
	@FindBy(xpath="//h3[text()='Amitabh Bachchan (@SrBachchan) · Twitter']")
	WebElement amitabhbacchan_twitter;
	
	@FindBy(xpath="//*[@id=\"page-content\"]/section[1]/div/div[3]/a")
	WebElement browse;
	@FindBy(xpath = "//*[@id=\"panel-1\"]/div/div/div")
	List<WebElement> productList;
	
	
	public Google_Search() {
		PageFactory.initElements(driver, this);
		}
	public void searching_Google() {
		search_box.sendKeys("amitabh bachchan");
		hardwait(2000);
		search_news.click();
		hardwait(4000);
		softassert=new SoftAssert();
		softassert.assertTrue(amitabhbacchan_wikipidia.get(0).isDisplayed());
		System.out.println(amitabhbacchan_wikipidia.get(0).getText());
		hardwait(4000);
		softassert.assertTrue(amitabh_img.isDisplayed());
		hardwait(4000);
		softassert.assertTrue(amitabhbacchan_twitter.isDisplayed());
		System.out.println(amitabhbacchan_twitter.getText());
		
		
		driver.navigate().to("https://about.google/intl/en/products/");
		hardwait(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", browse);
		hardwait(2000);
		browse.click();
		hardwait(2000);
		System.out.println(productList.size());
		
		for(int i=0; i<productList.size(); i++) {
			System.out.println(productList.get(i).getText());
		}
		
		//softassert.assertAll();
		
	}
}
