package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.vo.BussinessViewBean;
import bean.vo.ServiceAddViewBean;
import service.ProfessionService;

/**
 * Servlet implementation class ServiceDetailAction
 */
@WebServlet(urlPatterns="/ServiceDetailAction")
public class ServiceDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String bussinessId = request.getParameter("bussinessId");
		ServiceAddViewBean serviceAddViewBean = new ServiceAddViewBean();
		serviceAddViewBean.setBussinessId(Integer.parseInt(bussinessId));
		List<ServiceAddViewBean>  lsit = new ProfessionServiceImpl().toShowService(serviceAddViewBean);
		HttpSession  session = request.getSession();
		session.setAttribute("lsit", lsit);
		response.sendRedirect("service/service_detail.jsp");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
