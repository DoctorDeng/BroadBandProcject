package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.viewBean.AccountViewBean;
import service.AccountService;

/**
 * Servlet implementation class BussinessAccountModiAction
 */
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		AccountViewBean b = new AccountViewBean();
		//String name = new String(request.getParameter("name").getBytes("UTF-8"),"UTF-8");
		b.setBussinessId(Integer.parseInt(request.getParameter("bussinessId")));
		b.setBussinessName(request.getParameter("name"));
		b.setIdNumber(request.getParameter("idNumber"));
		if(request.getParameter("password")!=null&&request.getParameter("password")!="")
		b.setPassword(request.getParameter("password"));
		b.setPhone(request.getParameter("phone"));
		//b.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
		b.setLoginAccount(request.getParameter("loginAccount"));
		b.setPhone(request.getParameter("phone"));
		//b.setLastLoginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		new AccountService().updateBussinessAccount(b);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
