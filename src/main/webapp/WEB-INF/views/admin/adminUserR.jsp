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
	background-color: #f8e8e6;
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
										블랙/탈퇴 관리</span></a> <a href="#" class="list-group-item py-1"><span
									class="iconify" data-icon="icon-park-outline:gold-medal"
									data-width="25"></span>&ensp;<span>유저 등급변경</span></a> <a href="#"
									class="list-group-item py-1"><span class="iconify"
									data-icon="jam:coin" data-width="25"></span>&ensp;<span>유저
										환급</span></a> <a href="#" class="list-group-item py-1"><span
									class="iconify" data-icon="clarity:list-line" data-width="25"></span>&ensp;<span>유저
										챌린지 삭제 </span></a> <a href="#" class="list-group-item py-1"><span
									class="iconify" data-icon="ant-design:folder-open-outlined"
									data-width="25"></span>&ensp;<span>챌린지 관리</span></a> <a href="#"
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
						<form action ="/admin/userRefundSearch">
							<div class="row mt-3">
							<div class="col-sm-12 col-md-2 col-lg-2"
								style="text-align: center; margin-top: 5px; font-family: 'yg-jalnan', verdana, tahoma;">
								검색</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<input type="text" class="form-control" placeholder="챌린지 명을 입력하세요"
									aria-label="Recipient's username"
									aria-describedby="basic-addon2" name="chalName">
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<input type="text" class="form-control" placeholder="닉네임를 입력하세요"
									aria-label="Recipient's username"
									aria-describedby="basic-addon2" name="nickname">
							</div>
							
							<div class="col-sm-12 col-md-2 col-lg-2">
								<button type="submit" class="btn btn-danger" id="searchBtn"
									style="width: 100%; font-family: 'yg-jalnan', verdana, tahoma;">Search</button>
							</div>
						</div>
						</form>
					</div>

					<div class="table" id = "table" style="overflow-x: hidden;">
						<h6 class="mt-3 mb-0" style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma;">유저 환급
							리스트</h6>
						<br>
						<div class="row" style="text-align: center; line-height: 30px; border: none;">
							<div class="col-2 list" style="padding: 0px;">챌린지</div>
							<div class="col-2 list" style="padding: 0px;">닉네임</div>
							<div class="col-2 list" style="padding: 0px;">환급금액</div>
							<div class="col-1 list" style="padding: 0px;">은행명</div>
							<div class="col-3 list" style="padding: 0px;">계좌번호</div>
							<div class="col-2 list" style="padding: 0px;">환급</div>
						</div>
						<c:forEach var="list" items="${list}">
							<br>
							<div class="row" style="text-align: center; line-height: 30px; border: none;">
								<div class="col-2" style="padding: 0px;">${list.chalName}</div>
								<div class="col-2" style="padding: 0px;">${list.nickname}</div>
								<div class="col-2" style="padding: 0px;">${list.price}</div>
								<div class="col-1" style="padding: 0px;">${list.bank}</div>
								<div class="col-3" style="padding: 0px;">${list.account}</div>
								<div class="col-2" style="padding: 0px;">
									<a
										href="/admin/userRefundGo?nickname=${list.nickname}"
										style="text-decoration-line: none;"> <input type="button"
										value="환급" class="btn refundBtn"
										style="background-color: rgba(245, 188, 188, 0.65);">
									</a>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- 더보기 -->
						<div class = "row" style = "border: none;">
			            	<div class = "col">
			            		<div class="btn-box" style = "margin-left:45%;">
				               		<div class = "col-sm-12 col-md-4 col-lg-2">
										<button type="button" class="btn btn-danger" style = "width:100%;" id = "more">More</button>
									</div>
			            		</div>
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
		$(".refundBtn").on("click",function(){
			let result = confirm("환급을 완료시키겠습니까?");
			if(!result){return false;}
		})
		
		let moreNum = 1;
   		$("#more").on("click",function(){
   			moreNum += 5;
   			$.ajax({
   				url:"/admin/userRefundMore",
   				method:"POST",
   				data:{"moreNum":moreNum}
   			}).done(function(resp){
   				let result = JSON.parse(resp);
   				let content = "";
   				
   				for(let i = 0; i < result.length; i++){
   					console.log("회차 : " + i);
   					console.log(result[i].nickname);
   					content += `<br>
						<div class="row" style="text-align: center; line-height: 30px; border: none;">
						<div class="col-2" style="padding: 0px;">\${result[i].chalName}</div>
						<div class="col-2" style="padding: 0px;">\${result[i].nickname}</div>
						<div class="col-2" style="padding: 0px;">\${result[i].price}</div>
						<div class="col-1" style="padding: 0px;">\${result[i].bank}%</div>
						<div class="col-3" style="padding: 0px;">\${result[i].account}</div>
						<div class="col-2" style="padding: 0px;">
							<a
								href="/admin/userRefundGo?nickname=\${result[i].nickname}"
								style="text-decoration-line: none;"> <input type="button"
								value="환급" class="btn refundBtn"
								style="background-color: rgba(245, 188, 188, 0.65);">
							</a>
						</div>
					</div>`;
           		if (result[i].seq > 20) { // 더이상 불러올 것이 없다면 더보기 버튼 삭제
 	              $("#more").css("display","none");
 	            }
   				}$(content).appendTo("#table");
   				
   			})
   		});
	</script>
</body>
</html>