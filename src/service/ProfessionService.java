package service;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Bussiness;
import bean.dto.OsDto;
import mapper.BussinessMapper;
import mapper.CustomerMapper;
import mapper.OsMapper;
import util.SqlSessionUtil;
public class ProfessionService {
	private SqlSession sqlSession;
	private OsMapper osMapper;
	private BussinessMapper bussinessMapper;
	private CustomerMapper customerMapper;
	
	/**
	 * 查询信息显示界面
	 * @return
	 */
	public List<OsDto> serviceListShow() {
		start();
		osMapper = sqlSession.getMapper(OsMapper.class);
		List<OsDto> listOs = osMapper.selServiceShow();
		close();
		return listOs;
		// TODO Auto-generated method stub
		
	}
	
	public boolean delService(OsDto osDto){
		start();
		Bussiness bus = bussinessMapper.selectBussinessById(osDto.getBussinessId());
		bussinessMapper.deleteBussiness(bus.getBussinessId());
		osMapper.delOneOsByOsId(bus.getOsId());
		close();
		return false;
	}
	
	
	/**
	 * 构建环境
	 */
	public  void start(){
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
			osMapper = sqlSession.getMapper(OsMapper.class);
			bussinessMapper = sqlSession.getMapper(BussinessMapper.class);
			customerMapper = sqlSession.getMapper(CustomerMapper.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 提交和关闭资源
	 */
	public void close(){
		sqlSession.commit();
		sqlSession.close();
	}
}
