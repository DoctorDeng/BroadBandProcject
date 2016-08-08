package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.Os;
import service.OsLoginService;
import service.ProfessionService;
import util.IpUtil;

/**
 * Servlet implementation class OsLoginAction
 */
@WebServlet(name="OsLoginAction",urlPatterns="/OsLoginAction")
public class OsLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OsLoginAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OsLoginService osLoginService = new OsLoginService();
		ProfessionService professionService = new ProfessionService();
		HttpSession session = request.getSession();
		
		String operation = request.getParameter("operation");
		
		if (null == operation | "".equals(operation)) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		PrintWriter out = response.getWriter();
		
		switch(operation) {
		
		case "login":
			String osAccount = request.getParameter("osAccount");
			String password  = request.getParameter("password");
			String loginIp   = IpUtil.getIpAddr();
			Os os = professionService.selOsAcAndOsPa(osAccount, password);
			if (os == null) {
				response.sendRedirect("loginFail.jsp");
			} else {
				request.getSession().setAttribute("os", os);
				int osLoginId  = osLoginService.recordOsLogin(os.getOsId(), loginIp);
				if (osLoginId == 0) {
					response.sendRedirect("loginFail.jsp");
				} else {
					request.getSession().setAttribute("osLoginId", osLoginId);
					response.sendRedirect("simulationOsLogin/loginOut.jsp");
				}
			}
			break;
		case "loginOut":
			Object osLoginIdObj =session.getAttribute("osLoginId");
			if (null == osLoginIdObj) {
				out.print("登陆超时,请重新登陆");
			} else {
				int osLoginId = Integer.parseInt(osLoginIdObj.toString());
				boolean result = osLoginService.recordOsLoginOut(osLoginId);
				if (result) {
					
				} else {
					out.print("登出发生异常,请重新登陆");
				}
			}
			break;
		case "showLoginTime":
			break;
		case "showConsume":
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
