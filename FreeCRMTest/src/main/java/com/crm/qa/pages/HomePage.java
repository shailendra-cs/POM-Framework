package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@class='dropdown-toggle']//span")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//li[@class='first']")
	WebElement webSiteLoGo;

	@FindBy(css = "a[title='Configuration']")
	WebElement configurationLink;

	@FindBy(xpath = "//a[@title='Activity Tracking']")
	WebElement activityTrackingLink;

	@FindBy(css = "a[href='/en-US/User/UserDetail']")
	WebElement userLink;

	@FindBy(css = "a[href='/en-US/User/UserAdd']")
	WebElement addnewUserLink;
	
	@FindBy(xpath="//a[@title='Currency']")
	WebElement currencyLink;
	
	
	@FindBy(xpath="//a[@class='btn btn-blue']")
	WebElement addNewCurrency;
	
	
	@FindBy(xpath="//a[@title='Group & Privileges']")
	WebElement groupPrivilageLink;
	
	@FindBy(xpath="//a[@class='btn btn-blue]")
	WebElement addNewGroupPrivaleg;
	

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle(){
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}

	public boolean verifyWebsiteLogo(){
		return webSiteLoGo.isDisplayed();
	}
	
	public UserPage clickOnConfigurationLink(){
		configurationLink.click();
		return new UserPage();
	}

	public UserPage clickOnUserLink(){
		userLink.click();
		return new UserPage();
	}

	public void clickOnNewUserLink(){
		addnewUserLink.click();
	}
	
	public CurrencyPage clickConfigurationLink(){
		configurationLink.click();
		return new CurrencyPage();
	}
	
	public CurrencyPage clickOnCurrencylink(){
		currencyLink.click();
		return new CurrencyPage();
	}
	
	public void clickAddNewCurrency(){
		addNewCurrency.click();
	}
	
	public ActivityTrackingPage clickOnActivityTrackingLink(){
	activityTrackingLink.click();
	return new ActivityTrackingPage();
	}
	
	public GroupPrivilagePage clickOnGrouPrivlageLink(){
		groupPrivilageLink.click();
		return new GroupPrivilagePage();
	}
	public void clickAddNewGroupPrivileges(){
		addNewGroupPrivaleg.click();
	}
}
