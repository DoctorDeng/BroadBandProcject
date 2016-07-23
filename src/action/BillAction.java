package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Page;
import bean.viewBean.BillDetailFormBean;
import bean.viewBean.BillFormBean;
import bean.viewBean.OsLoginFormBean;
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
			request.getRequestDispatcher("/bill/bill_list.jsp").forward(request, response);
			break;
		/**
		 * 显示详单信息
		 */
		case "showDetailBill":
			String billIdStr  = request.getParameter("billId");
			if (null == billIdStr | "".equals(billIdStr)) {
				billIdStr = "0";
			}
			List<BillDetailFormBean> billDetailList = 
					billService.getBillDetailForm(Integer.parseInt(billIdStr));
			request.setAttribute("billDetailForm", billDetailList);
			request.getRequestDispatcher("/bill/bill_item.jsp").forward(request, response);
			break;
		/**
		 * 展示账号登陆信息
		 */
		case "showLogin":
			String osIdStr  = request.getParameter("osId");
			if (null == osIdStr | "".equals(osIdStr)) {
				osIdStr = "0";
			}
			List<OsLoginFormBean> osLoginList = 
					billService.getOsLoginForm(Integer.parseInt(osIdStr));
			request.setAttribute("osLoginForm", osLoginList);
			request.getRequestDispatcher("/bill/bill_service_detail.jsp").forward(request, response);
			break;
		/**
		 * 通过分页来显示信息
		 */
		case "page":
			Page page = new Page();
			//int pageCount = billService.get
			int pageSize    = 4;
			int currentPage = 1;
			
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
