package com.sportyshoes.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sportyshoes.seleniumscripts.BasePage;
import com.sportyshoes.seleniumscripts.HomePage;
import com.sportyshoes.seleniumscripts.LoginPage;
import com.sportyshoes.seleniumscripts.RegisterPage;

public class LoginPageTest  extends BasePage {
	
	HomePage hp;
	RegisterPage rp;
	LoginPage lp;
	
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser("Chrome");
		hp = new HomePage(driver);
		rp = new RegisterPage(driver);
		lp = new LoginPage(driver);
	}

	
	@Test(priority='1')
	public void test_login()
	{
		lp.user_login();
	}

	
	@Test(priority='2')
	public void test_getTitle_page()
	{
		String expected = "http://localhost:9010/login";
		String Actual = hp.getURL_page();
		Assert.assertEquals(Actual, expected);
		System.out.println("url of login page= "+Actual);
		
	}
	
    @Test(priority='3')
	
	public void Test_validate_registration_Text()
	{
		String expected = "Hello vaidehi !";
		String actualText = rp.validate_registration_Text();
		Assert.assertEquals(actualText, expected);
		System.out.println("the validation of login text =" +actualText);
	}


    @Test(priority='4')

      public void test_click_cart()
     {
	       lp.click_cart();
	
     }
}

