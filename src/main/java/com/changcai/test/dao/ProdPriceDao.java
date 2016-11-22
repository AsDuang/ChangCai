package com.changcai.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.changcai.test.utils.DataBaseUtil;

public class ProdPriceDao {
	
	public static String findTypeviaPID(int prod_price_id) throws SQLException {
		String s = null;
		ResultSet rs =  DataBaseUtil.findResults("select product_type from prod_price where id= " + prod_price_id +";");
		while(rs.next()) {
			s = rs.getString("product_type");
		}
		return s;
	}

}
