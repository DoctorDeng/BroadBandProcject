package mapper;

import java.util.List;

import bean.Page;
import bean.vo.StatementVo;

public interface StatementMapper {
	/**
	 * 获取指定页面的报表信息
	 * @param page  
	 * @return  List<StatementVo>
	 */
	public List<StatementVo> selectStatementByPagging(Page page);
	/**
	 * 获取通过客户Os账号总登陆时长降序排序的报表信息
	 * @param page
	 * @return   List<StatementVo>
	 */
	public List<StatementVo> selectStatementByPaggingByDesc(Page page);
}
