package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoard.freeBoardDAO;
import freeBoard.freeBoardVO;


public class FreeBoardListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 freeBoardDAO DAO = new freeBoardDAO();//모든 데이터 다 들고오기
		 DAO.selectAll(); //db에서 실행한 모든 데이터를 가짐
		 ArrayList<freeBoardVO> list = DAO.selectAll(); //DB에서 조회한 모든데이터를 리스트에 담아둠
		 request.setAttribute("list", list); //데이터를 담아둔 리스트를 리퀘스트라는 변수안에 저장
		 request.getRequestDispatcher("freeBoard/freeBoardSelectAll.jsp").forward(request, response);
		 //jsp페이지로 화면이동 (jsp view)
	}

}
