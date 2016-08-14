package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.Customer;
import bean.dto.OsAddDto;
import bean.vo.ServiceAddViewBean;
import service.ProfessionService;

/**
 * Servlet implementation class ServiceAddAction
 */
@WebServlet(urlPatterns="/ServiceAddAction")
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
		OsAddDto  osAddDto = new OsAddDto();
		Customer customer = (Customer) session.getAttribute("c");
		osAddDto.setCustomerId(customer.getCustomerId());
		osAddDto.setOsAccount(request.getParameter("osAccount"));
		osAddDto.setOsPassword(request.getParameter("osPassword"));
		String traiffId = request.getParameter("traiffId");
		osAddDto.setTariffId(Integer.parseInt(traiffId));
		osAddDto.setServerIp(request.getParameter("serverIp"));
		boolean succiess =   new ProfessionService().addServiceOneInfo(osAddDto);
		if(succiess){
			response.sendRedirect("ServiceListAction");
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
