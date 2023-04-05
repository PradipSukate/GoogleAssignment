package com.edusol.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.edusol.base.CommonMethods;

public class Google_languages extends CommonMethods {
	@FindBy(xpath = "//div//a[contains(@href, 'source=homepage&sa')]")
	List<WebElement> language_list;

	@FindBy(xpath = "//div//a[contains(@href, 'hl=en')]")
	WebElement english_lang;
	@FindBy(xpath = "//div//a[contains(@href, 'hl=hi')]")
	WebElement hindi_lang;
	@FindBy(xpath = "//div//a[contains(@href, 'hl=mr')]")
	WebElement marathi_lang;
	@FindBy(xpath = "//div//a[contains(@href, 'hl=bn')]")
	WebElement bangali_lang;
	@FindBy(xpath = "//div//a[contains(@href, 'hl=te')]")
	WebElement telagu_lang;
	@FindBy(xpath = "//div//a[contains(@href, 'hl=ta')]")
	WebElement tamil_lang;
	@FindBy(xpath = "//div//a[contains(@href, 'hl=gu')]")
	WebElement gujrati_lang;
	@FindBy(xpath = "//div//a[contains(@href, 'hl=kn')]")
	WebElement kannada_lang;
	@FindBy(xpath = "//div//a[contains(@href, 'hl=ml')]")
	WebElement malylam_lang;
	@FindBy(xpath = "//div//a[contains(@href, 'hl=pa')]")
	WebElement punjabi_lang;

	public Google_languages() {
		PageFactory.initElements(driver, this);
	}

	

	public void get_language() {
		driver.navigate().to("https://www.google.com//");
		hardwait(2000);
        softassert= new SoftAssert();
        
        String lang[]= new String [10];
		for (int i = 0; i <language_list.size(); i++) {
			 lang[i] = language_list.get(i).getText();
			 System.out.println(lang[i]);
		}  
		     
		   //  softassert.assertTrue(hindi_lang.isDisplayed(), "page displayed in Hindi language:");
		for(int i=0 ; i< lang.length; i++) {
			//for(int j= 0; j< language_list.size(); j++) {
			//	if(lang[i]== language_list.get(j).toString()) {
					
			//	}
		
		if(lang[i].equalsIgnoreCase(hindi_lang.getText())) {
			hindi_lang.click();
			if(lang[i] != marathi_lang.getText() && lang[i] !=punjabi_lang.getText()) {
				System.out.println("page displayed in hindi language");
			}		
				hardwait(2000);
		}
		else if(lang[i].equals(english_lang.getText())){ 
			  english_lang.click();
			  if(lang[i] != hindi_lang.getText() && lang[i] !=marathi_lang.getText()) {
					System.out.println("page displayed in english language");
				} 
		  }
		  else if(lang[i].equalsIgnoreCase(marathi_lang.getText())) {
			  marathi_lang.click();
			  if(lang[i] != hindi_lang.getText() && lang[i] !=punjabi_lang.getText()) {
					System.out.println("page displayed in marathi language");
				} 
		  hardwait(2000);
		  } 
		  
		  else if(lang[i].equalsIgnoreCase(punjabi_lang.getText())) {
			  punjabi_lang.click();
			  if(lang[i] != hindi_lang.getText() && lang[i] !=marathi_lang.getText()) {
					System.out.println("page displayed in punjabi language");
				} 
			  hardwait(2000);
			  break;
		  
		  }
		 
		
		  
		   hardwait(2000);
		  //break; }
		 
			
	
		
		//english_lang.click();
	//	System.out.println("page displayed in english language:");

			
			
		//	if (hindi_lang.isSelected()) {
				// hindi_lang.click();
			//	System.out.println("page displayed in Hindi language:");
			//}
		/*
		 * hardwait(1000); if (!language_list.get(i).equals(marathi_lang)) {
		 * marathi_lang.click();
		 * System.out.println("page displayed in Marathi language:"); } hardwait(1000);
		 * if (!bangali_lang.isDisplayed()) { //bangali_lang.click();
		 * System.out.println("page displayed in Bangali language:"); } hardwait(1000);
		 * if (!telagu_lang.isDisplayed()) { //telagu_lang.click();
		 * System.out.println("page displayed in Telagu language:"); } hardwait(1000);
		 * if (!tamil_lang.isDisplayed()) { //tamil_lang.click();
		 * System.out.println("page displayed in Tamil language:"); } hardwait(1000); if
		 * (!gujrati_lang.isDisplayed()) { //gujrati_lang.click();
		 * System.out.println("page displayed in Gujrati language:"); } hardwait(1000);
		 * if (!kannada_lang.isDisplayed()) { //kannada_lang.click();
		 * System.out.println("page displayed in Kannada language:"); } hardwait(1000);
		 * if (!malylam_lang.isDisplayed()) { //malylam_lang.click();
		 * System.out.println("page displayed in Malylam language:"); } hardwait(1000);
		 * if (!punjabi_lang.isDisplayed()) { //punjabi_lang.click();
		 * System.out.println("page displayed in Punjabi language:"); } hardwait(1000);
		 * if (!english_lang.isDisplayed()) { //english_lang.click();
		 * System.out.println("page displayed in English language:"); }
		 */
		}
	}
}

