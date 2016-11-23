package com.changcai.test.services;

import java.sql.SQLException;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.changcai.test.dao.EnterpriseDao;
import com.changcai.test.dao.UserDao;

public class UserServices {
	
	//验证当前是否有用户登录状态
	public static boolean loginVerifed(WebDriver driver) {
		
		boolean b = false;
		for(Cookie e:driver.manage().getCookies()) {
			if("MAIDOUPO_TOKEN".equals(e.getName())) {
				b = true;
			}
		}
		return b;
	}
	
	//验证用户是否已完成个人认证
	public static boolean userVerified(long id) throws SQLException {
		boolean b = false;
		long enter_id = UserDao.findUserviaId(id).getEnter_id();
		String status = EnterpriseDao.findEnterviaID(enter_id).getStatus();
		if("SUCCESS".equalsIgnoreCase(status))
			b = true;
		return b;
	}
	
	public static String userType(String account) {
		String s = null;
		//个人管理员
		
		
		return s;
	}
}
