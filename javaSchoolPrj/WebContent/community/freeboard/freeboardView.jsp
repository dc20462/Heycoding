<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>

<table border=1>
	<tr>
	<th>게시물 번호</th><td>${freeboard.bno}</td>
	</tr>
	<tr>
	<th>작성자</th><td>${freeboard.id}</td>
	</tr>
	<tr>
	<th>제목</th><td>${freeboard.title}</td>
	</tr>
	<tr>
	<th>내용</th><td>${freeboard.content}</td>
	</tr>
	<tr>
	<th>조회수</th><td>${freeboard.read_count}</td>
	</tr>
	<tr>
	<td colspan=2 align="center">
		<input type="button" value="수정" onclick="location.href='freeboardUpdateForm.do?bno=${freeboard.bno}&page=${page}'">
		<input type="button" value="삭제" onclick="location.href='freeboardDelete.do?bno=${freeboard.bno}&page=${page}'">
		<input type="button" value="글목록보기" onclick="location.href='freeboardList.do'">
	</td>
	</tr>
</table>
</body>
</html>