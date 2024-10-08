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
							<li><a class="dropdown-item" href="#">1</a></li>
							<li><a class="dropdown-item" href="#">2</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">3</a></li>
						</ul></li>
				</ul>
				<form class="d-flex" role="search" action="search">
					<select name="searchBy" class="form-select" style="width: 100px;">
						<option value="title">제목</option>
						<option value="content"
							<c:if test="${searchBy=='content' }">selected="selected"</c:if>>내용</option>
						<option value="writerName"
							<c:if test="${searchBy=='writerName' }">selected="selected"</c:if>>작성자</option>
					</select> <input class="form-control me-2" type="Search" placeholder="검색"
						aria-label="Search" name="searchKeyword">
					<button class="btn btn-outline-success" type="submit">
						<img
							src="${pageContext.request.contextPath }/assets/brand/search.svg">
					</button>
				</form>
			</div>
		</div>
	</nav>
</body>
</html>