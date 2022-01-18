<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>글피 - Glory Trophy</title>
<!-- Favicon-->
<link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/chalDetail.css" rel="stylesheet" />
<!-- 글피 남은 시간 카운트다운 js 
<script type="text/javascript" src="/js/timer.js"></script>-->
<!-- 전체적인 js -->
<script src="/js/scripts.js"></script>
<!-- JavaScript Includes -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.0.0/moment.min.js"></script>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!------ Include the above in your HEAD tag ---------->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- head -->
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

<style>
@font-face {
	font-family: 'yg-jalnan';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

@font-face {
	font-family: 'S-CoreDream-4Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-4Regular.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

#countdown, #HourCountdown, #countExpire {
	display: inline;
	color: rgb(0, 0, 0);
	font-weight: bold;
}

h1 {
	font-size: 2rem;
	font-weight: 500;
}

@
keyframes open { 0% {
	opacity: 0;
}

100






%
{
opacity






:






1




;
}
}
.detail summary::-webkit-details-marker {
	display: none;
}

.detail summary {
	width: 100%;
	padding: 0.5rem 0;
	border-top: 1px solid black;
	position: relative;
	cursor: pointer;
	font-size: 1.25rem;
	font-weight: 300;
	list-style: none;
}

.detail summary:after {
	content: "+";
	color: black;
	position: absolute;
	font-size: 1.75rem;
	line-height: 0;
	margin-top: 0.75rem;
	right: 0;
	font-weight: 200;
	transform-origin: center;
	transition: 200ms linear;
}

.detail[open] summary:after {
	transform: rotate(45deg);
	font-size: 2rem;
}

.detail summary {
	outline: 0;
}

.detail p {
	font-size: 0.95rem;
	margin: 0 0 1rem;
	padding-top: 1rem;
}

.certiImg {
	width: 100%;
	height: 400px;
	padding: 10px;
}

/*케러샐*/
.blog .carousel-indicators {
	left: 0;
	top: auto;
	bottom: -40px;
}

/* The colour of the indicators */
.blog .carousel-indicators li {
	background: #a3a3a3;
	border-radius: 50%;
	width: 8px;
	height: 8px;
}

/*점박이 컬러*/
.blog .carousel-indicators .active {
	background: #b61717;
}

.thumbnail img {
	width: 250px;
	height: 200px;
}
</style>
</head>



<body>
	<!-- Product section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0" src="${dto.oriName}" alt="..." />
				</div>
				<div class="col-md-6">
					<div class="chalTag" style="margin: 10px;">
						<span class="badge bg-warning text-dark" style="font-family: 'S-CoreDream-4Regular'">인기 글피</span>
						<span class="badge bg-warning text-dark" style="font-family: 'S-CoreDream-4Regular'">생활</span>
						<span class="badge bg-warning text-dark" style="font-family: 'S-CoreDream-4Regular'">아침형 인간</span>
					</div>
					<h1 class="display-5 fw-bolder" style="font-family: 'yg-jalnan', verdana, tahoma;">아침 6시 기상하기</h1>
					<div class="fs-5 mb-5">
						<i class="bi bi-people-fill"></i>
						<span style="font-family: 'S-CoreDream-4Regular'">현재 ${dto.personnel}명</span>
					</div>

					<div style="font-family: 'S-CoreDream-4Regular'">
						글피 시작까지
						<div id="countdown"></div>
						
					</div>
					<br>

					<span class="lead" style="font-family: 'S-CoreDream-4Regular'">
						확실한 동기 부여를 위해서 만 원을 걸어요.<br> 글피를 시작하기 전에 돈을걸고, <br> 내가 실천한 만큼 돌려받으면<br> 절대 포기할 수가 없죠!<br>
					</span>
					<br>

					<!-- 2019년 2월 19일인 오늘 <div id="countExpire"></div> -->
					<div class="d-flex">
						<button type="button" class="btn btn-warning" style="font-family: 'S-CoreDream-4Regular';">참여하기</button>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 인증 사진 찍는 방법-->
	<section class="py-5 bg-light" style="text-align: center;">
		<div class="container px-4 px-lg-5 mt-5">
			<div class="row gx-4 gx-lg-10 align-items-center" style="padding-bottom: 50px;">
				<h2 class="fw-bolder mb-4" style="font-family: 'yg-jalnan', verdana, tahoma;">인증은 이렇게 해주세요!</h2>
				<div class="col-md-7 col-sm-12" style="float: left;">
					<img class="certiImg" src="/assets/img/chalDetail/인증.png">
				</div>
				<div class="col-md-5" style="font-family: 'yg-jalnan', verdana, tahoma;">
					<span style="font-family: 'S-CoreDream-4Regular'; font-size: 20px;">01. 네이버 시계와 컴퓨터 달력을 캡쳐해주세요</span>
				</div>

				<div class="col-md-7 col-sm-12" style="float: left;">
					<img class="certiImg" src="/assets/img/chalDetail/wash.jpeg">
				</div>
				<div class="col-md-5">
					<span style="font-family: 'S-CoreDream-4Regular'; font-size: 20px;">02. 글피와 관련된 사진을 찍어주세요.</span>
				</div>
			</div>


			<!-- 실시간 인증 사진 캐러샐 -->
			<h2 class="fw-bolder mb-4" style="font-family: 'yg-jalnan', verdana, tahoma;">실시간 인증</h2>
			<div class="container" style="margin-bottom: 50px;">
				<div class="row blog">
					<div class="col-md-12">
						<div id="blogCarousel" class="carousel slide" data-ride="carousel">

							<!--캐러샐 하단 점박이 부분-->
							<ol class="carousel-indicators">
								<li data-target="#blogCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#blogCarousel" data-slide-to="1"></li>
							</ol>

							<div class="carousel-inner">
								<div class="carousel-item active">
									<div class="row">
										<div class="thumbnail col-md-3 col-sm-12">
											<a href="#">
												<img src="/assets/img/chalDetail/default.png" alt="Image" style="max-width: 100%;">
											</a>
										</div>
										<div class="thumbnail col-md-3">
											<a href="#">
												<img src="/assets/img/chalDetail/default.png" alt="Image" style="max-width: 100%;">
											</a>
										</div>
										<div class="thumbnail col-md-3">
											<a href="#">
												<img src="/assets/img/chalDetail/default.png" alt="Image" style="max-width: 100%;">
											</a>
										</div>
										<div class="thumbnail col-md-3">
											<a href="#">
												<img src="/assets/img/chalDetail/default.png" alt="Image" style="max-width: 100%;">
											</a>
										</div>
									</div>
								</div>

								<div class="carousel-item">
									<div class="row">
										<div class="thumbnail col-md-3">
											<a href="#">
												<img src="/assets/img/chalDetail/default.png" alt="Image" style="max-width: 100%;">
											</a>
										</div>
										<div class="thumbnail col-md-3">
											<a href="#">
												<img src="/assets/img/chalDetail/default.png" alt="Image" style="max-width: 100%;">
											</a>
										</div>
										<div class="thumbnail col-md-3">
											<a href="#">
												<img src="/assets/img/chalDetail/default.png" alt="Image" style="max-width: 100%;">
											</a>
										</div>
										<div class="thumbnail col-md-3">
											<a href="#">
												<img src="/assets/img/chalDetail/default.png" alt="Image" style="max-width: 100%;">
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br> <br>

			<!-- 50% 환급 정책 이미지 부분 -->
			<h2 class="fw-bolder mb-4" style="font-family: 'yg-jalnan', verdana, tahoma;">환급 정책</h2>
			<img src="/assets/img/about/money.png" style="width: 500px;">
		</div>
	</section>

	<!--맨 하단 주의사항 부분-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5" style="font-family: 'yg-jalnan', verdana, tahoma;">
			<div class="detail">
				<h1 style="font-family: 'yg-jalnan', verdana, tahoma;">글피 이용 방법 및 주의사항</h1>
				<details>
					<summary>이런 분들께 해당 글피를 추천합니다!</summary>
					<div style="text-align: center;">
						<img src="/assets/img/chalDetail/who.png" style="width: 80%;">
					</div>
				</details>
				<details>
					<summary>인증 방법 </summary>
					<div style="text-align: center;">
						<img src="/assets/img/chalDetail/how.png" style="width: 80%;">
					</div>
				</details>
				<details>
					<summary>환불 정책</summary>
					<div style="text-align: center;">
						<img src="/assets/img/chalDetail/repund.png" style="width: 80%;">
					</div>
				</details>
				<details>
					<summary>주의사항</summary>
					<div style="text-align: center;">
						<img src="/assets/img/chalDetail/notice.png" style="width: 80%;">
					</div>
				</details>
			</div>
		</div>
	</section>
	<!-- Core theme JS-->
	<script src="/js/scripts.js"></script>
	
	<script>
 	CountDownTimer(${dto.date}, 'countdown');
 	CountDownTimer('1/16/2022 5:00 PM', 'HourCountdown');
 	CountDownTimer('1/16/2022', 'countExpire');


	 function CountDownTimer(dt, id) {
     	var end = new Date(dt);
     	var _second = 1000;
     	var _minute = _second * 60;
     	var _hour = _minute * 60;
     	var _day = _hour * 24;
     	var timer;

     function showRemaining() {
         var now = new Date();
         var distance = end - now;


         // 시간 종료 시 뜨는 문구
         if (distance < 0) {
             clearInterval(timer);
             document.getElementById(id).innerHTML = '카운트다운이 끝났습니다. 곧 오픈합니다!';
             return;
         }

         var days = Math.floor(distance / _day);
         var hours = Math.floor((distance % _day) / _hour);
         var minutes = Math.floor((distance % _hour) / _minute);
         var seconds = Math.floor((distance % _minute) / _second);

         document.getElementById(id).innerHTML = days + '일 ';
         document.getElementById(id).innerHTML += hours + '시간 ';
         document.getElementById(id).innerHTML += minutes + '분 ';
         document.getElementById(id).innerHTML += seconds + '초';

     }

     timer = setInterval(showRemaining, 1000);

 }
 </script>	
</body>

<!-- Footer-->
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />

</html>