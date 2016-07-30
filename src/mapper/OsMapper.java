package mapper;

import java.util.List;

import bean.Os;

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
}
