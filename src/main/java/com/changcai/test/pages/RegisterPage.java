package com.changcai.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.changcai.test.utils.DataBaseUtil;
import com.changcai.test.utils.MD5Util;

public class RegisterPage {

	private WebDriver driver;
	private String url;
	
	public RegisterPage(WebDriver driver, String url) {
		super();
		this.driver = driver;
		this.url = url;
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	public String getUrl() {
		return url;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@FindBy(id="account")
	private WebElement txt_mobile;
	
	@FindBy(id="get_code")
	private WebElement btn_getCode;
	
	@FindBy(className="com-tms")
	private WebElement statusMsg;
	
	@FindBy(id="code")
	private WebElement txt_code;
	
	@FindBy(id="password")
	private WebElement txt_password;
	
	@FindBy(id="ensurePwd")
	private WebElement txt_ensurePwd;
	
	@FindBy(className="iCheck-helper")
	private WebElement ins_check;
	
	@FindBy(id="registerBtn")
	private WebElement btn_Register;
	
	@FindBy(linkText="立即登录")
	private WebElement toLogin;
	
	@FindBy(linkText="《买豆粕网平台用户规则》")
	private WebElement toRuler;
	
	public void getCode(String mobile) {
		txt_mobile.clear();
		txt_mobile.sendKeys(mobile);
		btn_getCode.click();
	}
	
	//注册流程的页面元素操作
	public void registerDo(String code,String password,String ensurePwd) {
		txt_code.clear();
		txt_code.sendKeys(code);
		txt_password.clear();
		txt_password.sendKeys(password);
		txt_ensurePwd.clear();
		txt_ensurePwd.sendKeys(ensurePwd);
		ins_check.click();
		btn_Register.click();
	}
	
	//注册操作，涉及到数据库操作。 
	public void registerAction(String mobile,String password) {
		//TODO
		String insertUser = "insert into usr_user (mobile,password) values ('"+mobile+"'"+",'"+MD5Util.getMD5String(password)+"')";
		DataBaseUtil.insertData(insertUser);
		
	}
	
	//验证注册是否成功，涉及到数据库操作 
	public boolean verifyRegister(String mobile) {
		//TODO
		boolean b = false;
		if(DataBaseUtil.findResults("select * from usr_user where mobile = '" + mobile + "'") != null)
			b = true;
		return b;
	}
	
}
