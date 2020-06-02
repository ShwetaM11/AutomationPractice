package com.automationpractice.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.automationpractice.StepDefination.BaseClass.logger;

/**
 * All the elements and respected methods of Navigate to Multiple Page feature are declared here<br>
 * The main page of the application WOMEN, DRESSES & T-SHIRT is verified here with page title.<br>
 * All the header and footer links will be verified here. If any link will have 404 error then log will show the result for same.<br>
 * Any alert is displayed for link then it will be handled.
 * @author skmehta
 *
 */
public class NavigateToMultiplePage {

	public WebDriver driver;

	public NavigateToMultiplePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Women']")
	WebElement btnWomen;

	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")
	WebElement btnDresses;

	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a")
	WebElement btnTshirt;

	@FindBy(xpath = "//button[@class='dismissButton']")
	WebElement OKButton;

	@FindBy(xpath = "//section[@id='block_various_links_footer']")
	WebElement footerInfo;

	@FindBy(xpath = "//ul[@class='bullet']")
	WebElement footerAccount;

	@FindBy(xpath = "//Section[@id='social_block']")
	WebElement footerSocial;

	@FindBy(xpath = "//div[@class='nav']")
	WebElement Header;
	
	@FindBy(xpath = "//div[@id='block_top_menu']")
	WebElement Header1;
	
	public void clickWOMENpage() {
		btnWomen.click();
	}

	public void clickDRESSESpage() {
		btnDresses.click();
	}

	public void clickTSHIRTpage() {
		btnTshirt.click();
	}

	public void footerPage() throws InterruptedException {

		List<WebElement> footerLinks = footerSocial.findElements(By.tagName("a"));
		long length = footerLinks.size();
		logger.info("Footer Length : " + length);
		logger.info(footerLinks);
		for (int j = 0; j < length; j++) {

			logger.info(footerSocial);
			footerSocial.findElements(By.tagName("a")).get(j).getText();
			footerSocial.findElements(By.tagName("a")).get(j).click();
			logger.info("Footer Link: " + driver.getTitle());
			if (driver.getTitle().contains("404")) {
				logger.info("404 Found");
			}
			driver.navigate().back();
			Thread.sleep(4000);
		}

		List<WebElement> footerlinks_Info = footerInfo.findElements(By.tagName("a"));
		int InfoLength = footerlinks_Info.size();
		for (int j = 0; j < InfoLength; j++) {

			logger.info(footerInfo);
			footerInfo.findElements(By.tagName("a")).get(j).getText();
			footerInfo.findElements(By.tagName("a")).get(j).click();
			logger.info("Footer Link: "+ driver.getTitle());
			if (driver.getTitle().contains("404")) {
					logger.info("404 Found");
				}
			driver.switchTo().defaultContent();
			Thread.sleep(4000);

			try {
					OKButton.isDisplayed();
					OKButton.click();
					logger.info("alert was present and accepted");
			} catch (Exception e) {
				logger.info("alert was not present");
			}
		}

		List<WebElement> footerlinks_Account = footerAccount.findElements(By.tagName("a"));
		int accLegth = footerlinks_Account.size();

		for (int j = 0; j < accLegth; j++) {

			logger.info(footerAccount); // as DOM changes after navigate.back()
			footerAccount.findElements(By.tagName("a")).get(j).getText();
			footerAccount.findElements(By.tagName("a")).get(j).click();
			logger.info("Footer Link: "+ driver.getTitle());
			if (driver.getTitle().contains("404")) {
				logger.info("404 Found");
				driver.navigate().back();
			}
			Thread.sleep(4000);
		}

	}
	
	public void headrPage() throws InterruptedException {

		List<WebElement> HeaderLinks = Header.findElements(By.tagName("a"));
		long length = HeaderLinks.size();
		logger.info("Header Length : " + length);
		logger.info(HeaderLinks);
		for (int j = 0; j < length; j++) {

			logger.info(HeaderLinks);
			Header.findElements(By.tagName("a")).get(j).getText();
			Header.findElements(By.tagName("a")).get(j).click();
			logger.info("Header Link: "+ driver.getTitle());
			if (driver.getTitle().contains("404")) {
				logger.info("404 Found");
			}
			Thread.sleep(4000);
			
		}
			
	}
}
