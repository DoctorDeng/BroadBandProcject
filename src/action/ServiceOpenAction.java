package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bussiness;
import bean.Customer;
import service.ProfessionService;

/**
 * Servlet implementation class ServiceOpenAction
 */
@WebServlet(urlPatterns="/ServiceOpenAction")
public class ServiceOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceOpenAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strId = request.getParameter("id");
		int bussinessId = -1;
		if(strId!=null&&!"".equals(strId)){
			bussinessId = Integer.parseInt(strId);
		}
		String status = request.getParameter("status");
		Customer customer = new Customer();
		customer.setCustomerId(bussinessId);
		if("1".equals(status)){
			customer.setStatus("0");
		}else if("0".equals(status)){
			customer.setStatus("1");
		}
		boolean b = new ProfessionService().upStutas(customer);
		if(b){
		response.sendRedirect(request.getContextPath()+"/service/service_list.jsp");
		}else{
			
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
