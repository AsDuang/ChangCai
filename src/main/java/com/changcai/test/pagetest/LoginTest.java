package com.changcai.test.pagetest;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.changcai.test.pages.LoginPage;
import com.changcai.test.utils.DriverUtil;
import com.changcai.test.utils.PropertiesUtil;

public class LoginTest {
	
	private WebDriver driver;
	private LoginPage loginpage;
	
	@DataProvider
    public Object[][] providerMethod(Method method){
        Object[][] result = null;
        switch(method.getName()) {
        case"loginNormalTest":
        	result = new Object[][]{{"18616250312","changcai1"}}; 
        	break;
        case"loginWrongTest":
        	result = new Object[][]{{"18616250312","changcai"}};
        	break;
        case"loginNullInput":
        	result = new Object[][]{{"",""}};
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
	public void openLoginPage() {
		loginpage = new LoginPage(driver,PropertiesUtil.getSite()+"/login");
	}
	
	@Test(dataProvider="providerMethod")
	public void loginNormalTest(String mobile,String pwd) throws InterruptedException {
		System.out.println();
		System.out.println("Login Normal mobile: " + mobile);
		System.out.println("Login Normal pwd: " + pwd);

		loginpage.loginAction(mobile, pwd);
		Thread.sleep(2000);
		assertTrue(driver.getCurrentUrl().contains("/index"));
	}
	
	@Test(dataProvider="providerMethod")
	public void loginWrongTest(String mobile,String pwd) {
		System.out.println("Wrong Pwd mobile: " + mobile);
		System.out.println("Wrong Pwd pwd: " + pwd);
		loginpage.loginAction(mobile, pwd);
		assertEquals(loginpage.getStatusMsg(),"手机号或密码错误，请重新输入");
	}
	
	@Test(dataProvider="providerMethod")
	public void loginNullInput(String mobile,String pwd) {
		System.out.println("Null mobile: " + mobile);
		System.out.println("Null pwd: " + pwd);
		loginpage.loginAction(mobile, pwd);
		assertEquals(loginpage.getStatusMsg(),"手机号或密码错误，请重新输入");
	}
	
	@Test
	public void toRegisterLink() throws InterruptedException {
		loginpage.toRegister();
		Thread.sleep(2000);
		assertEquals(driver.getTitle(),"注册_买豆粕网_专业豆粕电商");		
	}
	
	@Test
	public void toForgetPwdLink() throws InterruptedException {
		loginpage.toForgetPwd();
		Thread.sleep(2000);
		assertEquals(driver.getTitle(),"忘记密码_买豆粕网_专业豆粕电商");
	}
	
	@AfterMethod
	public void backTo() {
		driver.navigate().back();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

	

}
