package com.changcai.test.pagetest;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.changcai.test.pages.RegisterPage;
import com.changcai.test.utils.DriverUtil;
import com.changcai.test.utils.PropertiesUtil;

public class RegisterTest {
	
	private WebDriver driver;
	private RegisterPage rp;
	
	@DataProvider
	public Object[][] methodData(Method method) {
		Object[][] result  = null;
		switch(method.getName()) {
		case "existMobile":
			result = new Object[][]{{"18616250312"}}; 
			break;
		case "wrongVerifyCode":
			result = new Object[][]{{"15651803324","changcai1"}};
			break;
		case "notSamePwd":
			result = new Object[][]{{"15651803324","changcai","changc"}};
			break;
		case "notNormalMobile":
			result = new Object[][]{{"1234567890"}};
			break;
		case "registerSuccess":
			result = new Object[][]{{"15651803324","changcai1"}};
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
	public void openPage() {
		rp = new RegisterPage(driver,PropertiesUtil.getSite()+"/register");
	}
	
	@Test
	//已经存在的手机号码
	public void existMobile(String mobile) {
		rp.getCode(mobile);
		assertEquals("该手机号已被注册，请更换手机号",rp.getStatusMsg());
	}
	
	@Test
	//输入错误的验证码
	public void wrongVerifyCode(String mobile,String password) throws InterruptedException, SQLException {
		rp.inputWrongCode(mobile,password);
		assertEquals("验证码错误 or Something",rp.getStatusMsg());
	}
	
	@Test
	//输入的密码不一致
	public void notSamePwd(String mobile,String str1,String str2) throws SQLException, InterruptedException {
		rp.inputWrongPwd(mobile, str1, str2);
		assertEquals("密码不一致or Something",rp.getStatusMsg());
	}
	
	@Test
	//输入一个不合法的手机号
	public void notNormalMobile(String mobile) throws SQLException, InterruptedException {
		rp.getCode(mobile);
		assertEquals("请输入正确的手机号",rp.getStatusMsg());
	}
	
	@Test
	//正常的注册流程
	public void registerSuccess(String mobile, String password) throws SQLException, InterruptedException {
		rp.registerDo(mobile, password);
		assertTrue(rp.verifyRegister(mobile));
	}
	
	@AfterMethod
	public void backTo() {
		driver.navigate().forward();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
