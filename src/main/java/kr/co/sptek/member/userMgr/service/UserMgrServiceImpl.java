package kr.co.sptek.member.userMgr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sptek.member.info.ConditionInfo;
import kr.co.sptek.member.userMgr.dao.UserMgrDao;
import kr.co.sptek.member.info.ClientUserInfo;


@Service
public class UserMgrServiceImpl implements UserMgrService {
	
	@Autowired
    private UserMgrDao userMgrDao;
	
	
	//User_Info
    public int insertUserInfo(ClientUserInfo userInfo){
     	return userMgrDao.insertUserInfo(userInfo);
    }
    
    public List<ClientUserInfo> selectListUserInfo(ConditionInfo condition){
    	return userMgrDao.selectListUserInfo(condition); 
    }
    
    public ClientUserInfo selectUserInfo(ConditionInfo condition){
    	return userMgrDao.selectUserInfo(condition);
    }
    
    public ClientUserInfo getSelectUserInfoTotalNum(ConditionInfo condition){
    	return userMgrDao.getSelectUserInfoTotalNum(condition);
    }
    
    public int deleteUserInfo(ConditionInfo condition){
    	return userMgrDao.deleteUserInfo(condition);
    }
    
    public int updateUserInfo(ClientUserInfo adminInfo){
    	return userMgrDao.updateUserInfo(adminInfo);
    }
    
   

}
