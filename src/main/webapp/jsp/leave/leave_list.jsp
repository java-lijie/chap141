<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function(){
			 //日期选择控件
		 	$("#startDate").click(function(){
				WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}',isShowClear:true, readOnly:true });
			});
			$("#endDate").click(function(){
				WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}',isShowClear:true, readOnly:true });
			});
		});
</script>
<jsp:include page="/jsp/common/indexTop.jsp"></jsp:include>
<div class="main">
	<div class="global-width">
		<jsp:include page="/jsp/common/indexSidebar.jsp" />
		<div class="action  divaction">
			<div class="t">请假列表</div>
			<div class="pages">
				<div class="forms">
					<form action="${pageContext.request.contextPath}/leave/leave_list" name="queryForm">
						<label for="time">开始时间</label>
						<input name="startDate"value="${startDate}" id="startDate" class="nwinput">

						<label for="end-time">结束时间</label>

						<input name="endDate"value="${endDate}" id="endDate" class="nwinput">
						<input type="hidden" name="pageNo" value="1"/>
						<input type="hidden" name="pageSize" value="5"/>
						<input class="submit_01" type="submit" value="查询">
						<%--<submit cssClass="submit_01" value="查询"/>--%>
					</form>
				</div>
				<!--增加报销单 区域 开始-->
				<table width="90%" border="0" cellspacing="0" cellpadding="0" class="list items">
					<tr class="even">
						<td>编号</td>
						<td>名称</td>
						<td>发起时间</td>
						<td>审批时间</td>
						<td>审批意见</td>
						<td>审批状态</td>
						<td>操作</td>
					</tr>
					<c:forEach var="leave" items="${requestScope.leaveList}" >
						<tr>
							<td><a href="${pageContext.request.contextPath}/leave/leave_view/${leave.id}">${leave.id}</a></td>
								<td>${leave.sysEmployeeByEmployeeSn.name}请假${leave.leaveday}天</td>
                                 <td>${leave.createtime}</td>
                                 <td>${leave.modifytime}</td>
                                 <td>${leave.approveOpinion}</td>
                                 <td>${leave.status}</td>
                                 <td>


                                     <a href="${pageContext.request.contextPath}/leave/leave_view/${leave.id}">
                                      <img src="${pageContext.request.contextPath}/images/search.gif" width="16" height="15" />
                                     </a>

									 <c:if test="${sessionScope.EMP.sysPositionByPositionId.nameCn eq  '部门经理'||sessionScope.EMP.sysPositionByPositionId.nameCn eq  '总经理'}">
                                     <c:if test="${leave.status eq'待审批'}">
                                             <a href="${pageContext.request.contextPath}/leave/leave_check/${leave.id}">
                                             <img src="${pageContext.request.contextPath}/images/sub.gif" width="16" height="16" /></a>
                                         </c:if>
                                     </c:if>
                                 </td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="7" align="center">
							<c:import url="../common/rollPage.jsp" charEncoding="UTF-8">
								<c:param name="formName" value="document.forms[0]"/>
								<c:param name="totalRecordCount" value="${pageSupport.totalRecordCount}"/>
								<c:param name="totalPageCount" value="${pageSupport.totalPageCount}"/>
								<c:param name="currentPageNo" value="${pageSupport.currentPageNo}"/>
							</c:import>
						</td>
					</tr>
				</table>
				<!--请假 区域 结束-->
			</div>
		</div>
	</div>
</div>
<jsp:include page="/jsp/common/indexBottom.jsp"></jsp:include>
