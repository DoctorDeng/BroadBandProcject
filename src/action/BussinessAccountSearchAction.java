package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.vo.AccountViewBean;
import service.AccountService;

/**
 * Servlet implementation class BussinessAccountSearchAction
 */
@WebServlet("/BussinessAccountSearchAction")
public class BussinessAccountSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BussinessAccountSearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int currentPage = 0;
		if(request.getParameter("currentPage")!=null&&"".equals(request.getParameter("currentPage"))){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else{
			currentPage = 1;
		}
		String idNumber = request.getParameter("idNumber");
		String name = request.getParameter("name");
		String loginAccount = request.getParameter("loginAccount");
		String status = request.getParameter("sstatus");
		AccountViewBean a = new AccountViewBean();                                                                     
		a.setBussinessName(name);
		a.setIdNumber(idNumber);
		a.setStatus(status);
		a.setLoginAccount(loginAccount);
		List<AccountViewBean> l = new AccountService().searchAccountViewBean(a, currentPage);
		HttpSession session = request.getSession();
		session.setAttribute("ls", l);
		PrintWriter out = response.getWriter();
		for(AccountViewBean acc:l) {
			System.out.println("搜索到数据++++");
			out.println("<tr>");
			out.println("<td>"+acc.getBussinessId()+"</td>");
			out.println("<td><a href=\""+request.getContextPath()+"/BussinessAccountDetailAction?id="+acc.getBussinessId()+"\">"+acc.getBussinessName()+"</a><td>");
			out.println("<td>"+acc.getIdNumber()+"</td>");
			out.println("<td>"+acc.getLoginAccount()+"</td>");
			String statusValue = null;
			switch(acc.getStatus()) {
				case "0" :statusValue = "暂停";break;
				case "1" :statusValue = "开通";break;
				case "2" :statusValue = "删除";break;
				default  :statusValue = "";break;
			}
			out.println("<td>"+statusValue+"</td>");
			out.println("<td>"+acc.getCreateTime()+"</td>");
			out.println("<td>"+acc.getLastLoginTime()+"</td>");
			if(!"2".equals(acc.getStatus())) {
				out.println("<td class=\"td_modi\">");
				out.println("<input type=\"button\" value=\""+("1".equals(acc.getStatus())?"开通":"暂停")+"\" class=\"btn_pause\" onclick=\"location.href='"+request.getContextPath()+"/BussinessAccountOpenAction?id="+acc.getBussinessId()+"&status="+acc.getStatus()+"';\" />");
				out.println("<input type=\"button\" value=\"修改\" class=\"btn_modify\" onclick=\"location.href='account_modi.jsp?id="+acc.getBussinessId()+"';\" />");
				out.println("<input type=\"button\" value=\"删除\" class=\"btn_delete\" onclick=\"location.href='"+request.getContextPath()+"/BussinessAccountAction?id="+acc.getBussinessId()+"';\" />");
				out.println("</td>");
			}
			out.println("</tr>");
		}
		out.flush();
		out.close();
		//response.sendRedirect(request.getContextPath()+"/account/account_list.jsp?type=search&currentPage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
