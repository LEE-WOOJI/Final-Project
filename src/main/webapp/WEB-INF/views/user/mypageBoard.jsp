<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<link href="https://cdn.lineicons.com/3.0/lineicons.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/boxicons@2.0.7/css/boxicons.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://code.iconify.design/2/2.1.1/iconify.min.js"></script>
<link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
<!-- Date -->
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
body {
	margin-top: 20px;
	background-color: #f7f7ff;
}
.profile_img {
	margin-left:58px;
   border-radius: 50%;
   width: 150px;
   height: 150px;
}

#boaCon, #repCon{overflow:hidden;text-overflow:ellipsis;white-space:nowrap;}

.list {
	font-family: 'yg-jalnan', verdana, tahoma;
}

.row .col {
	padding: 0px;
}

.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0px solid rgba(0, 0, 0, 0);
	border-radius: .25rem;
	margin-bottom: 1.5rem;
	box-shadow: 0 2px 6px 0 rgb(218 218 253/ 65%), 0 2px 6px 0
		rgb(206 206 238/ 54%);
}

.fm-file-box {
	font-size: 25px;
	background: #e9ecef;
	width: 44px;
	height: 44px;
	display: flex;
	align-items: center;
	justify-content: center;
	border-radius: .25rem;
}

.ms-2 {
	margin-left: .5rem !important;
}

.fm-menu .list-group a {
	font-size: 16px;
	color: #5f5f5f;
	display: flex;
	align-items: center;
}

.list-group-flush>.list-group-item {
	border-width: 0 0 1px;
}

.list-group-item+.list-group-item {
	border-top-width: 0;
}

.py-1 {
	padding-top: .25rem !important;
	padding-bottom: .25rem !important;
}

.list-group-item {
	position: relative;
	display: block;
	padding: .5rem 1rem;
	text-decoration: none;
	background-color: #fff;
	border: 1px solid rgba(0, 0, 0, .125);
}

.radius-15 {
	border-radius: 15px;
}

.fm-icon-box {
	font-size: 32px;
	background: #ffffff;
	width: 52px;
	height: 52px;
	display: flex;
	align-items: center;
	justify-content: center;
	border-radius: .25rem;
}

.font-24 {
	font-size: 24px;
}

.ms-auto {
	margin-left: auto !important;
}

.font-30 {
	font-size: 30px;
}

.user-groups img {
	margin-left: -14px;
	border: 1px solid #e4e4e4;
	padding: 2px;
	cursor: pointer;
}

.rounded-circle {
	border-radius: 50% !important;
}

#header {
	margin-bottom: 100px;
}

