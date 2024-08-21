<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<nav class="navbar navbar-expand-lg bg-body-secondary"
		style="border: 2px solid rgb(134, 134, 134);">
		<div class="container-fluid">
			<a class="navbar-brand" href="list"><img
				src="${pageContext.request.contextPath }/assets/brand/box-fill.svg"
				style="width: 50px; height: 50px;"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="list">메인 페이지</a></li>
					<li class="nav-item"><c:choose>
							<c:when test="${memberNo != null }">
								<a class="nav-link" href="logout">로그아웃</a>
							</c:when>
							<c:otherwise>
								<a class="nav-link" href="login">로그인</a>
							</c:otherwise>
						</c:choose></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> 메뉴 </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">아직</a></li>
							<li><a class="dropdown-item" href="#">아무 것도</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">없지롱</a></li>
						</ul></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="검색"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">
						<img
							src="${pageContext.request.contextPath }/assets/brand/search.svg">
					</button>
				</form>
			</div>
		</div>
	</nav>
	<div style="padding: 50px;">
		<table class="table table-bordered">
			<thead class="table-light">
				<tr>
					<th class="num" width="60px">번호</th>
					<th class="title" width="100px">제목</th>
					<th class="writer" width="100px">작성자</th>
					<th class="regtime" width="250px">작성일시</th>
					<th width="60px">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="msg" items="${msgList}">
					<tr>
						<td>${msg.num}</td>
						<td style="text-align: left;"><a
							href="view?num=${msg.num}&page=${param.page}"> ${msg.title} </a></td>
						<td>${msg.name}</td>
						<td>${msg.regtime}</td>
						<td>${msg.hits}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<button class="btn btn-outline-primary"
			onclick="location.href='write'" <c:if test="${memberNo == null }">disabled</c:if>>글쓰기</button>
		<c:choose>
			<c:when test="${memberNo != null}">
				<button class="btn btn-outline-success"
					onclick="location.href='logout'">로그아웃</button>
			</c:when>
			<c:otherwise>
				<button class="btn btn-outline-success"
					onclick="location.href='login'">로그인</button>
			</c:otherwise>
		</c:choose>
		<br>
		<div style="text-align: center;">
			<c:forEach var="pgn" items="${pgnList}">
				<button
					class=<c:choose>
						<c:when test="${pgn.curPage}">
							"btn btn-secondary"
						</c:when>
						<c:otherwise>
                     "btn btn-light"
                 </c:otherwise>
					</c:choose>
					onclick="location.href='list?page=${pgn.pageNo}'">
					<c:choose>
						<c:when test="${pgn.curPage}">
							${pgn.display}
						</c:when>
						<c:otherwise>
                     ${pgn.display}
                 </c:otherwise>
					</c:choose>

				</button>
				<a class="pgn" href=""> </a>&nbsp;
    </c:forEach>
		</div>


	</div>
</body>
</html>