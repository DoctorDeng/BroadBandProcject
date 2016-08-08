package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.dto.PageDto;
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
		
  		String currentPageStr = request.getParameter("currentPage");
  		
		switch (operation) {
		case "init" :	
			PageDto<Admin> pagedto = adminService.selectFromPage(currentPageStr, 4);
			session.setAttribute("adminPage", pagedto);
			session.setAttribute("isPage", true);
		    response.sendRedirect("admin/admin_list.jsp");
		    return;
		  
		case "search":
			String power 	 = request.getParameter("power");
			String adminName = request.getParameter("adminName");

			List<Admin> admins = adminService.getAdminByCondition(adminName,power);
			PageDto<Admin> pageDto1 = new PageDto<>();
			System.out.println(admins.size());
			Object obj = session.getAttribute("adminPage");
			if (null != obj) {
				pageDto1 = (PageDto<Admin>) obj;
			}
			pageDto1.setDataList(admins);
			session.setAttribute("adminPage", pageDto1);
			session.setAttribute("isPage", false);
			response.sendRedirect("admin/admin_list.jsp");
			return;
			 
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
	    		 request.getRequestDispatcher("/admin/admin_modi.jsp").forward(request, response);
	    	 }
	    	 break;
		}
	 }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
