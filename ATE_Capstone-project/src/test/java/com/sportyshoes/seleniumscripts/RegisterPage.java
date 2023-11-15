package com.sportyshoes.seleniumscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage 
{
	@FindBy(xpath="//input[@id='name']")
	WebElement registername;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement registeremail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement registerpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement registerBtn;
	
	@FindBy(xpath="//div[@class='mt-4 p-5 bg-primary text-white rounded']/descendant::p[3]")
	WebElement userText;
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
    }
	
	public void register_user()
	{
		registername.sendKeys("vaidehi");
		registeremail.sendKeys("vaidehi.a2000@gmail.com");
		registerpassword.sendKeys("Harrystyles_01&");
		registerBtn.click();
	}
	
	public String validate_registration_URL()
	{
		String register_url = driver.getCurrentUrl();
		return register_url;
	}
	
	public String validate_registration_Text()
	{
		String user_name = userText.getText();
		return user_name;
	}
	
	
}
