package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dto.OsDto;
import bean.dto.PageDto;
import service.ProfessionService;

/**
 * Servlet implementation class ServiceListAction
 */
@WebServlet(urlPatterns="/ServiceListAction")
public class ServiceListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Object Listo = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	    /**
	     * 分页部分
	     */
		String currentPageStr = request.getParameter("curPage");  //当前页数
		int pageSize = 5; //每页显示的数据数目
		/**
		 * 获得总记录数
		 */
		PageDto pageDto = (new ProfessionService()).serviceListShow(currentPageStr, 5);
		session.setAttribute("pageDto", pageDto);
		response.sendRedirect("service/service_list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
