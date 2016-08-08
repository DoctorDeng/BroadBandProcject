package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import bean.Customer;
import bean.vo.AccountViewBean;
import mapper.CustomerMapper;
import service.AccountService;
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
		AccountViewBean a = new AccountViewBean();
		a.setBussinessId(bussinessId);
		a.setStatus("2");
		new AccountService().updateBussinessAccount(a);
		response.sendRedirect(request.getContextPath()+"/BussinessAccountShowAction?currentPage="+request.getParameter("currentPage"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
