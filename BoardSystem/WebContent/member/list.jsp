<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
	<tr><td colspan=6 align="right"><a href="member?command=joinForm">가입</a></td></tr>
		<tr>
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>성별</th><th>주소</th><th>전화번호</th>
		</tr>
			<!-- memberlist에서 하나를 꺼내서 member할당 -->
		<c:forEach items="${memberList}" var ="member">
		<tr>
		<!-- Memeber.java 에 있는 필드변수 이름을 따라간다. ${} : el(expression language) 방식 -->
		<td><a href="member?command=updateForm&id=${member.id }">${member.id }</a></td>
		<!-- id를 누르면 연결된다  member.getid -->
		<td>${member.pw }</td>
		<td>${member.name }</td>
		<td>${member.gender }</td>
		<td>${member.addr }</td>
		<td>${member.tel }</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr><td colspan=6 align="right"><a href="member?command=joinForm">가입</a></td></tr>
		<tr>
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>성별</th><th>주소</th><th>전화번호</th>
		</tr>
		<!-- memberList에 있는 값 하나하나를 가지고와서 할당 -->
		<c:forEach items="${memberList}" var ="member">
		<tr>
		<!-- Memeber.java 에 있는 필드변수 이름을 따라간다. -->
		<td><a href="member?command=updateForm&id=${member.id }">${member.id }</a></td>
		<td>${member.pw }</td>
		<td>${member.name }</td>
		<td>${member.gender }</td>
		<td>${member.addr }</td>
		<td>${member.tel }</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>