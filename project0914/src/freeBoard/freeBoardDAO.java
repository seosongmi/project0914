package freeBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.ConnectionManager;

public class freeBoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	//등록 
	   public int insert(freeBoardVO freeboardVO) {
	       int r = 0;
		   try {
	         conn = ConnectionManager.getConnnect();
	         String sql = "INSERT INTO BOARD (BOARD_NO, BOARD_SUB, MEMBER_ID,BOARD_CONTENT)"
	               + "VALUES (?,?,?,?)";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, freeboardVO.getBoard_no());
	         pstmt.setString(2, freeboardVO.getBoard_sub());
	         pstmt.setString(3, freeboardVO.getMember_id());
	         pstmt.setString(4, freeboardVO.getBoard_content());
	         r = pstmt.executeUpdate();
	         System.out.println(r + "건이 입력됨");

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         ConnectionManager.close(conn);
	      }
	   return r;
	   }
	   
	   //단건조회
//	   public freeBoardVO selectOne(freeBoardVO deptVO) {
//			 freeBoardVO resultVO = null;
//			 ResultSet rs = null;
//			 try {
//				 conn = ConnectionManager.getConnnect();
//				 String sql = "SELECT *"
//				 			+ " FROM board"
//				 		   +" order by no";
//				 pstmt = conn.prepareStatement(sql);
//				 pstmt.setInt(1, deptVO.getBoard_No());
//				rs = pstmt.executeQuery();
//				if(rs.next()) {
//					resultVO = new freeBoardVO();
//					resultVO.setBoard_No(rs.getInt("board_no"));
//					resultVO.setBoard_Sub(rs.getString("board_sub"));
//					resultVO.setBoard_File(rs.getString("board_file"));
//					resultVO.setMember_Id(rs.getString("member_id"));
//					resultVO.setBoard_GroupCode(rs.getInt("group_code"));
//				} else {
//					System.out.println("no data");
//				}
//			 }catch(Exception e) {
//				 e.printStackTrace();		 
//			 } finally {
//				 ConnectionManager.close(rs, pstmt, conn);
//			 }
//			return resultVO;
//		}
	   
	   
}
