package mapper;

import java.util.List;

import bean.Page;
import bean.vo.StatementVo;

public interface StatementMapper {
	
	public List<StatementVo> selectAllStatementByPagging(Page page);
}
