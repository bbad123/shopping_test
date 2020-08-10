package kr.co.sptek.member.userMgr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sptek.member.info.ConditionInfo;
import kr.co.sptek.member.info.ClientUserInfo;


@Repository
public class UserMgrDaoImpl implements UserMgrDao {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
	       this.sqlSession = sqlSession;
	}
	
	//User_Info
    public int insertUserInfo(ClientUserInfo userInfo){
    	 return  sqlSession.insert("kr.co.sptek.userMgrSql.mapper.insertUserInfo", userInfo);
    }
    
    public List<ClientUserInfo> selectListUserInfo(ConditionInfo condition){
    	return  sqlSession.selectList("kr.co.sptek.userMgrSql.mapper.selectListUserInfo", condition);
    }
    
    public ClientUserInfo selectUserInfo(ConditionInfo condition){
   	return  (ClientUserInfo)sqlSession.selectOne("kr.co.sptek.userMgrSql.mapper.selectUserInfo", condition);
    }
    
    public ClientUserInfo getSelectUserInfoTotalNum(ConditionInfo condition){
    	return (ClientUserInfo)sqlSession.selectOne("kr.co.sptek.userMgrSql.mapper.getUserInfoTotalNum", condition);
    }
    
    public int deleteUserInfo(ConditionInfo condition){
    	return  sqlSession.delete("kr.co.sptek.userMgrSql.mapper.deleteUserInfo", condition);
    }
    
    public int updateUserInfo(ClientUserInfo userInfo){
    	return  sqlSession.update("kr.co.sptek.userMgrSql.mapper.updateUserInfo", userInfo);
    }
}
