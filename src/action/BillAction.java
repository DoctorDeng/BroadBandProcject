package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
			response.sendRedirect("/lanqiao/login.jsp");
			return;
		}
		switch (operation) {
		/**
		 * 通过分页显示账单信息
		 */
		case "showBill":
			Page page       = new Page();
			int pageSize    = 4;
	  		int currentPage = 1;
	  		int indexPage   = 1;
			int nextPage    = 1;
	 		int upPage      = 1;	 		
	 		int recordNum   = billService.getBillFormSize();
	 		int pageNum     = (int) Math.ceil(recordNum/pageSize)+1;
	 		int endPage     = pageNum;
	 		
	 		String currentPageStr = request.getParameter("currentPage");
			if (null !=currentPageStr && !"".equals(currentPageStr)){
				currentPage = Integer.parseInt(currentPageStr);
			}
					
			if (currentPage!=1 && pageNum > 1) {
	  			upPage = currentPage - 1; 
	  		}
	  		if (currentPage<pageNum && pageNum>2) {
	  			nextPage = currentPage +1;
	  		}
	  		if (currentPage== pageNum) {
	  			nextPage = pageNum;
	  		}
	  		page.setIndexPage(indexPage);
	  		page.setEndPage(endPage);
	  		page.setNextPage(nextPage);
	  		page.setUpPage(upPage);
	  		page.setCurrentPage(currentPage);
	  		
	  		List<BillFormBean> billFormList = billService.getBillFormByPage((currentPage-1)*pageSize, pageSize);
	  		request.setAttribute("billForm", billFormList);
	  		request.setAttribute("page", page);
	  		request.setAttribute("isPage", "yes");
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
		case "condition":
			/*String idNumber = request.getParameter("idNumber");
			String loginAccount = request.getParameter("loginAccount");
			String customerName = java.net.URLDecoder.decode(request.getParameter("customerName"), "UTF-8");
			List<BillFormBean> billFormListTemp = billService.getBillFormByCondition(idNumber, loginAccount, customerName);
			if(billFormListTemp.size() >7) {
				List<BillFormBean> manyBillFrom = new ArrayList<>();
				for (int i=0; i<7;i ++) {
					manyBillFrom.add(billFormListTemp.get(i));
				}
				request.setAttribute("billForm", billFormListTemp);
				request.setAttribute("isPage", "no");
				request.getRequestDispatcher("/bill/bill_list.jsp").forward(request, response);
			}
			request.setAttribute("isPage", "no");
			request.setAttribute("billForm", billFormListTemp);
			request.getRequestDispatcher("/bill/bill_list.jsp").forward(request, response);
			break;*/
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
