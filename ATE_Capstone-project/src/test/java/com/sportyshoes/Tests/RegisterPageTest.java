package com.sportyshoes.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sportyshoes.seleniumscripts.BasePage;
import com.sportyshoes.seleniumscripts.HomePage;
import com.sportyshoes.seleniumscripts.RegisterPage;

public class RegisterPageTest extends BasePage{
	HomePage hp;
	RegisterPage rp;
	
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser("Chrome");
		hp = new HomePage(driver);
		rp = new RegisterPage(driver);
	}

	
	@Test(priority='1')
	public void test_click_register_link() throws InterruptedException
	{
		Thread.sleep(1500);
		hp.click_register_link();
	}
	
	@Test(priority='2')
	public void test_getTitle_page()
	{
		String expected = "http://localhost:9010/register";
		String Actual = hp.getURL_page();
		Assert.assertEquals(Actual, expected);
		System.out.println("page url is" +Actual);
		
	}
	
	@Test(priority='3')
	public void Test_register_user()
	{
		rp.register_user();
	}
	
	@Test(priority='4')
	public void Test_validate_registration_URL()
	{
		String expected = "http://localhost:9010/register-user";
		String Actual = rp.validate_registration_URL();
		assertEquals(Actual, expected);
		System.out.println("Rergistration page url is" +Actual);
		
	}
	
@Test(priority='5')
	
	public void Test_validate_registration_Text()
	{
		String expected = "Hello vaidehi !";
		String actualText = rp.validate_registration_Text();
		Assert.assertEquals(actualText, expected);
		System.out.println("Regristration text is" +actualText);
	}
}
