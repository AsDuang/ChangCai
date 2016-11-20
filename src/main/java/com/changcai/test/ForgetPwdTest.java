package com.changcai.test;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

import com.changcai.test.dao.SMSDao;
import com.changcai.test.pages.ForgetPwdPage;
import com.changcai.test.utils.DriverUtil;
import com.changcai.test.utils.PropertiesUtil;

public class ForgetPwdTest {
	
	private WebDriver driver;
	private ForgetPwdPage fpp;
	
	@DataProvider
	public Object[][] methodData(Method method){
		Object[][] result = null;
		switch(method.getName()) {
		case "notAvailableMobile":
			result =  new Object[][]{{"1234567890"}};
			break;
		case "notExistMobile":
			result = new Object[][]{{"15901423883"}};
			break;
		case "asNormalMobile":
			result = new Object[][]{{"18616250312"}};
			break;
		case "wrongVerifyCode":
			result = new Object[][]{{"18616250312"}};
			break;
		}
		return result;
	}

	@BeforeClass
	public void setUp() {
		driver = DriverUtil.setUpIEDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void openFpPage() {
		fpp = new ForgetPwdPage(driver,PropertiesUtil.getSite()+"/forgetpass");		
	}
	
	@Test(dataProvider="methodData")
	//输入了一个不合法的手机号
	public void notAvailableMobile(String mobile) throws InterruptedException {
		fpp.inputMobile(mobile);
		Thread.sleep(2000);
		assertEquals(fpp.getStatusMsg(),"请输入正确的手机号");
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="methodData")
	//输入正确的手机号码
	public void asNormalMobile(String mobile) throws InterruptedException {
		fpp.inputMobile(mobile);
		Thread.sleep(2000);
		assertEquals(fpp.getStatusMsg(),"");		
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="methodData")
	//输入一个没有注册过的手机号
	public void notExistMobile(String mobile) throws InterruptedException {
		fpp.inputMobile(mobile);
		Thread.sleep(2000);
		assertEquals(fpp.getStatusMsg(),"该手机号尚未注册，请重新输入");
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="methodData")
	//输入了错误的验证码
	public void wrongVerifyCode(String mobile) throws SQLException, InterruptedException {
		String right = SMSDao.getCodeviaMobile(mobile);
		if(!"123456".equals(right))  
			fpp.inputCode("123456");
		Thread.sleep(2000);
		assertEquals(fpp.getStatusMsg(),"请输入正确的验证码");
		Thread.sleep(2000);
	}
	
	@Test
	//重置密码时输入了不一样的密码
	public void notSamePwd() {
		//TODO
	}
	
	@Test
	//成功重置密码
	public void resetPwdSuccess() {
		//TODO
	}
	
	@AfterMethod
	public void toBack() {
		driver.navigate().back();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
