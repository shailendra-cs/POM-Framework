package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CurrencyPage extends TestBase {


	@FindBy(xpath="//div[@class='widget-header']/h4")
	WebElement addNewCurrencyLabel;

	@FindBy(id="Currency_CurrencyName")
	WebElement currencyName;

	@FindBy(id="Currency_CurrencyCode")
	WebElement currecnyCode;

	@FindBy(id="Currency_ConversionRate")
	WebElement currencyConversionRate;

	@FindBy(xpath="//div[@id='s2id_Currency_IsRedemptionAllowed']//span[@class='select2-arrow']/b")
	WebElement isRedemptionAllowedArrowClick;

	@FindBy(xpath="//div[@class='select2-result-label' and contains(text(),'Yes')]")
	WebElement isRedemptionAllowedSelected;

	@FindBy(xpath="//div[@id='s2id_Currency_Enabled']//b")
	WebElement currencyEnabledArrowClick;

	@FindBy(xpath="//div[@class='select2-result-label' and contains(text(),'Enabled')]")
	WebElement currencyStatus;

	@FindBy(xpath="//input[@value='Submit' and @type='submit']")
	WebElement btnSubmit;

	@FindBy(xpath="//div[starts-with(@class,'alert alert-')]")
	WebElement successText;

	@FindBy(xpath="//input[@type='search']")
	WebElement searchText;


	@FindBy(xpath="//a[@class='edit-btn']")
	WebElement edit;

	//Initializing the Page Objects:
	public CurrencyPage(){
		PageFactory.initElements(driver, this);
	}

	public boolean verifyCurrencyLabel(){
		return addNewCurrencyLabel.isDisplayed();
	}

	public void addNewCurrency(String cName,String cCode,String cConversationRate,String cRedemptionAllowed,String cEnabled){
		currencyName.sendKeys(cName);
		currecnyCode.sendKeys(cCode);
		currencyConversionRate.sendKeys(cConversationRate);
		isRedemptionAllowedArrowClick.click();
		isRedemptionAllowedSelected.click();
		currencyEnabledArrowClick.click();
		currencyStatus.click();
		btnSubmit.click();
	}

	public boolean currencyAddSucess(){
		return	successText.isDisplayed();
	}

	public void editCurrency(String cvalue,String cName,String cCode,String cConversationRate,String cEnabled){

		searchText.sendKeys(cvalue);
		edit.click();
		currencyName.sendKeys(cName);
		currencyName.sendKeys(cCode);
		currencyName.sendKeys(cConversationRate);
		currencyEnabledArrowClick.click();
		currencyStatus.click();
		btnSubmit.click();

	}

	public boolean currencyUpdatedSuccess(){
		return successText.isDisplayed();
	}
}
