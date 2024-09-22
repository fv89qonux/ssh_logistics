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

			<li><a class="edit" href="diaodumethod!diaoduadd?id={sid_user}" target="dialog" mask="true"><span>调度分配</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100">操作员</th>
				<th width="100">订车单号</th>
				<th width="100">订车性质</th>
				<th width="50">运输性质</th>
				<th width="100">联系人</th>
				<th width="50">电话</th>
				<th width="50">传真</th>
				<th width="50">邮件</th>
				<th width="100">分配车辆车牌</th>
				<th width="100">所属订单订单号</th>
				
				<th width="100">订车单状态</th>
				
				
				<th width="100">添加时间</th>

			

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${list}" var="bean"  >
			<tr target="sid_user" rel="${bean.id}">
			<td>
				${bean.user.username}
				</td>
				<td>
				${bean.dingchedanhao}
				</td>
				<td>
				${bean.dingchexingzhi}
				</td>
				<td>
				${bean.yunshuxingzhi}
				</td>
				<td>
				${bean.lianxiren}
				</td>
				<td>
				${bean.dianhua}
				</td>
				<td>
				${bean.chuanzhen}
				</td>
				
				<td>
				${bean.youjian}
				</td>
				<td>
				${bean.cheliang.chepai}
				</td>
				<td>
				${bean.dingdan.dingdanhao}
				</td>
				<td>
				${bean.fenpeizhuangtai}
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
