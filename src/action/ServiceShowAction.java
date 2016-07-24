package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Os;
import bean.viewBean.ServiceAddViewBean;
import dao.impl.BussinessViewBeanDaoImpl;

/**
 * Servlet implementation class ServiceShowAction
 */
public class ServiceShowAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceShowAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServiceAddViewBean serviceAddViewBean  =new ServiceAddViewBean();		
		serviceAddViewBean.setIdNumber( request.getParameter("id"));
		List<ServiceAddViewBean> lsa = new BussinessViewBeanDaoImpl().find(serviceAddViewBean);
		ServiceAddViewBean sa = new ServiceAddViewBean();
		for(ServiceAddViewBean sav : lsa){
			out.println(sav.getAdminId());
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
