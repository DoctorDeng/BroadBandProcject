package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Power;
import service.AdminService;

/**
 * Servlet implementation class UpdateAdminInfor
 */
@WebServlet(urlPatterns="/UpdateAdminInfor")
public class UpdateAdminInfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminInfor() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminName    = request.getParameter("adminName");
		int adminId         = Integer.parseInt(request.getParameter("adminId"));
		String phone        = request.getParameter("phone");
		String email        = request.getParameter("email");
		String[] powerStr   = request.getParameterValues("power");
		
		Admin admin = new Admin();
		admin.setAdminId(adminId);
		admin.setAdminName(adminName);
		admin.setPhone(phone);
		admin.setEmail(email);

		List<Power> powerList = new ArrayList<>();
		for (String str : powerStr) {
			Power power = new Power();
			power.setPowerId(Integer.parseInt(str));
			powerList.add(power);
		}
		admin.setPowers(powerList);
		AdminService adminManage = new AdminService();
		boolean isupdate = adminManage.updateAdmin(admin);
		
		if(isupdate==true){
			response.sendRedirect(request.getContextPath()+"/ShowAdminAction?operation=init");
		}else{
		   response.sendRedirect("admin/admin_modi.jsp");	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
