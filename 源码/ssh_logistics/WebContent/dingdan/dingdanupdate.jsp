<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageContent">
	
	<form method="post" name=form1 action="method!dingdanupdate2" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
	
<div class="pageFormContent" layoutH="58">
			
			
			<input type="hidden" name="id"   value="${bean.id }"/>
			<div class="unit">
				<label>客户名</label>
				 ${bean.kehuxingming }
			</div>
			<div class="unit">
				<label>联系方式</label>
				 <input type="text" name="liaxifangshi" size="30" class="required" value="${bean.liaxifangshi }"/>
			</div>
			<div class="unit">
				<label>出发地</label>
				 <input type="text" name="fahuodi" size="30" class="required" value="${bean.fahuodi }"/>
			</div>
			
			<div class="unit">
				<label>目的地</label>
				 <input type="text" name="mudidi" size="30" class="required" value="${bean.mudidi }"/>
			</div>
			
			<div class="unit">
				<label>金额</label>
				 <input type="text" name="jine" size="30" class="required number" value="${bean.jine }"/>
			</div>
			<div class="unit">
				<label>货物名</label>
				${bean.huowumingchen }
				
				
			</div>
			<div class="unit">
				<label>订货数量</label>
				 <input type="text" name="shuliang" size="30" class="required number" value="${bean.shuliang }"/>
			</div>
			<div class="unit">
				<label>面积</label>
				 <input type="text" name="mianji" size="30" class="required number" value="${bean.mianji }"/>
			</div>
			<div class="unit">
				<label>体积</label>
				 <input type="text" name="tiji" size="30" class="required number" value="${bean.tiji }"/>
			</div>
				<div class="unit">
				<label>重量</label>
				 <input type="text" name="zhongliang" size="30" class="required number" value="${bean.zhongliang }"/>
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