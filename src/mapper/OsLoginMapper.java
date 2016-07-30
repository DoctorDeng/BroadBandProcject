package mapper;

import java.util.List;

import bean.OsLogin;

public interface OsLoginMapper {
	/**
	 * 通过osLoginId来查询osLogin表的所有信息
	 * @param OsLogin
	 * @return List<OsLogin>
	 */
	public List<OsLogin> selAllOsLoginByOsLginId(int osLoginId);
	
	/**通过osLoginId来查询osLogin表特定的一条信息
	 * @param osLoginId
	 * @return
	 */
	public OsLogin selOneOsLoginByOsLoginId(int osLoginId);
}
