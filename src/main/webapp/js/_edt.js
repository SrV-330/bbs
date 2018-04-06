$(function(){
	
	CKEDITOR.editorConfig = function( config ) {
		    config.uiColor = '#f1e4db';
		    config.height = 200;
		    config.removePlugins = 'elementspath,resize'; // 移除编辑器底部状态栏显示的元素路径和调整编辑器大小的按钮
		    config.allowedContent = false; // 是否允许使用源码模式进行编辑
		    config.forcePasteAsPlainText = true; // 是否强制复制过来的文字去除格式
		    config.enterMode = CKEDITOR.ENTER_BR; // 编辑器中回车产生的标签CKEDITOR.ENTER_BR(<br>),CKEDITOR.ENTER_P(<p>),CKEDITOR_ENTER(回车)
		    // 设置快捷键
		   // 用于实现Ctrl + V进行粘贴
		   // 无此配置，无法进行快捷键粘贴
		   config.keystrokes = [
		     [CKEDITOR.CTRL + 86 /* V */, 'paste']
		   ];
		 
		   // 设置快捷键，可能与浏览器冲突plugins/keystrokes/plugin.js
		   // 用于实现Ctrl + V进行粘贴
		   // 此配置将会启动粘贴之前进行过滤，若无此配置，将会出现粘贴之后才弹出过滤框
		   config.blockedKeystrokes = [
		     CKEDITOR.CTRL + 86
		   ];
		 
		   // 图片上传相关
		   config.filebrowserImageUploadUrl = '/bbs/img'; // 图片上传路径
		   config.image_previewText = ' '; // 图片信息面板预览区内容的文字内容，默认显示CKEditor自带的内容
		   config.removeDialogTabs = 'image:advanced;image:Link'; // 移除图片上传页面的'高级','链接'页签
		 }
	
	
	     CKEDITOR.replace('editor');
	   $(".btn-send-posthead").bind("click",function(){
		   var title=$(".input-title").val();
		   var content=CKEDITOR.instances.editor.getData();
		   var simple=content;
		   simple = simple.replace(/(\n)/g, "");  
		   simple = simple.replace(/(\t)/g, "");  
		   simple = simple.replace(/(\r)/g, "");  
		   simple = simple.replace(/<\/?[^>]*>/g, "");  
		   simple = simple.replace(/\s*/g, "");
		   
		   
		   
		   $.ajax({
				type:"POST",
				url:"/bbs/posthead/add",
				async:false,
				dataType:"json",
				contentType: "application/json; charset=utf-8",
				data:JSON.stringify({
					headTitle:title,
					headSimple:simple,
					headDetail:content
				}),
				success:function(lj){
					
					
					$.globalMessenger().post({
			            message: lj.err,//提示信息
			            type: 'info',//消息类型。error、info、success
			            hideAfter: 2,//多长时间消失
			            showCloseButton:true,//是否显示关闭按钮
			            hideOnNavigate: true //是否隐藏导航
					});
					if(lj.res==1){
						CKEDITOR.instances.editor.setData("");
						window.setTimeout(function(){
							location.reload();
						},500);
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
	   $(".btn-send-post").bind("click",function(){
		  
		   var content=CKEDITOR.instances.editor.getData();
		   var hdid=$(this).children("input").val();
		   
		   $.ajax({
				type:"POST",
				url:"/bbs/post/add",
				async:false,
				dataType:"json",
				contentType: "application/json; charset=utf-8",
				data:JSON.stringify({
					hd:{
					hdid:hdid},
					postContent:content
				}),
				success:function(lj){
					
					
					$.globalMessenger().post({
			            message: lj.err,//提示信息
			            type: 'info',//消息类型。error、info、success
			            hideAfter: 2,//多长时间消失
			            showCloseButton:true,//是否显示关闭按钮
			            hideOnNavigate: true //是否隐藏导航
					});
					if(lj.res==1){
						CKEDITOR.instances.editor.setData("");
						window.setTimeout(function(){
							location.reload();
						},500);
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