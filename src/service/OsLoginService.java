package service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
	/**
	 * Os登陆方法,登陆时记载登陆IP和时间
	 * @param osId     登陆Os的OsId
	 * @param loginIp  登陆Ip
	 * @return         记载成功返回此次登陆的身份Id，失败返回0
	 */
	public int recordOsLogin(int osId,String loginIp) {
		init();
		
		Map map = new HashMap<>();
		map.put("osId", osId);
		map.put("loginIp", loginIp);
		map.put("osLoginId", 1);
		int result = osLoginMapper.insertOsLogin(map);
		if (result ==1) {
			sqlSession.commit();
			return Integer.parseInt(map.get("osLoginId").toString());
		}
		sqlSession.rollback();
		sqlSession.close();
		return 0;
	}
	/**
	 * 记载Os登出时间
	 * @param osLoginId  Os登陆唯唯一Id标识
	 * @return   记载成功返回true，失败返回false
	 */
	public boolean recordOsLoginOut(int osLoginId) {
		init();
		
		int result = osLoginMapper.updateOsLogin(osLoginId);
		if (result ==1) {
			close();
			return true;
		}
		sqlSession.rollback();
		sqlSession.close();
		return false;
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
	
	public static void main(String[] args) {
		OsLoginService osLoginService = new OsLoginService();
		System.out.println(osLoginService.recordOsLoginOut(67));
	}
}
