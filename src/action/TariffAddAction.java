package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Tariff;
import service.TariffService;

/**
 * Servlet implementation class TariffAction
 */
@WebServlet(urlPatterns="/TariffAddAction")
public class TariffAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TariffAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TariffService tariffManage = new TariffService();
		
			TariffService tar= new TariffService();
			Tariff t = new Tariff();
			String tariffName = request.getParameter("tariffName");
			t.setTariffName(tariffName);
			String tariffType = request.getParameter("tariffType");
			/*t.setTariff(Double.parseDouble(request.getParameter("tariff")));
			t.setTimeLong(Integer.parseInt(request.getParameter("timeLong")));
			t.setTimeTariff(Integer.parseInt(request.getParameter("timeTariff")));*/
			t.setCreateTime(request.getParameter("createTime"));
			t.setTariffType(request.getParameter("tariffType"));
			t.setTariffExplain(request.getParameter("tariffExplain"));
			
			
			String aaa = request.getParameter("timeTariff");
			int timeTariff = 0;
			if (null != aaa && !"".equals(aaa)) {
				timeTariff = Integer.parseInt(aaa);
			}
			t.setTimeTariff(timeTariff);
			String bbb = request.getParameter("tariff");
			double tariff = 0;
			if (null != bbb && !"".equals(bbb)) {
				tariff = Double.parseDouble(bbb);
			}
			t.setTariff(tariff);
			String ccc = request.getParameter("timeLong");
			int timeLong = 0;
			if (null != ccc && !"".equals(ccc)) {
				timeLong = Integer.parseInt(ccc);
			}
			t.setTimeLong(timeLong);
			boolean isAdd = tar.addTariff(t);
			if (isAdd) {
				response.sendRedirect(request.getContextPath()+"/fee/fee_list.jsp");
			} else {
				response.sendRedirect(request.getContextPath()+"/operationError.jsp");
			}
		/*	
			TariffManage tt = new TariffManage();
			String tariffId = request.getParameter("tariffId");
			boolean isOpen = tt.openTariff(Integer.parseInt(tariffId));
			break;
		case "delTariff":
			TariffManage ttt = new TariffManage();
			String tariffIdone = request.getParameter("tariffId");
			boolean isDel = ttt.openTariff(Integer.parseInt(tariffIdone));
			break;
		case "updateTariff":
			
			break;
		}*/
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
