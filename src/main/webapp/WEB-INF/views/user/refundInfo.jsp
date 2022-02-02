<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Date -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글피 - Glory Trophy</title>

<!-- Favicon-->
<link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<style>
@font-face {
	font-family: 'yg-jalnan';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

@font-face {
	font-family: 'S-CoreDream-4Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-4Regular.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	padding: 0;
	margin: 0;
}

#pop_container {
	font-family: 'NotoSans', '맑은 고딕', 'Malgun Gothic', "돋움", dotum, arial,
		sans-serif;
	text-align: center;
	position: relative;
}

.top {
	position: relative;
	display: flex;
	justify-content: space-between;
	padding: 0.5rem 1.4rem;
	background-color: rgb(228, 72, 72);
	vertical-align: middle;
}

h1.infoTit {
	font-size: 20px;
	color: #ffffff;
}

main.textBox {
	padding-top: 2em;
	text-align: center;
}

h2.tit {
	font-size: 1.6em;
	letter-spacing: -2px;
	font-weight: bold;
	line-height: 1.5em;
}

p {
	line-height: 1.8em;
}

p.textContents {
	margin: 1.5em 1.8em;
	font-size: 1.1em;
	font-weight: 200;
}

table {
	margin-left: auto;
	margin-right: auto;
}

footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	background-color: #dddddd;
}

footer.btnBox_todayClose {
	padding: 0.5rem 0 0.7rem;
	display: flex;
	justify-content: flex-end;
}

form {
	padding-right: 2rem;
}

input#chkday {
	width: 17px;
	height: 17px;
	vertical-align: middle;
}

label {
	vertical-align: middle;
}

table {
	width: 100%;
	border: 1px solid #333333;
	border-collapse: collapse;
}

td {
	padding: 10px;
	border: 2px solid #333333;
}

.title {
	background-color: rgba(128, 128, 128, 0.068);
	font-family: 'yg-jalnan', verdana, tahoma;
}
</style>
<body>

	<div class="container">
		<div class="btnBox">
			<a class="btn_popup" href="javascript:void(0);" onclick="window.open('../refundInfo', 'a', 
                       'top=140, left=300, width=500, height=600, menubar=no, toolbar=no, location=no, directories=no, status=no, scrollbars=no, copyhistory=no, resizable=no');"> 팝업창 호출</a>
		</div>
	</div>
	
	<!-- 환급 버튼 누를 시 /user/refund 로 파라미터들 보내기  -->
	<form action="/user/refund" method="post" id="frm">
		<!-- 타이틀 -->
		<div id="popup">
			<header class="top">
				<h1 class="infoTit">환급 안내</h1>
			</header>
			<!-- 컨텐츠 알맹이들 -->
			<main class="textBox">
				<input type="hidden" name="chalSeq" value="${dto.chalSeq} ">
				<h2 class="tit" name="nickname" style="font-family: 'yg-jalnan', verdana, tahoma;">${dto.nickname}님의글피결과</h2>

				<!-- 글피 트로피 이미지 -->
				<img src="/src/main/webapp/resources/assets/img/about/trophy.png" style="width: 300px; margin-bottom: 10px;">

				<!-- 참여한 글피 관련 정보 테이블 -->
				<table align="center" style="width: 300px;">
					<tr>
						<td class="title">참여한 글피</td>
						<td style="background-color: white; font-family: 'S-CoreDream-4Regular'">${dto.chalName}</td>
					</tr>
					<tr>
						<td class="title">참여 기간</td>
						<td><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${startDate }~${endDate }" /></td>
					</tr>
					<tr>
						<td class="title">신청금</td>
						<td style="font-family: 'S-CoreDream-4Regular'">10,000원</td>
					</tr>
					<tr>
						<td class="title">달성률</td>
						<td style="font-family: 'S-CoreDream-4Regular'">${dto.rate}%</td>
					</tr>
					<tr>
						<td class="title">환급금</td>
						<td style="font-family: 'S-CoreDream-4Regular'">${dto.price}원</td>
					</tr>
				</table>
				</p>

				<!-- 환급받을 계좌 선택 -->
				<p style="font-family: 'yg-jalnan', verdana, tahoma;">
					<strong>환급 계좌 정보</strong>
				</p>
				<select name="bank" style="font-family: 'S-CoreDream-4Regular'; text-align: center;">
					<option>우리</option>
					<option>KB국민</option>
					<option>기업</option>
					<option>농협</option>
					<option>산업</option>
					<option>수협</option>
					<option>신한</option>
					<option>우체국</option>
					<option>하나</option>
					<option>한국씨티</option>
					<option>SC제일</option>
					<option>새마을금고</option>
					<option>카카오뱅크</option>
					<option>케이뱅크</option>
					<option>토스뱅크</option>
				</select>

				<!-- 계좌번호 적기 -->
				<input type="text" name="account" placeholder=" - 제외한 숫자만 입력해주세요" style="width: 300px; text-align: center; font-family: 'S-CoreDream-4Regular'">
				<br> <br>

				<p style="font-family: 'yg-jalnan', verdana, tahoma;">
					<strong>환급 금액</strong>
				</p>
				
				<input type="text" value="${dto.price}원" placeholder="- 제외한 숫자만 입력해주세요" style="width: 200px; text-align: center; font-family: 'S-CoreDream-4Regular'" readonly>
				<br>

				<p style="font-size: 13px; font-family: 'S-CoreDream-4Regular'; margin: 10px 0px 0px;">*환급 금액은 따로 지정이 불가합니다.</p>
				<p style="font-size: 13px; font-family: 'S-CoreDream-4Regular'">환급은 입력하신 계좌로 영업일 기준 2-3일, 최대 7일 내에 입급됩니다.</p>

				<!-- 환급 / 취소 버튼 -->
				<button type="submit" class="btn btn-danger" id="refundOk" style="font-family: 'S-CoreDream-4Regular'">환급</button>
				<button type="button" class="btn btn-danger" id="refundCancle" style="font-family: 'S-CoreDream-4Regular'">취소</button>
				<br> <br>
	</form>
	</main>
	</div>
	<script>
		$("#refundOk").on("click",function(){
			if(confirm("입력하신 계좌로 환급 신청을 하시겠습니까?")==true){
				frm.submit();
			}
		})
		
		$("#refundCancle").on("click",function(){
			alert("환급신청이 취소됐습니다.");
			location.href="/user/mypage"
		})
		
		
	</script>

</body>
</html>