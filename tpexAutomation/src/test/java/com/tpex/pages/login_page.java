package com.tpex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login_page {
	WebDriver driver;
	By txt_username = By.id("name");
	By txt_password = By.id("password");
	By btn_login = By.id("login");
	
	public login_page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUSername(String userName) {
		driver.findElement(txt_username).sendKeys(userName);
	}

	public void enterPassword(String Password) {
		driver.findElement(txt_password).sendKeys(Password);
	}

	public void clickOnLoginBtn() {
		driver.findElement(btn_login).click();
	}

}
