<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	$(".btn-ungagu").bind("click",function(){
		var uid=$(this).children("input").val();
		var tr=$(this).parent().parent();
$.ajax({
			
			type:"POST",
			url:"/bbs/gag/ungaguser",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				
				gu:{
					uid:uid
				}
				
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
		  
		  <li class="active"><a href="/bbs/admin/gaguser">禁言用户</a></li> 
		  <li ><a href="#">被删的帖</a></li>
		  <li><a href="/bbs/admin/reply">被删的回复</a></li>
		  
		</ul>
		<c:set var="gags" value="${requestScope.GagList }"/>
		
		<table class="table table-hover table-responsive table-striped table-bordered">
        <thead>
        <tr>
            <td>序号</td>
            <td>用户名</td>
            <td>禁言时间</td>
            <td>解禁时间时间</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="gag" items="${gags}" varStatus="st">
            <tr>
            	
                <td>${st.index+1}</td>
                <td>${gag.gu.userName}</td>
                <td>${gag.startTime}</a></td>
                <td>${gag.endTime}</td>
                <td><button type="button" class="btn btn-link btn-ungagu"><input type="hidden" value="${gag.gu.uid }"><span>解禁</span></button></td>
                
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