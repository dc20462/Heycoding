<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<div class="container p-5">
</div>
<div class="container">
	<h2>게시판</h2> 
		<p align="right"><a href="freeboardWriteForm.do">글쓰기</a>
	<table class="table table-info table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${freeboardList }" var="freeboard">
			<tr>
				<td>${freeboard.bno }</td>
				<td>
				<a href="freeboardView.do?bno=${freeboard.bno }&page=${pageMaker.currPage }">
				${freeboard.title } [${freeboard.reply_count }]</a>
				</td>
				<td>${freeboard.id }</td>
				<td>${freeboard.write_date }</td>
				<td>${freeboard.read_count }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<!-- 페이징 -->
	<nav>
		<c:if test="${pageMaker.prev }">
			<a href="freeboardList.do?page=${pageMaker.startPage-pageMaker.pageSize}">[이전]</a>
		</c:if> 
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="page">
			<c:choose>
				<c:when test="${page==pageMaker.currPage }">${page}</c:when>
				<c:otherwise>
					<a href="freeboardList.do?page=${page}">${page}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach> 
		<c:if test="${pageMaker.next }">
			<a href="freeboardList.do?page=${pageMaker.endPage+1}">[다음]</a>
		</c:if>
	</nav>	
</div>
	<!-- 부트스트랩 -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> 
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script> 
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>