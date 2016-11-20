package com.changcai.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage {
	
	private WebDriver driver;
	private String url;


	public String getUrl() {
		return url;
	}

	@FindBy(linkText="登录")
	public WebElement loginLink;
	
	@FindBy(linkText="注册")
	public WebElement registerLink;
	
	@FindBy(linkText="买豆粕")
	public WebElement buydoupoLink;
	
	@FindBy(linkText="卖豆粕")
	public WebElement selldoupoLink;
	
	@FindBy(linkText="资讯")
	public WebElement cmsLink;
	
	@FindBy(linkText="新手引导")
	public WebElement newerLink;
	
	public void toLogin() {
		loginLink.click();
	}
	
	public void toBuy() {
		buydoupoLink.click();
	}
	
	public void toSell() {
		selldoupoLink.click();
	}
	
	public void toRegister() {
		registerLink.click();
	}
	
	public void toCMS() {
		cmsLink.click();
	}
	
	public void toNewer() {
		newerLink.click();
	}
	
	public HomePage(WebDriver driver,String url) {
		this.driver = driver;
		this.url = url;
		driver.get(url);
		PageFactory.initElements(driver, this);		
	}

	public WebDriver getDriver() {
		return driver;
	}
		
	public void setUrl(String url) {
		this.url = url;
	}
	
}
