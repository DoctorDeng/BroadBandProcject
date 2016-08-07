package service;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Bussiness;
import bean.Customer;
import bean.Os;
import bean.dto.OsAddDto;
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
		/*for(OsDto o : listOs){
			System.out.println(o.getTariffId());
		}*/
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
	public List<Customer> upServiceT(Customer customer){
		start();
		String idNumber = customer.getIdNumber();
		Customer cu = customerMapper.selectCustomerByIdNumber(idNumber);
		List<Customer> list = new ArrayList<Customer>();
		list.add(cu);
		close();
		return  list;
	}
	
	/**
	 * 通过不同的条件分别查询信息
	 * @return
	 */
	public List<OsDto> selForChoice(OsDto osDto){
		start();
		List<OsDto> listDto = osMapper.selChooseInfo(osDto);
		close();
		return listDto;
	}
	
	/**
	 * 根据查询返回osDto 修改资费类型
	 * @param osDto
	 * @return
	 */
	public boolean upForOneService(OsDto osDto){
		start();
		Os os = new Os();
		os.setOsAccount(osDto.getOsAccount());
		os.setTariffId(osDto.getTariffId());
		boolean b = osMapper.upOneOsByBussinessId(os);
		if(b){
			close();
			return true;
		}
		close();
		return false;
		
	}
	/**
	 * 增加信息
	 * @param osAddDto
	 * @return
	 */
	public boolean addServiceOneInfo(OsAddDto osAddDto){
		start();
		boolean b = osMapper.addOsInfo(osAddDto);
		if(b){
			Os os = osMapper.selOsidByOsAccount(osAddDto.getOsAccount());
			String createTime = (new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
			Bussiness bussiness = new Bussiness();
			bussiness.setCreateTime(createTime);
			bussiness.setOsId(os.getOsId());
			bussinessMapper.insertBussiness(bussiness);
			close();
			return b;
		}
		close();
		return b;
		
	}
	/**
	 * 修改状态
	 * @param customer
	 * @return
	 */
	public boolean  upStutas(OsDto customer){
		start();
		int id = customer.getCustomerId();
		Bussiness bussiness = bussinessMapper.selectBussinessById(id);
		int osId = bussiness.getOsId();
		Os os = new Os();
		os.setOsId(osId);
		os.setStatus(customer.getStatus());
		boolean b = osMapper.upStutas(os);
		if(b){
			close();
			return true;
		}
		close();
		return false;
		
	}
	/**
	 * 根据OsAccount 改变其状态  变为删除状态
	 * @param osDto
	 * @return
	 */
	public boolean  upStutasWithOsAccount(OsDto osDto){
		start();
		System.out.println(osDto.getBussinessId());
		int id = osDto.getBussinessId();
		Bussiness bussiness = bussinessMapper.selectBussinessById(id);
		int osId = bussiness.getOsId();
		Os o = new Os();
		o.setOsId(osId);
		boolean b =osMapper.upStutasWithOsAccount(o);
		if(b){
			close();
			return true;
		}
		close();
		return false;
		
	}
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
