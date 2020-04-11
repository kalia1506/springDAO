package kcp.spring.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kcp.spring.service.PlayerMngmtService;

@WebServlet(value = "/player", loadOnStartup = 1)
public class PlayerController extends HttpServlet {
	ApplicationContext context = null;
	private final String path = "kcp/spring/configuration/applicationContext.xml";

	public PlayerController() {
		System.out.println("PlayerController.PlayerController()");
	}

	@Override
	public void init() throws ServletException {
		context = new ClassPathXmlApplicationContext(path);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlayerMngmtService service = null;
		RequestDispatcher rd = null;
		String[] playerType = request.getParameterValues("type");
		System.out.println(Arrays.toString(playerType));
		service = context.getBean("playerService", PlayerMngmtService.class);
		List<Map<String, Object>> SearchData = service.fatchPlayerByType(playerType);
		System.out.println(SearchData);
		request.setAttribute("listData", SearchData);
		rd = request.getRequestDispatcher("/ShowPlayerData.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
