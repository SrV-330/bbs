<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>

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
<style type="text/css">

</style>



<style>
body{
	padding-bottom:70px;
	padding-top:70px;
	font-size: 15px;
	color: #262626;
	background: #f3f3f3;
	-webkit-tap-highlight-color: rgba(0,0,0,0);
}
.modal-dialog-set{
	width:380px;
	padding-top:200px;
}
.TopstoryItem {
    position: relative;
    padding: 16px 20px;
}
.Card {
    margin-bottom: 10px;
    background: #fff;
    overflow: hidden;
    border-radius: 2px;
    -webkit-box-shadow: 0 1px 3px rgba(0,0,0,.1);
    box-shadow: 0 1px 3px rgba(0,0,0,.1);
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
	display:block;
}

.reg-box{

	margin-top:100px;


}

.reg-box-body{

	width:420px;
	position: relative;
	left:50%;
	margin-left:-210px;
	height:auto;
	border-radius:8px;
	background-color:white;
	padding-left:20px;
	padding-right:20px;
	padding-bottom:10px;
	box-shadow: 0 1px 3px rgba(26,26,26,.1);
	
}
.reg-box-head{
	display:block;
	padding-top:10px;
	padding-left:10px;
	padding-right:10px;
	padding-bottom:10px;
	
}
.invalid::-webkit-input-placeholder { /* Mozilla Firefox 4 to 18 */
    color: red;  
}
.invalid:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
    color: red;  
}

.invalid::-moz-placeholder { /* Mozilla Firefox 19+ */
    color: red;
}
.invalid:-ms-input-placeholder{
    color: red;
}

</style>
<script type="text/javascript">

	$(function(){
	
		$("#ok-close").bind("click",function(){
			$("#msg-success").hide(100);
		}
		);
		$("#error-close").bind("click",function(){
			$("#msg-error").hide(100);
		}
		);
		
		$("#regName").focus(function(){
			$("#regName").removeClass("invalid");
			$("#regName").attr("placeholder","用户名");
			
		});
		$("#regName").bind("blur",function(){
			vailRegName();	
		});
		
		$("#regPwd").focus(function(){
			$("#regPwd").removeClass("invalid");
			$("#regPwd").attr("placeholder","密码");
			
		});
		
		$("#regPwd").bind("blur",function(){
			vailRegPwd();	
		});
		$("#regRePwd").focus(function(){
			$("#regRePwd").removeClass("invalid");
			$("#regRePwd").attr("placeholder","确认密码");
			
		});
		
		$("#regRePwd").bind("blur",function(){
			vailRegRePwd();	
		});
		
		$(".btn").bind("click",function(){
			$("#msg-success").hide(10);
			$("#msg-error").hide(10);
			if(vailRegName()&&vailRegPwd()&&vailRegRePwd()){
				$.ajax({
					type:"POST",
					url:"/bbs/user/reg",
					async:true,
					contentType: "application/json; charset=utf-8",
					dataType:"json",
					data:JSON.stringify({
						userName:$('#regName').val(),
						userPwd:$('#regPwd').val()
					}),
					success:function(rj){
						$("#msg-success-p").html(rj.err);
						$("#msg-error-p").html(rj.err);
						if(rj.res==1){
							$("#msg-error").hide(10);
							$("#msg-success").show(100);
						  	$.cookie('userName', $("#regName").val(), { expires: 365*50, path: '/' });  
						  	$.cookie('userPwd', $("#regPwd").val(), { expires: 365*50, path: '/' });
							window.setTimeout("location.href='/bbs/user/autologin'",500);
						}else{
							$("#msg-error").show(100);
							$("#msg-success").hide(10);
						}
					},
					error: function () {
						$("#msg-success").hide(10);
						$("#msg-error").show(100);
						$("#msg-error-p").html("浏览器错误！" );
					}
						
					
				});
				return;
			}
			$("#msg-error-p").html("请完善注册信息！");
			$("#msg-error").show(100);
			
			
		});
	
	});
</script>
<script type="text/javascript">

function vailRegName(){
	var regName=$("#regName").val().replace(" ","");
			
	if(regName==""){
		$("#regName").attr("placeholder","用户名不能为空！");
		$("#regName").addClass("invalid");
		
		return false;
	}
	if(regName.length<1||regName.length>7){
		$("#regName").val("");
		$("#regName").attr("placeholder","用户名长度最大为7！");
		$("#regName").addClass("invalid");
		
		return false;
	}
	$.ajax({
		type:"POST",
		url:"/bbs/user/vailregname",
		async:true,
		dataType:"json",
		contentType: "application/json; charset=utf-8",
		data:JSON.stringify({
			userName:$("#regName").val()
		}),
		success:function(rj){
			$("#msg-success-p").html(rj.err);
			$("#msg-error-p").html(rj.err);
			if(rj.res==1){
				$("#msg-error").hide(10);
				$("#msg-success").hide(10);
				
			}else{
				$("#msg-error").show(100);
				$("#msg-success").hide(10);
				return false;
			}
		},
		error: function () {
			$("#msg-success").hide(10);
			$("#msg-error").show(100);
			$("#msg-error-p").html("浏览器错误！" );
		}
		
	});
	
	return true;
}

function vailRegPwd(){
	var regPwd=$("#regPwd").val();
			
	if(regPwd==""){
		$("#regPwd").attr("placeholder","密码不能为空！");
		$("#regPwd").addClass("invalid");
		
		return false;
	}
	if(regPwd.length<3||regPwd.length>16){
		$("#regPwd").val("");
		$("#regPwd").attr("placeholder","密码长度为3~16位！");
		$("#regPwd").addClass("invalid");
		
		return false;
	}
	return true;
}


function vailRegRePwd(){
	var regRePwd=$("#regRePwd").val();
	var regPwd=$("#regPwd").val();
			
	if(regRePwd==""){
		$("#regRePwd").attr("placeholder","确认密码不能为空！");
		$("#regRePwd").addClass("invalid");
		
		return false;
	}
	if(regRePwd!=regPwd){
		$("#regRePwd").val("");
		$("#regRePwd").attr("placeholder","两次密码不一致！");
		$("#regRePwd").addClass("invalid");
		
		return false;
	}
	return true;
}


</script>




</head>

<body>
	<div id="root" class="container">
		<div class="reg-box">
			<div class="reg-box-body" >
				<div class="reg-box-head">
					<h1 class="title text-center">
						注册
					</h1>
					<h4 class="text-center">
						点一下 玩一年
					</h4>
					<h4 class="text-center">
						装逼不要一分钱
					</h4>
				</div>
				<div class="form-group has-feedback">
					<input type="text" class="form-control" id="regName" placeholder="用户名">
					
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" id="regPwd" placeholder="密码">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" id="regRePwd" placeholder="确认密码">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="button" class="btn btn-primary btn-block btn-flat" value="注册">
				</div>
				
				<div id="msg-success" class="alert alert-success alert-dismissable" style="display: none;">
					<button type="button" class="close" id="ok-close" aria-hidden="true">×</button>
					<h4><i class="icon fa fa-info"></i> 成功!</h4>
					<p id="msg-success-p"></p>
				</div>

				<div id="msg-error" class="alert alert-danger alert-dismissable" style="display: none;">
					<button type="button" class="close" id="error-close" aria-hidden="true">×</button>
					<h4><i class="icon fa fa-warning"></i> 出错了!</h4>
					<p id="msg-error-p"></p>
				</div>
				<a href="/bbs/home" class="text-center">已经注册？请登录</a>
				
			
			</div>
		
		</div>
		
	</div>
</body>




</html>