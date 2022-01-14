<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
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
	crossorigin="anonymous">	
	</script>
	<!--  jQuery, bootstrap -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.js"></script>

    <!-- summernote css/js-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/summernote.js"></script>
	
</head>
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
	text-align: left;
	background-color: #eef1f3
}

.mt-100 {
	margin-top: 80px
}

.card {
	box-shadow: 0 0.46875rem 2.1875rem rgba(4, 9, 20, 0.03), 0 0.9375rem
		1.40625rem rgba(4, 9, 20, 0.03), 0 0.25rem 0.53125rem
		rgba(4, 9, 20, 0.05), 0 0.125rem 0.1875rem rgba(4, 9, 20, 0.03);
	border-width: 0;
	transition: all .2s
}

.card-header:first-child {
	border-radius: calc(.25rem - 1px) calc(.25rem - 1px) 0 0;
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
	border-bottom: 1px solid rgba(26, 54, 126, 0.125)
}

.btn-primary.btn-shadow {
	box-shadow: 0 0.125rem 0.625rem rgba(63, 106, 216, 0.4), 0 0.0625rem
		0.125rem rgba(63, 106, 216, 0.5)
}

.btn.btn-wide {
	padding: .375rem 1.5rem;
	font-size: .8rem;
	line-height: 1.5;
	border-radius: .25rem
}

.btn-primary {
	color: #fff;
	background-color: #3f6ad8;
	border-color: #3f6ad8
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
	transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out
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

#writeBtn {
	background-color: transparent;
	border: 1px solid black;
	border-radius: 3px;
}

#writeBtn:hover {
	background-color: black;
	color: white;
	border: 1px solid black;
	border-radius: 3px;
}

#search {
	background-color: transparent;
	border: 1px solid transparent;
	border-radius: 3px;
}

.td {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	max-width: 130px;
}
#head{
	font-size: 16px;
	margin:4px;
}
#write{
	border-style:none;
	margin:20px;
	padding:10px;
	border-radius:5px;
}
</style>
<body>
	<!-- 메인 네비바 -->


	<div class="container-fluid mt-100">

		<!-- 타이틀  -->
		<div id="title" align=center>
			<img id="titleImg" src="">
		</div>
		<br>

		<!-- 자유게시판 박스 -->
		<div class="card mb-3">

			<!-- 분류 -->
			<div class="card-header pl-0 pr-0">
				<div class="row no-gutters w-100 align-items-center" id=head>
					<div class="col-12" align=center id=head>새 글 작성하기</div>
				</div>
			</div>

			<!-- 내용 -->
			<div class="card-body py-3">
				<div id="summernote"></div>
	
	<script>
	// 메인화면 페이지 로드 함수
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
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
        });
        
    });
	</script>
			</div>
		<!-- 버튼 페이징 -->
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center"></ul>
		</nav>
		<div align=right id=write>
			<button type=submit>글쓰기</button>
		</div>
	</div>
	<!-- 풋터 -->
	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
	<script>
	
		$("#write").on("click",function(){
			location.href="/board/main";
		})
	</script>
	
</body>
</html>