package kr.co.sptek.member.userMgr.dao;

import java.util.List;


import kr.co.sptek.member.info.ConditionInfo;
import kr.co.sptek.member.info.ClientUserInfo;

public interface UserMgrDao {
	
	//User_Info
	int insertUserInfo(ClientUserInfo userInfo);
	List<ClientUserInfo> selectListUserInfo(ConditionInfo condition);
	ClientUserInfo selectUserInfo(ConditionInfo condition);
	ClientUserInfo getSelectUserInfoTotalNum(ConditionInfo condition);
	int deleteUserInfo(ConditionInfo condition);
	int updateUserInfo(ClientUserInfo userInfo);
	
	
	
}
