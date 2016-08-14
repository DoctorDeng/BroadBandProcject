package service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Os;
import bean.OsLogin;
import bean.Tariff;
import mapper.OsLoginMapper;
import util.SqlSessionUtil;
import util.TariffUtil;
import util.TimeUtil;

/**
 * 客户Os账号登陆Service
 * @author Administrator
 *
 */
public class OsLoginService {
	private SqlSession sqlSession;
	private ProfessionService  osService;
	private OsLoginMapper osLoginMapper;
	
	public OsLoginService(){
		osService = new ProfessionService();
	}
	/**
	 * Os登陆方法,登陆时记载登陆IP和时间
	 * @param osId     登陆Os的OsId
	 * @param loginIp  登陆Ip
	 * @return         记载成功返回此次登陆的身份Id，失败返回0
	 */
	public int recordOsLogin(int osId,String loginIp) {
		init();
		
		Map map = new HashMap<>();
		map.put("osId", osId);
		map.put("loginIp", loginIp);
		map.put("osLoginId", 1);
		int result = osLoginMapper.insertOsLogin(map);
		if (result ==1) {
			sqlSession.commit();
			return Integer.parseInt(map.get("osLoginId").toString());
		}
		sqlSession.rollback();
		sqlSession.close();
		return 0;
	}
	/**
	 * 记载Os登出时间
	 * @param osLoginId  Os登陆唯唯一Id标识
	 * @return   记载成功返回true，失败返回false
	 */
	public boolean recordOsLoginOut(int osLoginId) {
		init();
		
		int result = osLoginMapper.updateOsLogin(osLoginId);
		if (result ==1) {
			close();
			return true;
		}
		sqlSession.rollback();
		sqlSession.close();
		return false;
	}
	/**
	 * 获取指定OS账号,指定月份的登陆总时间
	 * @param osId   Os账号ID
	 * @param months 月份
	 * @return int 
	 */
	public int getOsMonthTotalTime(int osId, String months) {
		init();
		Map map = new HashMap();
		map.put("osId", osId);
		map.put("months", months);
		
		int totalTime = osLoginMapper.selectTotalTimeByOsIdAndMonth(map);
		
		close();
		return totalTime;
	}
	/**
	 * 计算Os账号单次登陆费用
	 * @param osLoginId  Os每次登陆唯一Id标识
	 * @param osId       Os账号ID
	 * @return double    单次登陆费用
	 */
	public double countLoginTariff(int osLoginId,Os os) {
		init();
		
		String months = TimeUtil.getNowMonth();
		OsLogin osLogin = osLoginMapper.selOneOsLoginByOsLoginId(osLoginId);
		int oneTime = osLogin.getTimeLong();
		
		Map map = new HashMap<>();
		map.put("osId", os.getOsId());
		map.put("months", months);
		int totalTime = osLoginMapper.selectTotalTimeByOsIdAndMonth(map);
		
		Tariff tariff = os.getTariff();
		double loginTariff = TariffUtil.countLoginDetailTariff(totalTime, oneTime, tariff.getTariff(),
				tariff.getTimeLong(), tariff.getTimeTariff(), tariff.getTariffType());
		
		close();
		return loginTariff;
	}
	/**
	 * 查看Os账号指定OsLoginId的登入时间
	 * @param osLoginId
	 * @return  本次登陆时间,出现异常返回空字符串
	 */
	public String showLoginInTime(int osLoginId) {
		init();
		OsLogin osLogin = osLoginMapper.selOneOsLoginByOsLoginId(osLoginId);
		if (null == osLogin) {
			return "";
		}
		close();
		return osLogin.getLoginInTime();
	}
	/**
	 * 查询指定账号当前月份的总消费
	 * @param os  Os对象
	 * @return    Os当前月份的消费
	 */
	public double getOsMonthTariff(Os os) {
		int osId      = os.getOsId();
		String months = TimeUtil.getNowMonth();
		int totalTime = getOsMonthTotalTime(osId,months);
		System.out.println(totalTime);
		Tariff tariff = os.getTariff();
		double cost   = TariffUtil.countAccountTariff(totalTime, tariff.getTariff(),
				tariff.getTimeLong(), tariff.getTimeTariff(), tariff.getTariffType());
		
		return cost;
	}
	
	/**
	 * 初始化SqlSession和mapper
	 */
	public void init(){
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
			osLoginMapper = sqlSession.getMapper(OsLoginMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 提交关闭SqlSession
	 */
	public void close(){
		sqlSession.commit();
		sqlSession.close();
	}
	
	public static void main(String[] args) {
		OsLoginService osLoginService = new OsLoginService();
		System.out.println(osLoginService.recordOsLoginOut(67));
	}
}
