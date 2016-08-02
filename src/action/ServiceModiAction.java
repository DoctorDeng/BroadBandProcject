package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.vo.BussinessViewBean;
import bean.vo.ServiceAddViewBean;

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
		bussinessViewBean.setOsAccount(request.getParameter("osAccount"));
		bussinessViewBean.setTariffId(Integer.parseInt(tariffId));
		//boolean b = new BussinessViewBeanDaoImpl().update(bussinessViewBean);
		/*if(b){
			response.sendRedirect("ServiceMainAction");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
