<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Glory Trophy</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="/assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Font Awesome icons (free version)-->
<link href="/css/styles.css" rel="stylesheet" />
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<style type="text/css">
@font-face {
   font-family: 'yg-jalnan';
   src:
      url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
      format('woff');
   font-weight: normal;
   font-style: normal;
}

#login,#logout, #glphy, #community, #mypage{
   font-family: 'yg-jalnan', verdana, tahoma;
}

</style>
<script type="text/javascript">

Kakao.init('280f4b845b98a0adf26878c0048c5ade'); //발급받은 키 중 javascript키를 사용해준다.

function logout() {
		if (confirm("정말 로그아웃 하시겠습니까?")) {
			if (Kakao.Auth.getAccessToken()) {
				Kakao.API.request({
					url : '/v1/user/unlink',
					success : function(response) {
						location.href = "/user/logout"; //카카오api 결과값을 받은후 로그아웃 처리
					},
					fail : function(error) {
						location.href = "/user/logout";
					},
				})
				Kakao.Auth.setAccessToken(undefined)
			} else {
				location.href = "/user/logout"; //카카오 api를 사용한 로그인이 아니고 일반 로그인인 경우
			}

		}
	}
</script>
</head>
<!-- header -->
<body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav" style = "background-color:rgb(228, 72, 72);">
            <div class="container">
                <!--로고-->
                <a class="navbar-brand" href="/"><img src="/assets/img/logo.png" alt="..." id = "toplogo"/></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <c:if test="${loginId != null }"><div style = "color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${loginId}님 환영합니다!</div></c:if>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link" href="/chal/list"><span id = "glphy">Glphy</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="/board/main?cpage=1"><span id = "community">Community</span></a></li>
                        <c:if test="${loginId == null }">
                     <li class="nav-item"><a class="nav-link" href="/user/loginform"><span id = "login">login</span></a></li>
                  </c:if>
                  <c:if test="${loginId != null}" >
                     	<c:if test = "${loginId == 'admin1234' }">
                     		<li class="nav-item"><a class="nav-link" href="/admin/main"><span id = "mypage">Admin Page</span></a></li>
                         	<li class="nav-item"><a class="nav-link" href ="/user/logout"><span id = "logout">Logout</span></a><li>
                     	</c:if>
                     	<c:if test = "${loginId != 'admin1234' }">

                     		<li class="nav-item"><a class="nav-link" href="/mypage/myChalList"><span id = "mypage">My Page</span></a></li>
                            <li class="nav-item"><a class="nav-link" href ="javascript:logout();"><span id = "logout">Logout</span></a><li>

                     	</c:if>
                  </c:if>
                  
                    </ul>

                </div>
            </div>
        </nav>
    </body>