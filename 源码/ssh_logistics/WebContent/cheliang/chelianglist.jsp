<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
.display-flex {
	display: flex;
}

.div-size {
	width: 50%;
	margin: 10px;
}
</style>

</head>

<body>
	<form id="pagerForm" method="post" action="${url }">
		<input type="hidden" name="pageNum" value="1" /> <input type="hidden"
			name="numPerPage" value="${ps}" />
	</form>

	<!--  
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="demo_page1.html" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li>&nbsp;</li>
				<li>&nbsp;</li>
			</ul>
		</div>
	</div>
	</form>
</div>
-->
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">

				<li><a class="add" href="diaodumethod!cheliangadd"
					target="dialog" mask="true"><span>添加车辆</span></a></li>
				<li><a class="delete"
					href="diaodumethod!cheliangdelete?id={sid_user}" target="ajaxTodo"
					title="确定要删除吗?"><span>删除车辆</span></a></li>
				<li><a class="edit"
					href="diaodumethod!cheliangupdate?id={sid_user}" target="dialog"
					mask="true"><span>修改车辆</span></a></li>

			</ul>
		</div>

		<div class="display-flex">
			<div class="div-size">
				<table class="table" width="100%" layoutH="138">
					<thead>
						<tr>
							<th width="120">车牌</th>

							<th width="100">车型</th>
							<th width="100">柜号</th>
							<th width="100">承运公司</th>
							<th width="100">调度状态</th>
							<th width="100">注册时间</th>
							<th width="100">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="bean">
							<tr target="sid_user" rel="${bean.id}">
								<td>${bean.chepai}</td>

								<td>${bean.chexing}</td>

								<td>${bean.guihao}</td>

								<td>${bean.chengyungongsi}</td>
								<td>${bean.diaoduzhuangtai}</td>


								<td>${fn:substring(bean.createtime,0, 19)}</td>
								<td><a href="javascript:loadBaiduMap(${bean.id})">查看位置</a></td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
			<div class="div-size">
				<div style="width:500px;height:500px" id="allmap"></div>
			</div>
		</div>
		<div class="panelBar">
			<div class="pages">

				<span>共${totalCount}条</span>
			</div>

			<div class="pagination" targetType="navTab"
				totalCount="${totalCount}" numPerPage="${ps}" pageNumShown="10"
				currentPage="${pn}"></div>

		</div>
	</div>
	<script type="text/javascript">
		var map = new BMap.Map("allmap");
		map.centerAndZoom(new BMap.Point(116.331398, 39.897445), 11);
		map.enableScrollWheelZoom(true);
		// 百度地图API功能

		// 用经纬度设置地图中心点
		function theLocation(j, w) {
			if (w != "" && j != "") {
				map.clearOverlays();
				var new_point = new BMap.Point(w, j);
				var marker = new BMap.Marker(new_point); // 创建标注
				map.addOverlay(marker); // 将标注添加到地图中
				map.panTo(new_point);
			}
		}
	</script>
	<script>
		function load(name) {
			let xhr = new XMLHttpRequest(), okStatus = document.location.protocol === "file:" ? 0
					: 200;
			xhr.open('GET', name, false);
			xhr.overrideMimeType("text/html;charset=utf-8");//默认为utf-8
			xhr.send(null);
			return xhr.status === okStatus ? xhr.responseText : null;
		}
		function loadBaiduMap(id) {
			let text = load("test.txt");
			var obj = eval(text);
			for ( var i in obj) {
				if (obj[i].id == id) {
					theLocation(obj[i].j, obj[i].w);
				}
			}
		}
	</script>

</body>
</html>
