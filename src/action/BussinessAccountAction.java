package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import bean.Customer;
import mapper.CustomerMapper;
import util.SqlSessionUtil;

/**
 * Servlet implementation class BussinessAccountAction
 */
@WebServlet(name="BussinessAccountAction",urlPatterns="/BussinessAccountAction")
public class BussinessAccountAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BussinessAccountAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int bussinessId = 0;
		if(request.getParameter("id")!=null&&request.getParameter("id")!=""){
			String bus = request.getParameter("id");
			bussinessId = Integer.parseInt(bus);
		}
		int customerId = bussinessId;
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		SqlSession ss = null;
		try {
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);						
			cm.deleteCustomer(customerId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ss.commit();
			ss.close();
		}
		response.sendRedirect(request.getContextPath()+"/account/account_list.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
