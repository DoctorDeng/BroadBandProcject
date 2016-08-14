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
import util.StringUtil;

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
		Object osLoginIdObj =session.getAttribute("osLoginId");
		Object osObj  = session.getAttribute("os");
		
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
			System.out.println("正在登出");
			if (null == osLoginIdObj | null == osObj) {
				out.print("登陆超时,请重新登陆");
			} else {
				int osLoginId = Integer.parseInt(osLoginIdObj.toString());
				Os osTemp = (Os) osObj;
				
				boolean result = osLoginService.recordOsLoginOut(osLoginId);
				if (result) {
					double loginTariff = osLoginService.countLoginTariff(osLoginId, osTemp);
					/**
					 * 向数据库OsLogin插入本次费用
					 */
					out.println("本次登陆费用: " + loginTariff+"元");
				} else {
					out.print("登出发生异常,请重新登陆");
				}
			}
			break;
		case "showLoginTime":
			if (null == osLoginIdObj) {
				out.print("登陆超时,请重新登陆");
			} else {
				String loginInTime = osLoginService.showLoginInTime(Integer.parseInt(osLoginIdObj.toString()));
				if (StringUtil.isNull(loginInTime)) {
					out.print("对不起,查询出错");
				} else {
					out.print("登入时间:"+loginInTime);
				}
			}
			break;
		case "showConsume":
			if (null == osLoginIdObj | null == osObj) {
				out.print("登陆超时,请重新登陆");
			} else {
				Os osTemp1  = (Os) osObj;
				double cost = osLoginService.getOsMonthTariff(osTemp1);
				out.print("本月消费为: " + cost +"元");
			}
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
