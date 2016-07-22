package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.viewBean.ServiceAddViewBean;
import dao.impl.BussinessViewBeanDaoImpl;

/**
 * Servlet implementation class ServiceAddAction
 */
public class ServiceAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServiceAddViewBean  sab = new ServiceAddViewBean();
		sab.setAdminId(Integer.parseInt(request.getParameter("adminId")));
		sab.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		sab.setOsLoginId(Integer.parseInt(request.getParameter("osLoginId")));
		sab.setIdNumber(request.getParameter("idNumber"));
		sab.setOsPassword(request.getParameter("osPassword"));
		sab.setTraiffName(request.getParameter("traiffName"));
		sab.setServerId(request.getParameter("serverId"));
		BussinessViewBeanDaoImpl bbdi = new BussinessViewBeanDaoImpl();
		boolean succiess = bbdi.add(sab);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
