<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人主页</title>


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
</head>
<body>
<div class="container-fluid">
	<%@include  file="_nav.jsp"%>
	<div class="container">
		<ul class="nav nav-pills">
		  <li class="active"><a href="#">赞过的</a></li>
		  <li><a href="/bbs/user/posthead">发过的帖</a></li> 
		  <li><a href="/bbs/user/reply">回复过的</a></li>
		  
		</ul>
		<c:set var="zans" value="${requestScope.ZanList }"/>
		
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
        <c:forEach var="zan" items="${zans}" varStatus="st">
            <tr>
            	<c:set var='ztp' value="${zan.zanType!=0 and zan.zanType==1? '点赞':'反对'}"/>
                <td>${st.index+1}</td>
                <td>${zan.zp.hd.lz.userName}</td>
                <td><a href="/bbs/post/postdetail/${zan.zp.hd.hdid }">${zan.zp.hd.headTitle}</a></td>
                <td>${zan.zp.rpu.userName}</td>
                <td><a href="/bbs/post/postdetail/${zan.zp.hd.hdid }?cid=${zan.zp.pid}">${zan.zp.postContent}</a></td>
                <td>${ztp}</td>
                
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