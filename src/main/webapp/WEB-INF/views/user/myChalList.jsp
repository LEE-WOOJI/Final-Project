<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
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

.list {
	font-family: 'yg-jalnan', verdana, tahoma;
}

.row .col {
	padding: 0px;
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
							<a href="/admin/main" class="list-group-item py-1">
								<h5 class="my-3"
									style="font-family: 'yg-jalnan', verdana, tahoma;">관리자 페이지</h5>
							</a>
						</div>
						<div class="fm-menu">
							<div class="list-group list-group-flush">
								<a href="/admin/userBlack" class="list-group-item py-1"><span
									class="iconify" data-icon="el:ban-circle" data-width="25"></span>&ensp;<span>유저
										블랙/탈퇴 관리</span></a> <a href="/admin/userGrade" class="list-group-item py-1"><span
									class="iconify" data-icon="icon-park-outline:gold-medal"
									data-width="25"></span>&ensp;<span>유저 등급변경</span></a> <a href="/admin/userRefund"
									class="list-group-item py-1"><span class="iconify"
									data-icon="jam:coin" data-width="25"></span>&ensp;<span>유저
										환급</span></a> <a href="/admin/certi?cpage=1" class="list-group-item py-1"><span
									class="iconify" data-icon="clarity:list-line" data-width="25"></span>&ensp;<span>유저
										인증 삭제 </span></a> <a href="/admin/chal?cpage=1"
									class="list-group-item py-1"><span class="iconify"
									data-icon="ant-design:folder-open-outlined" data-width="25"></span>&ensp;<span>챌린지
										관리</span></a> <a href="/admin/board?cpage=1" class="list-group-item py-1"><span
									class="iconify" data-icon="clarity:note-line" data-width="25"></span>&ensp;<span>자유게시판
										관리</span></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-12 col-lg-9">
					<!-- 진행 중인 리스트 -->
					<div class="table" id = "presentG" style="height : 400px;overflow-y: scroll; overflow-x:hidden;"">
						<h6 class="mt-3 mb-0" style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma;">진행 중인 글피!</h6>
						<br>
						<div class="row" style="text-align: center; line-height: 30px; border: none; background-color:#f8e8e6;">
							<div class="col-2 list" style="padding: 0px;">챌린지 이름</div>
							<div class="col-2 list" style="padding: 0px;">카테고리</div>
							<div class="col-2 list" style="padding: 0px;">인원</div>
							<div class="col-2 list" style="padding: 0px;">시작일</div>
							<div class="col-2 list" style="padding: 0px;">종료일</div>
							<div class="col-2 list" style="padding: 0px;">인증</div>
						</div>
						<c:forEach var="list" items="${plist}">
							<br>
							<div class="row" style="text-align: center; line-height: 30px; border: none;">
								<div class="col-2" style="padding: 0px;">${list.chalName}</div>
								<div class="col-2" style="padding: 0px;">${list.category}</div>
								<div class="col-2" style="padding: 0px;">${list.personnel}</div>
								<div class="col-2" style="padding: 0px;">${list.startDate}</div>
								<div class="col-2" style="padding: 0px;">${list.endDate}</div>
								<div class="col-2" style="padding: 0px;">
									<a
										href="/mypage/certi?chalSeq=${list.chalSeq }&chalName=${list.chalName}"
										style="text-decoration-line: none;"> <input type="button"
										value="인증" class="btn certi"
										style="background-color: #f8d2cd;">
									</a>
								</div>
							</div>
						</c:forEach>
					</div>
					<br>
					<br>
					<br>
					<!-- 진행 예정 글피 리스트 -->
					<div class="table" id = "futureG" style="height : 400px;overflow-y: scroll;overflow-x:hidden;">
						<h6 class="mt-3 mb-0" style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma;">진행 예정 글피!</h6>
						<br>
						<div class="row" style="text-align: center; line-height: 30px; border: none; background-color:#f8e8e6;">
							<div class="col-2 list" style="padding: 0px;">챌린지 이름</div>
							<div class="col-2 list" style="padding: 0px;">카테고리</div>
							<div class="col-2 list" style="padding: 0px;">인원</div>
							<div class="col-2 list" style="padding: 0px;">시작일</div>
							<div class="col-2 list" style="padding: 0px;">종료일</div>
							<div class="col-2 list" style="padding: 0px;">취소</div>
						</div>
						<c:forEach var="list" items="${flist}">
							<br>
							<div class="row" style="text-align: center; line-height: 30px; border: none;">
								<div class="col-2" style="padding: 0px;">${list.chalName}</div>
								<div class="col-2" style="padding: 0px;">${list.category}</div>
								<div class="col-2" style="padding: 0px;">${list.personnel}</div>
								<div class="col-2" style="padding: 0px;">${list.startDate}</div>
								<div class="col-2" style="padding: 0px;">${list.endDate }</div>
								<div class="col-2" style="padding: 0px;">
								<input type="button" value="취소" class="btn cancle" style="background-color: #f8d2cd;"></div>
							</div>
						</c:forEach>
					</div>
					<br>
					<br>
					<br>
					<!-- 완료한 글피 리스트 -->
					<div class="table" id = "beforeG" style="height : 400px;overflow-y: scroll; overflow-x:hidden;"">
						<h6 class="mt-3 mb-0" style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma;">완료한 글피 리스트</h6>
						<br>
						<div class="row" style="text-align: center; line-height: 30px; border: none; background-color:#f8e8e6;">
							<div class="col-2 list" style="padding: 0px;">챌린지 이름</div>
							<div class="col-2 list" style="padding: 0px;">카테고리</div>
							<div class="col-2 list" style="padding: 0px;">인원</div>
							<div class="col-2 list" style="padding: 0px;">시작일</div>
							<div class="col-2 list" style="padding: 0px;">종료일</div>
							<div class="col-2 list" style="padding: 0px;">환급</div>
						</div>
						<c:forEach var="list" items="${blist}">
							<br>
							<div class="row" style="text-align: center; line-height: 30px; border: none; ">
								<div class="col-2" style="padding: 0px;">${list.chalName}</div>
								<div class="col-2" style="padding: 0px;">${list.category}</div>
								<div class="col-2" style="padding: 0px;">${list.personnel}</div>
								<div class="col-2" style="padding: 0px;">${list.startDate}</div>
								<div class="col-2" style="padding: 0px;">${list.endDate}</div>
									<div class="col-2" style="padding: 0px;"><input type="button"
											value="환급" class="btn refund"
											style="background-color: #f8d2cd;">
									</div>
								</div>
						</c:forEach>
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
	let chalName =  "${list.chalName}"	
	$(".cancle").on("click",function(){
			$.ajax({
				url:"/mypage/refundOk",
				method:"POST",
				data:{"chalName",chalName}
			}).done(function(resp){
				if(resp == "중복"){
					alert("이미 환급 신청이 완료되었습니다!");
				}else{
					location.href = "/user/cancleInfo?chalSeq=${list.chalSeq}";
				}
			})
		});
	
	$(".refund").on("click",function(){
		$.ajax({
			url:"/mypage/refundOk",
			method:"POST",
			data:{"chalName",chalName}
		}).done(function(resp){
			if(resp == "중복"){
				alert("이미 환급 신청이 완료되었습니다!");
			}else{
				location.href = "/user/refundInfo?chalSeq=${list.chalSeq}";
			}
		})
	});
	</script>
</body>
</html>