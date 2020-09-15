package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoard.freeBoardDAO;
import freeBoard.freeBoardVO;


public class FreeBoardWriteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		freeBoardVO freeboard = new freeBoardVO();
		System.out.println(request.getParameter("member_id"));
		freeboard.setBoard_no(Integer.parseInt(request.getParameter("board_no")));
		freeboard.setMember_id(request.getParameter("member_id"));
		freeboard.setBoard_sub(request.getParameter("board_sub"));
		freeboard.setBoard_content(request.getParameter("board_content"));
		
		freeBoardDAO DAO = new freeBoardDAO();
		DAO.insert(freeboard);
	}

}
