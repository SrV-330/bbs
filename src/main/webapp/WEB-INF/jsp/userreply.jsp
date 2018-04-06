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
<script>
$(function(){
	$(".btn-rmp").bind("click",function(){
		var pid=$(this).children("input").val();
		var tr=$(this).parent().parent();
$.ajax({
			
			type:"POST",
			url:"/bbs/post/postdetail/reply/del",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				
				pid:pid
				
			}),
			success:function(lj){
				if(lj.res==1){
					tr.remove();
					
				}
				$.globalMessenger().post({
		            message: lj.err,//提示信息
		            type: 'info',//消息类型。error、info、success
		            hideAfter: 2,//多长时间消失
		            showCloseButton:true,//是否显示关闭按钮
		            hideOnNavigate: true //是否隐藏导航
				});
				
				
			},
			error: function () {
				$.globalMessenger().post({
		            message: "浏览器错误",//提示信息
		            type: 'info',//消息类型。error、info、success
		            hideAfter: 2,//多长时间消失
		            showCloseButton:true,//是否显示关闭按钮
		            hideOnNavigate: true //是否隐藏导航
				});
			}

		});
	});
});
</script>
</head>
<body>
<div class="container-fluid">
	<%@include  file="_nav.jsp"%>
	<div class="container">
		<ul class="nav nav-pills">
		  <li ><a href="/bbs/user/zan">赞过的</a></li>
		  <li ><a href="/bbs/user/posthead">发过的帖</a></li> 
		  <li class="active"><a href="#">回复过的</a></li>
		  
		</ul>
		<c:set var="ps" value="${requestScope.PostList }"/>
		
		<table class="table table-hover table-responsive table-striped table-bordered">
        <thead>
        <tr>
            <td>序号</td>
            <td>楼主</td>
            <td>帖子</td>
            <td>层主</td>
            <td>回复</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ps" items="${ps}" varStatus="st">
            <tr>
            	
                <td>${st.index+1}</td>
                <td>${ps.rpu.userName}</td>
                <td><a href="/bbs/post/postdetail/${ps.hd.hdid }">${ps.hd.headTitle}</a></td>
                <c:set var="uname" value="${ps.c==null? ps.rpu.userName:ps.c.rpu.userName }"/>
                <c:set var="content" value="${ps.c==null? ps.postContent:ps.c.postContent }"/>
                <c:set var="c" value="${ps.c==null? ps:ps.c}"/>
                <td>${uname}</td>
                <td><a href="/bbs/post/postdetail/${ps.hd.hdid }?cid=${c.pid}">${content }</a></td>
                <td><button type="button" class="btn btn-link btn-rmp"><input type="hidden" value="${ps.pid }"><span>删除</span></button></td>
                
            </tr>
        </c:forEach>
        </tbody>
    	</table>
		
	</div>
	<%@include file="_page.jsp" %>
	
</div>
<%@include file="_loginmodel.jsp" %>
</body>
</html>