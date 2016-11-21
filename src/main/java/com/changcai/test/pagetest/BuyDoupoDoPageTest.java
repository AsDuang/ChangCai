package com.changcai.test.pagetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.changcai.test.pages.BuyDoupoDoPage;
import com.changcai.test.utils.DriverUtil;

public class BuyDoupoDoPageTest {
	
	private WebDriver driver;
	private BuyDoupoDoPage bddp;
	
	@BeforeClass
	public void setUp() {
		driver = DriverUtil.setUpIEDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void openPage() {
		bddp = new BuyDoupoDoPage(driver,"http://prd.maidoupo.com/common/buyDouPo.do");
	}
	
	@Test
	public void checkPrice() {
		bddp.toProductDetail();	
		System.out.println(driver.getCurrentUrl());
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
