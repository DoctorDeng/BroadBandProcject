package mapper;

import java.util.List;
import java.util.Map;

import bean.Page;
import bean.dto.BillDetailDto;
import bean.dto.BillDto;
import bean.dto.BillSearchDto;

public interface BillMapper {
	/**
	 * 获取客户账单详单信息(客户所有Os账号账单信息)Dto
	 * @param  billId  账单ID
	 * @return List<BillDetailDto>
	 */
	public List<BillDetailDto> selectBillDetailDtoByBillId(int billId);
	/**
	 * 获取所有的账单信息
	 * @return List<BillDto>
	 */
	public List<BillDto> selectPageBill(Page page);
	/**
	 * 通过条件查询账单信息
	 * @param billSearchDto  存储查询条件的Dto
	 * @return   List<BillDto>
	 */
	public List<BillDto> selectBillByCondition(BillSearchDto billSearchDto);
	/**
	 * 获取所有账单(Bill)的总数据条数,即长度
	 * @return int 账单数据数
	 */
	public int getBillNum();
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
}
