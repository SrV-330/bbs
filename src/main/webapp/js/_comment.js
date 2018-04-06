$(function(){
	
	
	
	/*$(".btn-gagrpu").bind("click",function(){
		
		var uid=$(this).children(".gaguid").val();
		var uname=$(this).children(".gagname").val();
		
		$("#gagTitle").html("禁言用户"+uname);
		$("#btngag").children("input").val(uid);
		
		$("#gagModal").modal("show");
		
	});*/
	
	
	
	
	
	
	
	$(".btn-vtup").bind("click",function(){
		var btnup=$(this);
		var btndown=btnup.next();
		var zannum=btnup.children(".zannum");
		var pid=btnup.children("input").val();
		
		$.ajax({
			
			type:"POST",
			url:"/bbs/post/postdetail/zan",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				
				zanType:1,
				zp:{
					pid:pid
				}
			}),
			success:function(lj){
				if(lj.res==1){
					if(btnup.hasClass("btn-primary")){
						btnup.removeClass("btn-primary");
						btnup.addClass("btn-default");
						
						zannum.html(zannum.html()-0-1);
						return;
					}
					if(btndown.hasClass("btn-primary")){
						btndown.removeClass("btn-primary");
						btndown.addClass("btn-default");
						btnup.addClass("btn-primary");
						btnup.removeClass("btn-default");
						zannum.html(zannum.html()-0+2);
						return;
					}
					btnup.removeClass("btn-default");
					btnup.addClass("btn-primary");
					zannum.html(zannum.html()-0+1);
					return;
				}else{
					$.globalMessenger().post({
			            message: lj.err,//提示信息
			            type: 'info',//消息类型。error、info、success
			            hideAfter: 2,//多长时间消失
			            showCloseButton:true,//是否显示关闭按钮
			            hideOnNavigate: true //是否隐藏导航
					});
				}
				
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
	
	$(".btn-vtdown").bind("click",function(){

		var btndown=$(this);
		var btnup=$(this).prev();
		var zannum=btnup.children(".zannum");
		var pid=btnup.children("input").val();
		
		$.ajax({
			
			type:"POST",
			url:"/bbs/post/postdetail/zan",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				
				zanType:-1,
				zp:{
					pid:pid
				}
			}),
			success:function(lj){
				if(lj.res==1){
					if(btndown.hasClass("btn-primary")){
						btndown.removeClass("btn-primary");
						btndown.addClass("btn-default");
						
						zannum.html(zannum.html()-0+1);
						return;
					}
					if(btnup.hasClass("btn-primary")){
						btnup.removeClass("btn-primary");
						btnup.addClass("btn-default");
						btndown.addClass("btn-primary");
						btndown.removeClass("btn-default");
						zannum.html(zannum.html()-0-2);
						return;
					}
					btndown.removeClass("btn-default");
					btndown.addClass("btn-primary");
					zannum.html(zannum.html()-0-1);
					return;
				}else{
					$.globalMessenger().post({
			            message: lj.err,//提示信息
			            type: 'info',//消息类型。error、info、success
			            hideAfter: 2,//多长时间消失
			            showCloseButton:true,//是否显示关闭按钮
			            hideOnNavigate: true //是否隐藏导航
					});
				}
				
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
	
	
	
	
	$(".btn-cmt").bind("click",function(){
		
		
		var cmts=$(this).parent().next().children(".comments");
		
		var load=cmts.children(".loading");
		var pid=$(this).children("input").val();
		
		if(cmts.css("display")=="none"){
		cmts.show();
		
		load.show();
			
			$.ajax({
				
				type:"POST",
				url:"/bbs/post/postdetail/reply",
				async:false,
				dataType:"json",
				contentType: "application/json; charset=utf-8",
				data:JSON.stringify({
					pid:pid
				}),
				success:function(cj){
					load.hide();
					addCmts(cj,load);
					$(".btn-rpage").bind("click",function(){
						
						var pn=$(this).children(".rpg").val();
						var pid=$(this).children(".rpid").val();
						
						var cmts=$(this).parent();
						var load=$(this).parent().children(".loading");
						
						cmts.children(".cmts-msg").remove();
						cmts.children(".Pagination").remove();
						load.show();
						
						$.ajax({
							
							type:"POST",
							url:"/bbs/post/postdetail/reply/"+pn,
							async:false,
							dataType:"json",
							contentType: "application/json; charset=utf-8",
							data:JSON.stringify({
								pid:pid
							}),
							success:function(cj){
								load.hide();
								addCmts(cj,load);
								
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
					
					
					$(".btn-rpurm").bind("click",function(){
						var rpurm=$(this);
						var pid=$(this).children("input").val();
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
									rpurm.parent().parent().remove();
								}else{
									$.globalMessenger().post({
							            message: lj.err,//提示信息
							            type: 'info',//消息类型。error、info、success
							            hideAfter: 2,//多长时间消失
							            showCloseButton:true,//是否显示关闭按钮
							            hideOnNavigate: true //是否隐藏导航
									});
								}
								
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
					
					
					
					$(".btn-gagc").bind("click",function(){
						
						var uid=$(this).children(".gaguid").val();
						var uname=$(this).children(".gagname").val();
						$("#gagTitle").html("禁言用户"+uname);
						$("#btngag").children("input").val(uid);
						
						$("#gagModal").modal("show");
						
					});
					
					
					$(".btn-ungagc").bind("click",function(){
						
						var uid=$(this).children(".gaguid").val();
						

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
									$.globalMessenger().post({
							            message: lj.err,//提示信息
							            type: 'success',//消息类型。error、info、success
							            hideAfter: 2,//多长时间消失
							            showCloseButton:true,//是否显示关闭按钮
							            hideOnNavigate: true //是否隐藏导航
									});
									
									
									window.setTimeout(function(){
										location.reload();
									},500);
								}else{
									$.globalMessenger().post({
							            message: lj.err,//提示信息
							            type: 'error',//消息类型。error、info、success
							            hideAfter: 2,//多长时间消失
							            showCloseButton:true,//是否显示关闭按钮
							            hideOnNavigate: true //是否隐藏导航
									});
								}
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
			
		}
		else{
			cmts.children(".cmts-msg").remove();
			cmts.children(".Pagination").remove();
			cmts.hide();
		}
		
			
		
	});
	
	
	$(".btn-rmp").bind("click",function(){
		var pid=$(this).children("input").val();
		var rmp=$(this).parent().parent().parent();
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
					rmp.remove();
				}else{
					$.globalMessenger().post({
			            message: lj.err,//提示信息
			            type: 'info',//消息类型。error、info、success
			            hideAfter: 2,//多长时间消失
			            showCloseButton:true,//是否显示关闭按钮
			            hideOnNavigate: true //是否隐藏导航
					});
				}
				
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
	
	$(".btn-send").bind("click",function(){
		
		var content=$(this).parent().parent().children(".cmt-input").children("input").val();
		
		var pid=$(this).children("input").val();
		
		$.ajax({
			
			type:"POST",
			url:"/bbs/post/postdetail/reply/add",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				pid:pid,
				postContent:content
			}),
			success:function(lj){
				if(lj.res==1){
					$.globalMessenger().post({
			            message: lj.err,//提示信息
			            type: 'info',//消息类型。error、info、success
			            hideAfter: 2,//多长时间消失
			            showCloseButton:true,//是否显示关闭按钮
			            hideOnNavigate: true //是否隐藏导航
					});
					window.setTimeout(function(){
						location.reload();
					},500);
					
				}else{
					
					if(lj.res==2){
						$.globalMessenger().post({
				            message: lj.err,//提示信息
				            type: 'info',//消息类型。error、info、success
				            hideAfter: 2,//多长时间消失
				            showCloseButton:true,//是否显示关闭按钮
				            hideOnNavigate: true //是否隐藏导航
						});
						window.setTimeout(function(){
							location.reload();
						},500);
					}
					else{
					$.globalMessenger().post({
			            message: lj.err,//提示信息
			            type: 'info',//消息类型。error、info、success
			            hideAfter: 2,//多长时间消失
			            showCloseButton:true,//是否显示关闭按钮
			            hideOnNavigate: true //是否隐藏导航
					});
					}
				}
				
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
	
	
	$(".btn-cancel").bind("click",function(){
		var cmts=$(this).parent().parent().parent();
		cmts.children(".cmts-msg").remove();
		cmts.children(".Pagination").remove();
		cmts.hide();
	});
	
	
	
		
});


function addCmts(cj,load){
	var cmthtml="";
	var uid=$("#uid").val();
	var utp=$("#userType").val();
	
	for(var cmmt in cj.posts){
		
		 cmthtml+="<div  class='CommentItem cmts-msg'>";
			cmthtml+="		<div class='CommentItem-meta'>";
			
			cmthtml+="					<span class='cmt-name'>"+cj.posts[cmmt].rpu.userName+"</span>";
			
			cmthtml+="					<span class='cmt-time'>"+cj.posts[cmmt].postTime+"</span>";
			cmthtml+="				</div>";
			cmthtml+="				<div class='CommentItem-content'>";
			cmthtml+="				<span class='content'>"+cj.posts[cmmt].postContent+"</span>";
			cmthtml+="				</div>";
			cmthtml+="				<div class='CommentItem-footer'>";
			
			if(utp==1||uid==cj.posts[cmmt].rpu.uid){
				
				cmthtml+="<button class='btn btn-link btn-rpurm'>" +
						"<span class='glyphicon glyphicon-remove'></span>" +
						"<input type='hidden' value='"+cj.posts[cmmt].pid+"'>" +
						"删除" +
						"</button>";
			}
			if(utp==1){
				
				var gag="btn-gagc";
				var gagc="禁言";
				if(cj.posts[cmmt].rpu.isGag==2){
					gag="btn-ungagc";
					gagc="解禁";
				}
					
				cmthtml+="<button class='btn btn-link "+gag+"'>" +
				"<span class='glyphicon glyphicon-lock'></span>" +
				"<input class='gaguid' type='hidden' value='"+cj.posts[cmmt].rpu.uid+"'>" +
						"<input class='gagname' type='hidden' value='"+cj.posts[cmmt].rpu.userName+"'>" +
				gagc +
				"</button>";
			}
			
			
								
			cmthtml+="						</div>";
			cmthtml+="					<div style=\"display:none;\">";
			cmthtml+="				<div class='cmt-input'>";
			cmthtml+="				<input class='form-control' type='text'>";
			cmthtml+="									</div>";
			cmthtml+="				<div class='cmt-btngroup'>";
			cmthtml+="				<button type='button' class='btn btn-primary btn-send'>" +
					"<input type='hidden' value='"+cj.posts[cmmt].pid+"'>";
										
								
			cmthtml+="						发送</button>";
			cmthtml+="					<button type='button' class='btn btn-default btn-cancel'>取消</button>";
			cmthtml+="				</div>";
			cmthtml+="				</div>";
			cmthtml+="				</div>";
			
			
			
			
	}
	
	cmthtml+="<div class='Pagination comments-Pagination'>";
	for(var p in cj.page.groupList){
		var a="";
		if(cj.page.groupList[p]==cj.page.currentPage)
			a="active";
		cmthtml+="<button type='button' class='btn btn-default btn-rpage "+a+"'>" +
				"<input class='rpg' type='hidden' value='"+cj.page.groupList[p]+"'>" +
				"<input class='rpid' type='hidden' value='"+cj.posts[cmmt].cz.uid+"'>" +
			cj.page.groupList[p] +
			
				"</button>";
		
	}
	
	
	cmthtml+="</div>";
	load.after(cmthtml);
	
}


function addPageClick(){
	
	var pn=$(this).children(".rpg").val();
	var pid=$(this).children(".rpid").val();
	var cmts=$(this).parent();
	var load=$(this).parent().children(".loading");
	
	cmts.remove("");
	load.show();
	
	$.ajax({
		
		type:"POST",
		url:"/bbs/post/postdetail/reply/"+pn,
		async:false,
		dataType:"json",
		contentType: "application/json; charset=utf-8",
		data:JSON.stringify({
			pid:pid
		}),
		success:function(cj){
			load.hide();
			addCmts(cj,load);
			
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
	
}
