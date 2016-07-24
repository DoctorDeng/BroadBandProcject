package action;

import java.io.IOException;
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
import bean.viewBean.StatementFormBean;
import service.StatementService;

/**
 * Servlet implementation class StatementAction
 */
@WebServlet(urlPatterns="/StatementAction")
public class StatementAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StatementService statementService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatementAction() {
        super();
        statementService = new StatementService();
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
		Page page       = new Page();
		int pageSize    = 4;
  		int currentPage = 1;
  		int indexPage   = 1;
		int nextPage    = 1;
 		int upPage      = 1;	 		
 		int recordNum   = statementService.getStatementCount();
 		System.out.println(recordNum);
 		int pageNum     = (int) Math.ceil(recordNum/pageSize)+1;
 		int endPage     = pageNum;
 		
 		String currentPageStr = request.getParameter("currentPage");
		if (null !=currentPageStr && !"".equals(currentPageStr)) {
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
		
		switch (operation) {
		/**
		 * 显示默认报表信息
		 */
		case "default":
			List<StatementFormBean> statementList = statementService.getStatementPage(currentPage,pageSize);
			request.setAttribute("statementForm", statementList);
			request.getRequestDispatcher("/report/report_list.jsp").forward(request, response);
			break;
		/**
		 * 通过时长降序显示报表信息
		 */
		case "orderByDesc":
			List<StatementFormBean> statementListDesc = statementService.getStatementPageByDesc(currentPage,pageSize);
			request.setAttribute("statementForm", statementListDesc);
			request.getRequestDispatcher("/report/report_list.jsp").forward(request, response);
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
