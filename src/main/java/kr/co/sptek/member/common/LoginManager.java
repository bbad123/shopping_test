package kr.co.sptek.member.common;


import javax.servlet.http.HttpSession;

import kr.co.sptek.member.info.ConditionInfo;
import kr.co.sptek.member.info.ClientUserInfo;

public class LoginManager {
	

	private static LoginManager loginManager = null; 

	private HttpSession currentSession;
	
	private LoginManager() 
	{ 
		    super(); 
	} 
	
	public static synchronized LoginManager getInstance() 
	{ 
	    if(loginManager == null){ 
	    	loginManager = new LoginManager(); 
	    } 
	    return loginManager; 
	} 
	
	public synchronized void setCurrentSession(HttpSession session){
		
	    	currentSession = session;
	}
	
	public synchronized HttpSession getCurrentSession(){		
    	return currentSession;
	}
		 
	//해당 세션에 이미 로그인 되있는지 체크 
	public boolean isLogin() 
	{ 
		boolean isLogin = false;
		if(currentSession != null){
			if(currentSession.getAttribute("UserInfo") != null){
				isLogin = true;
			}
		}
		
	    return isLogin; 
	} 
	 
	//중복 로그인 막기 위해 아이디 사용중인지 체크 
	public boolean isUsing(ConditionInfo condition, HttpSession session) 
	{ 
	    boolean isUsing = false; 	    
	    
	    if(isLogin() == true){
	    	
	    	//현재 사용자 로그인이 있을 경우
	    	ClientUserInfo userInfo = (ClientUserInfo)currentSession.getAttribute("ClientUserInfo");
	    	
	    	//if(condition.getUserId().equals(userInfo.getUserId()) && 
	    	//	condition.getMd5UserPwd().equals(userInfo.getUserPwd())){
	    	if(condition.getUserId().equals(userInfo.getUserId())){
	    		
	    		isUsing = true;
	    	}else {
	    		isUsing = false;
	    	}
	    }else {
	    	isUsing = false;
	    }	    
	    
	    return isUsing; 
	} 

	//세션 생성 
	public void setSession(ClientUserInfo userInfo, HttpSession session ){ 
		try{
			session.setAttribute("ClientUserInfo", userInfo);
		    setCurrentSession(session);
		}catch(Exception e){}
	} 
	
	//세션 삭제
	public void exitSession(){ 		
		if(currentSession != null){
			if(currentSession.getId() != null){
				currentSession.invalidate();
			}
			currentSession = null;			
		}
	} 	

}
