package com.changcai.test.utils;

import java.io.File;

import com.changcai.test.model.EnterpriseBean;
import com.changcai.test.model.UserBean;

public class TestDataUtil {
	
	public static UserBean getUsers(File f) {
		return new UserBean();
	}
	
	public static EnterpriseBean getEnterprise(File f) {
		return new EnterpriseBean();
	}

}

