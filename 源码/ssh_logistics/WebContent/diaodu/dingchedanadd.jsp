<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageContent">
	
	<form method="post" name=form1 action="diaodumethod!dingchedanadd2" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
	
<div class="pageFormContent" layoutH="58">
			
			<input type="hidden" name="id" value="${id }">
			<div class="unit">
				<label>订车性质</label>
				 <input type="text" name="dingchexingzhi" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>运输性质</label>
				 <input type="text" name="yunshuxingzhi" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>联系人</label>
				 <input type="text" name="lianxiren" size="30" class="required"/>
			</div>
			
			<div class="unit">
				<label>电话</label>
				 <input type="text" name="dianhua" size="30" class="required"/>
			</div>
			
			<div class="unit">
				<label>传真</label>
				 <input type="text" name="chuanzhen" size="30" class="required "/>
			</div>
			
			<div class="unit">
				<label>邮件</label>
				 <input type="text" name="youjian" size="30" class="required "/>
			</div>
			
	
			
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>