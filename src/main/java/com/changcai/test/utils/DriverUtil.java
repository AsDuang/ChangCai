package com.changcai.test.utils;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import com.changcai.test.pages.HomePage;

public class DriverUtil {
	
	static {
		System.setProperty("webdriver.ie.driver", "D:\\WebDrivers\\IEDriverServer.exe");		
	}
	public static InternetExplorerDriver setUpIEDriver() {
		return new InternetExplorerDriver();		
	}

}
