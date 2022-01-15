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
<link rel="icon" type="image/x-icon" href="/assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700"
	rel="stylesheet" type="text/css" />
<!-- Font Awesome icons (free version)-->
<link href="/css/styles.css" rel="stylesheet" />

<style type="text/css">
@font-face {
	font-family: 'yg-jalnan';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

#login, #glphy, #community, #mypage{
	font-family: 'yg-jalnan', verdana, tahoma;
}

</style>
</head>
<!-- header -->
<body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav" style = "background-color:rgb(228, 72, 72);">
            <div class="container">
                <!--로고-->
                <a class="navbar-brand" href="#page-top"><img src="/assets/img/logo.png" alt="..." id = "toplogo"/></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link" href="/chal/list"><span id = "glphy">Glphy</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="/board/main"><span id = "community">Community</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="#My page"><span id = "mypage">My Page</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="#Login"><span id = "login">login</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>