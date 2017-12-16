<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>类型列表</title>
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
		<li class="active"><a href="${ctx}/bookkeeping/category/list">列表</a></li>
		<li><a href="${ctx}/bookkeeping/form?sort=10">新增</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="bkCategory" action="${ctx}/bookkeeping/category/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<select name="parentId" style="width:200px;">
			<c:forEach items="${baseList}" var="base">
				<option value="${base.id }" <c:if test="${base.id == bkCategory.parentId }">selected</c:if>>${base.name }</option>
			</c:forEach>
		</select>
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>类型名称</th><th>父类型</th><th>支出类型</th><th>创建时间</th><th>创建人</th><th>修改时间</th><th>操作</th></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="bkCategory">
			<tr>
				<td>${bkCategory.name}</td>
				<td>${bkCategory.parentName}</td>
				<td>${fns:getDictLabel(bkCategory.type,'bk_direction','0')}</td>
				<td><fmt:formatDate value="${bkCategory.gmtCreate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${bkCategory.createUserName}</td>
				<td><fmt:formatDate value="${bkCategory.gmtModify}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
	    			<a href="${ctx}/bookkeeping/form?id=${bkCategory.id}">修改</a>
	    			<a href="${ctx}/bookkeeping/delete?id=${bkCategory.id}" onclick="return confirmx('确认要删除吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>