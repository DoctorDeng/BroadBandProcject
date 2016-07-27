package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

/**
 * Servlet implementation class DelAdminAction
 */
@WebServlet(urlPatterns="/DelAdminAction")
public class DelAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelAdminAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   int adminId = Integer.parseInt(request.getParameter("adminId")); 
	   AdminService delAdmin = new AdminService();
	   boolean delresult = delAdmin.delAdmin(adminId);
	   if(delresult==true){
		   response.sendRedirect(request.getContextPath()+"/ShowAdminAction?operation=init");
	   }
	   else{
		   response.sendRedirect("error.jsp");
	   }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
