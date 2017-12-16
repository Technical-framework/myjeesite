<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>记账管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#value").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/bookkeeping/list">列表</a></li>
		<li class="active"><a href="${ctx}/bookkeeping/form?id=${bills.id}">${not empty bills.id?'修改':'添加'}</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="bills" action="${ctx}/bookkeeping/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">金额来源:</label>
			<div class="controls">
				<form:radiobuttons path="direction" items="${fns:getDictList('direction')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">金额:</label>
			<div class="controls">
				<form:input path="money" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类型ID:</label>
			<div class="controls">
				<form:input path="category_id_1" htmlEscape="false" maxlength="11" class="required number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">子类型ID:</label>
			<div class="controls">
				<form:input path="category_id_2" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:input path="remark" htmlEscape="false" maxlength="500" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建时间:</label>
			<div class="controls">
				<form:input path="gmt_create" htmlEscape="false" maxlength="20" class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建人:</label>
			<div class="controls">
				<form:input path="create_user" htmlEscape="false" maxlength="10" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">修改时间:</label>
			<div class="controls">
				<form:input path="gmt_modify" htmlEscape="false" maxlength="20" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">修改人:</label>
			<div class="controls">
				<form:input path="modify_user" htmlEscape="false" maxlength="10" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>