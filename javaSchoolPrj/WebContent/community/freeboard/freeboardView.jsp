<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<!-- 유효성 검사 -->
	<!-- <form action="freeboardWrite.do" method="post"
	 enctype="multipart/form-data" name="freeboardform"> -->
	<div class="container pb-5">
		<img src="img/books.jpg">
	</div>
	<div class="container">
		<h2>자유게시판</h2>
		<hr />
		<div class="container p-3">
			<li>본 사이트는 대한민국 저작권법 및 개인정보보호법을 준수합니다.</li>
			<li>회원은 공공질서나 미풍양속에 위배되는 내용과 타인의 저작권을 포함한 지적재산권 및 기타 권리를 침해하는
				내용물은 등록할 수 없으며, 이러한 게시물로 인해 발생하는 결과의 모든 책임은 회원 본인에게 있습니다. 게시된 사진이나
				동영상은 요청 시에 삭제가능합니다. 관리자에게 문의바랍니다.</li>
			<li>개인정보보호법 제 59조, 3호에 따라 타인의 개인정보 (주민번호, 폰번호, 학년, 반, 번호, 학번,주소,
				혈액형 등)를 유출한 자는 처벌될 수 있으며, 등록된 글(텍스트, 이미지 등)에 대한 법적책임은 글쓴이에게 있습니다.</li>
		</div>
		<table class="table table-info table-hover">
			<tr>
				<th>번호</th>
				<td>${freeboard.bno}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${freeboard.id}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${freeboard.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${freeboard.content}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${freeboard.read_count}</td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="button" value="수정"
					onclick="location.href='freeboardUpdateForm.do?bno=${freeboard.bno}&page=${page}'">
					<input type="button" value="삭제"
					onclick="location.href='freeboardDelete.do?bno=${freeboard.bno}&page=${page}'">
					<input type="button" value="글목록보기"
					onclick="location.href='freeboardList.do'"></td>
			</tr>
		</table>
	</div>
	<div class="container my-5">
		<h5>댓글쓰기</h5>
		<form action="freereplyWrite.do">
			<input type="hidden" name="page" value="${page}"> <input
				type="hidden" name="bno" value="${freeboard.bno}"> <input
				type="hidden" name="id" value="${freeboard.id}">
			<table class="table-info table-hover">
				<tr>
					<td width="50">${freeboard.id }</td>
					<td width="400"><textarea name="content" rows=4 cols=50></textarea></td>
					<td width="50"><input type="submit" value="댓글등록"></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="container my-5">
		<h5>댓글리스트</h5>

		<div id="replyList">
			<table class="table-info table-hover">
				<c:choose>
					<c:when test="${freeboard.reply_count>0 }">
						<c:forEach items="${freereplyList }" var="reply">
							<tr>
								<td>${freereply.content }</td>
								<td>${freereply.id }</td>
								<td>${freereply.re_date }</td>
								<td><a
									href="freereplyDelete.do?rno=${freereply.rno }&page=${page}&bno=${freeboard.bno}">X</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td>등록된 댓글 없음</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
	<!-- 부트스트랩 -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>