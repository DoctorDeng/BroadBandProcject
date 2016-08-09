package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.vo.AccountViewBean;
import service.AccountService;

/**
 * Servlet implementation class BussinessAccountShowAction
 */
@WebServlet(name="BussinessAccountShowAction",urlPatterns="/BussinessAccountShowAction")
public class BussinessAccountShowAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BussinessAccountShowAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int currentPage = 0;
        String c = request.getParameter("currentPage");
        if(c!=""&&c!=null){
        	currentPage = Integer.parseInt(c);
        } else{
        	currentPage = 1;
        }
        String idNumber = request.getParameter("idNumber");
		String name = request.getParameter("name");
		String loginAccount = request.getParameter("loginAccount");
		String status = request.getParameter("sstatus");
		AccountViewBean a = new AccountViewBean();                                                                     
		a.setBussinessName(name);
		a.setIdNumber(idNumber);
		a.setStatus(status);
		a.setLoginAccount(loginAccount);
//		System.out.println(name);
//		System.out.println(request.getRequestURL());
		List<AccountViewBean> l = new AccountService().searchAccountViewBean(a, currentPage);
		HttpSession session = request.getSession();
		session.setAttribute("l", l);
		for(AccountViewBean ac:l) {
			System.out.println(ac.getBussinessName());
		}
		int countPage = new AccountService().getCountPage();
		//response.sendRedirect(request.getContextPath()+"/account/account_list.jsp?currentPage="+currentPage+"&countPage="+(countPage%5==0?(countPage/5):(countPage/5+1)));
		request.getRequestDispatcher("/account/account_list.jsp?currentPage="
		+currentPage+"&countPage="+(countPage%5==0?(countPage/5):(countPage/5+1))).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
