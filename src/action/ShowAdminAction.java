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

import bean.AdminInfor;
import bean.Page;
import dao.impl.AdminDaoImpl;
import service.AccountManage;

/**
 * Servlet implementation class ShowAdminMess
 */
@WebServlet(urlPatterns="/ShowAdminAction")
public class ShowAdminAction extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AdminDaoImpl admim;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAdminAction() {
        super();
        admim = new AdminDaoImpl();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String operation = request.getParameter("operation");
		if (null == operation | "".equals(operation)) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		/*Page page       = new Page();
		int pageSize    = 8;
  		int currentPage = 1;
  		int indexPage   = 1;
		int nextPage    = 1;
 		int upPage      = 1;	 		
 		int recordNum   = admim.findAllAdminInfor().size();
 		int pageNum     = (int) Math.ceil(recordNum/pageSize)+1;
 		int endPage     = pageNum;
 		
 		String currentPageStr = request.getParameter("currentPage");
		if (null !=currentPageStr && !"".equals(currentPageStr)){
			currentPage = Integer.parseInt(currentPageStr);
		}
				
		if (currentPage!=1 && pageNum > 1) {
  			upPage = currentPage - 1; 
  		}
  		if (currentPage<pageNum && pageNum>2) {
  			nextPage = currentPage +1;
  		}
  		if (currentPage== pageNum) {
  			nextPage = pageNum;
  		}
  		page.setIndexPage(indexPage);
  		page.setEndPage(endPage);
  		page.setNextPage(nextPage);
  		page.setUpPage(upPage);
  		page.setCurrentPage(currentPage);
  		*/
  		List<Map<String, Object>> admininforList = admim.findAllAdminInfor(); 
  	
		switch (operation) {
		case "init" :		
			session.setAttribute("admininforList", admininforList);
			/*request.setAttribute("page", page);
			request.setAttribute("isPage", "yes");*/
		    response.sendRedirect("admin/admin_list.jsp");
		    return;
		  
		case "search":
			 String adminId = request.getParameter("adminId");
			 if(null==adminId||"".equals(adminId)){
				 session.setAttribute("admininforList", admininforList);  
				 response.sendRedirect("admin/admin_list.jsp");
				 return;
			 } 
			 else{	 
			   for(int i=0;i<admininforList.size(); i++) {	
				 Map<String, Object> adminInfor = admininforList.get(i);
				  if(adminId.equals(adminInfor.get("adminId").toString().trim())){
				    List<Map<String, Object>> inforList =new ArrayList<>();
				    inforList.add(adminInfor);
				    session.setAttribute("admininforList", "");
				    session.setAttribute("admininforList", inforList);
				    response.sendRedirect("admin/admin_list.jsp");
				    return;
				  }
				}
			   List<Map<String, Object>> inforList1 =new ArrayList<>();
			   session.setAttribute("admininforList", inforList1);
			   response.sendRedirect("admin/admin_list.jsp");
			   return;
			 }
	     case "reset" :
	    	 String[] arrays = request.getParameterValues("choose");
	         int[] adminIds =new int[arrays.length]; 
	         
	         for(int i=0;i<adminIds.length;i++){
	        	 adminIds[i]=Integer.parseInt(arrays[i]);
	        	 System.out.println(adminIds[0]);
	         }	   
	         boolean resetResult = new AccountManage().resetPassword(adminIds);
	         if(resetResult){
	        	 response.sendRedirect(request.getContextPath()+"/ShowAdminAction?operation=search");
	         }
		}
	 }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
