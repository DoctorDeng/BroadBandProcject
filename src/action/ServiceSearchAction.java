package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.viewBean.BussinessViewBean;
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
		//HttpSession session =request.getSession();
		String idNumber = request.getParameter("id").trim();
		String osAccount  = request.getParameter("osc").trim();
		String serviceIp = request.getParameter("sIp").trim();
		String status   =  request.getParameter("status").trim();
		System.out.println(idNumber);
		System.out.println(osAccount);
		System.out.println(serviceIp);
		System.out.println(status);
		ServiceAddViewBean serviceAddViewBean  =new ServiceAddViewBean();
		serviceAddViewBean.setIdNumber(idNumber);
		serviceAddViewBean.setOsAccount(osAccount);
		serviceAddViewBean.setServerId(serviceIp);
		serviceAddViewBean.setStatus(status);
		List<BussinessViewBean> lsa = new  BussinessViewBeanDaoImpl().findOne(serviceAddViewBean);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
