package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.viewBean.AccountViewBean;
import service.AccountService;

/**
 * Servlet implementation class BussinessAccountModiAction
 */
@WebServlet(name="BussinessAccountModiAction",urlPatterns="/BussinessAccountModiAction")
public class BussinessAccountModiAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BussinessAccountModiAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		AccountViewBean b = new AccountViewBean();
		b.setBussinessId(Integer.parseInt(request.getParameter("bussinessId")));
		b.setBussinessName(name);
		b.setIdNumber(request.getParameter("idNumber"));
		if(request.getParameter("password")!=null&&request.getParameter("password")!=""){
			b.setPassword(request.getParameter("password"));
		}		
		b.setLoginAccount(request.getParameter("loginAccount"));
		b.setPhone(request.getParameter("phone"));
		new AccountService().updateBussinessAccount(b);
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
