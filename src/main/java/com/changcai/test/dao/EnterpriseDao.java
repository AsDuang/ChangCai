package com.changcai.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.changcai.test.model.EnterpriseBean;
import com.changcai.test.utils.DataBaseUtil;
import com.changcai.test.utils.PropertiesUtil;

public class EnterpriseDao {
	
	public static String insertUser = "insert into enter_enterprise(contact_phone,name) values(?,?)";
	public static String getEnter = "select grade,name,status,information from enter_enterprise where contact_phone = '";
	public static String sqlUrl = PropertiesUtil.getSqlURL();
	
	public static EnterpriseBean findEnterviaContactPhone(String mobile) throws SQLException {
		
		EnterpriseBean enter = new EnterpriseBean();
		ResultSet rs = DataBaseUtil.findResults(getEnter+mobile+"'");
		while(rs.next()) {
			enter.setGrade(rs.getInt("grade"));
			enter.setName(rs.getString("name"));
			enter.setStatus(rs.getString("status"));
			enter.setInformation(rs.getString("information"));
		}		
		return enter;		
	}
	
	public static void main(String args[]) throws SQLException {
		EnterpriseBean enter = EnterpriseDao.findEnterviaContactPhone("18516609995");
		System.out.println(enter.getGrade());
		System.out.println(enter.getName());
		System.out.println(enter.getStatus());
		System.out.println(enter.getInformation());
	}

}
