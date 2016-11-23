package com.changcai.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.changcai.test.model.EnterpriseBean;
import com.changcai.test.utils.DataBaseUtil;
import com.changcai.test.utils.PropertiesUtil;

public class EnterpriseDao {

	public static String sqlUrl = PropertiesUtil.getSqlURL();
	
	public static EnterpriseBean findEnterviaID(long id) throws SQLException {
		
		EnterpriseBean enter = new EnterpriseBean();
		ResultSet rs = DataBaseUtil.findResults( "select name,status,"
				+ "file1_id,file2_id,file4_id,file5_id,file6_id,file7_id,file8_id,usr_id,"
				+ "owner,address,contact_phone,information,external_mobile,bank_sign_status,"
				+ "buyer_deposit_rate,seller_deposit_rate,grade "
				+ "from home.enter_enterprise where id ="+id);
		while(rs.next()) {
			
			enter.setName(rs.getString("name"));
			enter.setStatus(rs.getString("status"));
			if(rs.getLong("file1_id") == 0)
				enter.setIszhengmian(false);
			else 
				enter.setIszhengmian(true);
			if(rs.getLong("file2_id") == 0 )
				enter.setIsfanmian(false);
			else 
				enter.setIsfanmian(true);
			if(rs.getLong("file4_id") == 0)
				enter.setIsqiyegongzhang(false);
			else 
				enter.setIsqiyegongzhang(true);
			if(rs.getLong("file5_id") == 0)
				enter.setIsshuiwudengji(false);
			else
				enter.setIsshuiwudengji(true);
			if(rs.getLong("file6_id") == 0)
				enter.setIszuzhijigou(false);
			else
				enter.setIszuzhijigou(true);
			if(rs.getLong("file7_id") == 0 ) 
				enter.setIsqiyelogo(false);
			else
				enter.setIsqiyelogo(true);
			if(rs.getLong("file8_id") == 0)
				enter.setIsqiyegongzhang(false);
			else
				enter.setIsqiyegongzhang(true);
			
			enter.setAdmin(rs.getLong("usr_id"));
			enter.setOwner(rs.getString("owner"));
			enter.setAddress(rs.getString("address"));
			enter.setContact_phone(rs.getString("contact_phone"));
			enter.setInformation(rs.getString("information"));
			enter.setExternal_phone(rs.getString("external_mobile"));
			enter.setBank_sign_status(rs.getString("bank_sign_status"));
			enter.setBuyer_deposit_rate(rs.getInt("buyer_deposit_rate"));
			enter.setSeller_deposit_rate(rs.getInt("seller_deposit_rate"));
			enter.setGrade(rs.getInt("grade"));
		}		
		return enter;		
	}
	
	public static void main(String args[]) throws SQLException {
		EnterpriseBean enter = EnterpriseDao.findEnterviaID(230);
		System.out.println(enter.getGrade());
		System.out.println(enter.getName());
		System.out.println(enter.getStatus());
		System.out.println(enter.getInformation());
	}

}
