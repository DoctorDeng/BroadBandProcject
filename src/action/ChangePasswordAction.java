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
 * Servlet implementation class AdminAction
 */
@WebServlet(urlPatterns="/ChangePasswordAction")
public class ChangePasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountManage accountManage = new AccountManage();
		
		Object obj  = request.getSession().getAttribute("admin");
		
		if (null == obj) {
			/**
			 * 当Obj为空即用户没有登陆获取不到存储在session中的admin中时，跳转到指定页面
			 */
			response.sendRedirect("login.jsp");
			return;
		}
		Admin admin = (Admin)obj;
		/**
		 * 这里是获取用户输入的旧的密码
		 */
		String oldPassword   = request.getParameter("oldPassword");
		/**
		 * 当用户输入的新密码和session中的密码不相等时,应跳转回页面并返回提示信息
		 */
		if (!admin.getPassword().equals(oldPassword)) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			/**
			 * 这里应该是获取用户输入的新的密码
			 */
			String newPassword = request.getParameter("newPassword");
			
			if (accountManage.changePassword(admin.getAdminId(), newPassword)) {
				request.getSession().setAttribute("admin", null);
				response.sendRedirect("/lanqiao/success.jsp");
				return;
			} 
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
