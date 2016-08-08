package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Power;
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
			System.out.println(adminName);
			System.out.println(power);
			
			PrintWriter out = response.getWriter();
			List<Admin> admins = adminService.getAdminByCondition(adminName,power);
			if (admins.size() == 0) {
				out.println("<tr>");
				out.println("<td><input type=\"checkbox\" name=\"choose\" /></td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.print("</tr>");
			}
			for(Admin admin :admins) {
				out.println("<tr>");
				out.println("<td><input type=\"checkbox\" name=\"choose\" value=\""+admin.getAdminId()+"\" /></td>");
				out.println("<td>" +admin.getAdminId()+"</td>");
				out.println("<td>" +admin.getAdminName()+"</td>");
				out.println("<td>" +admin.getAdminAccount()+"</td>");
				out.println("<td>" +admin.getPhone()+"</td>");
				out.println("<td>" +admin.getEmail()+"</td>");
				out.println("<td>" +admin.getCreateTime()+"</td>");
				out.println("<td>");
				out.println("<a class=\"summary\"  onmouseover=\"showDetail(true,this);\" onmouseout=\"showDetail(false,this);\">查看权限</a>");
				out.println("<div class=\"detail_info\">");
				for(Power temp:admin.getPowers()) {
					out.println(temp.getPowerName()+"&nbsp;");
				}
				out.println("</div>");
				out.println("</td>");
				out.println("<td class=\"td_modi\">");
				out.println("<input type=\"button\" value=\"修改\" class=\"btn_modify\" onclick=\"location.href='"+request.getContextPath()+"/ShowAdminAction?operation=initById&adminId="+admin.getAdminId()+"';\"/>");
				out.println("<input type=\"button\" value=\"删除\" class=\"btn_delete\" onclick=\"location.href='"+request.getContextPath()+"/DelAdminAction?adminId="+admin.getAdminId()+"';\"/>");
				out.println("</td>");
				out.print("</tr>");
			}
			out.flush();
			out.close();
			
			session.setAttribute("isPage", false);
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
