package mapper;

import java.util.List;

import bean.dto.OsLoginDto;

public interface BillMapper {
	public List<OsLoginDto> selectOsLoginDtoByOsId(int osId);
}
