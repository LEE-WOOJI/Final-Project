<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Like</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<script>
		var btn_like = document.getElementById("btn_like");
		btn_like.onclick = function() {
			changeHeart();
		}

		/* 좋아요 버튼 눌렀을떄 */
		function changeHeart() {
			$.ajax({
				type : "POST",
				url : "/clickLike",
				dataType : "json",
				data : "bbsidx=" + bbsidx + "&useridx=" + useridx,
				error : function() {
					Rnd.alert("통신 에러", "error", "확인", function() {
					});
				},
				success : function(jdata) {
					if (jdata.resultCode == -1) {
						Rnd.alert("좋아요 오류", "error", "확인", function() {
						});
					} else {
						if (jdata.likecheck == 1) {
							$("#btn_like").attr("src",
									"/home/img/ico_like_after.png");
							$("#likecnt").empty();
							$("#likecnt").append(jdata.likecnt);
						} else if (jdata.likecheck == 0) {
							$("#btn_like").attr("src",
									"/home/img/ico_like_before.png");
							$("#likecnt").empty();
							$("#likecnt").append(jdata.likecnt);

						}
					}
				}
			});
		}
	</script>
</body>
</html>