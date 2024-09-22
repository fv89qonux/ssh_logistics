<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageContent">
	
	<form method="post" name=form1 action="diaodumethod!diaoduadd2" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
	
<div class="pageFormContent" layoutH="58">
			
			<input type="hidden" name="id" value="${id }">
			<div class="unit">
				<label>选择车辆</label>
				 <select name="cheliang">
				 <c:forEach items="${list}" var="bean">
				 <option  value="${bean.id }">${bean.chepai }</option>
				 </c:forEach>
				 </select>
			</div>
			
			
			<div class="unit">
				<label>承运公司</label>
				 <input type="text" name="chengyungongsi" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>线路名称</label>
				 <input type="text" name="xianluming" size="30" class="required"/>
			</div>
			
			<div class="unit">
				<label>要求到达时间</label>
				 <input type="text" name="yaoqiudaidashijian" size="30" class="date"/>
			</div>
			
			<div class="unit">
				<label>运输费用</label>
				 <input type="text" name="yunshufeiyong" size="30" class="required "/>
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