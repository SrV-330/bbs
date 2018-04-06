<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>postdetail</title>

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
<link rel="stylesheet" href="/bbs/css/_loginmodel.css">
<script src="/bbs/js/_posthead.js"></script>
<script src="/bbs/js/_messenger.js"></script>

<script src="/bbs/js/_comment.js"></script>
<script src="/bbs/js/ckeditor_4.4.6_standard/ckeditor/ckeditor.js"></script>
<script src="/bbs/js/_edt.js"></script>
</head>
<script>
$(function(){
	
	var cid=getUrlParam("cid");
	if(cid!=""){
		var c=$("[data-cid="+cid+"]");
		var top=c.offset();
		 $("html,body").animate({scrollTop:top.top - "90" + "px"}, 500);
		
		
		
	}
});
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
  }
</script>


<style>
body{
	padding-bottom:70px;
	padding-top:70px;
	font-size: 15px;
	color: #262626;
	background: #f3f3f3;
	-webkit-tap-highlight-color: rgba(0,0,0,0);
}
.Card {
    margin-bottom: 10px;
    background: #fff;
    background-image: initial;
    background-position-x: initial;
    background-position-y: initial;
    background-size: initial;
    background-repeat-x: initial;
    background-repeat-y: initial;
    background-attachment: initial;
    background-origin: initial;
    background-clip: initial;
    background-color: rgb(255, 255, 255);
    overflow: hidden;
    overflow-x: hidden;
    overflow-y: hidden;
    border-radius: 2px;
    border-top-left-radius: 2px;
    border-top-right-radius: 2px;
    border-bottom-right-radius: 2px;
    border-bottom-left-radius: 2px;
    box-shadow: 0 1px 3px rgba(26,26,26,.1);
    box-sizing: border-box;
	display:block;
}
.TopstoryItem {
    position: relative;
    padding: 16px 20px;
}
.listitem{

	position: relative;
    padding: 16px 20px;
    padding-top: 16px;
    padding-right: 20px;
    padding-bottom: 16px;
    padding-left: 20px;

	
}
.listitem:after{

	position: absolute;
    left: 0;
    right: 0;
    top: 0;
    margin: 0 20px;
    margin-top: 0px;
    margin-right: 20px;
    margin-bottom: 0px;
    margin-left: 20px;
    display: block;
    border-bottom: 1px solid #f6f6f6;
    border-bottom-width: 1px;
    border-bottom-style: solid;
    border-bottom-color: rgb(246, 246, 246);
    content: "";

}

.btn-def{
height:30px;
width:auto;
background-color: rgba(0, 132, 255, 0.1);

}

.btn-cmt{

	margin-left:20px;
}


.comments {
    border: 1px solid #ebebeb;
    border-top-color: rgb(235, 235, 235);
    border-top-style: solid;
    border-top-width: 1px;
    border-right-color: rgb(235, 235, 235);
    border-right-style: solid;
    border-right-width: 1px;
    border-bottom-color: rgb(235, 235, 235);
    border-bottom-style: solid;
    border-bottom-width: 1px;
    border-left-color: rgb(235, 235, 235);
    border-left-style: solid;
    border-left-width: 1px;
    border-image-source: initial;
    border-image-slice: initial;
    border-image-width: initial;
    border-image-outset: initial;
    border-image-repeat: initial;
    box-shadow: 0 1px 3px rgba(26,26,26,.1);
    background: #fff;
    background-image: initial;
    background-position-x: initial;
    background-position-y: initial;
    background-size: initial;
    background-repeat-x: initial;
    background-repeat-y: initial;
    background-attachment: initial;
    background-origin: initial;
    background-clip: initial;
    background-color: rgb(255, 255, 255);
    margin-top: 12px;
    overflow: visible;
    overflow-x: visible;
    overflow-y: visible;
    border-radius: 4px;
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
    border-bottom-right-radius: 4px;
    border-bottom-left-radius: 4px;
    
        display: flex;
        flex-direction: column;
            box-sizing: border-box;
}

.CommentItem {
    position: relative;
    -ms-flex-negative: 0;
    flex-shrink: 0;
    padding: 12px 20px 10px;
    padding-top: 12px;
    padding-right: 20px;
    padding-bottom: 10px;
    padding-left: 20px;
    font-size: 15px;
}


