package com.changcai.test.utils;

/**
 * Deal, Test OK. 
 * Starting ChromeDriver 2.26.436362 (5476ec6bf7ccbada1734a0cdec7d570bb042aa30) on port 39236
 * 
 */

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {
	
	static {
		System.setProperty("webdriver.edge.driver", ".\\src\\res\\drivers\\MicrosoftWebDriver.exe");	
		System.setProperty("webdriver.gecko.driver", ".\\src\\res\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",".\\src\\res\\drivers\\chromedriver.exe");
	}
	public static EdgeDriver setUpEdgeDriver() {
		return new EdgeDriver();		
	}
	
	public static FirefoxDriver setUpFirefoxDriver() {
		return new FirefoxDriver();
	}
	
	public static ChromeDriver setUpChromeDriver() {
		return new ChromeDriver();
	}

}
