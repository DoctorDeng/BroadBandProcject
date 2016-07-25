package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.viewBean.AccountViewBean;
import service.AccountService;

/**
 * Servlet implementation class BussinessAccountSearchAction
 */
@WebServlet(urlPatterns="/BussinessAccountSearchAction")
public class BussinessAccountSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BussinessAccountSearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int currentPage = 0;
		if(request.getParameter("currentPage")!=null&&"".equals(request.getParameter("currentPage"))){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else{
			currentPage = 1;
		}
		String idNumber = request.getParameter("idNumber");
		String name = request.getParameter("name");
		String loginAccount = request.getParameter("loginAccount");
		String status = request.getParameter("status");
		AccountViewBean a = new AccountViewBean();                                                                     
		a.setBussinessName(name);
		a.setIdNumber(idNumber);
		a.setStatus(status);
		a.setLoginAccount(loginAccount);
		List<AccountViewBean> l = new AccountService().searchAccountViewBean(a, currentPage);
		for(AccountViewBean ac:l){
			System.out.println(ac.getBussinessName());
		}
		HttpSession session = request.getSession();
		session.setAttribute("ls", l);
		response.sendRedirect("http://localhost:8080/lanqiao/account/account_list.jsp?type=search&currentPage=1");
		//request.getRequestDispatcher("/account/account_list.jsp?type=search&currentPage=1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
