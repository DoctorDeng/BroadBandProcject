package mapper;

import java.util.List;
import java.util.Map;

import bean.OsLogin;
import bean.dto.OsLoginDto;

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
	/**
	 * 获取指定Os账号的登录信息
	 * @param osId
	 * @return
	 */
	public List<OsLoginDto> selectOsLoginDtoByOsId(int osId);
	/**
	 * 获取指定月份和OsId的登录记录
	 * @param map
	 * @return
	 */
	public List<OsLoginDto> selectOsLoginByMonthById(Map map);
}
