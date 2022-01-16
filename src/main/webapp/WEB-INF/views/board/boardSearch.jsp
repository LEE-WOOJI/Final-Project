<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
</head>
<style>
body {
	margin: 0;
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
	font-size: .88rem;
	font-weight: 400;
	line-height: 1.5;
	color: #495057;
	text-align: left;
	background-color: #eef1f3
}

.mt-100 {
	margin-top: 80px
}

.card {
	box-shadow: 0 0.46875rem 2.1875rem rgba(4, 9, 20, 0.03), 0 0.9375rem
		1.40625rem rgba(4, 9, 20, 0.03), 0 0.25rem 0.53125rem
		rgba(4, 9, 20, 0.05), 0 0.125rem 0.1875rem rgba(4, 9, 20, 0.03);
	border-width: 0;
	transition: all .2s
}

.card-header:first-child {
	border-radius: calc(.25rem - 1px) calc(.25rem - 1px) 0 0
}

.card-header {
	display: flex;
	align-items: center;
	border-bottom-width: 1px;
	padding-top: 0;
	padding-bottom: 0;
	padding-right: .625rem;
	height: 3.5rem;
	background-color: #fff;
	border-bottom: 1px solid rgba(26, 54, 126, 0.125)
}

.btn-primary.btn-shadow {
	box-shadow: 0 0.125rem 0.625rem rgba(63, 106, 216, 0.4), 0 0.0625rem
		0.125rem rgba(63, 106, 216, 0.5)
}

.btn.btn-wide {
	padding: .375rem 1.5rem;
	font-size: .8rem;
	line-height: 1.5;
	border-radius: .25rem
}

.btn-primary {
	color: #fff;
	background-color: #3f6ad8;
	border-color: #3f6ad8
}

.form-control {
	display: block;
	width: 100%;
	height: calc(2.25rem + 2px);
	padding: .375rem .75rem;
	font-size: 1rem;
	font-weight: 400;
	line-height: 1.5;
	color: #495057;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
	border-radius: .25rem;
	transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out
}

.card-body {
	flex: 1 1 auto;
	padding: 1.25rem
}

.flex-truncate {
	min-width: 0 !important
}

.d-block {
	display: block !important
}

a {
	color: #E91E63;
	text-decoration: none !important;
	background-color: transparent
}

.media img {
	width: 40px;
	height: auto
}

#writeBtn {
	background-color: transparent;
	border: 1px solid black;
	border-radius: 3px;
}

#writeBtn:hover {
	background-color: black;
	color: white;
	border: 1px solid black;
	border-radius: 3px;
}

#search {
	background-color: transparent;
	border: 1px solid transparent;
	border-radius: 3px;
}

.td {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	max-width: 130px;
}

#board-title {
	text-align: center;
	height: 100px;
	line-height: 100px;
	padding: 100px 0;
}

#title {
	width: 50px;
	height: 50px;
}

@font-face {
	font-family: 'yg-jalnan';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

.pagination.justify-content-center>li>a {
	color: black;
}

.pagination.justify-content-center>li>a:hover {
	background-color: black;
	color: white;
}
</style>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

	<div class="container-fluid mt-100">

		<!-- 타이틀  -->
		<div class="container-fluid mt-100">
			<div id="board-title"
				style="font-family: 'yg-jalnan', verdana, tahoma;">
				<img id="title" src="/assets/img/board.jpg">&ensp;<span><b>자유
						게시판</b></span>
			</div>

			<!-- 자유게시판 박스 -->
			<div class="card mb-3 col-10" style="float: none; margin: 0 auto">

				<!-- 분류 -->
				<div class="card-header pl-0 pr-0">
					<div class="row no-gutters w-100 align-items-center">
						<div class="col ml-3"
							style="font-family: 'yg-jalnan', verdana, tahoma;">번호</div>
						<div class="col ml-3"
							style="font-family: 'yg-jalnan', verdana, tahoma;">제목</div>
						<div class="col-4 text-muted">
							<div class="row no-gutters align-items-center">
								<div class="d-none d-md-block col-4"
									style="font-family: 'yg-jalnan', verdana, tahoma; color: black;">닉네임</div>
								<div class="d-md-none col-12"
									style="font-family: 'yg-jalnan', verdana, tahoma; color: black;">닉네임</div>
								<div class="d-none d-md-block col-4"
									style="font-family: 'yg-jalnan', verdana, tahoma; color: black;">작성일</div>
								<div class="d-none d-md-block col-4"
									style="font-family: 'yg-jalnan', verdana, tahoma; color: black;">조회수</div>
							</div>
						</div>
					</div>
				</div>

				<!-- 내용 -->
				<c:forEach var="list" items="${list}">
					<div class="card-body py-3">
						<div class="row no-gutters w-100 align-items-center">
							<div class="col ml-3">${list.seq }</div>
							<div class="col ml-3">
								<a href="/board/detail?cpage=${cpage}&seq=${list.seq}&select=${select}&keyword=${keyword}" class="text-big" data-abc="true"
									style="color: black;">${list.title}</a>
							</div>
							<div class="col-4 text-muted">
								<div class="row no-gutters align-items-center">
									<div class="d-none d-md-block col-4">${list.nickname}</div>
									<div class="d-md-none col-12">${list.nickname}</div>
									<div class="d-none d-md-block col-4">${list.write_date}</div>
									<div class="d-none d-md-block col-4">${list.view_count}</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- 버튼 페이징 -->
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">${navi }
				</ul>
			</nav>
			<div class="col-10"
				style="float: none; margin: 0 auto; border: 0px; background-color: transparent;">
				<div class="row">
					<div class="col">
						<table class="table-sm mb-0" align=right>
							<tr>
								<td><select class="selectpicker" id="select">
										<option value="title">제목</option>
										<option value="contents">내용</option>
										<option value="nickname">닉네임</option>
								</select></td>
								<td><input type="search" class="form-control rounded"
									placeholder="내용을 입력하세요" id="searchContents"
									name="searchContents" /></td>
								<td>
									<button id="search">
										<i class="fas fa-search"></i>
									</button>
								</td>
								<td>
									<button id="writeBtn">글쓰기</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<br>
	</div>
	<!-- 풋터 -->
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />

	<script>
		// 글쓰기 버튼 클릭 시.
		$("#writeBtn").on("click", function() {
			location.href = "/board/write";
		})

		// 검색 버튼 클릭 시.
		$("#search").on("click", function() {
			if ($("#searchContents").val() == "") {
				alert("내용을 입력하세요.");
				return false;
			}else{
				let select = $("#select").val();
				let keyword = $("#searchContents").val();
				location.href = "/board/search?cpage=1&select="+select+"&keyword="+keyword;
			}
		})
	</script>
</body>
</html>