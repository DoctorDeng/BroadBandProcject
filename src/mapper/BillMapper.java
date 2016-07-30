package mapper;

import java.util.List;

import bean.dto.BillDetailDto;
import bean.dto.BillDto;

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
	public List<BillDto> selectAllBill();
	
}
