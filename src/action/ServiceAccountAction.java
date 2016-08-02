package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bussiness;
import bean.Customer;
import bean.vo.BussinessViewBean;


/**
 * Servlet implementation class ServiceAccountAction
 */
@WebServlet(urlPatterns="/ServiceAccountAction")
public class ServiceAccountAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceAccountAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bussinessId = 0;
		if(request.getParameter("id")!=null&&request.getParameter("id")!=""){
			bussinessId = Integer.parseInt(request.getParameter("id"));
		}
		boolean b = true;
		BussinessViewBean bussinessViewBean = new BussinessViewBean();
		bussinessViewBean.setBussinessId(bussinessId);
		//b = b&&new BussinessViewBeanDaoImpl().del(bussinessViewBean);
		if(b){
			response.sendRedirect("service/service_list.jsp");
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
