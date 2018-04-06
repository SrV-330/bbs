<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生论坛-主页</title>

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
<script src="/bbs/js/ckeditor_4.4.6_standard/ckeditor/ckeditor.js"></script>
<script src="/bbs/js/_edt.js"></script>

<script>
$(function(){
	$(".alert-danger,.alert-success").css("display","none");
	$("#msgbtn").popover({html : true });
	var content="";
	$("#msgbtn").attr("data-content",content);
	
	$("#regbtn").bind("click",function(){
		
		$.globalMessenger().post({
            message: "操作成功",//提示信息
            type: 'info',//消息类型。error、info、success
            hideAfter: 2,//多长时间消失
            showCloseButton:true,//是否显示关闭按钮
            hideOnNavigate: true //是否隐藏导航
		});
		//toastr.warning('测试');
	});
	
	
	
	

});
</script>
<style>

.GlobalSideBar-navList {
    width: 100%;
    padding: 8px 0;
    padding-top: 8px;
    padding-right: 0px;
    padding-bottom: 8px;
    padding-left: 0px;
}
.right-title{
	padding-top:4px;
	padding-right: 10px;
	padding-bottom: 4px;
	padding-left: 10px;
	font-size:20px;
}
.right-item{
	padding-top:2px;
	padding-right: 10px;
	padding-bottom: 2px;
	padding-left: 10px;
	font-size:14px;
}
</style>





</head>
<body>

<div class="container-fluid">

	<%@include file="_nav.jsp" %>
	
	
	<div class="container">
		<!--
		<div class="jumbotron container"></div>-->
		<!-- 内容 -->
		<div class="container" >
			<div class="col-md-7 col-md-offset-1 col-lg-offset-1 col-lg-7" >
				<c:forEach var="phd" items="${requestScope.PostHeadList}">
					<div class="Card TopstoryItem">
							
							
							<div class="">
								<div class="">
									<span>用户</span>
									<span><b>${phd.lz.userName}</b></span>
									<span>提了一个问题</span>
									<span style="float:right"><b>${phd.postTime}</b></span>
								</div>	
								<!-- <div class="col-md-6 col-lg-6 "><b>${phd.postTime}</b></div>-->
							</div>	
							<div class="">
								 <h3>
								 <c:set var="upicon" value="${phd.isTop==2? 'glyphicon glyphicon-heart':''}"/>
								 <c:set var="fireicon" value="${phd.isGood==2? 'glyphicon glyphicon-fire':''}"/>
								 <c:set var="lockicon" value="${phd.isLock==2? 'glyphicon glyphicon-lock':''}"/>
								 	<font color="blue">
								 		<span class="${upicon}" aria-hidden="true"></span>
								 	</font>
								 	<font color="red">
								 		<span class="${fireicon }" aria-hidden="true"></span>
								 	</font>
								 	<font color="green">
								 		<span class="${lockicon}" aria-hidden="true"></span>
								 	</font>
								 	
								 	<span >
								 	<b><a href="<c:url value='/post/postdetail/${phd.hdid }'/>" >${phd.headTitle}</a></b></span>
								 </h3>
							</div>
							<div class="">
								 <div id="simple" class="postHeadSimple">${phd.headSimple}</div>
							</div>		
							<c:if test="${user!=null }">	
							<div class="">
								
								<c:if test="${user.userType==1 or phd.lz.uid==user.uid  }">
								<c:set var="isrmc" value="${phd.lz.uid==user.uid||user.userType==1? '删除':'' }"/>
								<c:set var="isrm" value="${phd.lz.uid==user.uid||user.userType==1? 'btn-rm':'btn-unrm' }"/>
								
								<button class="btn btn-link ${isrm }">
								<span class="glyphicon glyphicon-remove"></span>
								<input type="hidden" value="${phd.hdid }">
								<span>${isrmc }</span>
								</button>
								</c:if>
								
								<c:if test="${user.userType==1 }">
								
								
								<c:set var="isupc" value="${phd.isTop==1? '置顶':'不置顶' }"/>
								<c:set var="isup" value="${phd.isTop==1? 'btn-up':'btn-down' }"/>
								<button class="btn btn-link ${isup }"><span class="glyphicon glyphicon-arrow-up"></span>
								<span>${isupc}</span>
								<input type="hidden" value="${phd.hdid }">
								</button>
								
								<c:set var="isfrc" value="${phd.isGood==1? '加精':'不加精' }"/>
								<c:set var="isfr" value="${phd.isGood==1? 'btn-fr':'btn-unfr' }"/>
								
								
								<button class="btn btn-link ${isfr }"><span class="glyphicon glyphicon-fire"></span>
								<span>${isfrc }</span>
								<input type="hidden" value="${phd.hdid }">
								</button>
								
								<c:set var="islcc" value="${phd.isLock==1? '锁帖':'解锁' }"/>
								<c:set var="islc" value="${phd.isLock==1? 'btn-lc':'btn-unlc' }"/>
								
								
								<button class="btn btn-link ${islc }"><span class="glyphicon glyphicon-lock"></span>
								<span>${islcc }</span>
								<input type="hidden" value="${phd.hdid }">
								</button>
								
								<c:set var="isgagc" value="${phd.lz.isGag==1? '塞口球':'摘口球' }"/>
								<c:set var="isgag" value="${phd.lz.isGag==1? 'btn-gag':'btn-ungag' }"/>
								
								
								<button class="btn btn-link ${isgag} }">
								
								<span>${isgagc }</span>
								<input type="hidden" class="gaguid" value="${phd.lz.uid }">
								<input type="hidden" class="gagname" value="${phd.lz.userName }">
								</button>
								
								</c:if>
								
							</div>	
							</c:if>
					</div>
				</c:forEach>
			</div>
			<div class="col-lg-3 col-md-3" >
				<div class="Card ">
					<ul class="GlobalSideBar-navList ">
					<li class="right-title"><span><b>热帖</b></span></li>
					<c:forEach var="hphd" items="${requestScope.HotPostHeadList }">
						<li class="right-item">
							<span class="glyphicon glyphicon-fire" style="color:red"></span>
								<a href="<c:url value='/post/postdetail/${hphd.hdid }'/>">${hphd.headTitle }</a>
							
						</li>
					</c:forEach>
					
					</ul>
				</div>
				<div class="Card ">
					<ul class="GlobalSideBar-navList ">
					<li class="right-title"><span><b>置顶帖</b></span></li>
					<c:forEach var="tphd" items="${requestScope.TopPostHeadList }">
						<li class="right-item">
							<span class="glyphicon glyphicon-arrow-up" style="color:blue"></span>
								<a href="<c:url value='/post/postdetail/${tphd.hdid }'/>">${tphd.headTitle }</a>
							
						</li>
					</c:forEach>
					
					</ul>
				</div>
			
			</div>
		
		</div>
		
	</div>
	
	
	
	
	
	<%@include file="_page.jsp" %>
	<div class="container">
	<div class="container">
	<div class="col-md-10 col-md-offset-1 col-lg-offset-1 col-lg-10">
	<%@include file="_edt_home.jsp" %>
	</div>
	</div>
	</div>
	
	

</div>

<%@include file="_loginmodel.jsp" %>

<%@include file="_gagmodel.jsp" %>

</body>
</html>