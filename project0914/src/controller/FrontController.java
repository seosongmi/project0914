package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet( name = "front",
//			urlPatterns="*.do", 
//			initParams =
//		{
//				@WebInitParam(name="charset", value="UTF-9")
//		})


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String charset = null;
	HashMap<String, Controller> list = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/freeBoardwrite.do", new FreeBoardWriteController());
		list.put("/freeBoardList.do", new FreeBoardListController());
		list.put("/freeBoardDelete.do", new FreeBoardDeleteController());
		list.put("/freeBoardUpdate.do", new FreeBoardUpdateController());
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding(charset);
//	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		String uri = request.getRequestURI();            // frontWeb/memberInsert.do
		String contextPath = request.getContextPath();   // frontWeb
		String path = uri.substring(contextPath.length()); // /memberInsert.do
		Controller subController = list.get(path);
		subController.execute(request, response);
		
		
	}

}
