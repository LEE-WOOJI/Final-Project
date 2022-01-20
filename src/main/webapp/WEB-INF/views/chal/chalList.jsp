<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
   <head>
      <!-- Basic -->
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
      <!-- Favicon-->
    	<link rel="icon" href="/assets/img/favicon.ico" type="image/x-ico" />
      <!-- Site Metas -->
      <meta name="keywords" content="" />
      <meta name="description" content="" />
      <meta name="author" content="" />
      <link rel="shortcut icon" href="/assets/favicon.ico" type="">
      <title>Glphy</title>
      <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
      <!-- bootstrap core css -->
      <link href="/css/chalboot.css" rel="stylesheet" />
      <!-- css -->
      <link href="/css/chalcss.css" rel="stylesheet" />
      <!-- repcss -->
      <link href="/css/chalrepcss.css" rel="stylesheet" />
      <!-- Date -->
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
      <style>
      	#header{margin-bottom:110px;}
      	@font-face {
		font-family: 'yg-jalnan';
		src:
			url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
			format('woff');
		font-weight: normal;
		font-style: normal;
		}
		#searchBtn, #option, #moreBtn, #title, #chalTitle, #more{font-family: 'yg-jalnan', verdana, tahoma;}
      </style>
      
   </head>
   	
    <!-- contents -->
	<div class="container">
		<div class = "row" id = "header">
			<div class = "col">
				<!-- head -->
    				<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
			</div>
		</div>
		<br>
		<form action = "/chal/search" method = "post">
			<div class="row" style = "text-align:center">
				<div class = "col-sm-12 col-md-4 col-lg-2">
				<select class="form-select btn btn-danger" aria-label="Default select example" id = "option" name = "option">
  					<option selected>검색옵션</option>
  					<option value="name">이름</option>
  					<option value="tag">태그</option>
  					<option value="day">일수</option>
				</select>
				</div>
				<div class = "col-sm-12 col-md-4 col-lg-9">
					<input type="text" class="form-control" placeholder="검색어를 입력하세요" aria-label="Recipient's username" aria-describedby="basic-addon2" name = "searchText">
				</div>
				<div class = "col-sm-12 col-md-4 col-lg-1" style = "margin:0px;">
					<button type="submit" class="btn btn-danger" id = "searchBtn" style = "width:100%;">Search</button>
				</div>
		</div>
		</form>
	</div>
<!-- 챌린지 받아오는 곳 -->
      <section class="product_section layout_padding">
         <div class="container">
            <div class="heading_container heading_center">
               <h3>
                  <span id = "chalTitle">Our Challenge</span>
                  <hr>
               </h3>
            </div>
            <div class="row" id = "listLine">
               <c:forEach var = "list" items = "${list }">
               		<div class="col-sm-6 col-md-4 col-lg-4">
		                  <div class="box">
		                     <div class="img-box">
		                     	<a href="/chal/detail?seq=${list.chalSeq}" style = "text-decoration : none;">
		                        	<img src=${list.oriName} alt="">
		                        </a>
		                     </div>
		                     <div class="detail-box">
		                        <h4 id = "title">
		                           <a href="/chal/detail?seq=${list.chalSeq}" style = "text-decoration : none; color: black;">
		                           		${list.chalName }
		                           </a>
		                        </h4>
		                        <img src="/assets/img/heart.png" alt="">
		                     </div>
		                     <div class = "category">
		                        <hr>
		                        <h6>
		                           <label>Category : </label>
		                           ${list.category }
		                        </h6>
		                     </div>
		                     <div class = "tag-box">
		                        <hr>
		                        <h6>
		                           <label>Tag : </label>
		                           ${list.tag }
		                        </h6>
		                     </div>
		                     <div class = "startday">
		                        <h6>
		                           <label>시작일 : </label>
		                           <fmt:formatDate pattern="yyyy년 MM월 dd일 hh시" value = "${list.startDate }"/>
		                        </h6>
		                     </div>
		                     <div class = "endday">
		                        <h6>
		                           <label>종료일 : </label>
		                           <fmt:formatDate pattern="yyyy년 MM월 dd일 hh시" value = "${list.endDate }"/>
		                        </h6>
		                     </div>
		                  </div>
               		</div>
               </c:forEach>
            </div>
            
            <div class = "row">
            	<div class = "col">
            		<div class="btn-box">
	               		<div class = "col-sm-12 col-md-4 col-lg-2" style = "margin:0px;">
							<button type="button" class="btn btn-danger" style = "width:100%;" id = "more">View More</button>
						</div>
            		</div>
            	</div>
            </div>
            
         </div>
      </section>
      <!-- end product section -->
	  <!-- Footer-->
       	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
   </body>
   
   <script>
   		let moreNum = 1;
   		$("#more").on("click",function(){
   			moreNum += 6;
   			$.ajax({
   				url:"/chal/more",
   				method:"POST",
   				data:{"moreNum":moreNum}
   			}).done(function(resp){
   				let result = JSON.parse(resp);
   				let content = "";
   				
   				for(let i = 0; i < result.length; i++){
   					console.log("회차 : " + i);
   					console.log(result[i].chalName);
   					let start = moment(result[i].startDate).format("YYYY년 MM월 DD일 hh시")
   					let end = moment(result[i].endDate).format("YYYY년 MM월 DD일 hh시")
   					console.log(start);
   					content += `<div class="col-sm-6 col-md-4 col-lg-4">
		                  <div class="box">
		                     <div class="img-box">
		                     	<a href="/chal/detail?seq=\${result[i].chalSeq}" style = "text-decoration : none;">
		                     		<img src="\${result[i].oriName}" alt="">
	                        	</a>
		                     </div>
		                     <div class="detail-box">
		                        <h4 id = "title">
		                        <a href="/chal/detail?seq=\${result[i].chalSeq}" style = "text-decoration : none; color: black;">
		                        	\${result[i].chalName }
                           		</a>  
		                        </h4>
		                        <img src="/assets/img/heart.png" alt="">
		                     </div>
		                     <div class = "category">
		                        <hr>
		                        <h6>
		                           <label>Category : </label>
		                           \${result[i].category }
		                        </h6>
		                     </div>
		                     <div class = "tag-box">
		                        <hr>
		                        <h6>
		                           <label>Tag : </label>
		                           \${result[i].tag }
		                        </h6>
		                     </div>
		                     <div class = "startday">
		                        <h6>
		                           <label>시작일 : </label>
		                           \${start}
		                        </h6>
		                     </div>
		                     <div class = "endday">
		                        <h6>
		                           <label>종료일 : </label>
		                           \${end}
		                        </h6>
		                     </div>
		                  </div>
           		</div>`;
           		if (result[i].chalSeq > 20) { // 더이상 불러올 것이 없다면 더보기 버튼 삭제
 	              $("#more").css("display","none");
 	            }
   				}$(content).appendTo("#listLine");
   				
   			})
   		});
		
   </script>
</html>