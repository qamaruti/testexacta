package com.prjct.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prjct.qa.base.TestBase;
import com.prjct.qa.pages.HomePage;
import com.prjct.qa.pages.LoginPage;

public class LoginpageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginpageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initilization();
		 loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginpagetitletest() {
		String title=loginpage.validateloginpageTitle();
		Assert.assertEquals(title, "Login - Exacta Portal");
	}
	@Test(priority=2)
	public void crmlogotest() {
		boolean flag=loginpage.validatelogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
