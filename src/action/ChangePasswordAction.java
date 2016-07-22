package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import service.AccountManage;

/**
 * Servlet implementation class AdminAction
 */
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
			response.sendRedirect("xxx.jsp");
			return;
		}
		Admin admin = (Admin)obj;
		/**
		 * 这里是获取用户输入的旧的密码
		 */
		String oldPassword   = request.getParameter("oldPassword");
		/**
		 * 当用户输入的新密码和老密码不相等时,应跳转回页面并返回提示信息
		 */
		if (!admin.getPassword().equals(oldPassword)) {
			request.getRequestDispatcher("xxx.jsp").forward(request, response);
		} else {
			/**
			 * 这里应该是获取用户输入的新的密码
			 */
			String newPassword = request.getParameter("newPassword");
			
			if (accountManage.changePassword(admin.getAdminId(), newPassword)) {
				/**
				 * 当用户改密成功时应返回登陆界面，并且应将session重置为空，此处代码省去
				 */
			} else {
				/**
				 * 当用户改密不成功应做出的操作
				 */
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