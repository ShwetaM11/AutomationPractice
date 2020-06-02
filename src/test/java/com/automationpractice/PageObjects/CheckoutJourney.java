package com.automationpractice.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static com.automationpractice.StepDefination.BaseClass.logger;

/**
 * All the elements and respected methods of Checkout Journey feature are declared here<br>
 * Completed a check out process by adding new email id as well as already signed up email id.<br>
 * Verify each page of the process like authentication, order confirmation, order summary, order history.<br>
 * 
 * @author Shweta
 *
 */
public class CheckoutJourney {

	public WebDriver driver;

	public CheckoutJourney(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='product-image-container']")
	WebElement btnSelectT;

	@FindBy(xpath = "//button[@class='exclusive']")
	WebElement btnAddToCart;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement btnProceedToCheckout;

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement txtEmail;

	@FindBy(xpath = "//button[@id='SubmitCreate']")
	WebElement btnCreateAcc;

	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement btnRadio;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	private WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	private WebElement txtLastname;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@id='address1']")
	private WebElement txtAddress;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement txtCity;

	@FindBy(xpath = "//input[@id='postcode']")
	private WebElement txtZip;

	@FindBy(xpath = "//input[@id='phone_mobile']")
	private WebElement txtPhnNum;

	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]")
	private WebElement btnProceedToCheckout1;

	@FindBy(xpath = "//input[@id='alias']")
	private WebElement txtAlias;

	@FindBy(xpath = "//button[@id='submitAccount']")
	private WebElement btnRegister;

	@FindBy(xpath = "//select[@id='years']")
	private WebElement selectYear;

	@FindBy(xpath = "//select[@id='months']")
	private WebElement selectMonth;

	@FindBy(xpath = "//select[@id='days']")
	private WebElement selectDay;

	@FindBy(xpath = "//select[@id='id_state']")
	private WebElement selectState;

	@FindBy(xpath = "//a[@class='bankwire']")
	private WebElement btnPayment;

	@FindBy(xpath = "//input[@id='cgv']")
	private WebElement checkBoxTerm;

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	private WebElement btnConfirm;

	@FindBy(xpath = "//a[@title='Back to orders']")
	private WebElement btnBackOrder;

	@FindBy(xpath = "//a[@title='Log me out']")
	private WebElement btnSignOut;

	@FindBy(xpath = "//button[@name='processAddress']")
	private WebElement btnACheckOut;

	@FindBy(xpath = "//button[@name='processCarrier']")
	private WebElement btnCheckOut;

	@FindBy(xpath = "//h1[text()='Authentication']")
	private WebElement txtAuth;

	@FindBy(xpath = "//h1[text()='Addresses']")
	private WebElement txtAdd;

	@FindBy(xpath = "//h1[text()='Shipping']")
	private WebElement txtship;

	@FindBy(xpath = "//h1[@class='page-heading']")
	private WebElement txtOrderSummary;

	@FindBy(xpath = "//h1[text()='Order confirmation']")
	private WebElement txtOrderConfirm;

	@FindBy(xpath = "//h1[text()='Order history']")
	private WebElement txtOrderHistory;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement txtEnterPassword;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	private WebElement btnSignup;

	public void clickSignup() {
		btnSignup.click();
	}

	public void readAuth() {
		String txtauth = txtAuth.getText();
		logger.info("User navigate on " + txtauth + " Page");
	}

	public void readAdd() {
		String txtadd = txtAdd.getText();
		logger.info("User navigate on " + txtadd + " Page");
	}

	public void readShipping() {
		String txtshipping = txtship.getText();
		logger.info("User navigate on " + txtshipping + " Page");
	}

	public void readOrderConfirmation() {
		String txtOrdercon = txtOrderConfirm.getText();
		logger.info("User navigate on " + txtOrdercon + " Page");
	}

	public void readOrderHistory() {
		String txtOrderHis = txtOrderHistory.getText();
		logger.info("User navigate on " + txtOrderHis + " Page");
	}

	public void readOrderSummary() {
		String txtOrderSumm = txtOrderSummary.getText();
		logger.info("User navigate on " + txtOrderSumm + " Page");
	}

	public void selectDays() {
		Select Day = new Select(selectDay);
		Day.selectByIndex(1);
	}

	public void selectMonth() {
		Select Month = new Select(selectMonth);
		Month.selectByIndex(3);
	}

	public void selectYear() {
		Select Year = new Select(selectYear);
		Year.selectByIndex(4);
	}

	public void selectState() {
		Select State = new Select(selectState);
		State.selectByIndex(4);
	}

	public void selectTshirt() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnSelectT);

		btnSelectT.click();
	}

	public void clickAddToCart() {
		btnAddToCart.click();
	}

	public void clickCreateAccount() {
		btnCreateAcc.click();
	}

	public void clickProceedCheckout1() {
		btnProceedToCheckout1.click();
	}

	public WebElement setEmail() {
		return txtEmail;
	}

	public void clickProceedCheckout() {
		btnProceedToCheckout.click();
	}

	public void clickRadioButton() {
		btnRadio.click();
	}

	public WebElement setFirstname() {
		return txtFirstname;
	}

	public WebElement setSignupEmail() {
		return txtEmailAddress;
	}

	public WebElement setSignupPassword() {
		return txtEnterPassword;
	}

	public void setSecondname() {
		btnProceedToCheckout1.click();
	}

	public WebElement setLastname() {
		return txtLastname;
	}

	public WebElement setPassword() {
		return txtPassword;
	}

	public WebElement setAddress() {
		return txtAddress;
	}

	public WebElement setCity() {
		return txtCity;
	}

	public WebElement setPhnNumber() {
		return txtPhnNum;
	}

	public WebElement setZipCode() {
		return txtZip;
	}

	public WebElement setAlias() {
		return txtAlias;
	}

	public void clickRegister() {
		btnRegister.click();
	}

	public void clickTerm() {
		checkBoxTerm.click();
	}

	public void clickPayment() {
		btnPayment.click();
	}

	public void clickConfirm() {
		btnConfirm.click();
	}

	public void clickBackOrder() {
		btnBackOrder.click();
	}

	public void clickOrderCheckOut() {
		btnCheckOut.click();
	}

	public void clickOrderCheckOutAddress() {
		btnACheckOut.click();
	}

	public void clickSignOut() {
		btnSignOut.click();
	}

}
