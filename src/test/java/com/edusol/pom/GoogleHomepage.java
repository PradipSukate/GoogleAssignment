package com.edusol.pom;

import java.util.List;

import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.edusol.base.CommonMethods;

public class GoogleHomepage extends CommonMethods {
	@FindBy(className = "YacQv")
	WebElement google_SearchBox;
	@FindBy(css = "input[role='button']")
	List<WebElement> googleSearch;
	@FindBy(name = "btnI")
	List<WebElement> iAMFeelingLucky;
	@FindBy(xpath = "//div//a[contains(@aria-label, 'Google')]")
	WebElement google_apps;

	// Account
	@FindBy(xpath = "//span[text()='Account']")
	WebElement account;
	@FindBy(className = "h-c-header__lockup")
	WebElement account_logo;

	// Maps
	@FindBy(xpath = "//span[text()='Maps']")
	WebElement maps;
	@FindBy(css = "input[autofocus='autofocus']")
	WebElement maps_Search;
	@FindBy(xpath = "//*[@id=\"runway-expand-button\"]/div/div/button[3]/div[1]")
	WebElement runWay_Btn;

	// Youtube
	@FindBy(xpath = "//span[text()='YouTube']")
	WebElement youTube;
	@FindBy(css = "a[title='YouTube Home']")
	List<WebElement> yt_logo;
	@FindBy(css = "input[autocapitalize='none']")
	WebElement yt_SearchOption;

	// Play
	@FindBy(xpath = "//span[text()='Play']")
	WebElement play;
	@FindBy(xpath = "//span[text()='google_logo Play']")
	WebElement play_logo;
	@FindBy(xpath = "//span[text()='Apps']")
	WebElement appsOption;
	@FindBy(xpath = "//i[text()='search']")
	WebElement searchOption;

	// News
	@FindBy(xpath = "//span[text()='News']")
	WebElement news;
	@FindBy(id = "sdgBod")
	WebElement news_logo;
	@FindBy(linkText = "Top stories")
	WebElement topStories;

	// Gmail
	@FindBy(xpath = "//span[text()='Gmail']")
	WebElement gmail;
	@FindBy(css = "span[class='mobile-before-hero-only']")
	WebElement gmail_logo;
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	@FindBy(xpath = "//span[text()='Create an account']")
	List<WebElement> createAccount;

	// Drive
	@FindBy(xpath = "//span[text()='Drive']")
	WebElement drive;
	@FindBy(xpath = "//a[@title='Google Drive']")
	List<WebElement> drive_logo;
	@FindBy(linkText = "Go to Drive")
	WebElement goToDrive;

	// Translate
	@FindBy(xpath = "//span[text()='Translate']")
	WebElement translate;
	@FindBy(id = "sdgBod")
	WebElement translate_logo;

	// Photos
	@FindBy(xpath = "//span[text()='Photos']")
	WebElement photos;
	@FindBy(className = "header__logo")
	WebElement photos_logo;
	@FindBy(linkText = "Go to Google Photos")
	WebElement goToGooglePhoto;

	public GoogleHomepage() {
		PageFactory.initElements(driver, this);
	}

	public void get_HomePage() {
		hardwait(2000);
		softassert = new SoftAssert();
		softassert.assertTrue(google_SearchBox.isDisplayed());
		System.out.println(googleSearch.get(1).getText());
		System.out.println(iAMFeelingLucky.get(1).getText());
		waitForDisplay(google_apps);
		google_apps.click();

		driver.switchTo().frame(1);
		waitForDisplay(account);
		account.click();
		hardwait(3000);
		softassert.assertTrue(account_logo.isDisplayed());
		repeatable();
		waitForDisplay(maps);
		maps.click();
		hardwait(3000);
		softassert.assertTrue(maps_Search.isDisplayed());
		//softassert.assertTrue(runWay_Btn.isDisplayed());
		repeatable();
		waitForDisplay(youTube);
		youTube.click();
		hardwait(3000);
		softassert.assertTrue(yt_logo.get(0).isDisplayed());
		System.out.println(yt_SearchOption.getText());
		repeatable();
		waitForDisplay(play);
		play.click();
		hardwait(3000);
		softassert.assertTrue(play_logo.isDisplayed());
		//System.out.println(appsOption.getTagName());
		System.out.println(searchOption.getAttribute("class"));
		repeatable();
		waitForDisplay(news);
		news.click();
		hardwait(3000);
		softassert.assertTrue(news_logo.isDisplayed());
		System.out.println(topStories.getText());
		repeatable();
		waitForDisplay(gmail);
		gmail.click();
		hardwait(3000);
		softassert.assertTrue(gmail_logo.isDisplayed());
		System.out.println(signIn.getText());
		System.out.println(createAccount.get(0).getText());
		repeatable();
		waitForDisplay(drive);
		drive.click();
		hardwait(3000);
		softassert.assertTrue(drive_logo.get(0).isDisplayed());
		System.out.println(goToDrive.getText());
		repeatable();
		waitForDisplay(translate);
		translate.click();
		hardwait(3000);
		softassert.assertTrue(translate_logo.isDisplayed());
		repeatable();
		waitForDisplay(photos);
		photos.click();
		hardwait(3000);
		softassert.assertTrue(photos_logo.isDisplayed());
		softassert.assertTrue(goToGooglePhoto.isDisplayed());
		softassert.assertAll();
	}
}
