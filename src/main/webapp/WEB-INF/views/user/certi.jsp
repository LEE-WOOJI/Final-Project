<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 글피</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<link href="https://cdn.lineicons.com/3.0/lineicons.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/boxicons@2.0.7/css/boxicons.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://code.iconify.design/2/2.1.1/iconify.min.js"></script>
<link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
<style type="text/css">
body {
	margin-top: 20px;
	background-color: #f7f7ff;
}
.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0px solid rgba(0, 0, 0, 0);
	border-radius: .25rem;
	margin-bottom: 1.5rem;
	box-shadow: 0 2px 6px 0 rgb(218 218 253/ 65%), 0 2px 6px 0
		rgb(206 206 238/ 54%);
}
.fm-file-box {
	font-size: 25px;
	background: #e9ecef;
	width: 44px;
	height: 44px;
	display: flex;
	align-items: center;
	justify-content: center;
	border-radius: .25rem;
}
.ms-2 {
	margin-left: .5rem !important;
}
.fm-menu .list-group a {
	font-size: 16px;
	color: #5f5f5f;
	display: flex;
	align-items: center;
}
.list-group-flush>.list-group-item {
	border-width: 0 0 1px;
}
.list-group-item+.list-group-item {
	border-top-width: 0;
}
.py-1 {
	padding-top: .25rem !important;
	padding-bottom: .25rem !important;
}
.list-group-item {
	position: relative;
	display: block;
	padding: .5rem 1rem;
	text-decoration: none;
	background-color: #fff;
	border: 1px solid rgba(0, 0, 0, .125);
}
.radius-15 {
	border-radius: 15px;
}
.fm-icon-box {
	font-size: 32px;
	background: #ffffff;
	width: 52px;
	height: 52px;
	display: flex;
	align-items: center;
	justify-content: center;
	border-radius: .25rem;
}
.font-24 {
	font-size: 24px;
}
.ms-auto {
	margin-left: auto !important;
}
.font-30 {
	font-size: 30px;
}
.user-groups img {
	margin-left: -14px;
	border: 1px solid #e4e4e4;
	padding: 2px;
	cursor: pointer;
}
.rounded-circle {
	border-radius: 50% !important;
}
#header {
	margin-bottom: 100px;
}
a:hover {
	text-decoration-line: none;
}
@font-face {
	font-family: 'yg-jalnan';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
.pagination.justify-content-center>li {
	color: black;
}
.pagination.justify-content-center>li>a {
	color: black;
}
.pagination.justify-content-center>li>a:hover {
	background-color: black;
	color: white;
}
#delBtn {
	background-color: transparent;
	border: 1px solid black;
	border-radius: 3px;
}
#delBtn:hover {
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
#space {
	margin-bottom: 151px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row" id="header">
			<div class="col">
				<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
			</div>
		</div>
		<br>
		<form action="/mypage/certiWriteForm" method="post">
			<div class="row">
				<div class="col-12 col-lg-3">
					<div class="card">
						<div class="card-body">
							<div class="d-grid"></div>
							<div class="list-group list-group-flush">
								<a href="/admin/main" class="list-group-item py-1">
									<h5 class="my-3"
										style="font-family: 'yg-jalnan', verdana, tahoma;">관리자
										페이지</h5>
								</a>
							</div>
							<div class="fm-menu">
								<div class="list-group list-group-flush">
									<a href="/admin/userBlack" class="list-group-item py-1"><span
										class="iconify" data-icon="el:ban-circle" data-width="25"></span>&ensp;<span>유저
											블랙/탈퇴 관리</span></a> <a href="/admin/userGrade"
										class="list-group-item py-1"><span class="iconify"
										data-icon="icon-park-outline:gold-medal" data-width="25"></span>&ensp;<span>유저
											등급변경</span></a> <a href="/admin/userRefund" class="list-group-item py-1"><span
										class="iconify" data-icon="jam:coin" data-width="25"></span>&ensp;<span>유저
											환급</span></a> <a href="/admin/certi" class="list-group-item py-1"><span
										class="iconify" data-icon="clarity:list-line" data-width="25"></span>&ensp;<span>유저
											인증 삭제 </span></a> <a href="/admin/chal?cpage=1"
										class="list-group-item py-1"><span class="iconify"
										data-icon="ant-design:folder-open-outlined" data-width="25"></span>&ensp;<span>챌린지
											관리</span></a> <a href="/admin/board?cpage=1"
										class="list-group-item py-1"><span class="iconify"
										data-icon="clarity:note-line" data-width="25"></span>&ensp;<span>자유게시판
											관리</span></a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-12 col-lg-9">
					<div class="card">
						<div class="card-body">
							<div class="row mt-3">
								<h2 class="title"
									style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma; font-size: 23px;">${info.chalName}</h2>
								<div class="actions">
									<input type="hidden" name="chalSeq" value="${info.chalSeq}">
									<input type="hidden" name="chalName" value="${info.chalName}">
									<input type="hidden" name="refNickname"
										value="${info.refNickname}">
									<button class="btn btn-danger"
										style="font-family: 'yg-jalnan', verdana, tahoma; float: right;">
										<i class="fa fa-plus"></i> 인증하기
									</button>
								</div>
							</div>
							<div class="drive-wrapper drive-grid-view">
								<div class="grid-items-wrapper">
									<c:choose>
										<c:when test="${!empty list}">
											<c:forEach var="list" items="${list}">
												<div class="row"
													style="width: 300px; height: 300px; font-family: 'yg-jalnan', verdana, tahoma; float: left; margin: 5px; text-align: center; padding-bottom: 50px;">
													제목 : ${list.certiTitle} <img
														src="/image/certiWriteLoad?seq=${list.seq}" alt=""
														style="width:90%;height:90%;object-fit:cover;">인증날짜 :
													${list.certiDate}
												</div>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<br>
											<br>
											<div
												style="font-family: 'yg-jalnan', verdana, tahoma; margin: auto; text-align: center; font-size: 18px;">
												인증하신 내역이 없습니다. <br> <br> <br> <img alt=""
													src="/assets/img/noimage.jpg"
													style="max-width: 100%; height: auto;">
											</div>
										</c:otherwise>
									</c:choose>
									<br>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="row" id="space">
			<div class="col"></div>
		</div>
	</div>
	<!-- 풋터 -->
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
</body>
</html>