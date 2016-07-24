package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.AdminInfor;
import bean.Power;
import service.AdminService;

/**
 * Servlet implementation class AddAdminAction
 */
public class AddAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminAction() {
        super();
        // TODO Auto-generated constructor stub
    }    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	    
			String adminName    = request.getParameter("adminName");
			String adminAccount = request.getParameter("adminAccount");
			String password     = request.getParameter("password");
			String phone        = request.getParameter("phone");
			String idNumber     = request.getParameter("idNumber");
			String email        = request.getParameter("email");
			String[] powerStr   = request.getParameterValues("power");
			
			Admin admin = new Admin();
			admin.setAdminAccount(adminAccount);
			admin.setPassword(password);
			AdminInfor adminInfor = new AdminInfor();
			adminInfor.setAdminName(adminName);
			adminInfor.setPhone(phone);
			adminInfor.setIdNumber(idNumber);
			adminInfor.setEmail(email);

			List<Power> powerList = new ArrayList<>();
			for (String str : powerStr) {
				Power power = new Power();
				power.setPowerId(Integer.parseInt(str));
				powerList.add(power);
			}
		
			AdminService adminManage = new AdminService();
			boolean isAdd = adminManage.addAdmin(admin, adminInfor, powerList);
			
			if(isAdd==true){
				response.sendRedirect("admin/admin_list.jsp");
			}else{
			   response.sendRedirect("login.jsp");	
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
