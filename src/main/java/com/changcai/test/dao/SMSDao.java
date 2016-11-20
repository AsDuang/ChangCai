package com.changcai.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.changcai.test.utils.DataBaseUtil;
import com.changcai.test.utils.PropertiesUtil;

public class SMSDao {
	
	public static String sqlUrl = PropertiesUtil.getSqlURL();
	
	public static String getCodeviaMobile(String mobile) throws SQLException {
		String code = null;
		ResultSet rs = DataBaseUtil.findResults("select message from sms_info where mobile = '"+mobile+"'");
		while(rs.next()) {
			// 获取最新的Message的验证码，如果有多条信息，会自动获取最新的信息。
			code = rs.getString("message").substring(6, 12);
//			System.out.println("rs:"+code);
		}				
		return code;
	}
	
	public static void main(String args[]) throws SQLException {
		System.out.println(SMSDao.getCodeviaMobile("15651803324"));
	}
	
	

}
