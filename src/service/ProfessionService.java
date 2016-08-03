package service;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Bussiness;
import bean.Customer;
import bean.Os;
import bean.dto.OsDto;
import bean.dto.OsShowDto;
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
	
	/**
	 * 删除信息
	 * @param osDto
	 * @return
	 */
	public boolean delService(OsDto osDto){
		start();
		Bussiness bus = bussinessMapper.selectBussinessById(osDto.getBussinessId());
		bussinessMapper.deleteBussiness(bus.getBussinessId());
		boolean b = osMapper.delOneOsByOsId(bus.getOsId());
		if(b){
			return true;
		}
		close();
		return false;
	}
	
	
	 /**
	  * 修改用户信息,先查询出需要的信息 F意思为第一步
	  * @return
	  */
	public List<OsShowDto> upServiceF(Bussiness bussiness){
		start();
		OsShowDto osShowDto = new OsShowDto();
		int id = bussiness.getBussinessId();
		List<OsShowDto> list = osMapper.setManyInfo(id);
		close();
		return list;
	
	}
	/**
	 * 修改用户信息，根据bussinessID来修改 T 意思为第二步
	 * @param bussiness
	 * @return
	 */
	public List<OsShowDto> upServiceT(Bussiness bussiness){
		start();
		OsShowDto osShowDto = new OsShowDto();
		int id = bussiness.getBussinessId();
		List<OsShowDto> list = osMapper.setManyInfo(id);
		close();
		return list;
	}
	/**
	 * 进行修改信息
	 * @return
	 */
/*	public List<OsDto> upServiceT(OsDto osDto){
 * }
		return  OsDto;*/
		
	
	/**
	 * 
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
