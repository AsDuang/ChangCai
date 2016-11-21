package com.changcai.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.changcai.test.utils.DriverUtil;

public class BasisProductDetailPage {

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
	
	public BasisProductDetailPage(WebDriver _driver,String _url) {
		this.driver = _driver;
		this.url = _url;
		driver.get(url);
		PageFactory.initElements(driver, this);		
	}
	
	/*
	 * 页面元素
	 */
	@FindBy(id="numsBoxInput")
	private WebElement in_NumsBox;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div/div[1]/div[4]/span")
	private WebElement lab_sellerName;
	
	@FindBy(id="inventoryQuality")
	private WebElement lab_Quality;
	
	@FindBy(id="minPurchaseNumSpan")
	private WebElement lab_MinPurchase;
	
	@FindBy(id="depoistPrice")
	private WebElement lab_depoistPrice;
	
	
	public static void main(String args[]) {
		WebDriver driver = DriverUtil.setUpIEDriver();
		BasisProductDetailPage detail = new BasisProductDetailPage(driver,"http://prd.maidoupo.com/product/1486");
		System.out.println("Quality: "+ detail.lab_Quality.getText());
		System.out.println("SellerName: "+ detail.lab_sellerName.getText());
		System.out.println("MinPurchase: "+ detail.lab_MinPurchase.getText());
		System.out.println("DepoistPrice: "+ detail.lab_depoistPrice.getText());
		driver.quit();
	}
	
	
	
	
}
