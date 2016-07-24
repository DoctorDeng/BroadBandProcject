package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bussiness;
import bean.viewBean.AccountViewBean;
import service.AccountService;

/**
 * Servlet implementation class BussinessAccountAddAction
 */
@WebServlet(name="BussinessAccountAddAction",urlPatterns="/BussinessAccountAddAction")
public class BussinessAccountAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BussinessAccountAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		AccountViewBean b = new AccountViewBean();
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		b.setBussinessName(name);
		b.setIdNumber(request.getParameter("idNumber"));
		b.setPassword(request.getParameter("password"));
		b.setPhone(request.getParameter("phone"));
		b.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
		b.setLoginAccount(request.getParameter("loginAccount"));
		b.setStatus("1");
		b.setLastLoginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		new AccountService().addBussinessAccount(b);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
