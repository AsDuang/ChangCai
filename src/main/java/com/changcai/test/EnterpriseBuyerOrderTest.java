package com.changcai.test;

import org.testng.annotations.*;

public class EnterpriseBuyerOrderTest {

	@BeforeClass
	public void setUp() {
		//TODO
	}
	
	/*
	 * 企业管理员买家操作
	 */
	@Test
	//未认证企业的管理员买家 -- 弹出窗口
	public void createOrderviaNotVerifiedEnterAdminBuyer() {
		//TODO
	}
	
	@Test
	//认证企业的管理员买家 --确认下单 查看订单状态
	public void createOrderviaVerifiedEnterAdminBuyer() {
		//TODO
	}
	
	@Test
	//认证企业的管理员买家 --确认下单 -- 不签合同，使订单失效 查看订单状态
	public void createOrderviaVerifiedEnterAdminBuyerNotSigned() {
		//TODO
	}
	
	@Test
	//认证企业的管理员买家 --确认下单 -- 签署合同，使订单有效，查看订单状态。
	public void createOrderviaVerifiedEnterAdminBuyerSigned() {
		//TODO
	}
	
	@Test
	//认证企业的管理员买家 --确认下单 -- 签署合同，使订单有效，不支付保证金，使订单失效，查看订单状态
	public void createOrderviaVerifiedEnterAdminBuyerSignedNotPayed() {
		//TODO
	}
	
	@Test
	//认证企业的管理员买家 --确认下单 --签署合同，使订单有效，支付保证金，使订单有效，完成买家下单， 查看订单状态
	public void createOrderviaVerifiedEnterAdminBuyerSignedandPayed() {
		//TODO
	}
	
	/*
	 * 认证企业的业务员进行买家订单操作
	 */
	@Test
	//认证企业的业务员买家 -- 确认下单
	public void createOrderVerifiedEnterSalorBuyer() {
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		//TODO
	}
}
