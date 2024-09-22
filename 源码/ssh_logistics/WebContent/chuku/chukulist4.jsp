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
	<form onsubmit="return navTabSearch(this);" action="cangchumethod!chukulist4" method="post">
	<div class="searchBar">
		<table class="searchContent">
		   <input type="hidden" name="id" value="${id}" />
		   <input type="hidden" name="type" value="${type}" />
			
			
			<tr>
				<td>
					类型：<select name="leixing">
					<option value="" >选择类型</option> 
					<option value="2" <c:if test="${leixing==2 }">selected</c:if>  >出库记录</option> 
					<option value="1" <c:if test="${leixing==1 }">selected</c:if> >入库记录</option> 
					</select>
				</td>
				<td>
					商品名：<input type="text"  name="shangpingming" value="${shangpingming}"  size="12"/>
				</td>
				<td>
					操作员：<input type="text"  name="username" value="${username}"  size="12"/>
				</td>
				
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

		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120">类型</th>
				<th width="120">操作员</th>
				<th width="120">商品名</th>
				<th width="120">订单号</th>
				<th width="120">数量</th>
				<th width="120">价格</th>
				<th width="120">占用面积</th>
				<th width="100">出库时间</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${list}" var="bean"  >
			<tr target="sid_user" rel="${bean.id}">
				<td>
				<c:if test="${bean.type==1}">入库记录</c:if>
				<c:if test="${bean.type==2}">出库记录</c:if>
				
				</td>
			
				<td>
				${bean.user.username}
				</td>
				
				<td>
				${bean.shangpingming}
				</td>
				<td>
				${bean.dingdanhao}
				</td>
				<td>
				${bean.shuliang}
				</td>
				<td>
				${bean.jiage}
				</td>
				<td>
				${bean.zhanyongmianji}
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
