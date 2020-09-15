<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/freeBoardwrite.do" 
		enctype="multipart/form-data">
		<div>
			<label>글번호</label> 
			<input type="text" name="board_no" />
		</div>
		<div>
			<label>제목</label> 
			<input type="text" name="board_sub" />
		</div>
		<div>
			<label>아이디</label> 
			<input type="text" name="member_id" />
		</div>
		<div>
			<label>내용</label>
			<textarea name="board_contents" ></textarea>
		</div>
		<div>
			<button>등록</button>
		</div>		
	</form>
</body>
</html>