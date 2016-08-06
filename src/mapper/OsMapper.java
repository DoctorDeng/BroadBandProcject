package mapper;

import java.util.List;

import bean.Os;
import bean.dto.OsAddDto;
import bean.dto.OsDto;
import bean.dto.OsLoginDto;
import bean.dto.OsShowDto;

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
	 * @return 
	 */
	public boolean upOneOsByBussinessId(Os os);
	
	/**
	 * 业务账号通过业务ID来删除Os表中的一条信息
	 * @param OsId
	 * @return 
	 */
	public boolean delOneOsByOsId(int OsId);
	
	/**
	 * 查询业务界面显示信息
	 * @param osDto
	 * @return
	 */
	public List<OsDto> selServiceShow();
	
	/**
	 * 业务界面添加
	 * @param Os
	 * @return 
	 */
	public boolean addOsInfo(OsAddDto osAddDto);
	
	/**
	 * 通过条件查询
	 * @param osDto
	 * @return
	 */
	public List<OsDto> selChooseInfo(OsDto osDto);
	
	/**
	 * 查询详细信息所用
	 * @param osDto
	 * @return
	 */
	public List<OsShowDto> setManyInfo(int id);
	
	/**
	 * 根据OsAccount 改变其状态  变为删除状态
	 * @param osDto
	 * @return
	 */
	public boolean upStutasWithOsAccount(Os os);
	/**
	 * 根据bussinessId查询OSid
	 * @param os
	 * @return
	 */
	public Os upOsIdByCustomerId(int  id);
	public boolean upStutas(Os os);
}
	

