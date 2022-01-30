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
					<div class="img"  id="image_container">
						<img alt="noImage" src="/userProfile/user-${user.nickname}.png">
					</div>
					<h3 class="text-center mb-4">프로필 변경</h3>
					
					<form action="/mypage/updateUserProfileAction" class="signup-form" method="POST" enctype="multipart/form-data">
						<input name="seq" type="hidden" value="${user.seq}">
						<input type="file" name="file"/>
						<br/>
						<button type="submit">변경</button>
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