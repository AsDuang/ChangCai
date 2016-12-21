package com.changcai.test.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WebElementUtil {
	
	public static String getHiddenElement(WebDriver driver,String js) throws InterruptedException {
		//TODO
		String s = (String) ((JavascriptExecutor)driver).executeScript(js);
		 Thread.sleep(3000);
		return s;
	}
	
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = DriverUtil.setUpEdgeDriver();
		driver.get(PropertiesUtil.getSite());
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		String s  = getHiddenElement(driver,"var input = document.getElementById(\"btn_sub\").value;return input;");
		System.out.println(s);
		driver.quit();
//		WebElement element = driver.findElement(By.id("userId"));
//		element = (WebElement) 
//		System.out.println(js instanceof WebDriver);
//		System.out.println(js.getClass());
//				js.executeScript("alert('hello, world');");
//				Thread.sleep(5000);
////				WebElement element1 = (WebElement) js.executeScript("var input = document.getElementById(\"btn_sub\").value;return input;");
//		String s = (String) js.executeScript("var input = document.getElementById(\"provinceSel\").style;return input;");
////		System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/input[2]")).getAttribute("value"));
////		System.out.println(element1.getTagName());

		
		WebDriver drivers = DriverUtil.setUpFirefoxDriver();
		drivers.get(PropertiesUtil.getSite());
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		String t  = getHiddenElement(drivers,"var input = document.getElementById(\"btn_sub\").value;return input;");
		System.out.println(t);
		drivers.quit();
		
		WebDriver drivert = DriverUtil.setUpChromeDriver();
		drivert.get(PropertiesUtil.getSite());
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		String u  = getHiddenElement(drivert,"var input = document.getElementById(\"btn_sub\").value;return input;");
		System.out.println(u);
		drivert.quit();
		
		
	}

}
