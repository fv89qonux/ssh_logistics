<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageContent">
	
	<form method="post" name=form1 action="method!dingdanadd2" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
	
<div class="pageFormContent" layoutH="58">
			
			<div class="unit">
				<label>客户名</label>
				 <select name="kehu">
				<c:forEach  var="bean"   items="${list2}">
				<option value="${bean.id }">客户名称：${bean.kehumingcheng }&nbsp;&nbsp;&nbsp;公司名称：${bean.gongsimingchen }</option>
				</c:forEach>
				</select>
			</div>
			<div class="unit">
				<label>联系方式</label>
				 <input type="text" name="liaxifangshi" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>出发地</label>
				 <input type="text" name="fahuodi" size="30" class="required"/>
			</div>
			
			<div class="unit">
				<label>目的地</label>
				 <input type="text" name="mudidi" size="30" class="required"/>
			</div>
			
			<div class="unit">
				<label>金额</label>
				 <input type="text" name="jine" size="30" class="required number"/>
			</div>
			<div class="unit">
				<label>选择货物</label>
				<select name="kucun">
				<c:forEach  var="bean"   items="${list}">
				<option value="${bean.id }">货物名：${bean.shangpingming }&nbsp;&nbsp;&nbsp;数量：${bean.shuliang }</option>
				</c:forEach>
				</select>
			</div>
			<div class="unit">
				<label>订货数量</label>
				 <input type="text" name="shuliang" size="30" class="required number"/>
			</div>
			<div class="unit">
				<label>面积</label>
				 <input type="text" name="mianji" size="30" class="required number"/>
			</div>
			<div class="unit">
				<label>体积</label>
				 <input type="text" name="tiji" size="30" class="required number"/>
			</div>
				<div class="unit">
				<label>重量</label>
				 <input type="text" name="zhongliang" size="30" class="required number"/>
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