<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>home_test管理</title>
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
		<li class="active"><a href="${ctx}/home/test/list">列表</a></li>
		<li><a href="${ctx}/home/test/form?sort=10">新增</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="homeTest" action="${ctx}/home/test/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>name：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>&nbsp;
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>name</th><th>age</th><th>sex</th><th>remark</th><th>操作</th></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="homeTest">
			<tr>
				<td>${homeTest.name}</td>
				<td>${homeTest.age}</td>
				<td>${fns:getDictLabels(homeTest.sex,'sex',1)}</td>
				<td>${homeTest.remark }</td>
				<td>
	    			<a href="${ctx}/home/test/form?id=${homeTest.id}">修改</a>
	    			<a href="${ctx}/home/test/delete?id=${homeTest.id}" onclick="return confirmx('确认要删除吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>