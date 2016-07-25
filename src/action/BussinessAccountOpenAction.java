package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bussiness;
import dao.impl.BussinessDaoImpl;

/**
 * Servlet implementation class BussinessAccountOpenAction
 */
@WebServlet(name="BussinessAccountOpenAction",urlPatterns="/BussinessAccountOpenAction")
public class BussinessAccountOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BussinessAccountOpenAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String strId = request.getParameter("id");
		int bussinessId = -1;
		if(strId!=null&&!"".equals(strId)){
			bussinessId = Integer.parseInt(strId);
		}
		String status = request.getParameter("status");
		Bussiness b = new Bussiness();
		b.setBussinessId(bussinessId);
		b.setStatus(status);
		new BussinessDaoImpl().updateStatus(b);
		response.sendRedirect("http://localhost:8080/lanqiao/account/account_list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
