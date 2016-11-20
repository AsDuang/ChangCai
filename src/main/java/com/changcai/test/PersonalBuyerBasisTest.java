package com.changcai.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * 个人买家的基差交易订单
 */
public class PersonalBuyerBasisTest {
	
	@DataProvider
	//TODO
	public Object[][] dataMethod() {
		return new Object[][]{{}};
	}
	
	
	@BeforeClass
	public void setUp() {
		//TODO
	}
	
	@BeforeMethod
	public void openOrderPage() {
		//TODO
	}
	
	
	@Test
	//未认证个人买家对基差订单 -- 确认下单
	public void createBasisviaNotVerifiedBuyer() {
		//TODO
	}
	
	
	@Test
	//已认证个人买家对基差订单 -- 确认下单--查看订单状态
	public void createBasisviaVerifiedBuyer() {
		//TODO
	}
	
	@Test
	//已认证个人买家对价差订单 -- 确认下单 -- 不签署合同 使订单失效，查看订单状态
	public void createBasisviaVerifiedBuyerNotSigned() {
		//TODO
	}
	
	@Test
	//已认证个人买家对基差订单 -- 确认下单 -- 签署合同 查看订单状态
	public void createBasisviaVerifiedBuyerSigned() {
		//TODO
	}
	
	@Test
	//已认证个人买家对基差订单 -- 确认下单 -- 签署合同 --不支付保证金使订单失效，查看订单状态
	public void createBasisviaVerifiedBuyerNotPaid() {
		//TODO
	}
	
	@Test
	//已认证个人买家对基差订单 -- 确认下单 -- 签署合同 -- 支付保证金，完成订单。 查看订单状态。
	public void createBasisviaVerifiedBuyerPaid() {
		//TODO
	}
	

	@AfterMethod
	public void backTo() {
		//TODO
	}
	
	@AfterClass
	public void tearDown() {
		//TODO
	}


}
