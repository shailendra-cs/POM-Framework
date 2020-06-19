package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.UserPage;
import com.crm.qa.util.TestUtil;

public class UserPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UserPage userPage;

	String sheetName = "User";

	public UserPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		userPage = new UserPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		//testUtil.switchToFrame();
		//contactsPage = homePage.clickOnContactsLink();
		userPage=homePage.clickOnConfigurationLink();
		userPage = homePage.clickOnUserLink();
		//homePage.clickOnNewUserLink();
	}

	@Test(priority=1)
	public void verifyUsersLabel(){
		Assert.assertTrue(userPage.verifyUsersLabel(), "User label is missing on the page");
	}

	/*@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}*/

	@Test(priority=2)
	public void validateCreateNewUser(){
		//homePage.clickOnNewUserLink();
		homePage.clickOnNewUserLink();
		userPage.createNewUser("Pushkar52"+testUtil.generateRandonNumber(), "Gosain152"+testUtil.generateRandonNumber(), testUtil.generateRandonNumber()+"pk@lptest.com", "1234567890");
		Assert.assertTrue(userPage.VerifUserAdded(), "User details not added system.");
	}

	@Test(priority=3)
	public void validateUpdateUser(){
		userPage.userSearch("Pushkar", "Pushkar5222", "Gosain522");
		Assert.assertTrue(userPage.VerifUserAdded(), "User details not updated in system.");
	}
	
	@Test(priority=4)
	@Parameters("uname")
	public void validateSearchUser(String uname){
		//userPage.userSearch("", "","");
		
		if(uname.contains("ramphal")){
			userPage.userSearch(uname, "Pushkar5222", "Gosain522");
			Assert.assertTrue(userPage.VerifUserAdded(), "User details not updated in system.");
		}
		else if(uname.contains("test"))
		{
			userPage.userSearch(uname, "Pushkar5222", "Gosain522");
			Assert.assertTrue(userPage.VerifUserAdded(), "User details not updated in system.");
		}
		else if(uname.contains("zadduu")){
			userPage.userSearch(uname, "Pushkar5222", "Gosain522");
			Assert.assertTrue(userPage.VerifUserAdded(), "User details not updated in system.");
		}else if(uname.contains("goal")){
			userPage.userSearch(uname, "Pushkar5222", "Gosain522");
			Assert.assertTrue(userPage.VerifUserAdded(), "User details not updated in system.");
		}
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
