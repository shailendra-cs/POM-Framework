package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ActivityTrackingPage extends TestBase {

	// Initializing the Page Objects:
		public ActivityTrackingPage() {
			PageFactory.initElements(driver, this);
		}
	
}
