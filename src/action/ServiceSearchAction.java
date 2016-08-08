package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dto.OsDto;
import bean.dto.PageDto;
import bean.vo.ServiceAddViewBean;
import service.ProfessionService;

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
		String osAccount  = "#";
		 if(!(request.getParameter("osC") == "")){
			 osAccount = request.getParameter("osC");
		 }
		String serviceIp =  "#" ;
		if(!(request.getParameter("sIp") == "")){
			serviceIp = request.getParameter("sIp");
		}
		String status   =  request.getParameter("status");
		OsDto osD = new OsDto();
			osD.setIdNumber(idNumber);
			osD.setOsAccount(osAccount);
			osD.setServerIp(serviceIp);
			osD.setStatus(status);
		List<OsDto>	 lsa = new  ProfessionService().selForChoice(osD);
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
