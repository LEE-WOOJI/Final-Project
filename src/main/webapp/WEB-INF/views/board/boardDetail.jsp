<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>${bList.title}</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<script
	src="https://github.com/summernote/summernote/tree/master/lang/summernote-ko-KR.js"></script>
<style>
body {
	margin: 0;
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
	font-size: .88rem;
	font-weight: 400;
	line-height: 1.5;
	color: #495057;
	background-color: #eef1f3;
}

.mt-100 {
	margin-top: 80px;
}

.card {
	box-shadow: 0 0.46875rem 2.1875rem rgba(4, 9, 20, 0.03), 0 0.9375rem
		1.40625rem rgba(4, 9, 20, 0.03), 0 0.25rem 0.53125rem
		rgba(4, 9, 20, 0.05), 0 0.125rem 0.1875rem rgba(4, 9, 20, 0.03);
	border-width: 0;
	transition: all .2s;
	margin: auto;
}

.card-header:first-child {
	border-radius: calc(.25rem - 1px) calc(.25rem - 1px) 0 0
}

.card-header {
	display: flex;
	align-items: center;
	border-bottom-width: 1px;
	padding-top: 0;
	padding-bottom: 0;
	padding-right: .625rem;
	height: 3.5rem;
	background-color: #fff;
	border-bottom: 1px solid rgba(26, 54, 126, 0.125);
}

.btn-primary.btn-shadow {
	box-shadow: 0 0.125rem 0.625rem rgba(63, 106, 216, 0.4), 0 0.0625rem
		0.125rem rgba(63, 106, 216, 0.5);
}

.btn.btn-wide {
	padding: .375rem 1.5rem;
	font-size: .8rem;
	line-height: 1.5;
	border-radius: .25rem;
}

.btn-primary {
	color: #fff;
	background-color: #3f6ad8;
	border-color: #3f6ad8;
}

.form-control {
	display: block;
	width: 100%;
	height: calc(2.25rem + 2px);
	padding: .375rem .75rem;
	font-size: 1rem;
	font-weight: 400;
	line-height: 1.5;
	color: #495057;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
	border-radius: .25rem;
	transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

.card-body {
	flex: 1 1 auto;
	padding: 1.25rem
}

.flex-truncate {
	min-width: 0 !important
}

.d-block {
	display: block !important
}

a {
	color: #E91E63;
	text-decoration: none !important;
	background-color: transparent
}

.media img {
	width: 40px;
	height: auto
}

#board-title {
	text-align: center;
	height: 100px;
	line-height: 100px;
	padding: 100px 0;
}

#title {
	width: 50px;
	height: 50px;
}

.search-bar {
	margin: auto;
}

* {
	box-sizing: border-box;
}

.container {
	width: 1000px;
}

textarea {
	resize: none;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	width: 100%;
}

body {
	margin: 0;
	line-height: 1.5;
	color: #495057;
	text-align: left;
	background-color: #eef1f3
}

.profile-box {
	display: flex;
}

.img-profile {
	border-radius: 70%;
	width: 100%;
	height: 100%;
}

.profile-detail {
	text-align: center;
}

.name {
	font-weight: bold;
}

.list li {
	margin-top: 5px;
}

.label {
	font-size: 12px;
}

.profile-detail {
	justify-content: flex-start;
	flex-direction: column;
}

/* 리뷰 css */
body {
	background: #eee
}

.date {
	font-size: 11px
}

.comment-text {
	font-size: 12px
}

.fs-12 {
	font-size: 12px
}

.shadow-none {
	box-shadow: none
}

.name {
	color: #007bff
}

.cursor:hover {
	color: blue
}

.cursor {
	cursor: pointer
}

