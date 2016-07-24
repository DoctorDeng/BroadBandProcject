package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Customer;
import dao.impl.CustomerDaoImpl;

/**
 * Servlet implementation class CustomerAction
 */
@WebServlet(urlPatterns="/CustomerAction")
public class CustomerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String customerName = new String(request.getParameter("customerName").getBytes("ISO-8859-1"),"UTF-8");
		String idNumber     = request.getParameter("idName");
		String phone        = request.getParameter("phone");
		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setIdNumber(idNumber);
		customer.setPhone(phone);
		boolean c = new CustomerDaoImpl().add(customer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
