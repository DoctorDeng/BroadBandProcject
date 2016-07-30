package mapper;

import java.util.List;

import bean.OsLogin;

public interface OsLoginMapper {
	/**
	 * 通过某一个值来查询，此处的By后面值需要有需要的来填写
	 * @param OsLogin
	 * @return List<OsLogin>
	 */
	public List<OsLogin> selOsLoginBy(OsLogin OsLogin);
	
}
