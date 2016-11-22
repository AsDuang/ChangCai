package com.changcai.test.pages;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.changcai.test.dao.SMSDao;
import com.changcai.test.utils.DataBaseUtil;
//import com.changcai.test.utils.MD5Util;

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
	
	
	//输入手机号码
	public void getCode(String mobile) {
		txt_mobile.clear();
		txt_mobile.sendKeys(mobile);
		btn_getCode.click();
	}
	
	//输入获取的验证码
	public void inputCode(String mobile) throws SQLException, InterruptedException {
		txt_code.clear();
		Thread.sleep(5000);
		String code = SMSDao.getCodeviaMobile(mobile);
		txt_code.sendKeys(code);
	}
	
	//注册流程的页面元素操作
	public void registerDo(String mobile,String password) throws SQLException, InterruptedException {
		getCode(mobile);
		inputCode(mobile);
		txt_password.clear();
		txt_password.sendKeys(password);
		txt_ensurePwd.clear();
		txt_ensurePwd.sendKeys(password);
		ins_check.click();
		btn_Register.click();
	}
	
//	public void registerClick() {
//		btn_Register.click();
//	}
	
	//注册操作，涉及到数据库操作。 
//	public void registerAction(String mobile,String password) {
//		//TODO
//		String insertUser = "insert into usr_user (mobile,password) values ('"+mobile+"'"+",'"+MD5Util.getMD5String(password)+"')";
//		DataBaseUtil.insertData(insertUser);		
//	}
	
	//输入正确的验证码

	
	//输入错误的验证码
	public void inputWrongCode(String mobile,String password) throws InterruptedException, SQLException {
		getCode(mobile);
		inputCode(mobile);
		txt_code.clear();
		Thread.sleep(4000);
		txt_code.sendKeys("132456");
		txt_password.clear();
		txt_password.sendKeys(password);
		txt_ensurePwd.clear();
		txt_ensurePwd.sendKeys(password);
		ins_check.click();
		btn_Register.click();
	}
	
	public void inputWrongPwd(String mobile,String str1, String str2) throws SQLException, InterruptedException {
		// str1 not equals str2;
		getCode(mobile);
		inputCode(mobile);
		txt_password.clear();
		txt_password.sendKeys(str1);
		txt_ensurePwd.clear();
		txt_ensurePwd.sendKeys(str2);
		ins_check.click();
		btn_Register.click();
	}
	
	public void inputPwd(String mobile,String password) throws SQLException, InterruptedException {
		getCode(mobile);
		inputCode(mobile);
		txt_password.clear();
		txt_password.sendKeys(password);
		txt_ensurePwd.clear();
		txt_ensurePwd.sendKeys(password);
		ins_check.click();
		btn_Register.click();
	}
	//验证注册是否成功，涉及到数据库操作 
	public boolean verifyRegister(String mobile) {
		//TODO
		boolean b = false;
		if(DataBaseUtil.findResults("select * from usr_user where mobile = '" + mobile + "'") != null)
			b = true;
		return b;
	}
	
	public String getStatusMsg() {
		return statusMsg.getText();
	}
	
}
