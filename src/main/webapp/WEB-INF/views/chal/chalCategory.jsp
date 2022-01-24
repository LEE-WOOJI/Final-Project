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
		#searchBtn, #option, #moreBtn, #title, #chalTitle, #filter{font-family: 'yg-jalnan', verdana, tahoma;}
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
	</div>
<!-- 챌린지 받아오는 곳 -->
      <section class="product_section layout_padding">
         <div class="container">
            <div class="heading_container heading_center">
               <h3>
                  <span id = "chalTitle" name = "chalTitle">${category }챌린지 리스트</span>
                  <hr>
               </h3>
            </div>
            <div class = "row">
            	<div class = "col-sm-6 col-md-4 col-lg-3">
            		<select class="form-select btn btn-danger" aria-label="Default select example" id = "filter" name = "filter">
  					<option selected>정렬</option>
  					<option value="chalName"> 가나다순</option>
  					<option value="startDate">시작일순</option>
  					<option value="day">일수순</option>
					</select>
            	</div>
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
            
            
         </div>
      </section>
      <!-- end product section -->
	  <!-- Footer-->
       	<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
   </body>
   
   <script>
   		$("#filter").on("change",function(){
   			$('#listLine div').remove();
   			let filter = $("#filter").val();
   			let category = "${category}";
   			$.ajax({
   				url:"/chal/filter",
   				type:"get",
   				data:{"filter":filter,"category":category}
   			}).done(function(resp){
   				let result = JSON.parse(resp);
   				console.log(result); //콘솔창에 잘 찍힘
   				console.log(result[1].length);
   				let content = "";
   				for(let i = 0; i < result.length; i++){ //이게 안굴러감 미친년
   					console.log("회차 : " + i);
   					console.log(result[i].chalName);
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
		                           \${result[i].startDate }
		                           
		                        </h6>
		                     </div>
		                     <div class = "endday">
		                        <h6>
		                           <label>종료일 : </label>
		                           \${result[i].endDate }
		                        </h6>
		                     </div>
		                  </div>
         		</div>`;
   				}$(content).appendTo("#listLine");
   			})
   		});
		
   </script>
</html>