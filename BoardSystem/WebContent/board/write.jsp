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
	<form action="boardWrite.do" method="post"
	 enctype="multipart/form-data" name="boardform">
	 <!-- 테이블 -->
		<table>
			<tr>
				<th>작성자</th><td><input type="text" name="member_id"></td>
			</tr>
			<tr>
				<th>제목</th><td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th><td><textarea rows=10 cols=50 name="content"></textarea></td>
			</tr>
			<tr>
				<th>파일첨부</th><td><input type="file" name="filename"></td>						
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