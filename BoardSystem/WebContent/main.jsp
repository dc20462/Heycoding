<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// command를 list 로 설정해서 보낸다. //페이지 열리자마자 저기로 넘어간다
/* 	response.sendRedirect("member?command=list"); */
	response.sendRedirect("boardList.do");
/* url 프로토콜과 포함
uri리소스가 들은 뒤쪽 부분 */
%>
</body>
</html>