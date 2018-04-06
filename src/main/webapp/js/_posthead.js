

$(function(){
	$(".btn-rm").bind("click",function(){
		var hdid=$(this).children("input").val();
		
		$.ajax({
			type:"POST",
			url:"/bbs/posthead/remove",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				hdid:hdid
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
	
	
	
	$(".btn-fr").bind("click",function(){
		var hdid=$(this).children("input").val();
		
		$.ajax({
			type:"POST",
			url:"/bbs/posthead/good",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				hdid:hdid
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
	
	
	
	$(".btn-unfr").bind("click",function(){
		var hdid=$(this).children("input").val();
		
		$.ajax({
			type:"POST",
			url:"/bbs/posthead/ungood",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				hdid:hdid
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
	
	
	
	$(".btn-up").bind("click",function(){
		var hdid=$(this).children("input").val();
		
		$.ajax({
			type:"POST",
			url:"/bbs/posthead/up",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				hdid:hdid
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
	
	
	$(".btn-down").bind("click",function(){
		var hdid=$(this).children("input").val();
		
		$.ajax({
			type:"POST",
			url:"/bbs/posthead/down",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				hdid:hdid
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
	
	
	$(".btn-lc").bind("click",function(){
		var hdid=$(this).children("input").val();
		
		$.ajax({
			type:"POST",
			url:"/bbs/posthead/lock",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				hdid:hdid
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
	
	
	
	$(".btn-unlc").bind("click",function(){
		var hdid=$(this).children("input").val();
		
		$.ajax({
			type:"POST",
			url:"/bbs/posthead/unlock",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				hdid:hdid
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
	
	
	
	$(".btn-gag").bind("click",function(){
		
		var uid=$(this).children(".gaguid").val();
		var uname=$(this).children(".gagname").val();
		$("#gagTitle").html("禁言用户"+uname);
		$("#btngag").children("input").val(uid);
		
		$("#gagModal").modal("show");
		
	});
	
	$("#btngag").bind("click",function(){
		
		var uid=$(this).children("input").val();
		
		var totime = $("input[name='gagtime']:checked").val();
		if(totime=="")
			totime=3;
		$.ajax({
			type:"POST",
			url:"/bbs/gag/gaguser",
			async:false,
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify({
				endTime:totime,
				gu:{
					uid:uid	
				},
				gagType:2,
				gagRs:1
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
	
	
	
	
$(".btn-ungag").bind("click",function(){
		
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
	
	
	
	
	
	
	
});

