package com.changcai.test.pages;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.changcai.test.dao.ProdPriceDao;
import com.changcai.test.utils.DriverUtil;
import com.changcai.test.utils.PropertiesUtil;

/*
 * 在产品详情页点击确认下单后，跳转的页面。 
 */
public class BuyDoupoDoPage {
	
	//TODO BuyDouPo.do Page WebElement. 
	
	private WebDriver driver;
	private String url;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public BuyDoupoDoPage(WebDriver driver) {
		this.driver = driver;
		this.setUrl(PropertiesUtil.getSite()+"/common/buyDouPo.do");
		driver.get(url);
		PageFactory.initElements(driver, this);		
	}
	

	//获取所有产品报价
	@FindBys({@FindBy(css="html body div.proListMain div.screeningBox div.container div.productList div.container ul.clearfix.priceUl"),@FindBy(tagName="li")})
	private List<WebElement> ul_priceUL;
	
	
	// 检查当前时间内是否有报价。
	public boolean isThereAnyPrice() {
		//TODO 
		if( ul_priceUL.size() > 0 )
			return true;
		else return false;
	}
	
	//	//当前有报价时，报价列表是有效还是无效的。
	public boolean isPriceListAvailable() {
		boolean b = false;
		if(isThereAnyPrice()) {
			if(ul_priceUL.get(0).getAttribute("class").equals("noLM")) {
				b =  true;
			}else
				b =  false;
		}
		return b;
			
	}
	
	//当前有报价时，获取报价列表的个数。。
	public int getPriceLisSize() {
		return ul_priceUL.size();
	}
		
	//随机获取某一报价条目
	public WebElement getPriceLi() {
		Random rand = new Random();
		int i = rand.nextInt(ul_priceUL.size());
		return ul_priceUL.get(i);
	}
		
	//获取该报价的ID
	public int getDataRid(WebElement e) {
		return Integer.parseInt(e.getAttribute("data-rid"));
	}
	
	//验证当前报价是基差报价还是一口价报价
	public String checkProductPriceType(WebElement li) throws SQLException {
		// 检查当前的LI报价是基差报价还是一口价报价
		return ProdPriceDao.findTypeviaPID(this.getDataRid(li));		
	}
	
	//跳转到产品详情页
	public void toProductPriceDetail() throws SQLException, InterruptedException {

		List<String> urlList = new ArrayList<String>();
		String url = new String(PropertiesUtil.getSite()+"/product/");
		for(WebElement e : ul_priceUL) {
			System.out.println("Product Price ID: " +this.getDataRid(e));
			System.out.println("Spot or Basis: " + this.checkProductPriceType(e));
			urlList.add(url+this.getDataRid(e));
		}
		for(String urll: urlList) {
			driver.get(urll);
			System.out.println(urll);
			Thread.sleep(4000);
			driver.navigate().back();
		}
	}
		

	

	
	
	






	
	public static void main(String args[]) throws SQLException, InterruptedException {
		WebDriver driver = DriverUtil.setUpEdgeDriver();
		BuyDoupoDoPage buy = new BuyDoupoDoPage(driver);
//		for(WebElement e: buy.product_Prices) {
//			System.out.println("product_Prices: " + e.getTagName() + ": " + e.getText());
//		}
//		System.out.println("-------");
//		System.out.println("List size: " + buy.ul_priceUL.size());
//		System.out.println("Any Price: " + buy.isThereAnyPrice());
//		System.out.println("Is Available: " + buy.isPriceListAvailable());
		buy.toProductPriceDetail();
		driver.quit();
	}

}
