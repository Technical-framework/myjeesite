<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>记账列表</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/bookkeeping/list">列表</a></li>
		<li><a href="${ctx}/bookkeeping/form?sort=10">新增</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="bills" action="${ctx}/bookkeeping/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		操作：<input type="text" maxlength="50" />
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>金额</th><th>金额来源</th><th>类型ID</th><th>子类型ID</th><th>备注</th><th>创建时间</th><th>创建人</th><th>修改时间</th><th>修改人</th><th>操作</th></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="bills">
			<tr>
				<td>${bills.money}</td>
				<td>${bills.direction}</td>
				<td>${bills.category_id_1 }</td>
				<td>${bills.category_id_2 }</td>
				<td>${bills.remark}</td>
				<td>${bills.gmt_create}</td>
				<td>${bills.create_user }</td>
				<td>${bills.gmt_modify }</td>
				<td>${bills.modify_user }</td>
				<td>
	    			<a href="${ctx}/bookkeeping/form?id=${bills.id}">修改</a>
	    			<a href="${ctx}/bookkeeping/delete?id=${bills.id}" onclick="return confirmx('确认要删除吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>