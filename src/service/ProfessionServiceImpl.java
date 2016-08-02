package service;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.dto.OsDto;
import bean.vo.ServiceAddViewBean;
import mapper.BussinessMapper;
import mapper.CustomerMapper;
import mapper.OsMapper;
import util.SqlSessionUtil;

public class ProfessionServiceImpl implements ProfessionService {
	private SqlSession sqlSession;
	private OsMapper osMapper;
	private BussinessMapper bussinessMapper;
	private CustomerMapper customerMapper;
	
	@Override
	public List<OsDto> serviceListShow() {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		osMapper = sqlSession.getMapper(OsMapper.class);
		List<OsDto> listOs = osMapper.selServiceShow();
		return listOs;
		// TODO Auto-generated method stub
		
	}
	
}
