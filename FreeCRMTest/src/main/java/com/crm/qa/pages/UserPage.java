package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class UserPage extends TestBase {

	@FindBy(xpath = "//h4[contains(text(),'User')]")
	WebElement addNewUserLabel;

	@FindBy(id="User_FirstName")
	WebElement first_Name;

	@FindBy(id="User_LastName")
	WebElement last_Name;

	@FindBy(id="User_EmailId")
	WebElement email_Id;

	@FindBy(id="User_MobileNumber")
	WebElement mobile_Number;

	@FindBy(xpath = "//button[@type='submit' and @value='Submit']")
	WebElement saveBtn;

	@FindBy(xpath="//div[@class='alert alert-success fade in']")
	WebElement succesText;

	@FindBy(xpath="//input[@type='search']")
	WebElement searchUser;

	@FindBy(xpath="//tr[1]//a[@class='edit-btn']")
	WebElement edit;

	 
	// Initializing the Page Objects:
	public UserPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyUsersLabel(){
		return addNewUserLabel.isDisplayed();
	}

	public void createNewUser(String ftName, String ltName, String etemailId,String mtmobNumber){
		first_Name.sendKeys(ftName);
		last_Name.sendKeys(ltName);
		email_Id.sendKeys(etemailId);
		mobile_Number.sendKeys(mtmobNumber);

		//		Select selectLanguage = new Select(driver.findElement(By.xpath("//div[@class='select2-result-label']")));
		//		selectLanguage.selectByVisibleText("English");

		Select selectGroup = new Select(driver.findElement(By.id("User_GroupIds")));
		selectGroup.selectByVisibleText("Admin");

		saveBtn.click();
	}

	public boolean VerifUserAdded(){
		return succesText.isDisplayed();
	}

	public void userSearch(String user_name,String f_Name,String l_Name){
		searchUser.sendKeys(user_name);
		edit.click();
		updateNewUser(f_Name, l_Name);
	}

	public void updateNewUser(String ftName, String ltName){
		first_Name.sendKeys(ftName);
		last_Name.sendKeys(ltName);
		saveBtn.click();
	}

}
