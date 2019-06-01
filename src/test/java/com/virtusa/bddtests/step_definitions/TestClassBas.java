package com.virtusa.bddtests.step_definitions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.virtusa.bddtests.utils.Identifiers;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestClassBas {
	WebDriver driver;
		
	@Given("^The user launches the app$")
	public void the_user_launches_the_app() throws Throwable {
		
	    String ipapath = "D:\\ipafolder\\bmoipa.ipa";
	    File app = new File (ipapath);
	    URL url = null;
	    
		try {	    
			 url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("platformName", "iOS");
				caps.setCapability("platformVersion", "11.0");
				caps.setCapability("deviceName", "iPhone 8");
				caps.setCapability("uuid", "the uuid of the phone");
				caps.setCapability("bundleId", "bundle ID of the app");
				caps.setCapability("app", app);
				caps.setCapability("automationName", "XCUITest");
				caps.setCapability("language", "");
				caps.setCapability("locale", "es");

			driver = new RemoteWebDriver(url, caps);
			Assert.assertTrue("The required page is not displayed", driver.getTitle().contains("Chase Mobile Application"));
	}

	@When("^The user confirms the user is on alternate logon screen$")
	public void the_user_confirms_the_user_is_on_alternate_logon_screen() throws Throwable {
		verifyALternateLogonScreen();
	}

	@When("^The user taps on enroll button$")
	public void the_user_taps_on_enroll_button() throws Throwable {
		WebElement enrollBtn = driver.findElement(By.xpath(Identifiers.BASIC_ENROLL_BUTTON));
		enrollBtn.click();
	}

	@When("^The user taps on Log on button$")
	public void the_user_taps_on_Log_on_button() throws Throwable {
		WebElement loginButton = driver.findElement(By.xpath(Identifiers.BASIC_LOGIN_BUTTON));
		loginButton.click();
	}

	@Then("^The user is displayed with \"([^\"]*)\" screen$")
	public void the_user_is_displayed_with_BAU_Logon_Screen(String screen) throws Throwable {
		
		if(screen.equals("basic info")) {
			
			System.out.println("This is Basic Info Screen");
			verifyBasicInfoScreen();			
		}
		else if(screen.equals("BAU Logon")) {
			
			System.out.println("This is BAU Screen");
			verifyBAUScreen();
		}

	}
	
	private void verifyBasicInfoScreen() {
		
		WebElement enrollFirstname = driver.findElement(By.xpath(Identifiers.BASIC_ENROLL_FIRST_NAME));
		Assert.assertTrue("The enroll FIrst name is not present", enrollFirstname.isDisplayed());
		
		WebElement enrollLastName = driver.findElement(By.xpath(Identifiers.BASIC_ENROLL_LAST_NAME));
		Assert.assertTrue("The enroll Last anme is not present",enrollLastName.isDisplayed());
		
		WebElement enrollEmail = driver.findElement(By.xpath(Identifiers.BASIC_ENROLL_EMAIL));
		Assert.assertTrue("The enroll email is not present", enrollEmail.isDisplayed());
		
		WebElement enrollPhone = driver.findElement(By.xpath(Identifiers.BASIC_ENROLL_PHONE));
		Assert.assertTrue("The enroll Phone is not present", enrollPhone.isDisplayed());
		
		WebElement enrollCompleteBtn = driver.findElement(By.xpath(Identifiers.BASIC_COMPLETE_ENROLLMENT_BTN));
		Assert.assertTrue("The Basic Enrollment Button is not Enabled or not present", enrollCompleteBtn.isDisplayed() && enrollCompleteBtn.isEnabled());
		
	}
	
	private void verifyBAUScreen() {
		
		WebElement basicEmail = driver.findElement(By.xpath(Identifiers.BASIC_LOGIN_EMAIL));
		Assert.assertTrue("The basic email is not displayed", basicEmail.isDisplayed());
		
		WebElement basicPassword = driver.findElement(By.xpath(Identifiers.BASIC_LOGIN_PASSWORD));
		Assert.assertTrue("The basic password is not displayed", basicPassword.isDisplayed());
		
		WebElement basicSignInButton = driver.findElement(By.xpath(Identifiers.BASIC_SIGNIN_BUTTON));
		Assert.assertTrue("The basic sign in button is not enabled or not displayed", basicSignInButton.isDisplayed() && basicSignInButton.isEnabled());
	}
	
	private void verifyALternateLogonScreen() {
		
		WebElement enrollBtn = driver.findElement(By.xpath(Identifiers.BASIC_ENROLL_BUTTON));
		Assert.assertTrue("The enroll button on the AlternateLogin Screen is Not present or not enabled", enrollBtn.isDisplayed() && enrollBtn.isEnabled());
		
		WebElement loginButton = driver.findElement(By.xpath(Identifiers.BASIC_LOGIN_BUTTON));
		Assert.assertTrue("The login button on the Alternate Login screen is not displayed or not enabled", loginButton.isEnabled() && loginButton.isDisplayed());				
	}
}
