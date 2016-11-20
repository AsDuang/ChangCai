package com.changcai.test;

import org.testng.annotations.*;

public class EnterpriseBuyerBasisTest {
	
	@BeforeClass
	//创建WebDriver
	public void setUp() {
		//TODO
	}
	
	@BeforeMethod
	//打开测试页面
	public void openPage() {
		//TODO
	}
	
	/*
	 * 企业的管理员对基差订单的操作
	 */
	@Test
	//未认证企业的管理员 --确认下单
	public void createBasisviaNotVerifiedEnterpriseAdminBuyer() {
		//TODO
	}
	
	@Test
	//认证企业的管理员 -- 确认下单 
	public void createBasisviaVerifiedEnterpriseAdminBuyer(){
		//TODO
	}
	
	@Test
	//认证企业的管理员 -- 确认下单，但不签署合同，使合同失效，查看订单状态
	public void createBasisviaVerifiedEnterpriseAdminBuyerNotSigned() {
		//TODO
	}
	
	@Test
	//认证企业的管理员 -- 确认下单，签署合同，查看订单状态
	public void createBasisviaVerifiedEnterpriseAdminBuyerSigned() {
		
	}
	
	@Test
	//认证企业的管理员 -- 确认下单，签署合同，但不支付保证金，使订单失效，查看订单状态
	public void createBasisviaVerifiedEnterpriseAdminBuyerNotPaid() {
		
	}
	
	@Test
	//认证企业的管理员 -- 确认下单，签署合同，支付保证金，完成订单，查看订单状态
	public void createBasisviaVerifiedEnterpriseAdminBuyerPaid() {
		
	}
	
	
	/*
	 * 企业业务员对基差订单的操作
	 */
	@Test
	//认证企业的业务员 -- 确认下单
	public void createBasisviaVerifedEnterpriseSalorBuyer() {
		
	}
	
	@Test
	//认证企业的业务员 -- 确认下单，尝试签署合同，弹出权限提示。
	public void createBasisviaVerifiedEnterpriseSalorBuyerNotSigned() {
		
	}
	
	/*
	 * 企业财务员对基差订单的操作
	 */
	@Test
	//认证企业的财务员 -- 确认下单
	public void createBasisviaVerifiedEnterpriseTreasurerBuyer() {
		
	}
	@Test
	//认证企业的财务员 -- 对已确认下单的订单，不签署合同，使订单失效
	public void createBasisviaVerifiedEnterpriseTreasurerBuyerNotSigned() {
		
	}
	
	@Test
	//认证企业的财务员 -- 对已确认下单的订单，签署合同
	public void createBasisviaVerifiedEnterpriseTreasurerBuyerSigned() {
		
	}
	
	@Test
	//认证企业的财务员 -- 对已确认下单的订单，签署合同，不支付保证金，是订单失效
	public void createBasisviaVerifiedEnterpriseTreasurerBuyerSignedNotPaid() {
		
	}
	
	@Test
	//认证企业的财务员 --  对已确认下单的订单，签署合同，支付保证金，完成订单
	public void createBasisviaVerifiedEnterpriseTreasurerBuyerSignedPaid() {
		
	}
	
	/*
	 * 企业交易员对基差订单的操作
	 */
	@Test
	//认证企业的交易员 -- 确认下单
	public void createBasisviaVerifiedEnterpriseDealerBuyer() {
		
	}
	
	@AfterMethod
	public void backTo() {
		
	}
	
	@AfterClass
	public void tearDown() {
		
	}

}
