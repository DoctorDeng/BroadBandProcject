package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.viewBean.BillDetailFormBean;
import bean.viewBean.BillFormBean;
import bean.viewBean.OsLoginFormBean;
import bean.viewBean.StatementFormBean;
import service.StatementService;

/**
 * Servlet implementation class StatementAction
 */
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
		switch (operation) {
		/**
		 * 显示默认报表信息
		 */
		case "default":
			List<StatementFormBean> statementList = statementService.getAllStatement();
			request.setAttribute("statementListForm", statementList);
			request.getRequestDispatcher("/report/report_list.jsp").forward(request, response);
			break;
		/**
		 * 通过时长降序显示报表信息
		 */
		case "orderByDesc":
			List<StatementFormBean> statementListDesc = statementService.getAllStatementByDesc();
			request.setAttribute("statementListForm", statementListDesc);
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
