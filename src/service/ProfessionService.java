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
import bean.Tariff;
import bean.dto.OsAddDto;
import bean.dto.OsDto;
import bean.dto.OsShowDto;
import mapper.BussinessMapper;
import mapper.CustomerMapper;
import mapper.OsMapper;
import mapper.TariffMapper;
import util.SqlSessionUtil;
public class ProfessionService {
	private SqlSession sqlSession;
	private OsMapper osMapper;
	private BussinessMapper bussinessMapper;
	private CustomerMapper customerMapper;
	private TariffMapper tariffMapper;
	
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
		close();
		return b;
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
		close();
		return b;
		
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
			String openTime   = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			Bussiness bussiness = new Bussiness();
			bussiness.setCreateTime(createTime);
			bussiness.setOsId(os.getOsId());
			bussiness.setOpenTime(openTime);
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
		/**
		 * 获取取值的bussinessId
		 */
		int id = customer.getCustomerId();
		Bussiness bussiness = bussinessMapper.selectBussinessById(id);
		int osId = bussiness.getOsId();
		Os os = new Os();
		os.setOsId(osId);
		os.setStatus(customer.getStatus());
		boolean a = true;
		boolean b = osMapper.upStutas(os);
		if(a=b){
			if("0".equals(customer.getStatus())){
				String pauseTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
				Bussiness bus = new Bussiness();
				bus.setPauseTime(pauseTime);
				bus.setOsId(osId);
				boolean c = bussinessMapper.updatePauseTime(bus);
				close();
				return c ;
			}else if("1".equals(customer.getStatus())){
				Bussiness bus = new Bussiness();
				bus.setOsId(osId);
				boolean c = bussinessMapper.updatePauseTimeToNull(osId);
				close();
				return c;
			}
		}
		close();
		return b;
		
	}
	/**
	 * 根据OsAccount 改变其状态  变为删除状态
	 * @param osDto
	 * @return
	 */
	public boolean  upStutasWithOsAccount(OsDto osDto){
		start();
		int id = osDto.getBussinessId();
		Bussiness bussiness = bussinessMapper.selectBussinessById(id);
		int osId = bussiness.getOsId();
		Os o = new Os();
		o.setOsId(osId);
		boolean a = true;
		boolean b =osMapper.upStutasWithOsAccount(o);
		if(a=b){
			String deletTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			Bussiness bus = new Bussiness();
			bus.setOsId(osId);
			bus.setDeletTime(deletTime);
			boolean c = bussinessMapper.deletedDeletTime(bus);
			close();
			return c ;
		}
		close();
		return b;
		
	}
	/**
	 * 通过查询资费表里面的Name 获得其ID
	 * @param tariffName
	 * @return
	 */
	public Tariff selTarriffId(String tariffName){
		start();
		Tariff tariff = tariffMapper.findIdByName(tariffName);
		close();
		return tariff;
		
	}
	/**
	 * 判断登陆Os账户是否存在、
	 * @param os
	 * @return
	 */
	public Os selOsAcAndOsPa(String osAccount,String osPassword){
		start();
		Os os = new Os();
		os.setOsAccount(osAccount);
		os.setOsPassword(osPassword);
		Os o = osMapper.selOsAcAndOsPa(os);
		close();
		return o;
		
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
			tariffMapper = sqlSession.getMapper(TariffMapper.class);
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
