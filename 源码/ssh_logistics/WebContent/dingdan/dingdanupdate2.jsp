<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageContent">
	
	<form method="post" name=form1 action="method!dingdanupdate2" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
	
<div class="pageFormContent" layoutH="58">
			
			
			<input type="hidden" name="id"   value="${bean.id }"/>
			<div class="unit">
				更新失败，该订单已经进入物流配送
			</div>
			
	
			
			
		</div>
		<div class="formBar">
			<ul>
	
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">确定</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>