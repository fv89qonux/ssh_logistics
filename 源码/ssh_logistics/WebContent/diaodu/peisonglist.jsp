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



<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">

			<li><a class="edit" href="diaodumethod!dingchedanadd?id={sid_user}" target="dialog" mask="true"><span>创建订车单</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100">订单号</th>
				<th width="100">订车单数量</th>
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
				${bean.dingchedangeshu}
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
