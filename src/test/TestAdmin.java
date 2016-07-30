package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Admin;
import mapper.AdminMapper;
import util.SqlSessionUtil;

public class TestAdmin {
	private SqlSession sqlSession;
	private AdminMapper adminMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionUtil.getSqlSession();
		adminMapper = sqlSession.getMapper(AdminMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAdminById() {
		System.out.println(adminMapper.selectAdminById(5).getPowers().size());
		sqlSession.close();
	}
	@Test
	public void testSelectAllAdmin() {
		System.out.println(adminMapper.selectAllAdmin().size());
		sqlSession.close();
	}
	@Test
	public void insertAdmin() {
		Admin admin = new Admin("doctordeng","123456","杨幂","","","");
		System.out.println(adminMapper.insertAdmin(admin));
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void updateAdmin() {
		Admin admin = new Admin("doctordeng","123456","杨幂","","13256235142","sd");
		admin.setAdminId(43);
		System.out.println(adminMapper.updateAdminInfor(admin));
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void resetAdminsPassword() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(3);
		System.out.println(adminMapper.resetAdminsPassword(ids));
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void deleteAdminById() {
		System.out.println(adminMapper.deleteAdminById(43));
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void updateAdminPassword() {
		Admin admin = new Admin("doctordeng","123","杨幂","","13256235142","sd");
		admin.setAdminId(1);
		System.out.println(adminMapper.updateAdminPassword(admin));
		sqlSession.commit();
		sqlSession.close();
	}

}
