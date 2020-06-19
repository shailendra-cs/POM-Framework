package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class GroupPrivilagePage extends TestBase{

	@FindBy(xpath="//div[@class='widget-header']/h4")
	WebElement verifyGroupLabel;
	
	@FindBy(id="Group_GroupName")
	WebElement groupName;
	
	@FindBy(id="Group_GroupCode")
	WebElement groupCode;
	
	@FindBy(id="Group_Description")
	WebElement groupDescription;
	
	@FindBy(id="Partners")
	WebElement selectPartner;
	
	@FindBy(id="PointTypes")
	WebElement selectPointType;
	
	@FindBy(id="Continue")
	WebElement continueClick;
	
	@FindBy(xpath="//div[@id='nestable_list_1']")
	WebElement ctrlDrag;
	
	@FindBy(xpath="//div[@id='nestable_list_2']")
	WebElement ctrlDrop;
	
	
    //Initializing the Page Objects:
	public GroupPrivilagePage(){
		PageFactory.initElements(driver, this);
	}

	public boolean verifyGroupLabel(){
		return verifyGroupLabel.isDisplayed();
	}


}
