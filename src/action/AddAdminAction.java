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
import util.StringUtil;

/**
 * Servlet implementation class AddAdminAction
 */
@WebServlet(name="AddAdminAction",urlPatterns="/AddAdminAction")
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
			System.out.println(adminName);
			System.out.println(adminAccount);
			System.out.println(idNumber);
			if (StringUtil.isNull(adminAccount) | StringUtil.isNull(adminName) | StringUtil.isNull(idNumber) | StringUtil.isNull(password)) {
				response.sendRedirect("operationError.jsp");
				return;
			}
			
			Admin admin = new Admin();
			admin.setAdminAccount(adminAccount);
			admin.setPassword(password);
			admin.setAdminName(adminName);
			admin.setPhone(phone);
			admin.setIdNumber(idNumber);
			admin.setEmail(email);

			List<Power> powerList = new ArrayList<>();
			for (String str : powerStr) {
				Power power = new Power();
				power.setPowerId(Integer.parseInt(str));
				powerList.add(power);
			}
			admin.setPowers(powerList);
			
			AdminService adminManage = new AdminService();
			boolean isAdd = adminManage.addAdmin(admin);
			if(isAdd==true){
				response.sendRedirect(request.getContextPath()+"/ShowAdminAction?operation=init");
			}else{
			   response.sendRedirect("admin/admin_add.jsp");	
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
