<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			var $table = $('#contentTable');
			$("#create").click(function(){
				$.jBox.open("iframe:${ctx}/test1/testStudent/form", "新增", 800, 500, { buttons: { '关闭': true} });
			});
			$("#update").click(function(){
				var selected = getIdSelections();
	            if (selected.length!=0){
					$.jBox.open("iframe:${ctx}/test1/testStudent/form?id="+selected[0], "编辑", 800, 500, { buttons: { '关闭': true} });
				}else{
					alertx('请选择需要编辑的记录');
				}
			});
			$("#delete").click(function(){
				var selected = getIdSelections();
				if (selected.length!=0){
					confirmx("确认要删除该记录吗？",function () {
					    	$table.bootstrapTable('showLoading');
					    	$.ajax({
							    type: 'POST',
							    data: "ids="+selected,
							    url: '${ctx}/test1/testStudent/delete',
							    dataType: 'json',
							    success: function(data){
							    	if(data.success){
							    		successx("删除成功!");
							    		//$table.bootstrapTable('remove', {field:'id',values:selected});
							    		$table.bootstrapTable('refresh');
							    	}else{
					    				alertx("删除失败！");
						    		}
						    	}
							});
					});
				}else{
					alertx('请选择需要删除的记录');
				}
			});
			$("#btnReset").click(function(){
				$("input[class='input-medium']").attr("value","");
				$("select").val("");
				$("select").change();
			});
			$("#btnSubmit").click(function () {
			    $table.bootstrapTable('removeAll');
				$table.bootstrapTable('refresh');
			});
			function getIdSelections() {
		        return $.map($table.bootstrapTable('getSelections'), function (row) {
		            return row.id
		        });
		    };
		    window.onload = function() { 
				$table.bootstrapTable('resetView');//防止jbox页面打开，table显示不正常
			};
		});
		function queryParams(params) {
			$.each($('#searchForm').serializeArray(),function(i,item){
				params[item.name] = item.value;
			})
		    return params;
		}
	</script>
</head>
<body>
	<shiro:hasPermission name="test1:testStudent:edit">
	<div class="btn-toolbar" role="toolbar">
		<div class="btn-group" role="group">
		  <button id="create" type="button" class="btn btn-primary">新增</button>
		  <button id="update" type="button" class="btn btn-success">编辑</button>
		  <button id="delete" type="button" class="btn btn-danger">删除</button>
		</div>
	</div>
	</shiro:hasPermission>
	<form:form id="searchForm" modelAttribute="testStudent" action="${ctx}/test1/testStudent/" method="post" class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="button" value="查询"/><input id="btnReset" class="btn btn-primary" type="button" value="重置"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table 
		id="contentTable" 
		data-height="450"
		data-toggle="table"
		data-flat="true"
		data-url="${ctx}/test1/testStudent/jsonList"
		data-side-pagination="server"
		data-query-params-type=""
		data-pagination="true"
		data-query-params="queryParams"
		data-click-to-select="true">
		<thead>
			<tr>
				<th data-checkbox="true"></th>
				<th data-field="id" data-visible="false">id</th>
				<th data-field="name" data-sortable="true">姓名</th>
				<th data-field="age" data-sortable="true">年龄</th>
				<th data-field="sex" data-sortable="true">性别</th>
				<th data-field="remark" data-sortable="true">备注</th>
			</tr>
		</thead>
		<%--<tbody>
		<c:forEach items="${page.list}" var="testStudent">
			<tr>
				<td><input type="checkbox" name="id" value="${testStudent.id}"/></td>
				<td><a href="${ctx}/test1/testStudent/form?id=${testStudent.id}">
					${testStudent.name}
				</a></td>
				<td>
					${testStudent.age}
				</td>
				<td>
					${testStudent.sex}
				</td>
				<td>
					${testStudent.remark}
				</td>
			</tr>
		</c:forEach>
		</tbody>--%>
	</table>
</body>
</html>