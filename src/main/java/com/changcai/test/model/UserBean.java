package com.changcai.test.model;

public class UserBean {
	
	//用户在用户表的ID。
	private long id;
	//用户账号
	private String account;
	//用户密码，经过MD5加密
	private String password;
	//用户手机号
	private String mobile;
	//用户真实姓名
	private String name;
	//y用户身份证号
	private String identity_card_no;
	// 用户状态，默认为normal
	private String status;
	//用户的邮箱
	private String email;
	//用户的性别
	private String sex;
	//用户的类型
	private String type;
	//用户企业ID
	private long enter_id;
	// 用户银行账户Id 
	private long bank_card_id;
	// 是否开始注册银行账户->默认是no
	private String reg_bank_status;
	//会员等级
	private int rank;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentity_card_no() {
		return identity_card_no;
	}
	public void setIdentity_card_no(String identity_card_no) {
		this.identity_card_no = identity_card_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getEnter_id() {
		return enter_id;
	}
	public void setEnter_id(long enter_id) {
		this.enter_id = enter_id;
	}
	public long getBank_card_id() {
		return bank_card_id;
	}
	public void setBank_card_id(long bank_card_id) {
		this.bank_card_id = bank_card_id;
	}
	public String getReg_bank_status() {
		return reg_bank_status;
	}
	public void setReg_bank_status(String reg_bank_status) {
		this.reg_bank_status = reg_bank_status;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

}
