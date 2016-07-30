package mapper;

import java.util.List;

import bean.Os;
import bean.dto.OsAddDto;
import bean.dto.OsDto;
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
	 * @param osId
	 */
	public void upOneOsByBussinessId(Os os);
	
	/**
	 * 业务账号通过业务ID来删除Os表中的一条信息
	 * @param OsId
	 */
	public void delOneOsByOsId(int OsId);
	
	/**
	 * 查询业务界面显示信息
	 * @param osDto
	 * @return
	 */
	public List<OsDto> selServiceShow();
	
	/**
	 * 业务界面添加
	 * @param Os
	 */
	public void addOsInfo(OsAddDto osAddDto);

	public void upOneOsByBussinessId( int tariffId,int osId);
}
