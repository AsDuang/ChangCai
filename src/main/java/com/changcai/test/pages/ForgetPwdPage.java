package com.changcai.test.pages;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import com.changcai.test.dao.SMSDao;

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
	
	public void inputCode(String mobile) throws SQLException, InterruptedException {
		txt_Code.clear();
		Thread.sleep(5000);
		String code = SMSDao.getCodeviaMobile(mobile);
		txt_Code.sendKeys(code);
		btn_updateSubmit.click();
	}
	
	public void inputWrongCode(String str) throws InterruptedException {
		txt_Code.clear();
		Thread.sleep(4000);
		txt_Code.sendKeys(str);
		btn_updateSubmit.click();
	}

}
