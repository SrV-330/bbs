<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 登录框 -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="true">

    <div class="modal-dialog modal-dialog-set">
        <div class="modal-content">
        <form id="loginForm" action="user/login" method="POST">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="myModalLabel">请登录</h3>
            </div>
            <div class="modal-body container-fluid">
				<div class="form-group">
					<!--<label for="loginName">用户名</label>-->
					<input name="userName" type="text" class="form-control" id="userName" placeholder="用户名">
				</div>
				<div class="form-group">
					<!--<label for="loginPwd">密码</label>-->
					<input name="userPwd" type="password" class="form-control" id="userPwd" placeholder="密码">
				</div>
				<div class="row">
					<div class="col-xs-9">
					
						<label>
							<input name="isrem" type="checkbox">记住我</input>
						</label>
					</div>
					<div class="col-xs-3">
						<a href="/bbs/user/gotoreg">去注册</a>
					</div>
				</div>
				<div class="alert alert-danger alert-dismissable" style="display:none">
					<button id="closeAlertDanger" type="button" class="close" aria-hidden="true">
						&times;
					</button>
					<h4>
						<i class="icon fa">
						</i>
						登录错误
					</h4>
					<p id="errmsg">
						密码错误
					</p>
				</div>
				<div class="alert alert-success alert-dismissable" style="display:none">
					<button id="closeAlertSuccess" type="button" class="close" aria-hidden="true">
						&times;
					</button>
					<h4>
						<i class="icon fa">
						</i>
						登录成功
					</h4>
					<p id="sucmsg">
						欢迎回来
					</p>
				</div>
			</div>
            <div class="modal-footer">
				
				<button id="login" type="button" class="btn btn-primary btn-block" >登录</button>
				<button type="button" class="btn btn-default btn-block" data-dismiss="modal">关闭</button>
				
            </div>
            </form>
        </div><!-- /.modal-content -->
        
        
    </div><!-- /.modal -->
    

	
</div>
