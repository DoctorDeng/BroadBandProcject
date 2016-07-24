package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.viewBean.BussinessViewBean;
import bean.viewBean.ServiceAddViewBean;
import dao.impl.BussinessViewBeanDaoImpl;

/**
 * Servlet implementation class ServiceModiAction
 */
@WebServlet(urlPatterns="/ServiceModiAction")
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
		BussinessViewBean bussinessViewBean  = new BussinessViewBean();
		String tariffId = request.getParameter("traiffId");
		/*System.out.println(request.getParameter("traiffId"));
		System.out.println(request.getParameter("osAccount"));*/
		bussinessViewBean.setOsAccount(request.getParameter("osAccount"));
		bussinessViewBean.setTariffId(Integer.parseInt(tariffId));
		boolean b = new BussinessViewBeanDaoImpl().update(bussinessViewBean);
		if(b){
			response.sendRedirect("ServiceMainAction");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
