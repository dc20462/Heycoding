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
<div class="container pb-5">
	<img src="img/top.jpg">
</div>
<div class="container">
	<h2>자유게시판</h2>
	<hr/>
	<div class="container p-3">
	<li>본 사이트는 대한민국 저작권법 및 개인정보보호법을 준수합니다.</li>
	<li>회원은 공공질서나 미풍양속에 위배되는 내용과 타인의 저작권을 포함한 지적재산권 및 기타 권리를 침해하는
	내용물은 등록할 수 없으며, 이러한 게시물로 인해 발생하는 결과의 모든 책임은 회원 본인에게 있습니다.
	게시된 사진이나 동영상은 요청 시에 삭제가능합니다. 관리자에게 문의바랍니다.</li>
	<li>개인정보보호법 제 59조, 3호에 따라 타인의 개인정보
	(주민번호, 폰번호, 학년, 반, 번호, 학번,주소, 혈액형 등)를
	 유출한 자는 처벌될 수 있으며, 등록된 글(텍스트, 이미지 등)에 대한 법적책임은 글쓴이에게 있습니다.</li>
	</div> 
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