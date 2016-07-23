package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Tariff;
import service.TariffService;

/**
 * Servlet implementation class TariffUpdateAction
 */
public class TariffUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TariffUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		TariffService tar= new TariffService();
		Tariff t = new Tariff();
		String ss = request.getParameter("tariffId");
		int tariffId = 0;
		if (null != ss && !"".equals(ss)) {
			tariffId = Integer.parseInt(ss);
		}
		t.setTariffId(tariffId);
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
		boolean a = tar.updateTariff(t);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
