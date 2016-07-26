package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bussiness;
import bean.Customer;
import dao.impl.BussinessDaoImpl;
import dao.impl.CustomerDaoImpl;

/**
 * Servlet implementation class BussinessAccountAction
 */
@WebServlet(name="BussinessAccountAction",urlPatterns="/BussinessAccountAction")
public class BussinessAccountAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BussinessAccountAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int bussinessId = 0;
		if(request.getParameter("id")!=null&&request.getParameter("id")!=""){
			String bus = request.getParameter("id");
			bussinessId = Integer.parseInt(bus);
		}
		boolean b = true;
		int customerId = new BussinessDaoImpl().findOne(bussinessId).getCustomerId();
		System.out.println(customerId);
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		b = b&&new CustomerDaoImpl().del(customer);
		
		Bussiness bussiness = new Bussiness();
		bussiness.setBussinessId(bussinessId);
		b = b&&new BussinessDaoImpl().del(bussiness);
		if(b){
			response.sendRedirect("account_list.jsp");
		}
		response.sendRedirect(request.getContextPath()+"/account/account_list.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
