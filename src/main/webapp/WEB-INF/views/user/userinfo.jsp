<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
	<title>회원가입</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
	

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" href="/css/signup.css">

	<style type="text/css">@font-face {
		font-family: 'yg-jalnan';
		src:
			url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
			format('woff');
		font-weight: normal;
		font-style: normal;
	}
	*{font-family: 'yg-jalnan', verdana, tahoma;}
	</style>

</head>

<body>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
	<section class="ftco-section">
		<div class="container">
			<div class="col-md-6 text-center mb-5">

			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-10 col-lg-10">
				<div class="login-wrap">
					<div class="img"  id="image_container" img src="images/kakao_login.png"></div>

					<h3 class="text-center mb-4">회원가입</h3>
					
					<form action="#" class="signup-form">
						<div class="form-group col-lg-3 mb-3 ">
							<input type="text" class="form-control" placeholder="아이디" name="id" id="id" style="width: 65%; display: inline-block;">
							
							
								<button type="button" id="check" value="중복검사"
									class="form-control btn btn-primary submit px-2"
									style="text-align: center; width: 30%;">중복검사</button>
								
							
							
							<span id="checkResult"></span>
						</div>
						
						<div class="form-group col-lg-3 mb-3">
							<input type="password" name="pw" id="ps" class="form-control" placeholder="비밀번호">
							<span id="pwcheck1" style="color: red;"></span>
						</div>
						<div class="form-group col-lg-3 mb-3">
							<input type="password" id="reps" class="form-control" placeholder="비밀번호 확인">
							<span id="pwcheck2" style="color: red;"></span>
						</div>
						<div class="form-group col-lg-3 mb-3">
							<input type="text" name="name" id="name" maxlength="3" class="form-control"
								placeholder="이름">

						</div>
						<div class="form-group col-lg-3 mb-3">
							<input type="text" name="nickname" id="nickname" class="form-control" placeholder="닉네임">
						</div>
						<div class="form-group col-lg-3 mb-3">
							<input type="text" name="phone" class="form-control" placeholder="연락처">
						</div>
						<div class="form-group col-lg-3 mb-3">
							<input type="text" class="form-control" name="email" id="email" placeholder="이메일">
						</div>
						<div class="form-group col-lg-3 mb-3">
							<input type="text" name=zipcode id=zipcode max="99999" maxlength="5" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"readonly class="form-control" placeholder="우편번호" style="width: 70%; display:inline-block;">
							
								<button type="button" id="ad" class="form-control btn btn-primary submit px-3"
									style="text-align: center; width: 26%;">찾기</button>
							
						</div>
						<div class="form-group col-lg-3 mb-3">
							<input type="text" name="address1" id="ad1" class="form-control" placeholder="주소" readonly>
						</div>
						<div class="form-group col-lg-3 mb-3">
							<input type="text" name="address2" id="ad2" class="form-control" placeholder="상세주소">
						</div>
						<div class="form-group col-lg-3 mb-3">
							<button type="submit" class="form-control btn btn-primary submit px-3"
								style="text-align: center;">가입완료</button>
						</div>

					</form>
				</div>
			</div>
		</div>
		</div>
	</section>

	<script src="/js/signup/jquery.min.js"></script>
	<script src="/js/signup/popper.js"></script>
	<script src="/js/signup/bootstrap.min.js"></script>
	<script src="/js/signup/main.js"></script>
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />

</body>

</html>