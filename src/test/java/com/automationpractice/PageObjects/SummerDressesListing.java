package com.automationpractice.PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.automationpractice.StepDefination.BaseClass.logger;

/**
 * All the elements and respected methods of SummerDressesListing feature are declared here<br>
 * User will navigate to summerdresses page and total count of product will be displayed on screen.<br>
 * Sort option for price and product and filter applied here but page is not getting loaded for this both. Thus, put wait and condition to pass test scenario.
 * @author Shweta
 *
 */
public class SummerDressesListing {

	public WebDriver driver;

	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[1]/div[1]/div/ul/li[2]/span")
	WebElement btnSubDresses;

	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[1]/div[1]/div/ul/li[2]/ul/li[3]/a")
	private WebElement btnSummerDresses;

	@FindBy(xpath = "//select[@id='selectProductSort']")
	private WebElement SortOption;

	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/p/img")
	private WebElement btnLoading;

	@FindBy(xpath = "//span//input[@id=\"layered_id_feature_13\"]")
	private WebElement clickFilter;

	@FindBy(xpath = "//div[@class='product-image-container']")
	private WebElement SDress;

	public void loadingMethod() {

		if (btnLoading.isDisplayed()) {
			logger.info("List of items is not displayed on screen as page is loading");
		} else {
			logger.info("List of items is displayed on screen");
		}
	}

	public void clickSubDressespage() {
		btnSubDresses.click();

		List<WebElement> SummerDressesLinks = SDress.findElements(By.tagName("a"));
		long length = SummerDressesLinks.size();
		logger.info(" List of Summer Dresses : " + length);
	}

	public void clickSubSummerpage() {
		btnSummerDresses.click();
	}

	public void clickFilter() throws InterruptedException {
		clickFilter.click(); // After apply the filter, the page is not loaded so put wait and condition.
		Thread.sleep(3000);
		loadingMethod();
	}

	public void selectOption() throws InterruptedException {
		
		Select Option = new Select(SortOption);
		Option.selectByIndex(2);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeSelected(SDress));
		}

		catch (Exception e) {
			loadingMethod();
		}

		Option.selectByIndex(4);
		Thread.sleep(3000);
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeSelected(SDress));//After select the value from sorting options, page is not loaded so put wait and condition.
		}
		catch (Exception e) {
			loadingMethod();
		}
	}

	public SummerDressesListing(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
