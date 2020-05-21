<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglib.jsp"%>
<div class="top">
	<div class="global-width">
		<img src="${pageContext.request.contextPath}/images/logo.gif" class="logo" />
	</div>
</div>

<div class="status">
	<div class="global-width">
		<span class="usertype">【登录角色：${sessionScope.EMP.sysPositionByPositionId.nameCn}】</span>${sessionScope.EMP.name}你好！欢迎访问青鸟办公管理系统！
	</div>
</div>