button:hover {
	background-color: black;
	color: white;
	border: 1px solid black;
	border-radius: 3px;
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
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

	<!-- 타이틀  -->
	<div class="container-fluid mt-100">
		<div id="board-title"
			style="font-family: 'yg-jalnan', verdana, tahoma;">
			<img id="title" src="/assets/img/board.jpg">&ensp;<span>자유
				게시판</span>
		</div>
		<br>

		<!-- 자유게시판 박스 -->
		<div class="card mb-3 col-xl-6 col-md-12">

			<form
				action="/board/modify?cpage=${cpage}&seq=${bList.seq}&select=${select}&keyword=${keyword}"
				method="post" id="frm">
				<div class="container mb-4">
					<div class="row" style="padding-bottom: 5px;">
						<div class="col-sm-12">
							<div class="row profile-detail">
								<div class="col profile-box mt-4 mb-2 ">
									<div class="img-box"
										style="height: 100%; display: inline-block">
										<img id="profile" class="img-profile"
											style="width: 50px; height: 50px;"
											src="/image/board?nickname=${bList.nickname}" alt="">&ensp;
									</div>
									<ul
										class="meta list list-unstyled profile-detail d-flex mb-0 ml-2">
										<li class="name mt-3"
											style="color: black; font-family: 'yg-jalnan', verdana, tahoma;">${bList.nickname }</li>
									</ul>
									<ul class="meta list list-unstyled profile-detail d-flex mb-0"
										style="margin-left: auto; justify-content: flex-end;">
										<li class="label" style="margin: 0; padding: 0">${bList.write_date }</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="row" style="padding-bottom: 5px;">
						<div class="col-sm-12">
							<input type=text id=input-title name=title value="${bList.title}"
								style="width: 100%;" readonly>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div id="display"
								style="min-height: 200px; overflow: hidden; border: 1px solid black;">${bList.contents}</div>
							<textarea id="summernote" name="contents" readonly
								style="min-height: 200px; overflow: hidden; display: none;">${bList.contents}</textarea>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-12" style="text-align: right">
							<c:if test="${writerNickname==bList.nickname or loginId=='admin'}">
								<button type="button" id="mod"
									style="background-color: background-color: transparent; border: 1px solid black; border-radius: 3px;">수정하기</button>
								<button type="button" id="del"
									style="background-color: background-color: transparent; border: 1px solid black; border-radius: 3px;">삭제하기</button>
								<button id="modDone"
									style="background-color: background-color: transparent; border: 1px solid black; border-radius: 3px; display: none;">수정완료</button>
								<button type="button" id="cancel"
									style="background-color: background-color: transparent; border: 1px solid black; border-radius: 3px; display: none;">취소</button>
							</c:if>
							<button type="button" id="boardList"
								style="background-color: background-color: transparent; border: 1px solid black; border-radius: 3px;">목록으로</button>
						</div>
					</div>
				</div>
			</form>
			<!-- 댓글 보여주기 -->
			<c:if test="${!empty rList}">
				<hr>
				<c:forEach var="rList" items="${rList }">
					<form
						action="/board/modRp?cpage=${cpage}&seq=${bList.seq}&select=${select}&keyword=${keyword}"
						method="post" id="frmRp">
						<div class="container mb-4">
							<div class="row" style="padding-bottom: 5px;">
								<div class="col-sm-12">
									<div class="row profile-detail">
										<div class="col profile-box">
											<div class="img-box"
												style="height: 100%; display: inline-block">
												<img id="profile" class="img-profile"
													style="width: 50px; height: 50px;"
													src="/image/board?nickname=${rList.writerNickname}" alt="">&ensp;
											</div>
											<ul
												class="meta list list-unstyled profile-detail d-flex mb-0 ml-2">
												<li class="name mt-3" name="writerNickname"
													style="color: black; font-family: 'yg-jalnan', verdana, tahoma;">${rList.writerNickname}</li>
											</ul>
											<ul
												class="meta list list-unstyled profile-detail d-flex mb-0"
												style="margin-left: auto; justify-content: flex-end;">
												<li class="label" name="write_date"
													style="margin: 0; padding: 0">${rList.write_date}</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<textarea class="contents" name="repContents" readonly
										style="height: auto;">${rList.repContents}</textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12" style="text-align: right">
									<c:if test="${writerNickname==rList.writerNickname or loginId=='admin'}">
										<button type="button" class="modRp"
											style="background-color: background-color: transparent; border: 1px solid black; border-radius: 3px;">수정</button>
										<button class="modRpDone"
											style="background-color: background-color: transparent; border: 1px solid black; border-radius: 3px; display: none">완료</button>
										<button type="button" class="modRpCancel"
											style="background-color: background-color: transparent; border: 1px solid black; border-radius: 3px; display: none">취소</button>
										<button type="button" class="delRp"
											style="background-color: background-color: transparent; border: 1px solid black; border-radius: 3px;">삭제</button>
										<input id="rseq" name="rseq" type=hidden value="${rList.seq}">
										<input name="refBoardSeq" type=hidden value="${bList.seq}">
									</c:if>
								</div>
							</div>
						</div>
					</form>
				</c:forEach>
			</c:if>

			<!-- 댓글 작성 칸 -->
			<c:if test="${writerNickname != null or loginId=='admin'}">
			<form
				action="/board/writeRp?cpage=${cpage}&seq=${bList.seq}&select=${select}&keyword=${keyword}"
				method="post">
				<hr>
				<div class="container mb-4">
					<div class="row" style="padding-bottom: 5px;">
						<div class="col-sm-12">
							<div class="row profile-detail">
								<div class="col profile-box mb-2 ">
									<div class="img-box"
										style="height: 100%; display: inline-block">
										<img id="profile" class="img-profile"
											style="width: 50px; height: 50px;"
											src="/image/board?nickname=${writerNickname}" alt="">&ensp;
									</div>
									<ul
										class="meta list list-unstyled profile-detail d-flex mb-0 ml-2">
										<li class="name mt-3"
											style="color: black; font-family: 'yg-jalnan', verdana, tahoma;">${writerNickname}</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<textarea id="rpContents" cols=170 rows=4 name="repContents"></textarea>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12" style="text-align: right">
							<button id="writeRp"
								style="background-color: background-color: transparent; border: 1px solid black; border-radius: 3px;">등록</button>
						</div>
					</div>
				</div>
			</form>
			</c:if>
		</div>
		<br>
	</div>
	<!-- 푸터 -->
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
	<script>
		// 목록으로 버튼 클릭 시.
		$("#boardList").on("click", function() {
			<c:if test="${select==''}">
				location.href = "/board/main?cpage=${cpage}&select=${select}&keyword=${keyword}";
			</c:if>
			<c:if test="${select!=''}">
				location.href = "/board/search?cpage=${cpage}&select=${select}&keyword=${keyword}";
			</c:if>
		});
	</script>

	<script>
	// 게시 글 수정, 삭제, 취소 버튼 클릭 시.
	let bkTitle = $("#input-title").val();					
	let bkContents = $("#summernote").val();		
	$("#mod").on("click", function(){
		$("#display").css("display","none");
		$("#del").css("display","none");
		$("#mod").css("display","none");
		$("#boardList").css("display","none");
		$("#modDone").css("display","inline-block");
		$("#cancel").css("display","inline-block");
		$("#frm").removeAttr("action");
		$("#input-title").removeAttr("readonly");
		$("#summernote").removeAttr("readonly");
		$("#summernote").focus();
		
		// summernote 에디터
    $(document).ready(function () {
        $('#summernote').summernote({
            placeholder: '내용을 작성하세요',
            height: 400,
            maxHeight: null,
            minHeight: null,
            lang: "ko-KR",
            focus: true,
            toolbar: [
			    // [groupName, [list of button]]
			    ['fontname', ['fontname']],
			    ['fontsize', ['fontsize']],
			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			    ['color', ['forecolor','color']],
			    ['table', ['table']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']],
			    ['insert',['picture','link','video']],
			    ['view', ['fullscreen', 'help']]
			  ],
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
				// 이미지 파일 업로드 옵션
			callbacks:{
                onImageUpload: function(files, editor, welEditable) {
                	 for (var i = files.length - 1; i >= 0; i--) {
                         sendFile(files[i],this);
					}
				}
	    	}
		});
	});
	// summernote 이미지 업로드 함수
	function sendFile(file, el) {
		var form_data = new FormData();
		form_data.append('file', file);
		$.ajax({
			data : form_data,
			type : "POST",
			url : '/image/boardSnote',
			cache : false,
			contentType : false,
			enctype : 'multipart/form-data',
			processData : false,
			success : function(sysName) {
				console.log("img : "+sysName);
				$(el).summernote('insertImage', sysName.url);
			}
		});
	}
		$("#frm").attr("action","/board/modify?cpage=${cpage}&seq=${bList.seq}&select=${select}&keyword=${keyword}");
	});
	$("#del").on("click", function(){
		if(confirm("정말 삭제하시겠습니까?")) {
			location.href="/board/delete?cpage=${cpage}&seq=${bList.seq}&select=${select}&keyword=${keyword}";
		}
	});

	$("#cancel").on("click",function(){
		location.href="/board/detail?cpage=${cpage}&seq=${bList.seq}&select=${select}&keyword=${keyword}"
	})
	</script>
	<script>
		// 댓글 수정, 삭제, 취소 버튼 클릭 시.
	   	$(".card").on("click",".modRp",function(){
   		$(this).css("display","none");
   		$(this).next().next().next().css("display","none");
   		$(this).next().css("display","inline-block");
   		$(this).next().next().css("display","inline-block");
   		// 기존 내용 백업
    	bkContentsCmt = $(this).closest("#frmRp").find("textarea").val();
   		$(this).closest("#frmRp").find("textarea").removeAttr("readonly");
   		$(this).closest("#frmRp").find("textarea").focus();
   	});
   	$(".card").on("click",".modRpCancel",function(){
   		$(this).closest("#frmRp").find("textarea").val(bkContentsCmt);
   		$(this).closest("#frmRp").find("textarea").attr("readonly","");
   		$(this).prev().prev().css("display","inline-block");
   		$(this).next().css("display","inline-block");
   		$(this).prev().css("display","none");
   		$(this).css("display","none");
   	});
   	$(".card").on("click",".delRp",function(){
   		if(confirm("정말 삭제하시겠습니까?")){
   			$(this).closest("#frmRp").remove();
   			let rseq = $(this).next().val();
   			location.href="/board/delRp?cpage=${cpage}&seq=${bList.seq}&select=${select}&keyword=${keyword}&rseq="+rseq;
   		}
   	});
	</script>
</body>
</html>