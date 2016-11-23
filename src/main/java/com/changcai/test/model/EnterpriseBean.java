package com.changcai.test.model;

public class EnterpriseBean {
//TODO 添加转义，如type类型，需设置为
	
	// 企业名称
	private String name;
	// 状态 默认No
	private String status;
	//是否省份正正面照片ID
	private boolean iszhengmian;
	//是否身份证反面照片
	private boolean isfanmian;
	// 是否营业执照照片
	private boolean isyingyezhizhao;
	//是否税务登记证照片
	private boolean isshuiwudengji;
	//是否组织机构代码证照片
	private boolean iszuzhijigou;
	//是否有企业品牌图片
	private boolean isqiyelogo;
	//是否有企业公章图片
	private boolean isqiyegongzhang;
	// 企业管理员的UserID
	private long admin;
	// 企业法人姓名
	private String owner;
	// 企业地址
	private String address;
	// 联系电话
	private String contact_phone;
	// 企业描述
	private String information;
	// 联系电话-对外展示
	private String external_phone;
	// 银行签约状态
	private String bank_sign_status;
	// 买家保证金率
	private int buyer_deposit_rate;
	// 卖家保证金率
	private int seller_deposit_rate;
	// 企业会员等级你
	private int grade;
	// 公司类型： 个人，贸易商，油厂。
	private String type;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isIszhengmian() {
		return iszhengmian;
	}
	public void setIszhengmian(boolean iszhengmian) {
		this.iszhengmian = iszhengmian;
	}
	public boolean isIsfanmian() {
		return isfanmian;
	}
	public void setIsfanmian(boolean isfanmian) {
		this.isfanmian = isfanmian;
	}
	public boolean isIsyingyezhizhao() {
		return isyingyezhizhao;
	}
	public void setIsyingyezhizhao(boolean isyingyezhizhao) {
		this.isyingyezhizhao = isyingyezhizhao;
	}
	public boolean isIsshuiwudengji() {
		return isshuiwudengji;
	}
	public void setIsshuiwudengji(boolean isshuiwudengji) {
		this.isshuiwudengji = isshuiwudengji;
	}
	public boolean isIszuzhijigou() {
		return iszuzhijigou;
	}
	public void setIszuzhijigou(boolean iszuzhijigou) {
		this.iszuzhijigou = iszuzhijigou;
	}
	public boolean isIsqiyelogo() {
		return isqiyelogo;
	}
	public void setIsqiyelogo(boolean isqiyelogo) {
		this.isqiyelogo = isqiyelogo;
	}
	public boolean isIsqiyegongzhang() {
		return isqiyegongzhang;
	}
	public void setIsqiyegongzhang(boolean isqiyegongzhang) {
		this.isqiyegongzhang = isqiyegongzhang;
	}
	public long getAdmin() {
		return admin;
	}
	public void setAdmin(long admin) {
		this.admin = admin;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_phone() {
		return contact_phone;
	}
	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getExternal_phone() {
		return external_phone;
	}
	public void setExternal_phone(String external_phone) {
		this.external_phone = external_phone;
	}
	public String getBank_sign_status() {
		return bank_sign_status;
	}
	public void setBank_sign_status(String bank_sign_status) {
		this.bank_sign_status = bank_sign_status;
	}
	public int getBuyer_deposit_rate() {
		return buyer_deposit_rate;
	}
	public void setBuyer_deposit_rate(int buyer_deposit_rate) {
		this.buyer_deposit_rate = buyer_deposit_rate;
	}
	public int getSeller_deposit_rate() {
		return seller_deposit_rate;
	}
	public void setSeller_deposit_rate(int seller_deposit_rate) {
		this.seller_deposit_rate = seller_deposit_rate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
