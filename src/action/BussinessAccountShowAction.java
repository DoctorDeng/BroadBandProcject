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
		List<AccountViewBean> l = new AccountService().getAccountViewBean(currentPage);
		HttpSession session = request.getSession();
		session.setAttribute("l", l);
		int countPage = new AccountService().getCountPage();
		response.sendRedirect(request.getContextPath()+"/account/account_list.jsp?currentPage="+currentPage+"&countPage="+(countPage%5==0?(countPage/5):(countPage/5+1)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
