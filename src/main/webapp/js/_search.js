$(function(){
	
	$(".btn-search").bind("click",function(){
		
		var kw=$(".input-kw").val();
		
		if(kw!=""){
			/*$.ajax({
				
				type:"POST",
				url:"/bbs/post/search?kw="+kw,
				
				async:false,
				contentType: "text/plain; charset=utf-8",
				
				
				success:function(){
					
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

			});*/
			window.location.href="/bbs/post/search?kw="+encodeURI(kw);
		}
		
	});
	
});