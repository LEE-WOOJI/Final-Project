<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글피 - Glory Trophy</title>
<!-- Favicon-->
<link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- JavaScript Includes -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<!--  icons-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- CSS -->
<link href="/css/chalPayment.css" rel="stylesheet" />
<!-- head -->
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
 
<!-- 아임포트 -->
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>

</head>
<body>
	<!-- 비회원일경우 로그인페이지로 돌아가기 -->
	<!--<c:if test="${loginID == null }">
		<script>
			alert("로그인 후 참여가능합니다.");
			location.href = "/user/login";
		</script>
	</c:if>-->
	
	<div class=" container mt-5 mb-5 d-flex justify-content-center">
		<div class="border border-3 border-warning  card p-5" style="margin-top: 100px; width: 1000px;">
			<div>
				<div>
					<span style="font-family: 'yg-jalnan', verdana, tahoma; text-align: left; font-size: 30px ">결제완료</span><br>
					<!-- 대표 이미지 -->
					<div style="text-align: center;">
					<img class="card-img-top mb-5 mb-md-0" src="/assets/img/chalDetail/hands.png" style="text-align:center; width: 200px; height: 200px;" ><br><br>
					<span style="font-family: 'S-CoreDream-4Regular'; text-align: center; font-size: 25px;">글피에 참여해주셔서 감사합니다.<br> 어제보다 나아진 오늘,<br> 오늘보다 나아갈 내일을 위하여 글피가 함께합니다.</span>
					</div>
				</div>
				<!-- 글피 이름 -->
				<h4 class="heading" style="font-family: 'yg-jalnan', verdana, tahoma; font-size: 30px;">${dto.chalName }</h4>
				<!-- 글피 시작날짜~종료날짜 -->
				<p class="text" style="font-family: 'S-CoreDream-4Regular'; color: black;">${dto.SDate }~ ${dto.EDate }</p>
			</div>

		
			<div class="mt-3" style="text-align: center;">
				<button class="btn btn-danger btn-block payment-button" id="home" style="font-family: 'yg-jalnan', verdana, tahoma; color: white;">
					홈으로
				</button>
			</div>
		</div>
	</div>
</body>

<script>

// 취소하기 버튼 누르면 chalDetail 로 돌아감.
	$("#home").on("click",function(){
		location.href = "/chal/list";
	});


</script>

<!-- Footer-->
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
</html>