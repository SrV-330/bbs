
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="/bbs/js/_search.js">
</script>
<script>
$(function(){
$("#loginbtn").bind("click",function(){
	$("#loginModal").modal("show");
});


$("#login").bind("click",function(){
	$.ajax({
		url:"/bbs/user/login",
		async:true,
		type:"POST",
		data: $('#loginForm').serialize(),
		success:function(lj){
			if(lj.res==1){
				$(".alert-danger").hide(10);
				$(".alert-success").show(100);
				window.setTimeout(function(){
					location.reload();
				},500);
				
			}
			else{
				$(".alert-danger").show(100);
				$(".alert-success").hide(10);
				$("#errmsg").html(lj.err);
			}
		},
		error:function(){
			$(".alert-danger").show(100);
			$(".alert-success").hide(10);
		}
	});
});
$(".btn-logoff").bind("click",function(){
	$.ajax({
		
		type:"POST",
		url:"/bbs/user/logoff",
		async:false,
		dataType:"json",
		
		success:function(lj){
			if(lj.res==1){
				$.cookie('userName', '', {path : '/', expires: 0 });
				$.cookie('userPwd', '', {path : '/', expires: 0 });
				window.setTimeout(function(){
					window.location.href="/bbs/home";
				},500);
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
$("#closeAlertDanger").bind("click",function(){
	$(".alert-danger").hide(10);
});
$("#closeAlertSuccess").bind("click",function(){
	$(".alert-success").hide(10);
});
});
</script>

<!-- 导航栏 -->
	<nav class="navbar navbar-default navbar-fixed-top "  role="navigation">
	  <div class="container-fluid">
		<div class="col-md-2 col-lg-3">
		
		</div>
		<div class="col-md-8 col-lg-6 col-xs-12 col-sm-12">
			
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle</span>
					<span class="icon-bar"></span>
					
				</button>
			  <a class="navbar-brand" href="/bbs/home">大学生论坛</a>
			</div>
			
			
			<div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
					<form class="navbar-form navbar-left" role="search">
					
						<div class="form-group">
							<input name="kw" type="text" class="form-control input-kw" placeholder="输入关键字">
						</div>
						
						<button type="button" class="btn btn-primary btn-search">查询</button>
						
					</form>
					<ul class="nav nav-pills navbar-nav navbar-right">
						<c:set value="${sessionScope.user }" var="user"></c:set>
					
					
						<c:choose>
							<c:when test="${user==null}">
								
					  
					  
					  			<li>
					  
					  
						<a href="/bbs/user/reg" id="regbtn">
						
							<script type="text/javascript">
									$(function(){
									
									var un=$.cookie("userName");
									var up=$.cookie("userPwd");
									if(un&&up){
										
										window.location.href="/bbs/user/autologin";
									}
										
									});
									
								</script>
						
							<span class="glyphicon glyphicon-user"></span> 注册
						</a>
					 
					  </li>
					  <li>
					  
						<a href="#" id="loginbtn">
							<span class="glyphicon glyphicon-log-in"></span> 登录
						</a>
					  
					  </li>
					  <li>
						
					  </li>
					  
					  
					  
					  
								
					 	</c:when>
							
							<c:otherwise>
							<li>
							<a href="#" id="userbtn">
									<!-- <span class="glyphicon glyphicon-user">
									</span>--> 
									
									用户:${sessionScope.user.userName} 
									
									<!-- <span class="badge ">99</span>-->
								</a>
					 
					 			
					 
					 
					 
					 
					  			</li>
					  			<li class="dropdown">
					                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
					                    		查看
					                    <b class="caret"></b>
					                </a>
					                <ul class="dropdown-menu">
					                    <li><a href="/bbs/user/zan">赞过的</a></li>
					                    <li><a href="/bbs/user/posthead">发过的帖</a></li>
					                    <li><a href="/bbs/user/reply">回复过的帖</a></li>
					                    <c:if test="${user.userType==1}">
					                    <li class="divider"></li>
					                    
					                    <li><a href="/bbs/admin/posthead">被删的帖</a></li>
					                    <li><a href="/bbs/admin/reply">被删的回复</a></li>
					                    <li><a href="/bbs/admin/gaguser">被禁言的用户</a></li>
					                    </c:if>
					                    <li class="divider"></li>
					                    <li><a href="#" class="btn-logoff">退出登录</a></li>
					                </ul>
					            </li>
							<li style="display:none;">
							<a href="#" 
							id="msgbtn"
							 type="button" class="" title="<h2>Title</h2>"  
		   						data-container="body" data-toggle="popover" 
		   						data-placement="bottom" 
		   						data-content="<h4>Popover 中的一些内容 —— options 方法</h4>">
			
									<!-- <span class="glyphicon glyphicon-user">
									</span>--> 
									
									
									消息
									<span id="msgbtn" class="badge pull-right" style="display:none">0</span>
								</a>
					 
					 			
					 
					 
					 
					 
					  			</li>
							
							
						
						</c:otherwise>
							
							
							
						</c:choose>
						
						
						
					
					  
					</ul>

			</div>

		</div>
		<div class="col-md-2 col-lg-6">
		</div>
	  </div>
	</nav>