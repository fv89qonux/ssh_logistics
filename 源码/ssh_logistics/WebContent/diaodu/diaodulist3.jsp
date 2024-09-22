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

			<li><a class="delete" href="diaodumethod!diaoduupdate2?id={sid_user}" target="ajaxTodo" title="确定完成调度吗?" ><span>确认完成调度</span></a></li>
			
			
			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50">调度状态</th>
				<th width="100">调度日期</th>
				<th width="100">操作员</th>
				<th width="100">订单号</th>
				<th width="100">订车单号</th>
				<th width="50">车牌号</th>
				<th width="100">承运公司</th>
				<th width="50">线路名</th>
				<th width="50">要求达到时间</th>
				
				<th width="100">运输费用</th>
				<th width="100">添加时间</th>

			

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${list}" var="bean"  >
			<tr target="sid_user" rel="${bean.id}">
				<td>
				${bean.diaoduzhuangtai}
				</td>
				<td>
				${bean.diaoduriqi}
				</td>
				<td>
				${bean.user.username}
				</td>
				<td>
				${bean.dingdan.dingdanhao}
				</td>
				<td>
				${bean.dingchedan.dingchedanhao}
				</td>
				<td>
				${bean.cheliang.chepai}
				</td>
				<td>
				${bean.chengyungongsi}
				</td>
				<td>
				${bean.xianluming}
				</td>
				<td>
				${bean.yaoqiudaidashijian}
				</td>
				
				
				<td>
				${bean.yunshufeiyong}
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
