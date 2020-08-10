package kr.co.sptek.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sptek.member.common.LoginManager;
import kr.co.sptek.member.common.Utility;
import kr.co.sptek.member.info.ClientUserInfo;
import kr.co.sptek.member.info.ConditionInfo;
import kr.co.sptek.member.userMgr.service.UserMgrService;
import kr.co.sptek.member.info.ClientUserInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserMgrService userMgrService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, HttpSession session, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
    	ClientUserInfo user;
		String redirPage;
		
		if(session.getAttribute("ClientUserInfo") != null){
			
			user = (ClientUserInfo)session.getAttribute("ClientUserInfo");
			
			if(user.getUserId() != null && !"".equals(user.getUserId())
				&& user.getUserPwd() != null && !"".equals(user.getUserPwd())){				
				
				redirPage = "redirect:summaryInfo";
			}else {
				redirPage = "jsp/login";
			}
			
		}else {
			
			redirPage = "jsp/login";
		}
				
		return redirPage;
	}
	
	/* loginProc Controller */
	@RequestMapping(value = "/loginProc", method = RequestMethod.POST)
	public String loginProc(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  HomeController.loginProc(condition)");
		
		int rtn = 0;
		String rtnPage="jsp/login";

		// 입력 받은 패스워드 hash 값(MD5)
		condition.setMd5UserPwd(Utility.toMD5(condition.getUserPwd()));
		
		//로그인사용자의 사용자 DB확인
		ClientUserInfo userInfo = userMgrService.selectUserInfo(condition);		
		
		if(userInfo != null){
			
			//로그인 사용자와 현재 접속중이 사용자 비교 
			try {
				if(LoginManager.getInstance().isUsing(condition, session)){
					LoginManager.getInstance().exitSession();
				}
			} catch(Exception e) {}
			
			//마지막 로그인 시간 저장
			//rtn = sysManagerService.setUpdateLoginInfo(condition);
			rtn = 1;
			
			if(rtn == 0){
				model.addAttribute("resultFlag", rtn);
			}else {
				
				// 로그인 성공 후 session 값 설정
				LoginManager.getInstance().setSession(userInfo, session);							
				model.addAttribute("resultFlag", rtn);
				
				//rtnPage = "redirect:summaryInfo";
				rtnPage = "redirect:userInfoSelect";
			}
		}else{				
			model.addAttribute("resultFlag", rtn);
		}
				
		return rtnPage;
	}
	
	/* apiLoginProc Controller */
	@RequestMapping(value = "/apiLoginProc", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> apiLoginProc(@RequestBody Map<String, String> userInfo) {
		logger.info("Autowired :  HomeController.loginProc(condition)");
		
		Map rtn = new HashMap<String, String>();
		String rtnPage="jsp/login";
		
		ConditionInfo condition = new ConditionInfo();

		// 입력 받은 패스워드 hash 값(MD5)
		condition.setUserId(userInfo.get("userId"));
		condition.setMd5UserPwd(Utility.toMD5(userInfo.get("UserPwd")));
		
		//로그인사용자의 사용자 DB확인
		ClientUserInfo clientUserInfo = userMgrService.selectUserInfo(condition);
		
		if(userInfo != null){
			
			//마지막 로그인 시간 저장
			rtn.put("resultFlag", "200");
			
		}else{				
			rtn.put("resultFlag", "404");
			rtn.put("resultMsg", "NOT FOUND USER");
		}
				
		return rtn;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String userLogOut(HttpSession session, Locale locale) {

		// 모든 세션값 초기화
		try{
			LoginManager.getInstance().exitSession();	
		}catch(Exception e){
			
		}
		// System.out.println(session.getAttribute("user_id"));
		return "jsp/login";
	}	
	
}
