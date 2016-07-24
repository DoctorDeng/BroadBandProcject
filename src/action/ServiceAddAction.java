package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.Customer;
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
		HttpSession session =request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		ServiceAddViewBean  sab = new ServiceAddViewBean();
		sab.setCustomerId(customer.getCustomerId());
		System.out.println(customer.getCustomerId());
		sab.setOsAccount(request.getParameter("osAccount"));
		sab.setOsPassword(request.getParameter("osPassword"));
		String traiffId = request.getParameter("traiffId");
		System.out.println(traiffId);
		sab.setTariffId(Integer.parseInt(traiffId));
		sab.setServerId(request.getParameter("serverIp"));
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
