package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.viewBean.BillFormBean;
import service.BillService;

/**
 * Servlet implementation class BillAction
 */
public class BillAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BillService billService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillAction() {
        super();
        billService = new BillService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		
		if (null == operation | "".equals(operation)) {
			response.sendRedirect("/lanqiao/login.jsp");
			return;
		}
		switch (operation) {
		/**
		 * 显示账单信息
		 */
		case "showBill":
			List<BillFormBean> billList = billService.getBill();
			request.setAttribute("billForm", billList);
			request.getRequestDispatcher("").forward(request, response);
			break;
		/**
		 * 显示详单信息
		 */
		case "showDetailBill":
			
			break;
		/**
		 * 展示账号登陆信息
		 */
		case "showLogin":
			
			break;
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
