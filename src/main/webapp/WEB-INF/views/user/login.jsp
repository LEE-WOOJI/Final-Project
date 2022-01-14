<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <head>
  	<title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="/css/login.css">

	<style type="text/css">@font-face {
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
	<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section"></h2>
				</div>
				
			</div>
			<div class="row justify-content-center">
				<div class="col-md-12 col-lg-10">
					<div class="wrap d-md-flex">
						<div class="text-wrap p-4 p-lg-5 text-center d-flex align-items-center order-md-last">
							<div class="text w-100" style="font-family: 'yg-jalnan', verdana, tahoma;">
								<h2>글피에 오신것을 환영합니다</h2>
								<p>글피에 참여하시겠습니까?</p>
								<a href="#" class="btn btn-white btn-outline-white">회원가입</a>
							</div>
			      </div>
						<div class="login-wrap p-4 p-lg-5">
			      	<div class="d-flex">
			      		<div class="w-100" >
			      			<h3 class="mb-4" style="font-family: 'yg-jalnan', verdana, tahoma;">로그인</h3>
			      	
							<form action="#" class="signin-form">
			      		<div class="form-group mb-3" >
			      			<label class="label" for="name" style="font-family: 'yg-jalnan', verdana, tahoma;">아이디</label>
			      			<input type="text" class="form-control" placeholder="Username" required>
			      		</div>
		            <div class="form-group mb-3">
		            	<label class="label" for="password" style="font-family: 'yg-jalnan', verdana, tahoma;">비밀번호</label>
		              <input type="password" class="form-control" placeholder="Password" required>
		            </div>
		            <div class="form-group">
		            	<button type="submit" class="form-control btn btn-primary submit px-3" style="font-family: 'yg-jalnan', verdana, tahoma;">로그인</button>
		            </div>
					<div style="text-align: center;">
						<a href="javascript:kakaoLogin()">
							<img src="/assets/img/kakao_login.png"> 
						</a>
					</div>
					<br>
					<br>
		            <div class="form-group d-md-flex">
		            	<div class="w-50 text-left">
			            	<label class="checkbox-wrap checkbox-primary mb-0" style="font-family: 'yg-jalnan', verdana, tahoma;">아이디 저장하기
									  <input type="checkbox" checked>
									  <span class="checkmark"></span>
										</label>
									</div>
									<div class="w-50 text-md-right">
										<a href="#" style="font-family: 'yg-jalnan', verdana, tahoma;">비밀번호 찾기</a>
									</div>
		            </div>
		          </form>
		        </div>
		      </div>
				</div>
			</div>
		</div>
	</section>

	<script src="/js/jquery.min.js"></script>
  <script src="/js/popper.js"></script>
  <script src="/js/bootstrap.min.js"></script>
  <script src="/js/main.js"></script>
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
	</body>
</html>

