package com.changcai.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class ForgetPwdPage {
	
	private WebDriver driver;
	String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@FindBy(className="com-tms")
	public WebElement statusMsg;
	
	@FindBy(id="mobile")
	public WebElement txt_Mobile;
	
	@FindBy(id="smsBtn")
	public WebElement btn_submit;
	
	@FindBy(id="code")
	public WebElement txt_Code;
	
	@FindBy(id="updatePwdBtn")
	public WebElement btn_updateSubmit;

	public ForgetPwdPage(WebDriver driver,String url) {
		this.driver=driver;
		driver.get(url);
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public String getStatusMsg() {
		return statusMsg.getText();
	}
	
	public void inputMobile(String mobile) {
		txt_Mobile.clear();
		txt_Mobile.sendKeys(mobile);
		btn_submit.click();
	}
	
	public void inputCode(String code) {
		txt_Code.clear();
		txt_Code.sendKeys(code);
		btn_updateSubmit.click();
	}

}
