<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 禁言框 -->
<div class="modal fade" id="gagModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="true">

    <div class="modal-dialog modal-dialog-set">
        <div class="modal-content">
        
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="gagTitle">禁言</h3>
            </div>
            <div class="modal-body container-fluid">
				<div class="radio">
			        <label>
			          <input type="radio" name="gagtime" value="3">3分钟
			        </label>
		        </div>
				<div class="radio">
			        <label>
			          <input type="radio" name="gagtime" value="1440">1天
			        </label>
		        </div>
		        <div class="radio">
			        <label>
			          <input type="radio" name="gagtime" value="4320">3天
			        </label>
		        </div>
				
			</div>
            <div class="modal-footer">
				
				<button id="btngag" type="button" class="btn btn-primary btn-block" >
				<input type="hidden" class="" value="">
				
				禁言
				</button>
				<button type="button" class="btn btn-default btn-block" data-dismiss="modal">关闭</button>
				
            </div>
           
        </div><!-- /.modal-content -->
        
        
    </div><!-- /.modal -->
    
    
    
    
    
    
    
	
</div>