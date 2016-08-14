package mapper;

import java.util.List;

import bean.Page;
import bean.vo.StatementVo;

public interface StatementMapper {
	/**
	 * 获取按月份分组的客户报表信息
	 * @param page  Page
	 * @return  List<StatementVo>
	 */
	public List<StatementVo> selectMonthStatementByPage(Page page);
	/**
	 * 获取按月份分组的报表信息的数据总条数
	 * @return int
	 */
	public int getMonthStatementNum();
	/**
	 * 获取通过登陆总时长降序排序的按月份分组的客户报表信息
	 * @return List<StatementVo>
	 */
	public List<StatementVo> selectMonthStatementByPageDesc(Page page);
}
