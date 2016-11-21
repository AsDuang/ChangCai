package com.changcai.test.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.changcai.test.utils.DriverUtil;

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
	
	public BuyDoupoDoPage(WebDriver driver, String url) {
		this.driver = driver;
		this.setUrl(url);
		driver.get(url);
		PageFactory.initElements(driver, this);		
	}
	

	//获取所有产品报价
	@FindBys({@FindBy(xpath="/html/body/div[2]/div[1]/div/div[11]/div/ul"),@FindBy(tagName="li")})
	private List<WebElement> ul_priceUL;
	
	public int getPriceLisSize() {
		return ul_priceUL.size();
	}
	
	//随机获取某一报价条目
	public WebElement getPriceLi() {
		Random rand = new Random();
		int i = rand.nextInt(ul_priceUL.size());
		return ul_priceUL.get(i);
	}
	
	public void toProductDetail() {
		this.getPriceLi().click();
	}
	
	public String getDataRid(WebElement e) {
		return e.getAttribute("data-rid");
	}
	
	
	
	public String checkProductPriceType(int prod_price_id) {
		//TODO 检查当前的LI报价是基差报价还是一口价报价
		return "spot";
	}
	
	public boolean checkProductPriceValuable(int prod_price_id) {
		//TODO 检查当前的报价是否有效
		return true;
	}
	
	
	






	
	public static void main(String args[]) {
		WebDriver driver = DriverUtil.setUpIEDriver();
		BuyDoupoDoPage buy = new BuyDoupoDoPage(driver,"http://prd.maidoupo.com/common/buyDouPo.do");
//		for(WebElement e: buy.product_Prices) {
//			System.out.println("product_Prices: " + e.getTagName() + ": " + e.getText());
//		}
		System.out.println("-------");
		System.out.println(buy.ul_priceUL.size());
		for(WebElement e: buy.ul_priceUL) {
			System.out.println(e.getAttribute("data-rid"));
			System.out.println("ul_priceUL: " + e.getTagName() + ": " + e.getText());
			e.click();
			driver.navigate().back();
		}
		driver.quit();
	}

}
