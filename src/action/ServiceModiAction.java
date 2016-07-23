package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.viewBean.BussinessViewBean;
import bean.viewBean.ServiceAddViewBean;

/**
 * Servlet implementation class ServiceModiAction
 */
public class ServiceModiAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceModiAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BussinessViewBean bvb = new BussinessViewBean();
		bvb.setAdminId(Integer.parseInt(request.getParameter("adminId")));
		bvb.setOsAccount(request.getParameter("osAccount"));
		bvb.setServerId(request.getParameter("serverId"));
		bvb.setServerId(request.getParameter("serverId"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
