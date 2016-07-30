package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapper.impl.AdminDaoImpl;

/**
 * Servlet implementation class ResetPasswords
 */
public class ResetPasswords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AdminDaoImpl resetPwd ;
    public ResetPasswords() {
        super();
        resetPwd = new AdminDaoImpl();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String[] admins =request.getParameterValues("check");
	    /*if(admins.length==0){
	          
	    }*/
	    int[] adminIds = new int[admins.length];
        for (int i=0; i<adminIds.length; i++) {
        	adminIds[i] = Integer.parseInt(admins[i]);
        }
        
	    boolean resetResult = resetPwd.resetAdminsPassword(adminIds);
	    if(resetResult){
	    	
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
