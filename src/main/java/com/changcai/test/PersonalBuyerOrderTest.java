package com.changcai.test;

import org.testng.annotations.*;

public class PersonalBuyerOrderTest {

	@BeforeClass
	public void setUp() {
		//TODO 
		
	}
	
	@Test
	//未登录状态下点击确认下单
	public void createOrderviaNotLogin() {
		
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
