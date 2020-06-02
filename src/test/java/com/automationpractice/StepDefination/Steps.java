package com.automationpractice.StepDefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automationpractice.PageObjects.CheckoutJourney;
import com.automationpractice.PageObjects.NavigateToMultiplePage;
import com.automationpractice.PageObjects.NewsletterSubscription;
import com.automationpractice.PageObjects.SummerDressesListing;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * This class will work to initialize all web-drivers, to load reusable methods of feature files and variables.<br>
 * Need to add 'browser' value in config.propeties file and accordingly whole test will run on that browser.<br>
 * Browser name should be equal to the if condition.<br>
 * All the logger information is declared for assertions.<br> 
 * It will be displayed on ./log/application.html, ./log/application.log, ./log/Log4j.log, ./log/testlog.log<br>
 * HTML and JSON reports of features files are placed on ./test-out/index.html & ./test/cucumber.json
 *
 * @author Shweta
 *
 */
public class Steps extends BaseClass {

	@Before
	public void selectBrowser() throws IOException {

		properties = new Properties();
		FileInputStream configprop = new FileInputStream("config.properties");
		properties.load(configprop);
		logger = Logger.getLogger("AutomationPractice");
		PropertyConfigurator.configure("log4j.properties");

		String brw = properties.getProperty("browser"); // Method to select browser

		if (brw.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + properties.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
			logger.info("Lunching Browser");
		}

		else if (brw.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + properties.getProperty("chromepath"));
			driver = new ChromeDriver();
			logger.info("Lunching Browser");
		}
	}

	@Given("User Launch Browser")
	public void user_Launch_Browser() throws Throwable {
		np = new NavigateToMultiplePage(driver);
	}

	@And("User Open URL")
	public void user_Open_URL() throws Throwable {
		logger.info("URL is Opened");
		driver.navigate().to("http://automationpractice.com/index.php");
	}

	@And("User navigate on WOMEN page")
	public void user_nevigate_on_WOMEN_page() throws Throwable {
		logger.info("Scenario 1 : Navigate to multiple page and verify header and footer links will run");
		np.clickWOMENpage();
		String title = driver.getTitle();
		logger.info(title);
		Assert.assertEquals("Women - My Store", title);
		Thread.sleep(3000);
	}

	@And("User navigate on DRESSES page")
	public void user_nevigate_on_DRESSES_page() throws Throwable {
		np.clickDRESSESpage();
		String title = driver.getTitle();
		logger.info(title);
		Assert.assertEquals("Dresses - My Store", title);
		Thread.sleep(3000);
	}

	@And("User navigate on T-SHIRT Page")
	public void user_nevigate_on_T_SHIRT_Page() throws Throwable {
		logger.info("We are on T-shirt Page");
		np.clickTSHIRTpage();
		String title = driver.getTitle();
		logger.info(title);
		Assert.assertEquals("T-shirts - My Store", title);
		Thread.sleep(3000);
	}

	@And("Verify the header and footer of the page")
	public void verify_the_header_and_footer_of_the_page() throws Throwable {
		np.headrPage();
		logger.info("All the Header Links is working fine");
		np.footerPage();
		logger.info("All the Footer Links is working fine");
	}

	@And("Close the browser")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}

	// NavigateOnSummerDresses.feature

	@And("User navigate on Sub Dresses page")
	public void user_navigate_on_Sub_Dresses_page() throws Throwable {
		logger.info("Scenario 3 : Navigate to SummerDresses and verify sorting and filter functionality");
		sd = new SummerDressesListing(driver);
		sd.clickSubDressespage();
	}

	@And("User click on SummerDresses page")
	public void user_click_on_SummerDresses_page() throws Throwable {
		sd.clickSubSummerpage();
	}

	@And("User apply sorting option")
	public void user_apply_sorting_option() throws Throwable {
		sd.selectOption();
	}

	@And("User apply filter option")
	public void user_apply_filter_option() throws Throwable {
		sd.clickFilter();
	}

	// CheckoutJourney.feature

	@And("User will select Tshirt and add to cart")
	public void user_will_select_Tshirt_and_add_to_cart() throws Throwable {
		logger.info("Scenario 4 : Verify checkout journey by entering unique email id and static email id");
		cj = new CheckoutJourney(driver);
		cj.selectTshirt();
		cj.clickAddToCart();
		Thread.sleep(3000);
		cj.clickProceedCheckout();
		Thread.sleep(3000);
		cj.clickProceedCheckout1();
		Thread.sleep(3000);
	}

	@And("User will create new account")
	public void user_will_create_new_account() throws Throwable {
		cj.readAuth();
		cj.setEmail().sendKeys(randomValue + "@gmail.com");
		Thread.sleep(3000);
		cj.clickCreateAccount();
		Thread.sleep(3000);
		cj.clickRadioButton();
		cj.setFirstname().sendKeys(randomValue);
		cj.setLastname().sendKeys(randomValue);
		cj.setPassword().sendKeys(randomValue);
		cj.selectDays();
		cj.selectMonth();
		cj.selectYear();
		cj.setAddress().sendKeys(randomValue + " , " + randomValue);
		cj.setCity().sendKeys("Mumbai");
		cj.selectState();
		cj.setZipCode().clear();
		cj.setZipCode().sendKeys("09090");
		cj.setPhnNumber().sendKeys("9879879870");
		cj.setAlias().clear();
		cj.setAlias().sendKeys("Add");
		cj.clickRegister();
	}

	@And("User will enter email and password")
	public void user_will_enter_email_and_password() throws Throwable {
		logger.info("Static email and password is entered");
		cj.setSignupEmail().sendKeys("sm11@gmail.com");
		Thread.sleep(3000);
		cj.setSignupPassword().sendKeys("Admin@123");
		cj.clickSignup();
		Thread.sleep(3000);
	}

	@And("User will enter address and shipping details")
	public void user_will_enter_address_and_shipping_details() throws Throwable {
		cj.readAdd();
		cj.clickOrderCheckOutAddress();
		Thread.sleep(3000);
		cj.readShipping();
		cj.clickTerm();
		cj.clickOrderCheckOut();
	}

	@And("User will Select Payment Option and confirm the order")
	public void user_will_Select_Payment_Option_and_confirm_the_order() throws Throwable {
		cj.clickPayment();
		Thread.sleep(3000);
		cj.readOrderSummary();
		cj.clickConfirm();
		cj.readOrderConfirmation();
	}

	@And("User will navigate to order history and do sign out")
	public void user_will_navigate_to_order_history_and_do_sign_out() throws Throwable {
		cj.clickBackOrder();
		cj.readOrderHistory();
		Thread.sleep(5000);
		cj.clickSignOut();
	}

	// NewsletterSubscription.feature

	@And("User navigate on Newsletter filed")
	public void user_navigate_on_Newsletter_filed() throws Throwable {
		logger.info("Scenario 2 : Verify NewsletterSubscription by entering unique email id and duplicate email id");
		ns = new NewsletterSubscription(driver);
		ns.clickNewsletter();
	}

	@And("User will subscribe Newsletter by entering email id")
	public void user_will_subscribe_Newsletter_by_entering_email_id() throws Throwable {
		ns.nemail().sendKeys(randomValue + "@gmail.com");
		ns.clickArrow();
		Thread.sleep(3000);
	}

	@And("User will subscribe Newsletter by entering duplicate email id")
	public void user_will_subscribe_Newsletter_by_entering_duplicate__email_id() throws Throwable {
		ns.nemail().sendKeys("admin@gmail.com");
		ns.clickArrow();
	}

	@And("User get a successful subscription message on screen")
	public void user_get_a_successful_subscription_message_on_screen() throws Throwable {
		String Smessage = ns.textMessage().getText();
		Assert.assertEquals("Newsletter : You have successfully subscribed to this newsletter.", Smessage);
		logger.info(Smessage);
	}

	@And("User get an error message as subscription is already done with this email")
	public void user_get_an_error_message_as_subscription_is_already_done_with_this_email() throws Throwable {
		String message = ns.alertMessage().getText();
		Assert.assertEquals("Newsletter : This email address is already registered.", message);
		logger.info(message);
	}
}
