<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<form id="pagerForm" method="post" action="${url }">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${ps}" />
</form>

<div class="pageHeader">

	<form onsubmit="return navTabSearch(this);" action="method!dingdanlist2" method="post">
	<div class="searchBar">
		<table class="searchContent">
		   <input type="hidden" name="id" value="${id}" />
		   <input type="hidden" name="type" value="${type}" />
			<tr>
				
				<td>
					订单号：<input type="text"  name="dingdanhao" value="${dingdanhao}"  size="12"/>
				</td>
				<td>
					货物名称：<input type="text"  name="huowumingchen" value="${huowumingchen}" size="12"/>
				</td>
				<td>
					客户名：<input type="text"  name="kehuxingming" value="${kehuxingming}"  size="12"/>
				</td>
				<td>
					发货地：<input type="text"  name="fahuodi" value="${fahuodi}" size="12"/>
				</td>
				<td>
					目的地：<input type="text"  name="mudidi" value="${mudidi}" size="12"/>
				</td>
				
				
				
			</tr>
			
			<tr>
				<td>
					收货状态：<select name="shouhuozhuangtai">
					<option value="">请选择</option> 
					<option value="未发货" <c:if test="${shouhuozhuangtai=='未发货' }">selected</c:if> >未发货</option> 
					<option value="库存数量不够,转入订单仓库" <c:if test="${shouhuozhuangtai=='库存数量不够,转入订单仓库' }">selected</c:if>>库存数量不够,转入订单仓库</option> 
					<option value="商品已出库，转入调度中心" <c:if test="${shouhuozhuangtai=='商品已出库，转入调度中心' }">selected</c:if>>商品已出库，转入调度中心</option> 
					<option value="商品已配送" <c:if test="${shouhuozhuangtai=='商品已配送' }">selected</c:if>>商品已配送</option> 
					<option value="完成配送" <c:if test="${shouhuozhuangtai=='完成配送' }">selected</c:if>>完成配送</option> 
					</select>
				</td>
				<td>
					对账状态：<select name="duizhangzhuangtai">
					<option value="">请选择</option> 
					<option value="未对帐" <c:if test="${duizhangzhuangtai=='未对帐' }">selected</c:if>>未对帐</option> 
					<option value="已对账" <c:if test="${duizhangzhuangtai=='已对账' }">selected</c:if>>已对账</option>
					</select>
				</td>
				<td>
					订单添加开始时间：<input type="text" class="date" readonly="true" name="time1" value="${time1}" size="12"/>
				</td>
				<td>
					订单添加结束时间：<input type="text" class="date" readonly="true" name="time2" value="${time2}" size="12"/>
				</td>
				<td>
					<div class="subBar">
					<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
					</ul>
					</div>
				</td>
				
			</tr>
			
		</table>
		
	</div>
	</form>
</div>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100">订单号</th>
				<th width="50">客户名</th>
				<th width="100">联系方式</th>
				<th width="50">出发地</th>
				<th width="50">目的地</th>
				<th width="50">金额</th>
				<th width="100">货物编号</th>
				<th width="100">货物名</th>
				<th width="50">数量</th>
				<th width="50">面积</th>
				<th width="50">体积</th>
				<th width="50">重量</th>
				<th width="100">收货状态</th>
				<th width="100">对账状态 </th>
				
				<th width="100">日期</th>

			

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${list}" var="bean"  >
			<tr target="sid_user" rel="${bean.id}">
				<td>
				${bean.dingdanhao}
				</td>
				<td>
				${bean.kehuxingming}
				</td>
				<td>
				${bean.liaxifangshi}
				</td>
				<td>
				${bean.fahuodi}
				</td>
				<td>
				${bean.mudidi}
				</td>
				
				<td>
				${bean.jine}
				</td>
				<td>
				${bean.huowubianhao}
				</td>
				<td>
				${bean.huowumingchen}
				</td>
				<td>
				${bean.shuliang}
				</td>
				<td>
				${bean.mianji}
				</td>
				<td>
				${bean.tiji}
				</td>
				<td>
				${bean.zhongliang}
				</td>
				<td>
				${bean.shouhuozhuangtai}
				</td>
				<td>
				${bean.duizhangzhuangtai}
				</td>
				<td>
				${fn:substring(bean.riqi,0, 19)}
				</td>
				
				
				
				
			</tr>			
			</c:forEach>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			
			<span>共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${totalCount}" numPerPage="${ps}" pageNumShown="10" currentPage="${pn}"></div>

	</div>
</div>

  </body>
</html>
