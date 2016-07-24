package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.AdminInfor;
import bean.viewBean.BillDetailFormBean;
import bean.viewBean.BillFormBean;
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
			response.sendRedirect("/lanqiao/login.jsp");
			return;
		}
		Object objAdmin = request.getSession().getAttribute("admin");
		
		if (null == objAdmin) {
			response.sendRedirect("/lanqiao/login.jsp");
			return;
		}
		Admin admin  = (Admin)objAdmin;
		switch (operation) {
		/**
		 * 初始化修改信息页面信息
		 */
		case "initInfor":
			AdminInfor  adminInfor = adminService.getAdminInforById(admin.getAdminId());
			if (adminInfor == null) {
				if (adminService.initAdminInfor(admin.getAdminId())) {
					adminInfor = adminService.getAdminInforById(admin.getAdminId());
				} else {
					response.sendRedirect("/lanqiao/nopower.jsp");
					return;
				}
			}
			request.setAttribute("adminInfor", adminInfor);
			request.getRequestDispatcher("/user/user_info.jsp").forward(request, response);
			break;
		/**
		 * 更改管理员信息
		 */
		case "updateInfor":
			String adminName = request.getParameter("adminName");
			String email     = request.getParameter("email");
			String phone     = request.getParameter("phone");
			AdminInfor newAdminInfor = new AdminInfor();
			newAdminInfor.setAdminId(admin.getAdminId());
			newAdminInfor.setAdminName(adminName);
			newAdminInfor.setEmail(email);
			newAdminInfor.setPhone(phone);
			adminService.updateInfor(newAdminInfor);
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
