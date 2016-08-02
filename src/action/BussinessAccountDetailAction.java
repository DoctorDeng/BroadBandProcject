package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import bean.Customer;
import bean.vo.AccountViewBean;
import mapper.CustomerMapper;
import util.SqlSessionUtil;

/**
 * Servlet implementation class BussinessAccountDetailAction
 */
@WebServlet(name="BussinessAccountDetailAction",urlPatterns="/BussinessAccountDetailAction")
public class BussinessAccountDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BussinessAccountDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String strId = request.getParameter("id");
		int bussinessId = -1;
		if(strId!=null&&!strId.equals("")){
			bussinessId = Integer.parseInt(strId);
		}		
		AccountViewBean a = new AccountViewBean();
		SqlSession ss = null;
		try {
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);						
			Customer c =  cm.selectCustomerById(bussinessId);			
			a.setBussinessId(c.getCustomerId());
			a.setBussinessName(c.getCustomerName());
			a.setCreateTime(c.getCreateTime());
			a.setIdNumber(c.getIdNumber());
			a.setLastLoginTime(c.getLastLoginTime());
			a.setLoginAccount(c.getCustomerAccount());
			a.setPassword(c.getPassword());
			a.setPhone(c.getPhone());
			a.setStatus(c.getStatus());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ss.commit();
			ss.close();
		}
		HttpSession session = request.getSession();
		session.setAttribute("acc", a);
		response.sendRedirect(request.getContextPath()+"/account/account_detail.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
