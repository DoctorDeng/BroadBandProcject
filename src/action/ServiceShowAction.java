package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.Customer;
import bean.Os;
import bean.dto.OsDto;
import bean.vo.ServiceAddViewBean;
import service.CustomerService;
import service.ProfessionService;

/**
 * Servlet implementation class ServiceShowAction
 */
@WebServlet(urlPatterns="/ServiceShowAction")
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
		OsDto 	osDto = new OsDto();
		osDto.setIdNumber( request.getParameter("id"));
		List<OsDto> lsa = new ProfessionService().upServiceT(osDto);
		for(OsDto sav : lsa){
			out.println(sav.getBussinessId());
			Customer customer = new Customer();
			customer.setCustomerId(sav.getCustomerId());
			Os os = new Os();
			os.setCustomer(customer);
			HttpSession session = request.getSession();
			session.setAttribute("os", os);
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
