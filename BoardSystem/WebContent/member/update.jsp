<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>**Update**</title>
</head>
<body>
	<form action="member" method="post">
		<input type="hidden" name="command" value="update">
		<table border=1>
			<tr>
				<th>아디</th>
				<td><input type="text" name="id" value="${member.id }" readonly></td>
			</tr>
			<tr>
				<th>비번</th>
				<td><input type="password" name="pw" value="${member.pw }"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${member.name }"></td>
			</tr>
			<tr>
				<th>젠더</th>
				<td>
				<!-- if else 대신 choose, otherwise -->
				<c:choose> 
				<c:when test="${member.gender=='M'}">
					남<input type="radio" name="gender" value="m" checked>
					여<input type="radio" name="gender" value="f">
				</c:when>
				<c:otherwise>
					남<input type="radio" name="gender" value="m">
					여<input type="radio" name="gender" value="f" checked>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="addr" value="${member.addr }"></td>
			</tr>
			<tr>
				<th>전화</th>
				<td><input type="text" name="tel" value="${member.tel }"></td>
			</tr>
			<td colspan=2>
			<input type="submit" value="update">
			<input type="button" value="delete" onclick="location.href='member?command=delete&id=${member.id }'">
			<input type="reset" value="reset">
			</td>
		</table>
		<!-- command 먼저 -->
	</form>
</body>
</html>