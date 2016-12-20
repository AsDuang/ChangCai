package com.changcai.test.pagetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;

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
		bddp = new BuyDoupoDoPage(driver);
	}
	
	@Test
	public void checkPriceLi() throws SQLException, InterruptedException {
		
		//先判断当前是否有报价
		assertTrue(bddp.isThereAnyPrice());
		//在判断当前的报价是有效报价还是无效报价
		assertTrue(bddp.isPriceListAvailable());
		//有效报价的情况下，进入产品详情后，确认下单
		bddp.toProductPriceDetail();
		
	}
	
//	@AfterMethod
//	public void backTo() {
//		driver.navigate().back();
//	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
