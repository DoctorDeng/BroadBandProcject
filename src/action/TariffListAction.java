package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Tariff;
import bean.dto.PageDto;
import service.TariffService;

/**
 * Servlet implementation class TariffListAction
 */
@WebServlet(urlPatterns="/TariffListAction")
public class TariffListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TariffListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // TODO Auto-generated method stub
		  String currentPageStr = request.getParameter("currentPage");
		  TariffService tm = new TariffService();
          List<Tariff> tv = tm.getShowMessage();
          request.getSession().setAttribute("tariffs",tv );
          /*response.sendRedirect(request.getContextPath()+"/fee/fee_list.jsp");
          PageDto<Tariff> pagedto = tm.selectFromPage(currentPageStr, 4);
			session.setAttribute("adminPage", pagedto);
			session.setAttribute("isPage", true);
		    response.sendRedirect("admin/admin_list.jsp");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
