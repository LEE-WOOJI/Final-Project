<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글피 인증</title>
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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
	background-color: #eef1f3;
}

.mt-100 {
	margin-top: 80px;
}

.card {
	box-shadow: 0 0.46875rem 2.1875rem rgba(4, 9, 20, 0.03), 0 0.9375rem
		1.40625rem rgba(4, 9, 20, 0.03), 0 0.25rem 0.53125rem
		rgba(4, 9, 20, 0.05), 0 0.125rem 0.1875rem rgba(4, 9, 20, 0.03);
	border-width: 0;
	transition: all .2s;
	margin: auto;
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
	border-bottom: 1px solid rgba(26, 54, 126, 0.125);
}

.btn-primary.btn-shadow {
	box-shadow: 0 0.125rem 0.625rem rgba(63, 106, 216, 0.4), 0 0.0625rem
		0.125rem rgba(63, 106, 216, 0.5);
}

.btn.btn-wide {
	padding: .375rem 1.5rem;
	font-size: .8rem;
	line-height: 1.5;
	border-radius: .25rem;
}

.btn-primary {
	color: #fff;
	background-color: #3f6ad8;
	border-color: #3f6ad8;
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
	transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
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

#board-title {
	text-align: center;
	height: 100px;
	line-height: 100px;
	padding: 100px 0;
}

#title {
	width: 50px;
	height: 50px;
	margin-bottom: 3px;
}

.search-bar {
	margin: auto;
}

* {
	box-sizing: border-box;
}

.container {
	width: 1000px;
}

textarea {
	resize: none;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	width: 100%;
}

body {
	margin: 0;
	line-height: 1.5;
	color: #495057;
	text-align: left;
	background-color: #eef1f3
}

.profile-box {
	display: flex;
}

.img-profile {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.profile-detail {
	text-align: center;
}

.name {
	font-weight: bold;
}

.list li {
	margin-top: 5px;
}

.label {
	font-size: 12px;
}

.profile-detail {
	justify-content: flex-start;
	flex-direction: column;
}

/* 리뷰 css */
body {
	background: #eee
}

.date {
	font-size: 11px
}

.comment-text {
	font-size: 12px
}

.fs-12 {
	font-size: 12px
}

.shadow-none {
	box-shadow: none
}

.name {
	color: #007bff
}

.cursor:hover {
	color: blue
}

.cursor {
	cursor: pointer
}

#chalList {
	background-color: transparent;
	border: 1px solid black;
	border-radius: 3px;
}

#chalList:hover {
	background-color: black;
	color: white;
	border: 1px solid black;
	border-radius: 3px;
}

#complete {
	background-color: transparent;
	border: 1px solid black;
	border-radius: 3px;
}

#complete:hover {
	background-color: black;
	color: white;
	border: 1px solid black;
	border-radius: 3px;
}

@font-face {
	font-family: 'yg-jalnan';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

.ui-datepicker {
	margin-left: -40px;
	margin-top: -80px;
	z-index: 1000;
}

.img-box {
	box-shadow: 0 0.46875rem 2.1875rem rgba(4, 9, 20, 0.03), 0 0.9375rem
		1.40625rem rgba(4, 9, 20, 0.03), 0 0.25rem 0.53125rem
		rgba(4, 9, 20, 0.05), 0 0.125rem 0.1875rem rgba(4, 9, 20, 0.03);
	border-width: 0;
	transition: all .2s;
	margin: auto;
	height: 260px;
	width: 260px;
	border-radius: 3px;
	overflow: hidden;
	border-radius: 3px;
}

label {
	text-align: center;
}

label:hover {
	text-align: center;
	cursor: pointer;
}
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

	<!-- 타이틀  -->
	<div class="container-fluid mt-100">
		<div id="board-title"
			style="font-family: 'yg-jalnan', verdana, tahoma;">
			<img id="title" src="/assets/img/certi1.jpg"><span>글피 인증</span>
		</div>
		<div class="img-box">
			<img id="preview" class="img-profile" src="/assets/img/certi2.jpg"
				alt="">
		</div>
		<br>
		<form action="/image/certiWrite" method="post"
			enctype="multipart/form-data">
			<div class="container row"
				style="float: none; margin: auto; font-family: 'yg-jalnan', verdana, tahoma;">
				<label id="fileUpload">사진 선택<input type="file" name="file"
					id="file" accept="jpg,jpeg,png" style="display: none;">
				</label>
			</div>
			<br>

			<!-- 작성 박스 -->
			<div class="card mb-3 col-xl-6 col-md-12">
				<div class="container mb-4">
					<div class="row" style="padding-bottom: 5px;">
						<div class="col-sm-12">
							<div class="row profile-detail">
								<div class="col profile-box mt-4 mb-2 "></div>
							</div>
						</div>
					</div>
					<input type="hidden" name="chalSeq" value="${list.chalSeq}">
					<input type="hidden" name="chalName" value="${list.chalName}">
					<input type="hidden" name="refNickname" value="${list.refNickname}">
					<div class="row" style="padding-bottom: 5px;">
						<div class="col-sm-12">
							<input type=text id=input-title name="certiTitle"
								style="width: 100%;" placeholder="인증 제목을 입력하세요.">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<textarea name="certiContents" id="certiContents"
								style="min-height: 200px; overflow: hidden;"
								placeholder="인증 내용을 입력하세요."></textarea>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12" style="text-align: right">
							<button type="button" id="chalList">목록으로</button>
							<button id="complete">작성완료</button>
						</div>
					</div>
				</div>
		</form>
	</div>
	</div>
	<!-- 푸터 -->
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />

	<script>
		// 사진 업로드시 변경.
		$('#file').change(function() {
			setImageFromFile(this, '#preview');
		});

		function setImageFromFile(input, expression) {
			if (input.files && input.files[0]) {
				let reader = new FileReader();
				reader.onload = function(e) {
					$(expression).attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
	</script>

	<script>
		// 목록으로가기.
		$("#chalList").on("click", function() {
			location.href = "/mypage/certi?refChalSeq=${list.chalSeq}&chalName=${list.chalName}";
		})
	</script>

	<script>
		// 작성완료 버튼 클릭 시.
		$("#complete").on("click", function() {
			if ($("#input-title").val() == "") {
				alert("인증 제목을 입력하세요.");
				return false;
			}
			if ($("#certiContents").val() == "") {
				alert("인증 내용을 입력하세요.");
				return false;
			}
			if ($("#file").val() == "") {
				alert("사진을 선택하세요.");
				return false;
			}
		})
	</script>
</body>
</html>