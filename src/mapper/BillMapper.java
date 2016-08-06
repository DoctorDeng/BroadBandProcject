package mapper;

import java.util.List;
import java.util.Map;

import bean.Page;
import bean.dto.BillDetailDto;
import bean.dto.BillDto;
import bean.dto.BillSearchDto;

public interface BillMapper {
	/**
	 * 查找指定客户，指定月份的os账号详单情况
	 * @param map
	 * @return
	 */
	public List<BillDetailDto> selectBillDetailByMonthById(Map map);
	/**
	 * 通过月份和指定页面来查找客户的月份账单信息
	 * @param page
	 * @return
	 */
	public List<BillDto>  selectMonthBillByPage(Page page);
	/**
	 * 获取月份账单的数据总条数
	 * @return
	 */
	public int getBillsNum();
	/**
	 * 通过条件来查询出月份账单
	 * @param billSearchDto
	 * @return
	 */
	public List<BillDto> selectMonthBillByCondition(BillSearchDto billSearchDto);
	/**
	 * 更新指定账单的资费数据
	 * @param map  
	 * @return 
	 */
	public int updateBill(Map map);
	/**
	 * 获取所有月份账单数据
	 * @return
	 */
	public List<BillDto> selectAllMonthBill();
}
