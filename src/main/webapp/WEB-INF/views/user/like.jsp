<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글피 - Glory Trophy</title>
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
* {
	box-sizing: border-box;
}

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

.profile_img {
	margin-left: 58px;
	border-radius: 50%;
	width: 150px;
	height: 150px;
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
		<div class="row">
			<div class="col-12 col-lg-3">
				<div class="card">
					<div class="card-body">
						<div class="d-grid"></div>
						<div class="list-group list-group-flush">
							<a href="/mypage/myChalList" class="list-group-item py-1">
								<h5 class="my-3"
									style="font-family: 'yg-jalnan', verdana, tahoma;">마이페이지</h5>
							</a>
						</div>
						<div class="fm-menu">
							<div class="profile_box">
								<img class="profile_img" src="/image/board?nickname=${nickname}">
								<br>
							</div>

							<div class="list-group list-group-flush">
								<a href="/mypage/updateForm" class="list-group-item py-1"><span
									class="iconify" data-icon="icon-park-outline:people-search-one"
									data-width="25"></span>&ensp;<span a
									href=/mypage/updateUserInfo>내 정보 </span></a> <a
									href="/mypage/myChalList" class="list-group-item py-1"><span
									class="iconify" data-icon="icon-park-outline:gold-medal"
									data-width="25"></span>&ensp;<span>도전중인 글피</span></a> <a
									href="/mypage/myBoardAndReply" class="list-group-item py-1"><span
									class="iconify" data-icon="clarity:note-line" data-width="25"></span>&ensp;<span>작성한
										글 / 댓글</span></a> <a href="/mypage/like" class="list-group-item py-1"><span
									class="iconify" data-icon="bi:balloon-heart-fill"
									data-width="25"></span>&ensp;<span>내가 찜한 글피 </span></a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-12 col-lg-9">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<c:choose>
								<c:when test="${!empty list }">
									<c:forEach var="list" items="${list }">
										<div class="col-sm-6 col-md-4 col-lg-4">
											<div class="card shadow-none border radius-15">
												<div class="card-body">
													<div class="img-box" style="text-align: center;">
														<a href="/chal/detail?seq=${list.chalSeq}"
															style="text-decoration: none;"> <img
															src="/image/chalModifyLoad?chalSeq=${list.chalSeq}"
															alt="" style="width: 200px; height: 200px;">
														</a>
													</div>
													<div class="detail-box" style="text-align: center;">
														<h4 id="title">
															<a href="/chal/detail?seq=${list.chalSeq}"
																style="text-decoration: none; color: black;">
																${list.chalName} </a>
														</h4>
													</div>
													<div class="category">
														<hr>
														<h6>
															<label>Category : </label> ${list.category }
														</h6>
													</div>
													<div class="tag-box">
														<hr>
														<h6>
															<label>Tag : </label> ${list.tag }
														</h6>
													</div>
													<div class="startday">
														<h6>
															<label>시작일 : ${list.formedStartdate }</label>
														</h6>
													</div>
													<div class="endday">
														<h6>
															<label>종료일 : ${list.formedEnddate } </label>
														</h6>
													</div>
												</div>
												<!-- card-body 끝 -->
											</div>
										</div>
										<!--  col- 끝 -->
									</c:forEach>
								</c:when>
								<c:otherwise>
									<br>
									<br>
									<div
										style="font-family: 'yg-jalnan', verdana, tahoma; margin: auto; text-align: center; font-size: 18px;">
										찜한 글피가 없습니다. <br> <br> <br> <img alt=""
											src="/assets/img/noimage.jpg"
											style="max-width: 100%; height: auto;">
									</div>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 풋터 -->
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />

	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	<script>
		$("#leave")
		function leave() {
			if (confirm("정말 탈퇴하시겠습니까?")) {
				if (Kakao.Auth.getAccessToken()) {
					Kakao.API.request({
						url : '/v1/user/unlink',
						success : function(response) {
							location.href = "leave.mem"; //카카오api 결과값을 받은후 로그아웃 처리
						},
						fail : function(error) {
							location.href = "leave.mem";
						},
					})
					Kakao.Auth.setAccessToken(undefined)
				} else {
					location.href = "leave.mem"; //카카오 api를 사용한 로그인이 아니고 일반 로그인인 경우
				}

			}
		}
	</script>
</body>
</html>