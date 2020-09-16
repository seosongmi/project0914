package freeBoard;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class freeBoardWriteServ extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public freeBoardWriteServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/board/freeBoardWrite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		freeBoardVO freeboard = new freeBoardVO();

		freeboard.setBoard_sub(request.getParameter("board_sub"));
		freeboard.setBoard_file(request.getParameter("board_file"));
		freeboard.setMember_id(request.getParameter("member_id"));

		// 첨부파일처리 부분
//		Part part = request.getPart("board_file");
//		if (part != null) {
//			String fileName = getBoard_File(part);
//			String path = request.getServletContext().getRealPath("/images");// "c:/upload";
//			System.out.println(path);
//			// 파일명 중복체크
//			File renameFile = FileRenamePolicy.rename(new File(path, fileName));
//			part.write(path + "/" + renameFile.getName());
//			freeboard.setBoard_file(renameFile.getName());			
//		}
//
		freeBoardDAO dao = new freeBoardDAO();// freeboard DAO 인서트
		dao.insert(freeboard);

//	}
	}
	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("board_file")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
