package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.TariffDaoImpl;
import service.TariffService;

/**
 * Servlet implementation class TariffDelAction
 */
public class TariffDelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TariffDelAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		TariffDaoImpl tt = new TariffDaoImpl();
		String mm = request.getParameter("tariffId");
		int tariffId = 0;
		if (null != mm && !"".equals(mm)) {
			tariffId = Integer.parseInt(mm);
		}
		boolean isDel = tt.del(tariffId);
		request.getRequestDispatcher("/fee/fee_list.jsp").forward(request,response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
