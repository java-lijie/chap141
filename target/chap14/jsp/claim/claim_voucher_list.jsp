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
   	function delVoucher(id){
   		if(!confirm('确定删除报单吗')) return;
   		
   		document.claimVoucherForm.action = "${pageContext.request.contextPath}/claimVoucher/claimVoucher_todel/"+id;
   		document.claimVoucherForm.submit();
   		
   	}
   	
</script>
<jsp:include page="/jsp/common/indexTop.jsp"></jsp:include>
<div class="main">
	<div class="global-width">
		<jsp:include page="/jsp/common/indexSidebar.jsp" />
		<div class="action  divaction">
			<div class="t">报销单列表</div>
			<div class="pages">
				<div class="forms">
					<form action="${pageContext.request.contextPath}/claimVoucher/claimVoucher_list" name="queryForm">
						<label>报销单状态</label>
						<select  name="status" >
							<option ${status eq ''?'selected':''} value="">全部</option>
							<option value="新创建" ${status eq '新创建'?'selected':''}>新创建</option>
							<option value="已提交" ${status eq '已提交'?'selected':''}>已提交</option>
							<option value="已审批" ${status eq '已审批'?'selected':''}>已审批</option>
							<option value="已付款" ${status eq '已付款'?'selected':''}>已付款</option>
							<option value="已打回" ${status eq '已打回'?'selected':''}>已打回</option>
							<option value="已终止" ${status eq '已终止'?'selected':''}>已终止</option>
						</select>



						<input type="hidden" name="pageNo" value="1"/>
						<input type="hidden" name="pageSize" value="5"/>
						<input type="submit" class="submit_01" value="查询"/>

					</form>
				</div>
				<!--增加报销单 区域 开始-->
				<form action="claimVoucher_searchClaimVoucher.action" name="claimVoucherForm">
					<table width="90%" border="0" cellspacing="0" cellpadding="0" class="list items">
						<tr class="even">
							<td>编号</td>
							<td>填报日期</td>
							<td>填报人</td>
							<td>总金额</td>
							<td>状态</td>
							<td>待处理人</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${claimVoucherList}" var="claimVoucher">

							<tr>
								<td><a href="${pageContext.request.contextPath}/claimVoucher/claimVoucher_getClaimVoucherById/${claimVoucher.id}">${claimVoucher.id}</a></td>
								<td>${claimVoucher.createTime}</td>
								<td>${claimVoucher.sysEmployeeByCreateSn.name}</td>
								<td>${claimVoucher.totalAccount}</td>
								<td>${claimVoucher.status}</td>
								<td>${claimVoucher.sysEmployeeByNextDealSn.name}</td>
								<td>

									<c:if test="${claimVoucher.status == '新创建' || claimVoucher.status == '已打回'}">
									<c:if test="${claimVoucher.sysEmployeeByCreateSn.name == sessionScope.EMP.name }">
										<a href="${pageContext.request.contextPath}/claimVoucher/claimVoucher_toUpdate/${claimVoucher.id}">
											<img src="${pageContext.request.contextPath}/images/edit.gif" width="16" height="16" />
										</a>
										<a onClick="delVoucher(${claimVoucher.id})" href="#">
											<img src="${pageContext.request.contextPath}/images/delete.gif" width="16" height="16" />
										</a>
									</c:if>
									</c:if>
									<img src="${pageContext.request.contextPath}/images/save.gif" width="16" height="16" />
									<a href="${pageContext.request.contextPath}/claimVoucher/claimVoucher_getClaimVoucherById/${claimVoucher.id}">
										<img src="${pageContext.request.contextPath}/images/search.gif" width="16" height="15" />
									</a>
									<c:if test="${claimVoucher.sysEmployeeByNextDealSn.name == sessionScope.EMP.name}">
										<c:if test="${claimVoucher.status eq '已提交' || claimVoucher.status eq '侍审批' || claimVoucher.status eq '已审批'}">
											<%--.id=${claimVoucher.id}--%>
                                            <a href="${pageContext.request.contextPath}/claimVoucher/claim_check/${claimVoucher.id}">
												<img src="${pageContext.request.contextPath}/images/sub.gif" width="16" height="16" />
											</a>
										</c:if>
									</c:if>
								</td>
							</tr>
							</c:forEach>
						<tr>
							<td colspan="6" align="center">
								<c:import url="rollPage.jsp" charEncoding="UTF-8">
									<c:param name="formName" value="document.forms[0]"/>
									<c:param name="totalRecordCount" value="${pageSupport.totalRecordCount}"/>
									<c:param name="totalPageCount" value="${pageSupport.totalPageCount}"/>
									<c:param name="currentPageNo" value="${pageSupport.currentPageNo}"/>

								</c:import>
							</td>
						</tr>
					</table>
				</form>
				<!--增加报销单 区域 结束-->
			</div>
		</div>
	</div>
</div>

<jsp:include page="/jsp/common/indexBottom.jsp"></jsp:include>
