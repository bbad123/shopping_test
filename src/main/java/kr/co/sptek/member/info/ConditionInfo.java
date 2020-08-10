package kr.co.sptek.member.info;

public class ConditionInfo {
	
	int id;
	
	/* Page Info */
	int 	showPageLimit 		= 10;     	// show page
	int 	showArticleLimit 	= 10;  		// page row num
	int 	pageOffset 			= 0;		// offset
	int 	currentPage 		= 1;		// current page	
	
	int 	showLogLimit 		= 6;     	// show page
	
	String beginDate;
	String endDate;
	
	/* User Mgr Info*/	
	String userId;
	String userNm;
	String userPwd;
	String userMail;
	String userSms;
	String md5UserPwd;
	
	public void calsPageOffset() {
		this.pageOffset = (this.currentPage-1) * this.showArticleLimit;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShowPageLimit() {
		return showPageLimit;
	}
	public void setShowPageLimit(int showPageLimit) {
		this.showPageLimit = showPageLimit;
	}
	public int getShowArticleLimit() {
		return showArticleLimit;
	}
	public void setShowArticleLimit(int showArticleLimit) {
		this.showArticleLimit = showArticleLimit;
	}
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getShowLogLimit() {
		return showLogLimit;
	}
	public void setShowLogLimit(int showLogLimit) {
		this.showLogLimit = showLogLimit;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public String getMd5UserPwd() {
		return md5UserPwd;
	}
	public void setMd5UserPwd(String md5UserPwd) {
		this.md5UserPwd = md5UserPwd;
	}
	
	

}
