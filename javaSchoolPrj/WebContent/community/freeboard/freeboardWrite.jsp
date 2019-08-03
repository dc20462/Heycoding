<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글쓰기</title>
</head>
<body>
<form action="freeboardWrite.do" method="post" 
enctype="multipart/form-data" name="freeboardform">
<table>
	<tr>
	<th>작성자</th><td><input type="text" name="id"></td>
	</tr>
	<tr>
	<th>제목</th><td><input type="text" name="title"></td>
	</tr>
	<tr>
	<th>내용</th><td><textarea rows=10 cols=50 name="content"></textarea></td>
	</tr>
	<tr>
	<td colspan=2 align="center">
		<input type="submit" value="등록">
		<input type="reset" value="다시쓰기">
		<input type="button" value="글목록보기" onclick="location.href='freeboardList.do'">
	</td>
	</tr>
</table> 
</form>
</body>
</html>