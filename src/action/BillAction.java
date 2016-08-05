package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.dto.PageDto;
import bean.vo.BillDetailFormBean;
import bean.vo.BillFormBean;
import bean.vo.OsLoginFormBean;
import service.BillService;

/**
 * Servlet implementation class BillAction
 */
@WebServlet(name="BillAction",urlPatterns="/BillAction")
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
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		String months   = request.getParameter("months");
		switch (operation) {
		/**
		 * 通过分页显示账单信息
		 */
		case "showBill":
			String currentPageStr = request.getParameter("currentPage");
			PageDto pageDto = billService.getMonthBillFormByPage(currentPageStr, 4);
	  		request.setAttribute("billPage", pageDto);
	  		request.setAttribute("isPage", "yes");
			request.getRequestDispatcher("/bill/bill_list.jsp").forward(request, response);
			break;
		/**
		 * 显示详单信息
		 */
		case "showDetailBill":
			String customerIdStr = request.getParameter("customerId");
			
			if (null == customerIdStr | "".equals(customerIdStr)) {
				customerIdStr = "0";
			}
			
			List<BillDetailFormBean> billDetails = 
					billService.getMonthBillDetailForm(Integer.parseInt(customerIdStr),months);
			
			request.setAttribute("billDetailForm",billDetails);
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
					billService.getOsLoginFormByMonth(Integer.parseInt(osIdStr),months);
			request.setAttribute("osLoginForm", osLoginList);
			request.getRequestDispatcher("/bill/bill_service_detail.jsp").forward(request, response);
			break;
		case "condition":
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
