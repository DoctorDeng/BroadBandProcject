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
		String operation = request.getParameter("operation");
		
		if (null == operation | "".equals(operation)) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		Object objAdmin = request.getSession().getAttribute("admin");
		//Object objAdmin = LoginAction.session;
		if (null == objAdmin) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		Admin admin  = (Admin)objAdmin;
		switch (operation) {
		/**
		 * 鍒濆鍖栦慨鏀逛俊鎭〉闈俊鎭�
		 */
		case "initInfor":
			Admin temp = adminService.getAdminById(admin.getAdminId());
			request.setAttribute("admin", temp);
			request.getRequestDispatcher("/user/user_info.jsp").forward(request, response);
			break;
		/**
		 * 鏇存敼绠＄悊鍛樹俊鎭�
		 */
		case "updateInfor":
			String adminName = request.getParameter("adminName");
			String email     = request.getParameter("email");
			String phone     = request.getParameter("phone");
			Admin newAdmin = new Admin();
			newAdmin.setAdminId(admin.getAdminId());
			newAdmin.setAdminName(adminName);
			newAdmin.setEmail(email);
			newAdmin.setPhone(phone);
			adminService.updateInfor(newAdmin);
			request.getRequestDispatcher("/AdminInforAction?operation=initInfor").forward(request, response);
			break;
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