.CommentItem:not(:first-child):after {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    display: block;
    margin: 0 20px;
    margin-top: 0px;
    margin-right: 20px;
    margin-bottom: 0px;
    margin-left: 20px;
    border-bottom-style: solid;
    border-bottom-color: #f6f6f6;
    border-bottom-width: 1px;
    content: "";
}


.CommentItem-meta {
    position: relative;
    height: 27px;
    padding-right: 3px;
    padding-left: 1px;
    margin-bottom: 5px;
    line-height: 24px;
}

.CommentItem-content {
    margin-bottom: 5px;
    
    
     
}

.CommentItem-footer {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    height: 24px;
    font-size: 14px;
    line-height: 24px;
}
.cmt-input{

	margin-top:5px;
	margin-bottom:5px;
	padding-top:5px;
	padding-bottom:5px;

}
.cmt-btngroup{

	
	margin-bottom:5px;
	
	padding-bottom:5px;
	text-align:right;

}

.cmt-time{

	float:right;
}


.comments-pagination {
    border-top: 1px solid #ebebeb;
    border-top-width: 1px;
    border-top-style: solid;
    border-top-color: rgb(235, 235, 235);
}

.Pagination {
    padding: 16px 20px;
    padding-top: 16px;
    padding-right: 20px;
    padding-bottom: 16px;
    padding-left: 20px;
    text-align: center;
    margin: 0 auto;
    margin-top: 0px;
    margin-right: auto;
    margin-bottom: 0px;
    margin-left: auto;
}

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
<script>
$(function(){
	$(".comments").hide();
	
});
</script>

<body>

<div class="container">

