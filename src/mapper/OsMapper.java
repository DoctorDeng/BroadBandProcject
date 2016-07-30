package mapper;

import java.util.List;

import bean.Os;
import bean.dto.OsLoginDto;

public interface OsMapper {
	/**
	 * 通过Osid查询Os表的记录
	 * @param osId
	 * @return List<Os>
	 */
	public List<Os> selAllOsByOSid(int osId);
	
	/**
	 * 通过Osid查询Os表的的特定一条记录
	 * @param osId
	 */
	public Os selOneOsByOsid(int osId);
	
	/**
	 * 业务账号通过业务Id来修改Os表里面的资费类型
	 * @param bussinessId
	 */
	public void upOneOsByBussinessId(int bussinessId);
	
	/**
	 * 业务账号通过业务ID来删除Os表中的一条信息
	 * @param bussinessId
	 */
	public void delOneOsByOsId(int OsId);
}
