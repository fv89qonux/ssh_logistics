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
<form id="pagerForm" method="post" action="caiwumethod!caiwulist2">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${ps}" />
</form>

<div class="pageHeader">

	<form onsubmit="return navTabSearch(this);" action="caiwumethod!caiwulist2" method="post">
	<div class="searchBar">
		<table class="searchContent">
		  
			
			<tr>
				
				<td>
					开始时间：<input type="text" class="date" readonly="true" name="time1" value="${time1}" size="12"/>
				</td>
				<td>
					结束时间：<input type="text" class="date" readonly="true" name="time2" value="${time2}" size="12"/>
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
			
<li><a class="delete" href="caiwumethod!duizhang?id={sid_user}" target="ajaxTodo" title="确定对账吗?" ><span>确定对账</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100">金额</th>
				<th width="100">订单号</th>
				<th width="50">客户名</th>
				<th width="100">联系方式</th>
				<th width="100">货物名</th>
				<th width="50">数量</th>
				<th width="100">收货状态</th>
				<th width="100">对账状态 </th>
				
				<th width="100">时间</th>

			

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${list}" var="bean"  >
			<tr target="sid_user" rel="${bean.id}">
			
				<td>
				${bean.jine}
				</td>
				<td>
				${bean.dingdan.dingdanhao}
				</td>
				<td>
				${bean.dingdan.kehuxingming}
				</td>
				<td>
				${bean.dingdan.liaxifangshi}
				</td>
				<td>
				${bean.dingdan.huowumingchen}
				</td>
				<td>
				${bean.dingdan.shuliang}
				</td>
				<td>
				${bean.dingdan.shouhuozhuangtai}
				</td>
				<td>
				${bean.dingdan.duizhangzhuangtai}
				</td>
				
				
				<td>
				${fn:substring(bean.createtime,0, 19)}
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
