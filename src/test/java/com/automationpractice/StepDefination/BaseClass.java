package com.automationpractice.StepDefination;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.automationpractice.PageObjects.CheckoutJourney;
import com.automationpractice.PageObjects.NavigateToMultiplePage;
import com.automationpractice.PageObjects.NewsletterSubscription;
import com.automationpractice.PageObjects.SummerDressesListing;

/**
 * All the objects are declared here<br>
 * A reusable variable(randomValue) is created.<br>
 * As per the requirement we can create common methods and variables here which can be passed to the steps.java class.<br>
 * @author Shweta
 */

public class BaseClass {

	public WebDriver driver;
	public NavigateToMultiplePage np;
	public SummerDressesListing sd;
	public CheckoutJourney cj;
	public NewsletterSubscription ns;
	public static Logger logger;
	public Properties properties;

	String randomValue = RandomStringUtils.randomAlphabetic(5);
}
