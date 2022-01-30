<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<title>회원가입</title>
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

	var confirmId = ""; // 중복확인 후 전역변수에 확인한 ID 대입.
	$(function() {
		
		$("#check").on("click", function() {
			if ($("#id").val() == '') {
				alert("ID 를 입력하세요.");
				$("#id").focus();
				return false;
			}
			 var id = $("input[name=id]").val()
			 var num = id.search(/[0-9]/g);
			 var eng = id.search(/[a-z]/ig);
			 var idJ = id.search(/^[a-z0-9]{6,12}$/);
			
			  

			 if(id.length < 6 || id.length > 12){

			  alert("6~12자리 이내로 입력해주세요.");
			  return false;
			}else if(id.search(/\s/) != -1){
			  alert("아이디는 공백 없이 입력해주세요.");
			  return false;
			}else if(num < 0 || eng < 0){
			  alert("영문,숫자 혼합하여 입력해주세요.");
			    return false;
			}
			$.ajax({
				url : "/user/idcheck",
				data : {
					id : $("#id").val()
				}
			}).done(function(resp) {
				debugger;
				if (resp == "true") {
					$("#checkResult").css("color", "red")
					$("#checkResult").css("font-size", "12px")
					$("#checkResult").text("이미사용중인 아이디 입니다.")
					confirmId = ""; // 중복되면 id 제거
				} else {
					$("#checkResult").css("color", "#5daf5d")
					$("#checkResult").css("font-size", "12px")
					$("#checkResult").text("사용가능한 아이디 입니다.")
					confirmId = $("#id").val(); // 중복되지 않으면 id 저장. 
					console.log(confirmId);
					
				}
				
			})
		});
	})
		
	var confirmNic = ""; // 중복확인 후 전역변수에 확인한 닉넥임 대입.	
	$(function() {
		
		$("#niccheck").on("click", function() {
			if ($("#nickname").val() == '') {
				alert("닉네임을 입력하세요.");
				$("#nickname").focus();
				return false;
			}
			
			$.ajax({
				url : "/user/nickcheck",
				data : {
					nickname : $("#nickname").val()
				}
			}).done(function(resp) {
				if (resp == "true") {
					$("#niccheckResult").css("color", "red")
					$("#niccheckResult").css("font-size", "12px")
					$("#niccheckResult").text("이미사용중인 닉네임 입니다.")
					confirmNic = ""; // 중복되면 닉네임 제거
				} else {
					$("#niccheckResult").css("color", "#5daf5d")
					$("#niccheckResult").css("font-size", "12px")
					$("#niccheckResult").text("사용가능한 닉네임 입니다.")
					confirmNic = $("#nickname").val(); // 중복되지 않으면 닉네임 저장.
					
				}
				
			})
		});
	})
	
	var confirmEmail = ""; // 중복확인 후 전역변수에 확인한 이메일 대입.	
	$(function() {
		
		$("#emailcheck").on("click", function() {
			if ($("#email").val() == '') {
				alert("이메일를 입력하세요.");
				$("#email").focus();
				return false;
			}
			
			$.ajax({
				url : "/user/emailcheck",
				data : {
					email : $("#email").val()
				}
			}).done(function(resp) {
				if (resp == "true") {
					$("#emailcheckResult").css("color", "red")
					$("#emailcheckResult").css("font-size", "12px")
					$("#emailcheckResult").text("이미사용중인 이메일 입니다.")
					confirmEmail = ""; // 중복되면 이메일 제거
				} else {
					$("#emailcheckResult").css("color", "#5daf5d")
					$("#emailcheckResult").css("font-size", "12px")
					$("#emailcheckResult").text("사용가능한 이메일 입니다.")
					confirmEmail = $("#email").val(); // 중복되지 않으면 이메일 저장.
					
				}
				
			})
		});
	})
	$(document).ready(function() {
	    var readURL = function(input) {
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();
	
	            reader.onload = function (e) {
	                $('.profile-pic').attr('src', e.target.result);
	            }
	            reader.readAsDataURL(input.files[0]);
	        }
	    }
	
	    $(".file-upload").on('change', function(){
	        readURL(this);
	    });
	    
	    $(".upload-button").on('click', function() {
	       $(".file-upload").click();
	    });
	});
	//회원가입 시 필수 값 체크
	function validation() {
		if ($("#id").val() == '') {
			alert("ID 를 입력하세요.");
			$("#id").focus();
			return false;
		}

		// 전역 변화 값과 입력값 같으면 pass
	
		if (confirmId != $("#id").val()){
			alert("ID 중복확인 해주세요.");
			
			return false;
		}
		  var idReg = /^[a-z]+[a-z0-9]{5,11}$/g;
	        if( !idReg.test( $("input[name=id]").val() ) ) {
	            alert("아이디는 특수문자를 제외한 영문자 숫자를 혼합하여야합니다.");
	            return false;
	        }
		

	    if ($("#ps").val() == '') {
			alert("비밀번호를 입력하세요.");
			$("#ps").focus();
			return false;
		}
		 var pw = $("input[name=pw]").val()
		 var num = pw.search(/[0-9]/g);
		 var eng = pw.search(/[a-z]/ig);
		 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi); 

		 if(pw.length < 8 || pw.length > 20){

		  alert("특수문자를 포함한 8~20자리 이내로 입력해주세요.");
		  return false;
		}else if(pw.search(/\s/) != -1){
		  alert("비밀번호는 공백 없이 입력해주세요.");
		  return false;
		}else if(num < 0 || eng < 0 || spe < 0 ){
		  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
		    return false;
		}
		if( $("#ps").val() != $("#reps").val() ) {
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        }
		if ($("#name").val() == '') {
			alert("이름을 입력하세요.");
			$("#name").focus();
			return false;
		}
		var name = /^[가-힣]{2,4}$/;
		if(!name.test($("input[name=name]").val() ) ){
			alert("이름입력은 영어,숫자,특수문자를 제외한 한글 2~4글자만 입력해주시기 바랍니다.");
		return false;
		}
		
		if ($("#nickname").val() == '') {
			alert("사용할 닉네임을 확인해주세요.");
			$("#nickname").focus();
			return false;
		}
		if ($("#phone").val() == '') {
			alert("휴대폰 번호를 확인해주세요.");
			$("#phone").focus();
			return false;
		}
		if ($("#email").val() == '') {
			alert("이메일을 확인해주세요.");
			$("#email").focus();
			return false;
		}
		  var emailReg = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/g;
	        if( !emailReg.test( $("input[name=email]").val() ) ) {
	            alert("이메일 형식을 다시한번 확인해주세요.");
	            return false;
	        }
		if ($("#ad").val() == '') {
			alert("우편번호를 선택해주세요.");
			$("#ad").focus();
			return false;
		}
		if ($("#ad1").val() == '') {
			alert("주소를 입력해주세요.");
			$("#ad1").focus();
			return false;
		}
		if ($("#ad2").val() == '') {
			alert("주소를 입력해주세요.");
			$("#ad2").focus();
			return false;
		}
		var answer=confirm("회원가입을 하시겠습니까?");
		if (answer==false){
			return false
		}
		return true;
			
		
	    }
		function pwcheck(pwval){
			if(pwval.id == "ps") {
			
				var pw = $("input[name=pw]").val()
				var num = pw.search(/[0-9]/g);
				var eng = pw.search(/[a-z]/ig);
				var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
				if ($("#ps").val() == '') {
					$('#pwcheck1').text("비밀번호를 입력하세요.");
					$('#pwcheck2').text("");
					return false;
				}else if(pw.length < 8 || pw.length > 20){
					$('#pwcheck1').text("8자리 ~ 20자리 이내로 입력해주세요.");
					$('#pwcheck2').text("");
					return false;
				}else if(pw.search(/\s/) != -1){
					$('#pwcheck1').text("비밀번호는 공백 없이 입력해주세요.");
					$('#pwcheck2').text("");
					return false;
				}else if(num < 0 || eng < 0 || spe < 0 ){
					$('#pwcheck1').text("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
					$('#pwcheck2').text("");
					return false;
				}else{
					if($("#reps").val() != "") {
						if( $("#ps").val() != $("#reps").val() ){
							$('#pwcheck2').text("비밀번호불일치");
							$('#pwcheck2').css('color','red')
						}else if( $("#ps").val() == $("#reps").val() ){
							$('#pwcheck2').text("비밀번호일치");
							$('#pwcheck2').css('color','green')
						}
					}
					$('#pwcheck1').text("");
				}
			}
			if(pwval.id == "reps") {
				if ($('#pwcheck1').text()!=""){
					return false;
				}
				if ($("#reps").val() == '') {
					$('#pwcheck2').text("비밀번호를 입력하세요.");
					$('#pwcheck2').css('color','red')
				}else if( $("#ps").val() != $("#reps").val() ) {
		            $('#pwcheck2').text("비밀번호불일치");
		            $('#pwcheck2').css('color','red')
				}else if( $("#ps").val() == $("#reps").val() ) {
		            $('#pwcheck2').text("비밀번호일치");
		            $('#pwcheck2').css('color','green')
		            
		        }else{
		        	$('#pwcheck2').text("");
		        }
			}
				
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
		<form action="signproc" class="signup-form"
			onsubmit="return validation()" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="small-12 medium-2 large-2 columns"
				style="text-align: center">
				<div class="circle">
					<img class="profile-pic"
						style="width: 300px; height: 300px; border-radius: 50%;"
						src="/assets/img/디폴트이미지.jpg">

				</div>

				<div class="p-image">
					<i class="fa fa-camera upload-button"></i> 
					<!-- <input class="file-upload" type="file" accept="image/*" style="width: 220px" > -->
					<label id="fileUpload">사진 선택<input type="file" name="file" accept="image/*" class="file-upload"
						id="file" accept="jpg,jpeg,png" style="display: none;">
					</label>
				</div>
			</div>
		</div>
		&nbsp;
		&nbsp;
		<h3 class="text-center mb-4">회원가입</h3>

			<div class="form-group col-lg-3 mb-3 ">
				<input type="text" class="form-control" placeholder="아이디" name="id"
					id="id" maxlength="12"
					style="width: 69%; display: inline-block; font-family: 'yg-jalnan', verdana, tahoma;">
				<button type="button" id="check" value="중복검사"
					class="form-control btn btn-primary submit px-2"
					style="text-align: center; width: 30%; font-family: 'yg-jalnan', verdana, tahoma;">중복검사</button>
				<span id="checkResult"></span>
			</div>

			<div class="form-group col-lg-3 mb-3">
				<input type="password" name="pw" id="ps" class="form-control"
					placeholder="비밀번호 특수문자 포함 8~20자리" onblur="pwcheck(this);"
					style="font-size: smaller;font-family: 'yg-jalnan', verdana, tahoma;"> <span
					id="pwcheck1" style="color: red;"></span>
			</div>


			<div class="form-group col-lg-3 mb-3">
				<input type="password" id="reps" class="form-control"
					placeholder="비밀번호 확인" onblur="pwcheck(this);"
					style="font-size: smaller;font-family: 'yg-jalnan', verdana, tahoma;"> <span
					id="pwcheck2" style="color: red;"></span>
			</div>


			<div class="form-group col-lg-3 mb-3">
				<input type="text" name="name" id="name" maxlength="4"
					class="form-control" placeholder="이름"
					style="font-size: smaller;font-family: 'yg-jalnan', verdana, tahoma;">

			</div>
			<div class="form-group col-lg-3 mb-3">
				<input type="text" name="nickname" id="nickname" maxlength="10"
					class="form-control" placeholder="닉네임"
					style="width: 69%;font-size: smaller; display: inline-block; font-family: 'yg-jalnan', verdana, tahoma;">
				<button type="button" id="niccheck" value="중복검사"
					class="form-control btn btn-primary submit px-2"
					style="text-align: center; width: 30%; font-family: 'yg-jalnan', verdana, tahoma;">중복검사</button>
				<span id="niccheckResult"></span>
			</div>


			<div class="form-group col-lg-3 mb-3">
				<input type="text" name="phone" id="phone" max="9999" maxlength="11"
					size="28" onKeyup="this.value=this.value.replace(/[^0-9]/g,'')"
					class="form-control" placeholder="연락처 ex) - 없이 숫자로만 입력해주세요"
					style="font-size: smaller;font-family: 'yg-jalnan', verdana, tahoma;">
			</div>


			<div class="form-group col-lg-3 mb-3">
				<input type="text" class="form-control" name="email" id="email"
					placeholder="이메일 ex) glorytrophy@gmail.com"
					style="width: 69%;display: inline-block;font-size: smaller;font-family: 'yg-jalnan', verdana, tahoma;">
				<button type="button" id="emailcheck" value="중복검사"
					class="form-control btn btn-primary submit px-2"
					style="text-align: center; width: 30%; font-family: 'yg-jalnan', verdana, tahoma;">중복검사</button>
				<span id="emailcheckResult"></span>
			</div>


			<div class="form-group col-lg-3 mb-3">
				<input type="text" name=zipcode id=zipcode max="99999" maxlength="5"
					onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" readonly
					class="form-control" placeholder="우편번호"
					style="font-size: smaller;width: 70%; display: inline-block; font-family: 'yg-jalnan', verdana, tahoma;">

				<button type="button" value="우편번호찾기" id="ad"
					class="form-control btn btn-primary submit px-3"
					style="text-align: center; width: 26%; font-family: 'yg-jalnan', verdana, tahoma;">
					찾기</input>
					<script>
									//카카오 api 우편번호 검색 
									document.getElementById("ad").onclick = function(){
									      new daum.Postcode({
									          oncomplete: function(data) {
									               // 우편번호와 주소 정보를 해당 필드에 넣는다.
									               document.getElementById('zipcode').value = data.zonecode;
									               document.getElementById("ad1").value = data.roadAddress;
									              
									               }
									           }).open();
									}
									</script>
			</div>
			<div class="form-group col-lg-3 mb-3">
				<input type="text" name="address1" id="ad1" class="form-control"
					placeholder="주소" style="font-size: smaller;font-family: 'yg-jalnan', verdana, tahoma;"
					readonly>
			</div>
			<div class="form-group col-lg-3 mb-3">
				<input type="text" name="address2" id="ad2" class="form-control"
					placeholder="상세주소"
					style="font-size: smaller;font-family: 'yg-jalnan', verdana, tahoma;">
			</div>
			<div class="form-group col-lg-3 mb-3">
				<input type="submit" value="가입완료" id="regi"
					class="form-control btn btn-primary submit px-3"
					style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma;" />

			</div>

		</form>
		<p style="text-align: center;">
			이미 회원인가요? <a href="/user/loginform"
				style="color: rgb(228, 72, 72); font-family: 'yg-jalnan', verdana, tahoma;">로그인</a>
		</p>
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