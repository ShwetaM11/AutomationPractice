package com.automationpractice.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All the elements and respected methods of NewsletterSubscription  feature are declared here<br>
 * Newsletter subscription is verified by entering unique email id and duplicate email id.
 * @author Shweta
 *
 */
public class NewsletterSubscription {

	public WebDriver driver;

	public NewsletterSubscription(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='newsletter-input']")
	WebElement btnNemail;

	@FindBy(xpath = "//button[@name='submitNewsletter']")
	WebElement btnNarrow;

	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement successText;
	
	@FindBy(xpath = "//p[@class='alert alert-danger']")
	WebElement alertText;
		
	public void clickNewsletter() {
		btnNemail.click();
	}

	public WebElement nemail() {
		return btnNemail;
	}
	
	public WebElement textMessage() {
		return successText;
	}

	public WebElement alertMessage() {
		return alertText;
	}	
	
	
	public void clickArrow() {
		btnNarrow.click();
	}

}
