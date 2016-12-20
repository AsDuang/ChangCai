package com.changcai.test.pagetest;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.changcai.test.pages.HomePage;
import com.changcai.test.utils.DriverUtil;



public class HomePageLinkTest {

	private WebDriver driver;
	private HomePage home;
	
	@BeforeClass
	public void setUp() {
		driver = DriverUtil.setUpIEDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void openHome() {
		home = new HomePage(driver);
		System.out.println("setUp: " + driver.getCurrentUrl());
	}
	
	@Test
	//打开登录页面
	public void toLogin() throws InterruptedException {
		Thread.sleep(2000);
		home.toLogin();
		System.out.println("Login: " + driver.getCurrentUrl());
		assertEquals(driver.getTitle(),"登录_买豆粕网_专业豆粕电商");		
		Thread.sleep(2000);
	}
	
	@Test
	//打开注册页面
	public void toRegister() throws InterruptedException {
		Thread.sleep(2000);
		home.toRegister();
		assertEquals(driver.getTitle(),"注册_买豆粕网_专业豆粕电商");
		Thread.sleep(2000);
		System.out.println("Register: " + driver.getCurrentUrl());
		
	}
	
	@Test
	//打开资讯页面
	public void toCMS() throws InterruptedException {
		Thread.sleep(2000);
		home.toCMS();
		System.out.println("CMS: " + driver.getCurrentUrl());
		assertEquals(driver.getTitle(),"买豆粕网 专业豆粕电商");
		Thread.sleep(2000);
	}
	
	@Test
	//打开新手引导页面
	public void toNewer() throws InterruptedException {
		Thread.sleep(2000);
		home.toNewer();
		assertEquals(driver.getTitle(),"买豆粕网 专业豆粕电商");
		System.out.println("Newer " + driver.getCurrentUrl());
		Thread.sleep(2000);
		
	}
	
	@Test
	//打开买豆粕页面
	public void toBuyDoupo() throws InterruptedException {
		Thread.sleep(2000);
		home.toBuy();
		assertEquals(driver.getTitle(),"我要买豆粕_豆粕报价_买豆粕网");
		System.out.println("Buy " + driver.getCurrentUrl());
		Thread.sleep(2000);		
	}
	
	@Test
	//打开卖豆粕页面
	public void toSellDoupo() throws InterruptedException {
		Thread.sleep(2000);
		home.toSell();
		assertEquals(driver.getTitle(),"登录_买豆粕网_专业豆粕电商");
		System.out.println("Sell " + driver.getCurrentUrl());
		Thread.sleep(2000);		
	}
	
	@AfterMethod
	public void backTo() {
		driver.navigate().back();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
}
