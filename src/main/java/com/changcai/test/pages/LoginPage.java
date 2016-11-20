package com.changcai.test.pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {
	
	private WebDriver driver;
	private String url;

	@FindBy(linkText="免费注册")
	public WebElement toRegisterLink;
	
	@FindBy(linkText="忘记密码")
	public WebElement toForgetPwdLink;
	
	@FindBy(id="account")
	public WebElement txt_account;
	
	@FindBy(id="password") 
	public WebElement pwd_password;
	
	@FindBy(id="loginBtn")
	public WebElement btn_Login;
	
	@FindBy(className="com-tms")
	public WebElement statusMsg;

	public LoginPage(WebDriver driver,String url) {
		this.driver = driver;
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public String getStatusMsg() {
		return statusMsg.getText();
	}
	public void loginAction(String account, String pwd) {
		txt_account.clear();
		txt_account.sendKeys(account);
		pwd_password.clear();
		pwd_password.sendKeys(pwd);
		btn_Login.click();
	}
	
	public void toRegister() {
		toRegisterLink.click();
	}
	
	public void toForgetPwd() {
		toForgetPwdLink.click();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isLoginSuccess(String name) {
		boolean is = false;
		for(Cookie ck: driver.manage().getCookies()) {
			if (name.equals(ck.getName() ) ) {
				is = true;
			}
		}
		return is;
	}
	
}