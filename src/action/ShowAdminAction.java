package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import service.AccountManage;
import service.AdminService;

/**
 * Servlet implementation class ShowAdminMess
 */
@WebServlet(urlPatterns="/ShowAdminAction")
public class ShowAdminAction extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAdminAction() {
        super();
        adminService = new AdminService();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String operation = request.getParameter("operation");
		if (null == operation | "".equals(operation)) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
  		List<Admin> adminList = adminService.getAllAdminInfor();
  	
		switch (operation) {
		case "init" :		
			session.setAttribute("admininforList", adminList);
		    response.sendRedirect("admin/admin_list.jsp");
		    return;
		  
		case "search":
			 String adminId = request.getParameter("adminId");
			 if(null==adminId||"".equals(adminId)){
				 session.setAttribute("admininforList", adminList);  
				 response.sendRedirect("admin/admin_list.jsp");
				 return;
			 } 
			 else{	 
				 Admin temp = adminService.getAdminById(Integer.parseInt(adminId));
				 
				 if(null != temp) {
					  List<Admin> inforList =new ArrayList<>();
					  inforList.add(temp);
					  session.setAttribute("admininforList", "");
					  session.setAttribute("admininforList", inforList);
					  response.sendRedirect("admin/admin_list.jsp");
					  return;
				 } else {
					  List<Admin> inforList1 =new ArrayList<>();
					  session.setAttribute("admininforList", inforList1);
					  response.sendRedirect("admin/admin_list.jsp");
					  return;
				 }
			 }
			 
	     case "reset" :
	    	 String[] arrays = request.getParameterValues("choose");
	         int[] adminIds =new int[arrays.length]; 
	         
	         for(int i=0;i<adminIds.length;i++){
	        	 adminIds[i]=Integer.parseInt(arrays[i]);
	         }	   
	         boolean resetResult = new AccountManage().resetPassword(adminIds);
	         if(resetResult){
	        	 response.sendRedirect(request.getContextPath()+"/ShowAdminAction?operation=search");
	        	 return;
	         } else {
	        	 response.sendRedirect(request.getContextPath()+"/operationError.jsp");
	        	 return;
	         }
	         
	     case "initById" :
	    	 String adminIdStr = request.getParameter("adminId");
	    	 if (null == adminIdStr | "".equals(adminIdStr)) {
	    		 response.sendRedirect(request.getContextPath()+"/operationError.jsp");
	        	 return;
	    	 } else {
	    		 Admin admin = adminService.getAdminById(Integer.parseInt(adminIdStr));
	    		 request.setAttribute("modiAdmin", admin);
	    		 request.getRequestDispatcher(request.getContextPath()+"/admin/admin_modi.jsp").forward(request, response);
	    	 }
	    	 break;
		}
	 }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
