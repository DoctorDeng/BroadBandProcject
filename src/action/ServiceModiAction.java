package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Tariff;
import bean.dto.OsDto;
import service.ProfessionService;

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
		OsDto osDto  = new OsDto();
		/*String tariffName = request.getParameter("traiffName");
		Tariff tariff = new ProfessionService().selTarriffId(tariffName);
		int tariffId = tariff.getTariffId();*/
		int tariffId = Integer.parseInt(request.getParameter("tariffId"));
		osDto.setOsAccount(request.getParameter("osAccount"));
		osDto.setTariffId(tariffId);
		boolean b = new ProfessionService().upForOneService(osDto);
		if(b){
			response.sendRedirect("ServiceListAction");
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
