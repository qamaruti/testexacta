package com.prjct.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prjct.qa.base.TestBase;
import com.prjct.qa.pages.HomePage;
import com.prjct.qa.pages.LoginPage;

public class HomepageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public HomepageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {

		initilization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void clickVerifyFavoritesPageTitile() {
		homePage.clickFavoritiesMenu();
		String title1 = homePage.VerifyFavoritesPageTitile();
		Assert.assertEquals(title1, "FAVORITES");
		System.out.print(title1);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
