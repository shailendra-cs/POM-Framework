/**
 * 
 */
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CurrencyPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.UserPage;
import com.crm.qa.util.TestUtil;

/**
 * @author pushkar.gosai
 *Test cases of currency module.
 */
public class CurrencyPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	CurrencyPage currencypage;
	UserPage userPage;
	TestUtil testUtil;


	public CurrencyPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		testUtil = new TestUtil();
		userPage = new UserPage();
		loginPage = new LoginPage();
		currencypage = new CurrencyPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		currencypage=homePage.clickConfigurationLink();
		currencypage=homePage.clickOnCurrencylink();
	}

	@Test(priority=1)
	public void verifyLbel(){
		Assert.assertTrue(currencypage.verifyCurrencyLabel(), "Currency label is missing on the page");
	}


	@Test(priority=2)
	public void validateAddNewCurrency(){
		homePage.clickAddNewCurrency();
		currencypage.addNewCurrency("AutoC1234"+testUtil.generateRandonNumber(), "AU"+testUtil.generateRandonNumber(), "1", "Yes", "Yes");
		Assert.assertTrue(currencypage.currencyAddSucess(), "Success! Currency has been added successfully.");
	}
	
	
	@Test(priority=3)
	public void validateUpdateCurrency(){
		homePage.clickAddNewCurrency();
		currencypage.editCurrency("AutoC1234","AutoC12345","AT01","2","Yes");
		Assert.assertTrue(currencypage.currencyUpdatedSuccess(), "Success! Currency has been updated successfully.");
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}