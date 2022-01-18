<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
	<title>Sign up</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" href="css/signup.css">

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
					<div class="img"  id="image_container" style="background-image: url(images/bg.jpg);"></div>
					
					


					<h3 class="text-center mb-4">회원가입</h3>
					
					<form action="#" class="signup-form">
						<div class="form-group col-lg-3 mb-3 ">
							<input type="text" class="form-control" placeholder="아이디" name="id" id="id">
							
							<div class="form-group col-lg-6 mb-3">
								<button type="button" id="check" value="중복검사"
									class="form-control btn btn-primary submit px-2"
									style="text-align: center;">중복검사</button>
								
							</div>
							
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
							<input type="text" name=zipcode id=zipcode max="99999" maxlength="5" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"readonly class="form-control" placeholder="우편번호">
							<div class="form-group col-lg-6 mb-3">
								<button type="button" id="ad" class="form-control btn btn-primary submit px-3"
									style="text-align: center;">우편번호 찾기</button>
							</div>
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
					<p style="text-align: center;">이미 회원인가요? <a data-toggle="tab" href="#signin">로그인</a></p>
				</div>
			</div>
		</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />

</body>

</html>