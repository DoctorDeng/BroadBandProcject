package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.viewBean.ServiceAddViewBean;
import dao.impl.BussinessViewBeanDaoImpl;

/**
 * Servlet implementation class ServiceSearchAction
 */
@WebServlet(urlPatterns="/ServiceSearchAction")
public class ServiceSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceSearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		String idNumber = "#";
		 if(!(request.getParameter("idCard") == "")){
			 idNumber = request.getParameter("idCard");
		 }
		 System.out.println(idNumber);
		String osAccount  = "#";
		 if(!(request.getParameter("osC") == "")){
			 osAccount = request.getParameter("osC");
		 }
		 System.out.println(osAccount);
		String serviceIp =  "#" ;
		if(!(request.getParameter("sIp") == "")){
			serviceIp = request.getParameter("sIp");
		}
		String status   =  request.getParameter("status");
		ServiceAddViewBean serviceAddViewBean  =new ServiceAddViewBean();
		serviceAddViewBean.setIdNumber(idNumber);
		serviceAddViewBean.setOsAccount(osAccount);
		serviceAddViewBean.setServerId(serviceIp);
		serviceAddViewBean.setStatus(status);
		List<ServiceAddViewBean> lsa = new  BussinessViewBeanDaoImpl().findOne(serviceAddViewBean);
		//BussinessViewBean bussinessViewBean = new BussinessViewBean();
		for(ServiceAddViewBean sa :lsa){
			/*System.out.println(sa.getAdminId());
			System.out.println(sa.getBussinessId());
			System.out.println(sa.getCustomerName());*/
		}
		session.setAttribute("lsa", lsa);
		response.sendRedirect(request.getContextPath()+"/service/service_search.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
