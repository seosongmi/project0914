package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoard.freeBoardDAO;
import freeBoard.freeBoardVO;

public class FreeBoardDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		freeBoardVO freeboard = new freeBoardVO();
		freeboard.setBoard_no(board_no);
		freeBoardDAO DAO = new freeBoardDAO();
		DAO.delete(freeboard);
		
		
	}

}
