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
	<c:if test="${loginId == null }">
		<script>
			alert("로그인 후 참여가능합니다.");
			location.href = "/user/login";
		</script>
	</c:if>
	
	
	<form id=frm method="post" action="/chal/chalOut">
		<input type=hidden value="${dto.chalSeq}" name="refChalSeq">
		<input type=hidden value="${member.nickname}" name="nickname">	
		<input type=hidden value="${dto.chalName}" name="chalName">
		<input type=hidden value="${dto.startDate}" name="startDate">	
		<input type=hidden value="${dto.endDate}" name="endDate">
		<input type=hidden value="${dto.personnel}" name="personnel">	
		<input type=hidden value="${dto.chalInfo}" name="chalInfo">
		<input type=hidden value="${dto.tag}" name="tag">
		<input type=hidden value="Y" name="chalStat">
	</form>
	
	
	<div class=" container mt-5 mb-5 d-flex justify-content-center">
		<div class="border border-3 border-warning  card p-5" style="margin-top: 100px; width: 1000px;">
			<div>
			<span style="font-family: 'yg-jalnan', verdana, tahoma; text-align: left; font-size: 30px ">결제</span><br>
				<div style="text-align: center;">
				
					<input type=hidden value="${dto.chalSeq}" name="chalSeq" id=chalSeq>
					<!-- 대표 이미지 -->
					<img src="/image/chalModifyLoad?chalSeq=${dto.chalSeq}" alt="">
				</div>
				<!-- 글피 이름 -->
				<h4 class="heading" style="font-family: 'yg-jalnan', verdana, tahoma; font-size: 30px;">${dto.chalName }</h4>
				<!-- 글피 시작날짜~종료날짜 -->
				<p class="text" style="font-family: 'S-CoreDream-4Regular'; color: black;">${dto.SDate }~ ${dto.EDate }</p>
			</div>
	
			<!--가격 만원 부분-->
			<div class="border border-light  bg-light p-3 rounded mt-4 d-flex justify-content-between">
				<div class="images align-items-center">
					<i class="fas fa-user-friends fa-lg"></i>&nbsp;
					<span style="font-family: 'S-CoreDream-4Regular'">참가인원 ${dto.personnel} 명</span>
				</div>
			</div>

			<!--가격 만원 부분-->
			<div class="border border-light bg-light p-3 rounded mt-4 d-flex justify-content-between"  style="font-family: 'yg-jalnan', verdana, tahoma">
				<div class="images d-flex flex-row align-items-center">
					<div class="d-flex flex-column ml-4">
						<span class="chalMoney">참가비</span>
						<span class="chalMoney" style="font-family: 'S-CoreDream-4Regular'">모든 글피의 참가비는 동일합니다.</span>
					</div>
				</div>
				<div class="d-flex flex-row align-items-center">
					<span class="amount ml-1 mr-1">10,000</span>
					<span class="year font-weight-bold">원</span>
				</div>
			</div>
			
		
			<span class="detail mt-5" style="font-family: 'yg-jalnan', verdana, tahoma;">결제 수단</span>
			<span class="plan" style="font-family: 'S-CoreDream-4Regular'">목표에 돈을 걸고 의지를 유지하세요!</span>
			
			<div class="credit rounded mt-4 d-flex justify-content-between align-items-center" style="font-family: 'S-CoreDream-4Regular'">
				<div class="d-flex flex-row align-items-center">
					<img src="https://i.imgur.com/qHX7vY1.png" class="rounded" width="70">
					<div class="d-flex flex-column ml-3">
						<span class="business">&nbsp;카드결제</span>
					</div>
				</div>
				<div>
					<button type="button" class="btn btn-danger" id="iamport" style="color: white;">결제하기</button>
				</div>
			</div>
			<div class="credit rounded mt-2 d-flex justify-content-between align-items-center" style="font-family: 'S-CoreDream-4Regular'">
				<div class="d-flex flex-row align-items-center">
					<img src="/assets/img/chalDetail/통장.png" class="rounded" width="70">
					<div class="d-flex flex-column ml-3">
						<span class="business">&nbsp;무통장입금&nbsp;&nbsp;&nbsp;&nbsp; 
						<img src="/assets/img/chalDetail/kb.png" style="width: 150px"> 
						660401-01-826550 (주)글피  </span>
					</div>
				</div>
				<div>
					<button type="button" class="btn btn-danger" id="accountPay" style="color: white;">결제하기</button>
				</div>
			</div>
			
		
			<div class="mt-3" style="text-align: center;">
				<button class="btn btn-danger btn-block payment-button" id="payBtn" style="font-family: 'yg-jalnan', verdana, tahoma; color: white;">
					결제취소
				</button>
				<button class="btn btn-danger btn-block payment-button" id="list" style="font-family: 'yg-jalnan', verdana, tahoma; color: white;">
					목록으로
				</button>
			</div>
		</div>
	</div>
</body>

<script>

// 취소하기 버튼 누르면 chalDetail 로 돌아감.
$("#payBtn").on("click",function(){
	location.href = "/chal/detail?seq=${dto.chalSeq}"
});

// 목록으로 돌아가기.
$("#list").on("click",function(){
	location.href = "/chal/list"
});

//목록으로 돌아가기.
$("#accountPay").on("click",function(){
	$("#frm").submit();
});




$(document).ready(function(){ 
		var IMP = window.IMP;
		var code = "imp57075748"; //가맹점 식별코드
		IMP.init(code);
		
		$("#iamport").click(function(e){
			//결제요청
			IMP.request_pay({
				//name과 amout만있어도 결제 진행가능
				//pg : 'kakao', //pg사 선택 (kakao, kakaopay 둘다 가능)
				pay_method: 'card',
				merchant_uid : 'merchant_' + new Date().getTime(),
				name : '${dto.chalName }', // 상품명
				amount : 10000,
				buyer_email :'${member.email}',
				buyer_name : '${member.name}',
				buyer_tel : '${member.phone}',  //필수항목
			}, function(rsp){
				if(rsp.success){//결제 성공시
					var msg = '결제가 완료되었습니다';
					var result = {
					"imp_uid" : rsp.imp_uid,
					"merchant_uid" : rsp.merchant_uid,
					"biz_email" : '',
					"pay_date" : new Date().getTime(),
					"amount" : rsp.paid_amount,
					"card_no" : rsp.apply_num,
					"refund" : 'payed'
					}
					console.log("결제성공 " + msg);
					$("#frm").submit();
					//location.href = "/chal/chalOut?seq=${dto.chalSeq}";
	
				}else{//결제 실패시
					var msg = '결제에 실패했습니다';
					msg += '에러 : ' + rsp.error_msg
				}
				 alert(msg);
			});//pay
		}); //check1 클릭 이벤트
	});	
</script>

<!-- Footer-->
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
</html>