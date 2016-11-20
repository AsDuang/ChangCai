package com.changcai.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.changcai.test.model.UserBean;
import com.changcai.test.utils.DataBaseUtil;
import com.changcai.test.utils.PropertiesUtil;

public class UserDao {
	
//	public static String insertUser = "insert into usr_user(mobile,password) values(?,?)";
//	public static String getUser = "select * from usr_user";
	public static String sqlUrl = PropertiesUtil.getSqlURL();
	
	public static UserBean findUserviaMobile(String mobile) throws SQLException {
		
		UserBean user = new UserBean();
		ResultSet rs = DataBaseUtil.findResults("select account,type,mobile,password from usr_user where mobile = '"+mobile+"'");
		while(rs.next()) {
			user.setMobile(rs.getString("mobile"));
			user.setAccount(rs.getString("account"));
			user.setType(rs.getString("type"));
			user.setPassword(rs.getString("password"));
		}		
		return user;		
	}
	
	public void registerUserBean(UserBean user) {		
		DataBaseUtil.insertData("insert into usr_user(mobile,password) values("+user.getMobile()+","+user.getPassword()+")");		
	}
		
	public static void main(String args[]) throws SQLException {
		String account = UserDao.findUserviaMobile("18616250312").getAccount();
		System.out.println(account);
		String type = UserDao.findUserviaMobile("18616250312").getType();
		System.out.println(type);
	}
}
