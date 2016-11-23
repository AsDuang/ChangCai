package com.changcai.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.changcai.test.pages.BuyDoupoDoPage;
import com.changcai.test.pages.HomePage;
import com.changcai.test.pages.LoginPage;
import com.changcai.test.pages.ProductDetailPage;
import com.changcai.test.services.UserServices;
import com.changcai.test.utils.DriverUtil;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;


public class PersonalBuyerOrderTest {
	
	private WebDriver driver;
	private BuyDoupoDoPage bddp;
	private ProductDetailPage pdp;
	
	@BeforeClass
	public void setUp() {
		//TODO 
		driver = DriverUtil.setUpIEDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		bddp = new BuyDoupoDoPage(driver);
	}
	
	@Test
	//未登录状态下点击确认下单
	public void createOrderviaNotLogin() {
		//当前没有用户登录
		assertFalse(UserServices.loginVerifed(driver));
		//当前的报价列表是有效的
		assertTrue(bddp.isPriceListAvailable());
		//当前的报价是一个一口价报价
//		assertTrue(bddp.getPriceLi().)
		
	}
	
	@Test
	//未认证为个人买家  创建订单--立即下单，查看订单状态， 弹出窗口
	public void createOrderviaNotVerifiedBuyer() {
		//TODO 
	}
	
	@Test
	//已认证为个人买家 创建订单--立即下单， 查看订单状态
	public void  createOrderviaVerifiesBuyer() {
		//TODO 
	}
	
	
	
	@Test
	//已认证为个人买家 创建订单--立即下单--不签署合同，使订单失效，查看订单状态
	public void createOrderviaVerifiesBuyerNotSigned() {
		//TODO 
	}
	
	@Test
	//已认证为个人买家 创建订单--立即下单--签署合同--不支付保证金，使订单失效，查看订单状态
	public void createOrderviaVerifiesBuyersignedandNotPay() {
		//TODO 
	}
		
	@Test
	//已认证为个人买家 创建订单--立即下单--签署合同--支付保证金， 查看订单状态
	public void createOrderviaVerifiesBuyersignedandpayed() {
		//TODO 
	}
	

	@AfterClass
	public void tearDown() {
		
	}
}
