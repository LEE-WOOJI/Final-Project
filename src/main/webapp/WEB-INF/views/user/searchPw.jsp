<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<title>아이디찾기</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/signup.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

var ingSearchPw = false;
function searchPw() {
	if(ingSearchPw){
		alert("전송중입니다. 잠시만 기다려주세요.")
		return false;
	}
	ingSearchPw = true;
	if ($("#id").val() == '') {
		alert("이메일 를 입력하세요.");
		$("#id").focus();
		return false;
	}
	var emailReg = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/g;
    if( !emailReg.test( $("#id").val() ) ) {
        alert("이메일 형식을 다시한번 확인해주세요.");
        return false;
    }
	$.ajax({
		url : "/user/searchPw",
		data : {
			email : $("#id").val()
		}
	}).done(function(resp) {
		if (resp == true) {
			alert("가입하신 이메일로 임시비밀번호가 전송되었습니다.")
		} else {
			alert("전송에 실패했습니다 이메일를 확인해주세요.")
		}
		ingSearchPw = false;
	})
}


	</script>

<style type="text/css">
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
	<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
	<section class="ftco-section">
		<div class="container">
			<div class="col-md-6 text-center mb-5"></div>
		</div>
		

		<h3 class="text-center mb-4">비밀번호 찾기</h3>

			<div class="form-group col-lg-3 mb-3 ">
				<input type="text" class="form-control" placeholder="이메일를 입력해주세요" name="id"
					id="id" style="width: 69%; display: inline-block; font-family: 'yg-jalnan', verdana, tahoma;">
				<button type="button" id="searchPw" value="중복검사"
					class="form-control btn btn-primary submit px-2"
					style="text-align: center; width: 30%; font-family: 'yg-jalnan', verdana, tahoma;"onclick="searchPw()">찾기</button>
				<span id="seachidcheckResult"></span>
			</div>

		
		<p style="text-align: center;">
			비밀번호를 찾으셨나요? 
			<a href="/user/loginform" style="color: rgb(228, 72, 72); font-family: 'yg-jalnan', verdana, tahoma;">로그인</a>
		</p>

	</section>

	<script src="/js/signup/jquery.min.js"></script>
	<script src="/js/signup/popper.js"></script>
	<script src="/js/signup/bootstrap.min.js"></script>
	<script src="/js/signup/main.js"></script>
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />

</body>

</html>