<%@include file="_nav.jsp" %>
<input id="userName" type="hidden" value="${user.userName }"/>
<input id="userType" type="hidden" value="${user.userType }"/>
<input id="uid" type="hidden" value="${user.uid }"/>
<div class="container">
	<div class="container">
	
	<div class="col-md-7 col-lg-7
	 col-md-offset-1 col-lg-offset-1">
	
	<div class="Card TopstoryItem">
	<c:set var="phd" value="${requestScope.PostHead }"/>
			<div class="">
				
					<span>用户</span>
					<span><b>${phd.lz.userName}</b></span>
					<span>提了一个问题</span>
					
				
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
				 	
				 	<b>${phd.headTitle}</b>
				 </h3>
			</div>
			<div class="">
				 <div id="simple" class="postHeadSimple">${phd.headDetail}</div>
			</div>		
			<c:if test="${user!=null }">	
			<div class="">
				
				<c:if test="${phd.lz.uid==user.uid or user.userType==1}">
				<c:set var="isrmc" value="${phd.lz.uid==user.uid? '狗管理真的可以为所欲为':'' }"/>
				<c:set var="isrm" value="${phd.lz.uid==user.uid? 'btn-rm':'btn-unrm' }"/>
				
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
				
				<c:set var="islcc" value="${phd.isLock==1? '贞操带':'性解放' }"/>
				<c:set var="islc" value="${phd.isLock==1? 'btn-lc':'btn-unlc' }"/>
				
				
				<button class="btn btn-link ${islc }"><span class="glyphicon glyphicon-lock"></span>
				<span>${islcc }</span>
				<input type="hidden" value="${phd.hdid }">
				</button>
				
				<c:set var="isgagc" value="${phd.lz.isGag==1? '塞口球':'摘口球' }"/>
				<c:set var="isgag" value="${phd.lz.isGag==1? 'btn-gag':'btn-ungag' }"/>
				
				
				<button class="btn btn-link ${isgag}">
				
				<span>${isgagc }</span>
				<input type="hidden" class="gaguid" value="${phd.lz.uid }">
				<input type="hidden" class="gagname" value="${phd.lz.userName }">
				</button>
				
				</c:if>
				
			</div>	
			</c:if>
			<div class="">
			<span>发布于</span>
			<span><b>${phd.postTime}</b></span>
			</div>
			
		</div>

	<div class="Card">
	<div class="list">
	<c:set var="zans" value="${requestScope.ZanList}"/>
	<c:forEach var="post" items="${requestScope.PostList }" varStatus="st">
		<div class="listitem" data-cid="${post.pid }">
			<div class="">
				<span>用户</span><span>${post.rpu.userName }</span><span>回答了</span>
			</div>
			<div class="">
			${post.postContent }
			</div>
			<div class="">
			<span>发布于</span><span>${post.postTime }</span>
			</div>
			<div class="">
			<div class="">
				<c:set var="btnup" value="${zans.size()>0&&post.pid==zans.get(st.index).zp.pid&&zans.get(st.index).zanType==1? "btn-primary":"btn-default" }"/>
				<c:set var="btndown" value="${zans.size()>0&&post.pid==zans.get(st.index).zp.pid&&zans.get(st.index).zanType==-1? "btn-primary":"btn-default" }"/>
				<button type="button" class="btn ${btnup}  btn-vtup" style="height:30px;">
				<input type="hidden" value="${post.pid }">
				<span class="glyphicon glyphicon-triangle-top" aria-hidden="true" ></span>
				<span class="zannum">${post.zan }</span>
				</button>
				<button type="button" class="btn   ${btndown } btn-vtdown" style="height:30px;">
				<input type="hidden" value="${post.pid }">
				<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true" ></span>
				<span class=""></span>
				</button>
				
				<button class="btn btn-link btn-cmt">
				<span class=""></span>
				<input type="hidden" value="${post.pid }">
				<span>评论</span>
				</button>
				<c:if test="${user.userType==1 or user.uid==post.rpu.uid }">
				<button class="btn btn-link btn-rmp">
				<span class="glyphicon glyphicon-remove"></span>
				<input type="hidden" value="${post.pid }">
				<span>删除</span>
				</button>
				</c:if>
				
				<c:if test="${user.userType==1}">
				<c:set var="isgagc" value="${post.rpu.isGag==1? '禁言':'解禁' }"/>
				<c:set var="isgag" value="${post.rpu.isGag==1? 'btn-gag':'btn-ungag' }"/>
				<button class="btn btn-link ${isgag }">
				<span class="glyphicon glyphicon-lock"></span>
				<input class="gaguid" type="hidden" value="${post.rpu.uid }"/>
				<input class="gagname" type="hidden" value="${post.rpu.userName }"/>
				<span>${isgagc }</span>
				</button>
				</c:if>
				
			</div>
			<div class="">
			
				<div class="comments" style="display:none;">
					<div class="Commentitem loading" style="text-align:center;">
						<span >加载中</span>
					</div>

					<div class="CommentItem" style="display:none;">
						<div class="CommentItem-meta">
							<span class="cmt-name"></span>
							<span class="cmt-time"></span>
						</div>
						<div class="CommentItem-content">
						<p class="content"></p>
						</div>
						<div class="CommentItem-footer">
						
						</div>
						<div>
						<div class="cmt-input">
							<input class="form-control" type="text">
						</div>
						<div class="cmt-btngroup">
							<button type="button" class="btn btn-primary">
							
							
							发送</button>
							<button type="button" class="btn btn-default">取消</button>
						</div>
						</div>
					</div>
					
					
					
					<div class="Pagination comments-Pagination" style="display:none;">
					
						
					
					</div>
					<c:if test="${user!=null and user.uid!=0}">
					<div class="CommentItem">
						<div class="cmt-input">
							<input class="form-control" type="text">
						</div>
						<div class="cmt-btngroup">
							<button type="button" class="btn btn-primary btn-send">
							<input type="hidden" value="${post.pid }">
							发送</button>
							<button type="button" class="btn btn-default btn-cancel">取消</button>
						</div>
					</div>
					</c:if>
				</div>
					
					
					
					
			</div>
			
			
			
			
			</div>
			
			
		</div>
	</c:forEach>
	</div>
	</div>
	
	</div>
	
	
	<div class="col-md-3 col-lg-3 ">
	
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
	
	<%@include file="_page.jsp" %>
	
	
	<div class="container">
	<div class="container">
	<div class="col-md-10 col-md-offset-1 col-lg-offset-1 col-lg-10">
	<%@include file="_edt_post.jsp" %>
	</div>
	</div>
	</div>
	
</div>

<%@include file="_loginmodel.jsp" %>
<%@include file="_gagmodel.jsp" %>
</div>




</body>
</html>