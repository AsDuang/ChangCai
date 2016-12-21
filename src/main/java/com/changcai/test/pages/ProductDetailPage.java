package com.changcai.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.changcai.test.utils.DriverUtil;

public class ProductDetailPage {

	/*
	 * 构造方法
	 */
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
	
	public ProductDetailPage(WebDriver _driver,String _url) {
		this.driver = _driver;
		this.url = _url;
		_driver.get(_url);
		PageFactory.initElements(driver, this);		
	}
	
	/*
	 * 页面元素
	 */
	@FindBy(id="numsBoxInput")
	private WebElement in_NumsBox;
	
	@FindBys({@FindBy(className="seller"),@FindBy(tagName="span")})
	private WebElement lab_sellerName;
	
	@FindBy(id="inventoryQuality")
	private WebElement lab_Quality;
	
	@FindBy(id="minPurchaseNumSpan")
	private WebElement lab_MinPurchase;
	
	@FindBy(id="depoistPrice")
	private WebElement lab_depoistPrice;
	
	@FindBy(id="createOrderBtn")
	private WebElement btn_CreateOrder;
	
	public String getInNums() {
		return in_NumsBox.getAttribute("value");
	}
	
	public void setInNums(String i) {
		in_NumsBox.clear();
		in_NumsBox.sendKeys(i);
	}
	
	
	
	
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = DriverUtil.setUpEdgeDriver();
		ProductDetailPage detail = new ProductDetailPage(driver,"http://prd.maidoupo.com/product/1500");
		System.out.println("Quality: "+ detail.lab_Quality.getText());
		System.out.println("SellerName: "+ detail.lab_sellerName.getText());
		System.out.println("MinPurchase: "+ detail.lab_MinPurchase.getText());
		System.out.println("DepoistPrice: "+ detail.lab_depoistPrice.getText());
		System.out.println("Input Num： " + detail.getInNums());
		Thread.sleep(5000);
		detail.setInNums("15");
		Thread.sleep(5000);
		System.out.println("Input Num： " + detail.getInNums());
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	
	
}
