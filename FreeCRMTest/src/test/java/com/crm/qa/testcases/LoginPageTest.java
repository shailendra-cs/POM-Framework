package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	public LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}

	@Test(priority=1)
	public void loginPageTitleTest() throws InterruptedException, IOException{
		String title = loginPage.validateLoginPageTitle();
		//Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
		//Assert.assertEquals(title,"Prime Cloud V5.8.0.0");

		testUtil.runTimeInfo("info", title);

		if (title.equals("Free CRM #1 cloud software for any business large or small")) {
			testUtil.runTimeInfo("info", "title is correct!! YAY!!!");
			Assert.assertTrue(true);
		} else {
			testUtil.runTimeInfo("error", "title is not correct!! BUG BUG BUG!!!");
			testUtil.takeScreenshotAtEndOfTest();
			Assert.assertTrue(false);
		}

	}

	@Test(priority=2)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority=3)
	public void invalidUserName(){
		homePage = loginPage.login("", "ashu@001");
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=4)
	public void invalidPassword(){
		homePage = loginPage.login("ashu.chanda@loyaltyprime.com", "");
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=5)
	public void invalidLoginCredentails(){
		homePage = loginPage.login("ashu.chanda1@loyaltyprime.com", "3232");
	}

	@Test(priority=6)
	public void blankCredentailsForBoth(){
		homePage = loginPage.login("", "");
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=7)
	public void validCredentailsForBoth(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}







}
