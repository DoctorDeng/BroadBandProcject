package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
 * Servlet implementation class BussinessAccountOpenAction
 */
@WebServlet(name="BussinessAccountOpenAction",urlPatterns="/BussinessAccountOpenAction")
public class BussinessAccountOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BussinessAccountOpenAction() {
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
		if(strId!=null&&!"".equals(strId)){
			bussinessId = Integer.parseInt(strId);
		}
		String status = request.getParameter("status");
		Customer c = new Customer();
		c.setCustomerId(bussinessId);
		if("1".equals(status)){
			c.setStatus("0");
			c.setPauseTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			
		}else if("0".equals(status)){
			c.setStatus("1");
		}
		AccountViewBean a = new AccountViewBean();
		a.setBussinessId(bussinessId);
		a.setStatus(c.getStatus());
		a.setPauseTime(c.getPauseTime());
		new AccountService().updateBussinessAccount(a);
		response.sendRedirect(request.getContextPath()+"/BussinessAccountShowAction?currentPage="
		+request.getParameter("currentPage"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
