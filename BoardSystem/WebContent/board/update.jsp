<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 유효성 검사 -->
	<form action="boardUpdate.do" method="post"
	 enctype="multipart/form-data" name="boardform">
	<input type="hidden" name="bno" value="${board.bno}">
	<!-- 원이미지파일이름을 넣으려면 hidden으로 가져와야한다. -->
	<input type="hidden" name="page" value="${page}">
	<input type="hidden" name="nonMakeImg" value="${board.filename}">
	
	 <!-- 테이블 -->
		<table>
			<tr>
				<th>작성자</th><td><input type="text" name="member_id" value="${board.member_id}"></td>
			</tr>
			<tr>
				<th>제목</th><td><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<th>내용</th><td><textarea rows=10 cols=50 name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<th>파일첨부</th><td><input type="file" name="filename">${board.filename}</td>						
				<%-- <input type="file" name="filename" value="${board.filename}"></td> 이게 안된다. input할게 아니고 보여주기만 하니까.--%>
			</tr>
			<tr>
				<td colspan=2 align="center">
					<input type="submit" value="등록">
					<input type="reset" value="다시쓰기">
					<input type="button" value="목록보기" onclick="location.href='boardList.do'">
					<!-- 기본 주소는 context밑임 -->
				</td>						
			</tr>
		</table>	
	</form>
</body>
</html>