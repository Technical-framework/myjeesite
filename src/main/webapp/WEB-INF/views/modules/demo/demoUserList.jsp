<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户列表</title>
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
		<li class="active"><a href="${ctx}/demo/list">列表</a></li>
		<li><a href="${ctx}/demo/form?sort=10">新增</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="demoUser" action="${ctx}/demo/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>操作：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>&nbsp;
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>姓名</th><th>年龄</th><th>性别</th><th>手机</th><th>地址</th><th>操作</th></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="demoUser">
			<tr>
				<td>${demoUser.name}</td>
				<td>${demoUser.age}</td>
				<td>${fns:getDictLabels(demoUser.sex,'sex',1)}</td>
				<td>${demoUser.phone }</td>
				<td>${demoUser.address }</td>
				<td>
	    			<a href="${ctx}/demo/form?id=${demoUser.id}">修改</a>
	    			<a href="${ctx}/demo/delete?id=${demoUser.id}" onclick="return confirmx('确认要删除吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>