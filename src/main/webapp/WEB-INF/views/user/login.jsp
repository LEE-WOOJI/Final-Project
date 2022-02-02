<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <head>
  	<title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	 <link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

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
								<a href="/user/signup" class="btn btn-white btn-outline-white">회원가입</a>
							</div>
			      </div>
						<div class="login-wrap p-4 p-lg-5">
			      	<div class="d-flex">
			      		<div class="w-100" >
			      			<h3 class="mb-4" style="font-family: 'yg-jalnan', verdana, tahoma;">로그인</h3>
			      	
							<form action="/user/login" class="signin-form" method="post">
			      		<div class="form-group mb-3" >
			      			<label class="label" for="name" style="font-family: 'yg-jalnan', verdana, tahoma;">아이디</label>
			      			<input type="text" id="id"  name="id"class="form-control" placeholder="Username" required>
			      		</div>
		            <div class="form-group mb-3">
		            	<label class="label" for="password" style="font-family: 'yg-jalnan', verdana, tahoma;">비밀번호</label>
		              <input type="password" name="pw" class="form-control" placeholder="Password" required>
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
										<a href="/user/searchIdForm" style="font-family: 'yg-jalnan', verdana, tahoma;" >아이디 찾기</a>
										&nbsp;
										<a href="/user/searchPwForm" style="font-family: 'yg-jalnan', verdana, tahoma;">비밀번호 찾기</a>
									</div>
		            </div>
		          </form>
		          <!-- 카카오 로그인 처리 -->
		          	<form action="kakaologin" method="post" id="kakaoLogin">
					<input type="hidden" name=kakaoid id="kakaoid"> 
					<input type="hidden" name=nickname id="nickname"> 
					<input type="hidden" name=email id="email">
		          </form>
		        </div>
		      </div>
				</div>
			</div>
		</div>
	</section>
	<script >
	Kakao.init('280f4b845b98a0adf26878c0048c5ade'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단
	
	function kakaoLogin() {
		Kakao.Auth.login({
			success : function(response) {
				Kakao.API.request({
					url : '/v2/user/me',
					success : function(response) {
						console.log(response);
						//response는 카카오 api로 부터 return 받은 로그인 정보
						// 값을 form에 세팅
						$("#nickname").val(response.properties.nickname);
						$("#email").val(response.kakao_account.email);
						$("#kakaoid").val(response.id);
						//폼을 전송(글피에로그인처리)
						$("#kakaoLogin").submit();

					},
					fail : function(error) {
						console.log(error)
					},
				})
			},
			fail : function(error) {
				console.log(error)
			},
		})
	}
	//아이디 찾기
	var ingSearchID = false;
	function searchID() {
		if(ingSearchID){
			alert("전송중입니다. 잠시만 기다려주세요.")
			return false;
		}
		ingSearchID = true;
		if ($("#email").val() == '') {
			alert("Email 를 입력하세요.");
			$("#email").focus();
			return false;
		}
		$.ajax({
			url : "/user/searchID",
			data : {
				email : $("#email").val()
			}
		}).done(function(resp) {
			if (resp == true) {
				alert("아이디가 전송되었습니다.")
			} else {
				alert("전송에 실패했습니다 이메일를 확인해주세요.")
			}
			ingSearchID = false;
		})
	}
	
	//비밀번호 찾기
	var ingSearchPw = false;
	function searchPw() {
		if(ingSearchPw){
			alert("전송중입니다. 잠시만 기다려주세요.")
			return false;
		}
		ingSearchPw = true;
		if ($("#id").val() == '') {
			alert("ID 를 입력하세요.");
			$("#id").focus();
			return false;
		}
		$.ajax({
			url : "/user/searchPw",
			data : {
				id : $("#id").val()
			}
		}).done(function(resp) {
			if (resp == true) {
				alert("임시비밀번호가 전송되었습니다.")
			} else {
				alert("전송에 실패했습니다 아아디를 확인해주세요.")
			}
			ingSearchPw = false;
		})
	}

	
	
	</script>
	<script src="/js/signup/jquery.min.js"></script>
 	<script src="/js/signup/popper.js"></script>
  	<script src="/js/signup/bootstrap.min.js"></script>
 	<script src="/js/signup/main.js"></script>
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
	</body>
</html>

