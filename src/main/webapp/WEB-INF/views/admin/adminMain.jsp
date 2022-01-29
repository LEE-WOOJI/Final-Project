<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
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
				<div class="card">
					<div class="card-body">
						<div class="row mt-3">
							<div class="col-12 col-lg-4">
								<div class="card shadow-none border radius-15">
									<div class="card-body">
										<div class="d-flex align-items-center"
											style="font-family: 'yg-jalnan', verdana, tahoma;">
											<div class="fm-icon-box radius-15 bg-warning text-dark"
												style="height: 40px; width: 40px;">
												<i class="fas fa-user-friends fa-xs"></i>
											</div>
											&ensp; 총 유저(회원) 수 ${memberResult}명
										</div>
									</div>
								</div>
							</div>
							<div class="col-12 col-lg-4">
								<div class="card shadow-none border radius-15">
									<div class="card-body">
										<div class="d-flex align-items-center"
											style="font-family: 'yg-jalnan', verdana, tahoma;">
											<div class="fm-icon-box radius-15 bg-danger text-white"
												style="height: 40px; width: 40px;">
												<i class="far fa-edit fa-xs"></i>
											</div>
											&ensp; 자유게시판 글 수 ${boardResult}건
										</div>
									</div>
								</div>
							</div>
							<div class="col-12 col-lg-4">
								<div class="card shadow-none border radius-15">
									<div class="card-body">
										<div class="d-flex align-items-center"
											style="font-family: 'yg-jalnan', verdana, tahoma;">
											<div class="fm-icon-box radius-15 bg-success text-white"
												style="height: 40px; width: 40px;">
												<span class="iconify"
													data-icon="ant-design:folder-open-outlined" data-width="30"></span>
											</div>
											&ensp; 챌린지 수 ${chalResult}건
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="table-responsive mt-3">
							<table class="table table-striped table-hover table-sm mb-0">
								<h6 class="mt-3 mb-0"
									style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma;">회원
									수 추이</h6>
								<div class="chart-box">
									<div class="chart-container">
										<canvas id="lineChart" width="400" height="300"></canvas>
									</div>
								</div>
								<br>
								<br>
								<h6 class="mt-3 mb-0"
									style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma;">등급
									별 회원 수</h6>
								<div class="chart-box">
									<div class="chart-container">
										<canvas id="gradeChart" width="400" height="300"></canvas>
									</div>
								</div>
								<br>
								<br>
								<h6 class="mt-3 mb-0"
									style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma;">등급별
									결제 수</h6>
								<div class="chart-box">
									<div class="chart-container">
										<canvas id="payChart" width="400" height="200"></canvas>
									</div>
								</div>
							</table>
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
		// 등급 차트
		const ctx = document.getElementById('gradeChart').getContext('2d');
		const myChart = new Chart(ctx, {
			type : 'doughnut',
			data : {
				labels : [ '골드', '실버', '브론즈' ],
				datasets : [ {
					label : '# of Votes',
					data : [ ${gradeResult.goldcount}, ${gradeResult.silvercount}, ${gradeResult.bronzecount} ],
					backgroundColor : [ 'rgba(255, 217, 0, 0.5)',
							'rgba(192, 192, 192, 0.5)',
							'rgba(168, 128, 74, 0.5)', ],
					borderColor : [ 'rgba(255, 217, 0)', 'rgba(192, 192, 192)',
							'rgba(168, 128, 74)', ],
					borderWidth : 1
				} ]
			},
			options : {
				maintainAspectRatio : false,
				scales : {
					y : {
						beginAtZero : true
					}
				}
			}
		});

		// 등급별 결제 수 차트
		new Chart(document.getElementById("payChart"), {
			type : 'bar',
			data : {
				labels : [ '브론즈', '실버', '골드' ],
				datasets : [ {
					data : [ ${payResult.bronzePay}, ${payResult.silverPay}, ${payResult.goldPay} ],
					backgroundColor : [ 'rgba(168, 128, 74, 0.5)',
							'rgba(192, 192, 192, 0.5)',
							'rgba(255, 217, 0, 0.5)' ],
					borderColor : [ 'rgba(168, 128, 74)',
							'rgba(192, 192, 192)', 'rgba(255, 217, 0)' ],
					borderWidth : 1
				} ]
			},
			options : {
				maintainAspectRatio : false,
				legend : {
					display : false
				},
				scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true
						}
					} ]
				},
			}
		});

		// 유저 수 추이 차트
		new Chart(document.getElementById("lineChart"), {
			type : 'line',
			data : {
				labels : [ '${dateResult.today_6}', '${dateResult.today_5}', '${dateResult.today_4}', '${dateResult.today_3}', '${dateResult.today_2}', '${dateResult.today_1}', '${dateResult.today}(오늘)' ],
				datasets : [ {
					label : '누적 회원 수',
					data : [ ${signUpAccumResult.signUp_6}, ${signUpAccumResult.signUp_5}, ${signUpAccumResult.signUp_4}, ${signUpAccumResult.signUp_3}, ${signUpAccumResult.signUp_2}, ${signUpAccumResult.signUp_1}, ${signUpAccumResult.signUp} ],
					fill : false,
					borderColor : '#F77272',
					tension : 0.1
				
			},{
					label : '일일 가입한 회원 수',
					data : [ ${signUpDailyResult.signUpDaily_6}, ${signUpDailyResult.signUpDaily_5}, ${signUpDailyResult.signUpDaily_4}, ${signUpDailyResult.signUpDaily_3}, ${signUpDailyResult.signUpDaily_2}, ${signUpDailyResult.signUpDaily_1}, ${signUpDailyResult.signUpDaily} ],
					fill : false,
					borderColor : '#7B9EFA',
					tension : 0.1
				} ]
			},
			options : {
				maintainAspectRatio : false,
				legend : {
					display : false
				},
				scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true
						}
					} ]
				},
			}
		});
	</script>
</body>
</html>