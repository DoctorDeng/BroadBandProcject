package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.vo.BillDetailFormBean;
import bean.vo.BillFormBean;
import service.AdminService;

/**
 * Servlet implementation class AdminInforAction
 */
@WebServlet(name="AdminInforAction",urlPatterns="/AdminInforAction")
public class AdminInforAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminService adminService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInforAction() {
        super();
        adminService = new AdminService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin objAdmin = (Admin)request.getSession().getAttribute("admin");
		
		if (null == objAdmin) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
			Admin adminInfo  = (Admin)objAdmin;
			
			String adminName = request.getParameter("adminName");
			String email     = request.getParameter("email");
			String phone     = request.getParameter("phone");
			adminInfo.setAdminName(adminName);
			adminInfo.setEmail(email);
			adminInfo.setPhone(phone);
			
			if (adminService.updateInfor(adminInfo)) {
				request.getSession().setAttribute("admin", adminInfo);
				request.getRequestDispatcher("/user/user_info.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/error.jsp").forward(request, response);
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
