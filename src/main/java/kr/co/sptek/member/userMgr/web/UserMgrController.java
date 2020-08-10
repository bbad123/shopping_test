package kr.co.sptek.member.userMgr.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sptek.member.common.PageHtmlUtil;
import kr.co.sptek.member.common.Utility;

import kr.co.sptek.member.info.ConditionInfo;
import kr.co.sptek.member.info.ClientUserInfo;
import kr.co.sptek.member.userMgr.service.UserMgrService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class UserMgrController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserMgrController.class);
	
	@Autowired
	private UserMgrService userMgrService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/userInfoSelect", method = RequestMethod.GET)
	public String userInfoSelect(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  userMgrController.userInfoSelect(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("UserInfo") == null){
    		return "jsp/login";
    	}    	
    	
    	ClientUserInfo loginUser = (ClientUserInfo)session.getAttribute("UserInfo");
    	model.addAttribute("LoginID", loginUser.getUserId() );
		model.addAttribute("LoginName", loginUser.getUserNm());
		
		/* 현재 page index를 통한 page offset을 구함 */
		condition.calsPageOffset();
		
		/* 검사이력정보  조회조건에 따른 전체 수 조회 */
		double totalNum = 0;
		if(userMgrService.getSelectUserInfoTotalNum(condition) != null){
			totalNum = userMgrService.getSelectUserInfoTotalNum(condition).getTotalNum();
		}		
		
		PageHtmlUtil pageHtmlUtil = new PageHtmlUtil();
		String pageHtml = pageHtmlUtil.getPageHtml(condition, totalNum);		
		
		List<ClientUserInfo> userInfoList = userMgrService.selectListUserInfo(condition);
		
		model.addAttribute("Condition", condition );
		model.addAttribute("PageHtml", pageHtml);
		model.addAttribute("UserInfoList", userInfoList );
		
		return "jsp/userMgr/userInfoSelect";
	}
	
	@RequestMapping(value = "/userInfoInsert", method = RequestMethod.GET)
	public String userInfoInsert(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  userMgrController.userInfoInsert(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("UserInfo") == null){
    		return "jsp/login";
    	}    	
    	
    	ClientUserInfo loginUser = (ClientUserInfo)session.getAttribute("UserInfo");
    	model.addAttribute("LoginID", loginUser.getUserId() );
		model.addAttribute("LoginName", loginUser.getUserNm());
		
		model.addAttribute("Condition", condition );
		
		return "jsp/userMgr/userInfoInsert";
	}	
	
	@RequestMapping(value = "/userInfoSave", method = RequestMethod.GET)
	public String userInfoSave(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  userMgrController.userInfoSave(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("UserInfo") == null){
    		return "jsp/login";
    	}    
    	
    	ClientUserInfo loginUser = (ClientUserInfo)session.getAttribute("UserInfo");
    	model.addAttribute("LoginID", loginUser.getUserId() );
		model.addAttribute("LoginName", loginUser.getUserNm());	
		
		model.addAttribute("Condition", condition );

		if(StringUtils.isNotEmpty(condition.getUserId())==true && StringUtils.isNotEmpty(condition.getUserPwd())==true
				&& StringUtils.isNotEmpty(condition.getUserMail())==true && StringUtils.isNotEmpty(condition.getUserSms())==true){		
				
			ClientUserInfo userInfo = new ClientUserInfo();
			
			String md5UserPwd = Utility.toMD5(condition.getUserPwd());
			
			userInfo.setUserId(condition.getUserId());
			userInfo.setMd5UserPwd(md5UserPwd);
			userInfo.setUserMail(condition.getUserMail());
			userInfo.setUserSms(condition.getUserSms());
			userInfo.setUserNm(condition.getUserNm());
			
			userMgrService.insertUserInfo(userInfo);
		}
		
		return "redirect:userInfoSelect";
	}	
	
	@RequestMapping(value = "/apiUserInfoSave", method = RequestMethod.GET)
	public Map<String, String> apiUserInfoSave(@RequestBody Map<String, String> userInfo) {
		logger.info("Autowired :  userMgrController.apiUserInfoSave(condition)");
		
		int rtn = 0; 
		
		ConditionInfo condition = new ConditionInfo();
				
		condition.setUserId(userInfo.get("userId"));
		condition.setUserPwd(userInfo.get("userPwd"));
		condition.setUserMail(userInfo.get("userMail"));
		condition.setUserSms(userInfo.get("userSms"));
		condition.setUserNm(userInfo.get("userNm"));
		
		if(StringUtils.isNotEmpty(condition.getUserId())==true && StringUtils.isNotEmpty(condition.getUserPwd())==true
				&& StringUtils.isNotEmpty(condition.getUserMail())==true && StringUtils.isNotEmpty(condition.getUserSms())==true){		
				
			ClientUserInfo clientUserInfo = new ClientUserInfo();
			
			String md5UserPwd = Utility.toMD5(condition.getUserPwd());
			
			clientUserInfo.setUserId(condition.getUserId());
			clientUserInfo.setMd5UserPwd(md5UserPwd);
			clientUserInfo.setUserMail(condition.getUserMail());
			clientUserInfo.setUserSms(condition.getUserSms());
			clientUserInfo.setUserNm(condition.getUserNm());
			
			rtn = userMgrService.insertUserInfo(clientUserInfo);			
		}
		
		Map res = new HashMap<String, String>();
		
		if(rtn > 0) {			
			//마지막 로그인 시간 저장
			res.put("resultFlag", "200");
			
		}else{				
			res.put("resultFlag", "500");
			res.put("resultMsg", "NOT SUCCESS INSERT USER");
		}
		
		return res;
	}
	
	@RequestMapping(value = "/userInfoDelete", method = RequestMethod.GET)
	public String userInfoDelete(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  userMgrController.userInfoDelete(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("UserInfo") == null){
    		return "jsp/login";
    	}   
    	
    	ClientUserInfo loginUser = (ClientUserInfo)session.getAttribute("UserInfo");
    	model.addAttribute("LoginID", loginUser.getUserId() );
		model.addAttribute("LoginName", loginUser.getUserNm());	
		
		userMgrService.deleteUserInfo(condition);
		
		return "redirect:userInfoSelect";
	}
	
	@RequestMapping(value = "/userInfoUpdate", method = RequestMethod.GET)
	public String userInfoUpdate(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  userMgrController.userInfoUpdate(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("UserInfo") == null){
    		return "jsp/login";
    	}   
    	
    	ClientUserInfo loginUser = (ClientUserInfo)session.getAttribute("UserInfo");
    	model.addAttribute("LoginID", loginUser.getUserId() );
		model.addAttribute("LoginName", loginUser.getUserNm());	
		
		model.addAttribute("Condition", condition );
		
		if(StringUtils.isNotEmpty(condition.getUserId())==true && StringUtils.isNotEmpty(condition.getUserPwd())==true
				&& StringUtils.isNotEmpty(condition.getUserMail())==true && StringUtils.isNotEmpty(condition.getUserSms())==true){		
				
			ClientUserInfo userInfo = new ClientUserInfo();
			
			String md5UserPwd = Utility.toMD5(condition.getUserPwd());
			
			userInfo.setId(condition.getId());
			userInfo.setUserId(condition.getUserId());
			userInfo.setMd5UserPwd(md5UserPwd);
			userInfo.setUserMail(condition.getUserMail());
			userInfo.setUserSms(condition.getUserSms());
			userInfo.setUserNm(condition.getUserNm());
			
			userMgrService.updateUserInfo(userInfo);
		}
		
		return "redirect:userInfoDetail?id="+ condition.getId();
	}
	
	@RequestMapping(value = "/userInfoDetail", method = RequestMethod.GET)
	public String userInfoDetail(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  userMgrController.userInfoDetail(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("UserInfo") == null){
    		return "jsp/login";
    	}   
    	
    	ClientUserInfo loginUser = (ClientUserInfo)session.getAttribute("UserInfo");
    	model.addAttribute("LoginID", loginUser.getUserId() );
		model.addAttribute("LoginName", loginUser.getUserNm());	
		
		ClientUserInfo userInfo = userMgrService.selectUserInfo(condition);
		
		model.addAttribute("Condition", condition );
		model.addAttribute("UserInfo", userInfo );
		
		return "jsp/userMgr/userInfoDetail";
	}	
	//--------------------------------------------------------------------------------------------
		
	
}
