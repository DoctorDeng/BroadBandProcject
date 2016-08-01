package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Page;
import bean.vo.StatementVo;
import mapper.StatementMapper;
import util.SqlSessionUtil;
import util.TimeUtil;

/**
 * 报表模块
 * @author Doctor邓
 *
 */
public class StatementService {
	private SqlSession sqlSession;
	private StatementMapper statementMapper;
	
	public StatementService() {
	}
	
	/**
	 * 获取所有报表信息
	 * @return   返回报表Bean的集合
	 *//*
	public List<StatementVo> getAllStatement() {
		
		
		List<StatementVo> result 
		
		List<StatementVo> statementList = new ArrayList<>();
		
		List<Map<String,Object>> mapList = statementDao.findAllStatement();
		
		for (Map map : mapList) {
			
			int bussinessId 	= Integer.parseInt(map.get("bussinessId").toString());
			String loginAccount = map.get("loginAccount").toString();
			String customerName  = map.get("customerName").toString();
			String idNumber     = map.get("idNumber").toString();
			String phone     	= map.get("phone").toString();
			String totalTime    = map.get("totalTime").toString();
			
			int times = 0;
			if (!"".equals(totalTime)) {
				times = Integer.parseInt(totalTime);
			}
			*//**
			 * 获取总的时长 时/分/秒
			 *//*
			int h = times/3600;
			int m = (times%3600)/60;
			int s = (times%3600)%60;
			String timeLong    = h + "时" + m + "分" + s +"秒";
			
			StatementVo statement = new StatementVo(bussinessId, loginAccount, customerName, idNumber, phone, timeLong);
			statementList.add(statement);
		}
		
		return statementList;
	}*/
	
	/*  获取所有通过时长降序的报表信息
	 * @return   返回报表Bean的集合
	 
	public List<StatementVo> getAllStatementByDesc() {
		List<StatementVo> statementList = new ArrayList<>();
		
		List<Map<String,Object>> mapList = statementDao.findAllStatementByDesc();
		
		for (Map map : mapList) {
			
			int bussinessId 	= Integer.parseInt(map.get("bussinessId").toString());
			String loginAccount = map.get("loginAccount").toString();
			String customerName  = map.get("customerName").toString();
			String idNumber     = map.get("idNumber").toString();
			String phone     	= map.get("phone").toString();
			String totalTime    = map.get("totalTime").toString();
			
			int times = 0;
			if (!"".equals(totalTime)) {
				times = Integer.parseInt(totalTime);
			}
			*//**
			 * 获取总的时长 时/分/秒
			 *//*
			int h = times/3600;
			int m = (times%3600)/60;
			int s = (times%3600)%60;
			String timeLong    = h + "时" + m + "分" + s +"秒";
			
			StatementVo statement = new StatementVo(bussinessId, loginAccount, customerName, idNumber, phone, timeLong);
			statementList.add(statement);
		}
		
		return statementList;
	}*/
	
	/**
	 * 获取指定页的报表信息
	 * @return   返回报表Bean的集合
	 */
	public List<StatementVo> getStatementPage(int currentPage, int pageSize) {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		statementMapper = sqlSession.getMapper(StatementMapper.class);
		
		Page page = new Page((currentPage-1)*pageSize,pageSize);
		
		List<StatementVo> result = statementMapper.selectStatementByPagging(page);
		
		sqlSession.close();
		
		for (StatementVo statement : result) {
			String timesStr = statement.getTimeLong();
			int times = 0;
			if (null != timesStr && !"".equals(timesStr)) {
				times = Integer.parseInt(timesStr);
			}
			String time = TimeUtil.secondToString(times);
			statement.setTimeLong(time);
		}
		return result;
	}
	
	 /* 获取所有通过时长降序的报表信息
	  * @return   返回报表Bean的集合
	  */
	public List<StatementVo> getStatementPageByDesc(int currentPage, int pageSize) {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		statementMapper = sqlSession.getMapper(StatementMapper.class);
		
		Page page = new Page((currentPage-1)*pageSize,pageSize);
		
		List<StatementVo> result = statementMapper.selectStatementByPaggingByDesc(page);
		
		sqlSession.close();
		
		for (StatementVo statement : result) {
			String timesStr = statement.getTimeLong();
			int times = 0;
			if (null != timesStr && !"".equals(timesStr)) {
				times = Integer.parseInt(timesStr);
			}
			String time = TimeUtil.secondToString(times);
			statement.setTimeLong(time);
		}
		return result;
	}
	/**
	 * 获取报表数据总长度
	 * @return
	 */
	public int getStatementCount() {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		statementMapper = sqlSession.getMapper(StatementMapper.class);
		return statementMapper.getStatementNum();
	}
	
	public static void main(String[] args) {
		StatementService statementManage = new StatementService();
		List<StatementVo> formList = statementManage.getStatementPageByDesc(1,5);
		for (StatementVo form : formList) {
			System.out.println(form.toString());
		}
		/*System.out.println(statementManage.getStatementCount());*/
		/*System.out.println(statementManage.getStatementPageByDesc(1, 3).size());*/
	}
	
}
