<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="/bbs/js/jquery-3.2.1.min.js"></script>
<script src="/bbs/js/jquery.cookie.js"></script>
<script src="/bbs/js/jquery.session.js"></script>
<script src="/bbs/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link href="/bbs/css/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/bbs/js/messenger.min.js"></script>
<script src="/bbs/js/toastr.min.js"></script>
<link rel="stylesheet" href="/bbs/css/messenger/messenger.css">
<link rel="stylesheet" href="/bbs/css/messenger/messenger-theme-air.css">
<link rel="stylesheet" href="/bbs/css/toastr/toastr.min.css">
<link rel="stylesheet" href="/bbs/css/_messeng.css">
<link rel="stylesheet" href="/bbs/css/_home.css">
<link rel="stylesheet" href="/bbs/css/_loginmodel.css">
<script src="/bbs/js/_posthead.js"></script>
<script src="/bbs/js/_messenger.js"></script>
<script src="//cdn.ckeditor.com/4.8.0/standard/ckeditor.js"></script>
<script src="/bbs/js/_edt.js"></script>
<style>
body{
	padding-bottom:70px;
	padding-top:70px;
	font-size: 15px;
	color: #262626;
	background: #f3f3f3;
	-webkit-tap-highlight-color: rgba(0,0,0,0);
}

.TopstoryItem {
    position: relative;
    padding: 16px 20px;
}
.Card {
    margin-bottom: 10px;
    background: #fff;
    overflow:hidden;
    border-radius: 2px;
    -webkit-box-shadow: 0 1px 3px rgba(0,0,0,.1);
    box-shadow: 0 1px 3px rgba(0,0,0,.1);
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
	display:block;
}
</style>
</head>
<body>
<div class="container-fluid">

	<%@include file="_nav.jsp" %>
	
	
	<div class="container">
		<!--图片-->
		<div class="jumbotron container">
			
			
			
		</div>
		<!-- 内容 -->
		<div class="container">
			<div class="col-md-10 col-md-offset-1 col-lg-offset-1 col-lg-10">
				<c:forEach var="post" items="${requestScope.PostList}">
					<div class="Card TopstoryItem">
					<div class="container">
						<div>
							<a href="/bbs/post/postdetail/${post.hd.hdid }">${post.hd.headSimple }</a>	
						</div>
						<div>
							<a href="/bbs/post/postdetail/${post.hd.hdid }?cid=${post.pid}">
								${post.postContent }
							</a>
						</div>
					</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		
		
		
	</div>
	<%@include file="_page.jsp" %>
</div>
</body>
</html>