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
	
	public static UserBean findUserviaId(long id) throws SQLException {
		
		UserBean user = new UserBean();
		ResultSet rs = DataBaseUtil.findResults("select id,mobile,account,name,identity_card_no,status,email,sex,enter_id,bank_card_id,reg_bank_status,rank,type from home.usr_user where id = "+id);
		while(rs.next()) {
			user.setId(rs.getInt("id"));
			user.setMobile(rs.getString("mobile"));
			user.setAccount(rs.getString("account"));
			user.setName(rs.getString("name"));
			user.setIdentity_card_no(rs.getString("identity_card_no"));
			user.setStatus(rs.getString("status"));
			user.setEmail(rs.getString("email"));
			user.setSex(rs.getString("sex"));
			user.setEnter_id(rs.getLong("enter_id"));
			user.setBank_card_id(rs.getLong("bank_card_id"));
			user.setReg_bank_status(rs.getString("reg_bank_status"));
			user.setRank(rs.getInt("rank"));
			user.setType(rs.getString("type"));			
		}		
		return user;		
	}
	
//	public void registerUserBean(UserBean user) {		
//		DataBaseUtil.insertData("insert into usr_user(mobile,password) values("+user.getMobile()+","+user.getPassword()+")");		
//	}
		
	public static void main(String args[]) throws SQLException {
		UserBean user = UserDao.findUserviaId(332);

		System.out.println("User ID: " + user.getId());
		System.out.println("User Account: " + user.getAccount());
		System.out.println("User Mobile: " + user.getMobile());
		System.out.println("User Name: " + user.getName());
		System.out.println("User Identity_Card_ID: " + user.getIdentity_card_no());
		System.out.println("User Status: " + user.getStatus());
		System.out.println("User Email: " + user.getEmail());
		System.out.println("User Sex: " + user.getSex());		
		System.out.println("User Enter ID: " + user.getEnter_id());
		System.out.println("User Bank Card ID: " + user.getBank_card_id());
		System.out.println("User Reg Bank Status: " + user.getReg_bank_status());
		System.out.println("User Rank: " + user.getRank());		
		System.out.println("User Type: " + user.getType());
		
	}
}
