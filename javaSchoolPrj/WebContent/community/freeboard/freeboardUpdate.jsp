<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<link rel="stylesheet" href="css/mainstyle.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form action="freeboardUpdate.do" method="post" 
enctype="multipart/form-data" name="freeboardform">
<input type="hidden" name="bno" value="${freeboard.bno}">
<input type="hidden" name="page" value="${page }">
<%-- <input type="hidden" name="nonMakeImg" value="${freeboard.filename}"> --%>
<table>
	<tr>
	<th>작성자</th><td><input type="text" name="id" value="${freeboard.id}"></td>
	</tr>
	<tr>
	<th>제목</th><td><input type="text" name="title" value="${freeboard.title}"></td>
	</tr>
	<tr>
	<th>내용</th><td><textarea rows=10 cols=50 name="content">${freeboard.content }</textarea></td>
	</tr>
	<tr>
	<td colspan=2 align="center">
		<input type="submit" value="수정">
		<input type="reset" value="다시쓰기">
		<input type="button" value="글목록보기" onclick="location.href='freeboardList.do'">
	</td>
	</tr>
</table>
</form>
<!-- 부트스트랩 -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>