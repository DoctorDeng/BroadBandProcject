package service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import bean.Os;
import mapper.OsLoginMapper;
import util.SqlSessionUtil;

/**
 * 客户Os账号登陆Service
 * @author Administrator
 *
 */
public class OsLoginService {
	private SqlSession sqlSession;
	private ProfessionService  osService;
	private OsLoginMapper osLoginMapper;
	
	public OsLoginService(){
		osService = new ProfessionService();
	}
	
	public void osLogin(int osId) {
		
	}
	
	/**
	 * 初始化SqlSession和mapper
	 */
	public void init(){
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
			osLoginMapper = sqlSession.getMapper(OsLoginMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 提交关闭SqlSession
	 */
	public void close(){
		sqlSession.commit();
		sqlSession.close();
	}
}
