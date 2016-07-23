package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TariffService;

/**
 * Servlet implementation class TariffAction
 */
public class TariffAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TariffAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TariffService tariffManage = new TariffService();
		/**
		 * 获取操作的类型，注意在jsp页面中应定义相应的隐藏字段，来代表操作的类型，
		 */
		/**
		 * 操作类型说明如下：  addTariff    添加资费信息
		 *              openTariff   开启资费
		 *              delTariff    删除资费
		 *              updateTariff 更新资费信息
		 */
		String operationType = request.getParameter("operation");
		switch(operationType) {
		case "addTariff":
			//具体获取参数，调用TariffManage的方法我就不写了，注意返回错误信息
			break;
		case "openTariff":
			break;
		case "delTariff":
			break;
		case "updateTariff":
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
