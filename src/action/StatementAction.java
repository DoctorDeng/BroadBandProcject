package action;

import java.io.IOException;
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
import bean.vo.StatementVo;
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
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		PageDto page       = new PageDto();
		int pageSize    = 4;	 		
 		int recordNum   = statementService.getMonthStatementCount();
 		int pageNum     = (int) Math.ceil((recordNum*1.0)/(pageSize*1.0));
 		String currentPageStr = request.getParameter("currentPage");
 		page.init(recordNum, pageSize, currentPageStr);
		
		switch (operation) {
		/**
		 * 显示默认报表信息
		 */
		case "default":
			List<StatementVo> statementList = statementService.getMonthStatementPage(page.getCurrentPage(),page.getPageSize());
			request.setAttribute("statementForm", statementList);
			request.setAttribute("page", page);
			request.setAttribute("operation", "default");
			request.getRequestDispatcher("/report/report_list.jsp").forward(request, response);
			break;
		/**
		 * 通过时长降序显示报表信息
		 */
		case "orderByDesc":
			List<StatementVo> statementListDesc = statementService.getMonthStatementPageByDesc(page.getCurrentPage(),page.getPageSize());
			request.setAttribute("statementForm", statementListDesc);
			request.setAttribute("page", page);
			request.setAttribute("operation", "orderByDesc");
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
