package mapper;

import java.util.List;

import bean.Bussiness;

public interface BussinessMapper {

	/**
	 * 查找所有记录
	 * @return
	 */
	public List<Bussiness> selectAllBussiness();
	
	/**
	 * 根据ID查找
	 */
	public Bussiness selectBussinessById(int id);
	
	/**
	 * 添加记录
	 */
	public void insertBussiness(Bussiness bussiness);
	
	/**
	 * 删除记录
	 */
	public void deleteBussiness(int id);
	
	/**
	 * 修改记录（根据ID修改）
	 */
	public void updateBussiness(Bussiness bussiness);
	
}
