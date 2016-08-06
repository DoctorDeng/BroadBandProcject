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
	 * 获取按月份分组的报表信息的数据总条数
	 * @return int
	 */
	public int getMonthStatementCount() {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		statementMapper = sqlSession.getMapper(StatementMapper.class);
		int i = statementMapper.getMonthStatementNum();
		sqlSession.close();
		return i;
	}
	
	/**
	 * 获取指定页的报表信息
	 * @return   List<StatementVo> 返回报表信息的集合
	 */
	public List<StatementVo> getMonthStatementPage(int currentPage, int pageSize) {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		statementMapper = sqlSession.getMapper(StatementMapper.class);
		
		Page page = new Page((currentPage-1)*pageSize,pageSize);
		
		List<StatementVo> result = statementMapper.selectMonthStatementByPage(page);
		
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
	  * @return List<StatementVo>  返回报表信息的集合
	  */
	public List<StatementVo> getMonthStatementPageByDesc(int currentPage, int pageSize) {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		statementMapper = sqlSession.getMapper(StatementMapper.class);
		
		Page page = new Page((currentPage-1)*pageSize,pageSize);
		
		List<StatementVo> result = statementMapper.selectMonthStatementByPageDesc(page);
		
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
	
	public static void main(String[] args) {
		StatementService statementManage = new StatementService();
		/*List<StatementVo> formList = statementManage.getMonthStatementPageByDesc(1,100);
		for (StatementVo form : formList) {
			System.out.println(form.toString());
		}*/
		System.out.println(statementManage.getMonthStatementCount());
		/*System.out.println(statementManage.getStatementPageByDesc(1, 3).size());*/
	}
	
}