a:hover {
	text-decoration-line: none;
}

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
	<div class="container">
		<div class="row" id="header">
			<div class="col">
				<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-12 col-lg-3">
				<div class="card">
					<div class="card-body">
						<div class="d-grid"></div>
						<div class="list-group list-group-flush">
							<a href="/admin/main" class="list-group-item py-1">
								<h5 class="my-3"
									style="font-family: 'yg-jalnan', verdana, tahoma;">관리자 페이지</h5>
							</a>
						</div>
						<div class="fm-menu">
							<div class="profile_box">
                              <img class="profile_img" src="/image/board?nickname=${nickname}">
                              <br>
                           </div>
							
							<div class="list-group list-group-flush">
								<a href="/mypage/updateForm" class="list-group-item py-1"><span
                           class="iconify" data-icon="el:ban-circle" data-width="25"></span>&ensp;<span
                           a href=/mypage/updateUserInfo>내 정보 </span></a>

                           		<a href="/mypage/myChalList" class="list-group-item py-1"><span
                           class="iconify" data-icon="icon-park-outline:gold-medal"
                           data-width="25"></span>&ensp;<span>도전중인 글피</span></a>
                           
                            	<a href="/mypage/myBoardAndReply" class="list-group-item py-1"><span
                           class="iconify" data-icon="jam:coin" data-width="25"></span>&ensp;<span>작성한
                              글 / 댓글</span></a> 
                              
                                <a href="/mypage/zzzim"
                           class="list-group-item py-1"><span class="iconify"
                           data-icon="clarity:list-line" data-width="25"></span>&ensp;<span>내가
                              찜한 글피 </span></a> 
                              
                              
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-12 col-lg-9">
				<div class="card">
					<div class="card-body">
						<form action = "/mypage/myBARSearch" method = "post">
							<div class="row" style = "text-align:center">
								<div class = "col-sm-12 col-md-4 col-lg-2">
								<select class="form-select btn btn-danger" aria-label="Default select example" id = "option" name = "option">
				  					<option selected>검색옵션</option>
				  					<option value="seq">글번호</option>
				  					<option value="title">제목</option>
				  					<option value="contents">내용</option>
								</select>
								</div>
								<div class = "col-sm-12 col-md-4 col-lg-8">
									<input type="text" class="form-control" placeholder="검색어를 입력하세요" aria-label="Recipient's username" aria-describedby="basic-addon2" id = "keyword" name = "keyword">
								</div>
								<div class = "col-sm-12 col-md-4 col-lg-2" style = "margin:0px;">
									<button type="submit" class="btn btn-danger" id = "searchBtn" style = "width:100%;">Search</button>
								</div>
							</div>
						</form>
					</div>
					<br>
					<br>
					
					<!-- 글 리스트 -->
					<div class="table" id = "silver" style="height : 400px;overflow-y: scroll;overflow-x:hidden;">
						<h6 class="mt-3 mb-0" style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma;">글 리스트</h6>
						<br>
						<div class="row" style="text-align: center; line-height: 30px; border: none; background-color:#e6e5e4;">
							<div class="col-2 list" style="padding: 0px;">글번호</div>
							<div class="col-3 list" style="padding: 0px;">제목</div>
							<div class="col-2 list" style="padding: 0px;">내용</div>
							<div class="col-2 list" style="padding: 0px;">닉네임</div>
							<div class="col-1 list" style="padding: 0px;">조회수</div>
							<div class="col-2 list" style="padding: 0px;">작성일</div>
						</div>
						<c:forEach var="list" items="${blist}">
							<br>
							<div class="row" style="text-align: center; line-height: 30px; border: none;">
								<div class="col-2" style="padding: 0px;">${list.seq}</div>
								<div class="col-3" style="padding: 0px;"><a href="/board/detail?cpage=1&seq=${list.seq}" class="text-big" data-abc="true"
									style="color: black;">${list.title}</a></div>
								<div class="col-2" style="padding: 0px;" id = "boaCon">${list.contents}</div>
								<div class="col-2" style="padding: 0px;">${list.nickname}</div>
								<div class="col-1" style="padding: 0px;">${list.view_count}</div>
								<div class="col-2" style="padding: 0px;">
								<fmt:formatDate pattern="yyyy년 MM월 dd일" value = "${list.write_date}"/>
								</div>
							</div>
						</c:forEach>
					</div>
					<br>
					<br>
					<br>
					<!-- 댓글 리스트 -->
					<div class="table" id = "gold" style="height : 400px;overflow-y: scroll; overflow-x:hidden;"">
						<h6 class="mt-3 mb-0" style="text-align: center; font-family: 'yg-jalnan', verdana, tahoma;">댓글 리스트</h6>
						<br>
						<div class="row" style="text-align: center; line-height: 30px; border: none; background-color:#fff09b;">
							<div class="col-2 list" style="padding: 0px;">댓글 번호</div>
							<div class="col-2 list" style="padding: 0px;">글 번호</div>
							<div class="col-2 list" style="padding: 0px;">닉네임</div>
							<div class="col-2 list" style="padding: 0px;">작성일</div>
							<div class="col-4 list" style="padding: 0px;">댓글 내용</div>
						</div>
						<c:forEach var="list" items="${rlist}">
							<br>
							<div class="row" style="text-align: center; line-height: 30px; border: none; ">
								<div class="col-2" style="padding: 0px;">${list.seq}</div>
								<div class="col-2" style="padding: 0px;">${list.refBoardSeq}</div>
								<div class="col-2" style="padding: 0px;">${list.writerNickname}</div>
								<div class="col-2" style="padding: 0px;">
								<fmt:formatDate pattern="yyyy년 MM월 dd일" value = "${list.write_date}"/>
								</div>
								<div class="col-4" style="padding: 0px;" id = "repCon"><a href="/board/detail?cpage=1&seq=${list.refBoardSeq}" class="text-big" data-abc="true"
									style="color: black;">${list.repContents}</a></div>
								</div>
						</c:forEach>
					</div>
					
				</div>
			</div>
		</div>
	</div>

	<!-- 풋터 -->
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />

	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	<script>
		
		$("#searchBtn").on("click",function(){
			
			if($("#option").val() == "검색옵션"){
				alert("검색옵션을 선택해주세요.");
				return false;
			}
			if($("#keyword").val() == ""){
				alert("검색어를 입력해주세요.");
				return false;
			}
		})
		
	</script>
</body>
</html>