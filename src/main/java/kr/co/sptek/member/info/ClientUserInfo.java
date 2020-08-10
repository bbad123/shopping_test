package kr.co.sptek.member.info;

public class ClientUserInfo {
	int id;
	String userId;
	String userNm;
	String userPwd;
	String userMail;
	String userSms;
	int totalNum;
	String md5UserPwd;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserSms() {
		return userSms;
	}
	public void setUserSms(String userSms) {
		this.userSms = userSms;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public String getMd5UserPwd() {
		return md5UserPwd;
	}
	public void setMd5UserPwd(String md5UserPwd) {
		this.md5UserPwd = md5UserPwd;
	}
	
	

}
