package service;

import java.util.List;

import bean.dto.OsDto;
import bean.vo.ServiceAddViewBean;

public interface ProfessionService {
	/**
	 * 通过查询的信息实现将吧信息传递到页面
	 * @param osDto
	 * @return
	 */
	public List<OsDto>  serviceListShow();
}
