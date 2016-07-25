package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import service.AccountManage;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet(urlPatterns="/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminAccount = request.getParameter("adminAccount");
		String password = request.getParameter("password");
		AccountManage accountManage = new AccountManage();
		if (null != adminAccount && null != password) {
			Admin  admin = accountManage.login(adminAccount, password);
			if (null == admin) {
				response.sendRedirect("loginFail.jsp");
				return;
			} else {
				request.getSession().setAttribute("admin", admin);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
		} else {
			response.sendRedirect("login.jsp");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
