<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>北大青鸟办公自动化管理系统</title>
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript">
			$(function(){				
			//表单提交校验
		
			//$("#myTable tr").eq(0).hide();	
			$("#sumb").submit(function(){
				alert("adsasdasdasd")

				//判断是否加入了问题 
				if($("#rowNumber").val()<1){
					//$.messager.defaults={ok:"确定"};$.messager.alert("提示信息",$("#rowNumber").val());
					$("#notice").text("* 添加报销单的明细，至少一条 ！");
					return false;
				}

				$("#notice").text("*");
				$(".buttons").hide();
				return true;
			});	
			$("#AddRow").click(function(){
				var tr=$("#myTable tr").eq(0).clone();
				++i;
				var j=i-1;
				var des=$("#des").val();
				var item = $("#item").val();
				var account = $("#account").val();
				if(account.length==0||des.length==0){
					alert("金额或说明不可为空")
				}else {
					totalAccount=parseFloat(totalAccount)+parseFloat(account);
					alert(account+""+totalAccount);


					tr.find("td").get(0).innerHTML=j+"<input type=hidden name=bizClaimVoucherDetailsById["+j+"].bizClaimVoucherByMainId.id value='${claimVoucher.id}'/><input  name=bizClaimVoucherDetailsById["+j+"].item id=item"+j+" type=hidden value="+item+" />"+item;
					tr.find("td").get(1).innerHTML="<input  name=bizClaimVoucherDetailsById["+j+"].account id=account"+j+"  type=hidden value="+account+" />"+account;
					tr.find("td").get(2).innerHTML="<input  name=bizClaimVoucherDetailsById["+j+"].des  id=des"+j+" type=hidden value="+des+" />"+des;
					tr.find("td").get(3).innerHTML="<img src=${pageContext.request.contextPath}/images/delete.gif width=16 height=16 id=DelRow"+j+" onclick=delRow("+j+") />";
					tr.show();
					tr.appendTo("#myTable");
					//传递一共添加多少问题
					rowNumber=i;
					$("#account").attr("value","");
					$("#des").attr("value","");
					$("#totalAccount").attr("value",totalAccount);

				}
			});	
			
		});
		var i=parseInt(${fn:length(claimVoucher.bizClaimVoucherDetailsById)});
		var rowNumber=parseInt(${fn:length(claimVoucher.bizClaimVoucherDetailsById)});
		var totalAccount =${claimVoucher.totalAccount}

		function delRow(id){
			var delid=$("#bizClaimVoucherDetailsById"+id).val();
			alert("id="+id+""+delid);
			$.ajax({
				type:"get",
				url:"/sshoffices_war_exploded/claimVoucher/claimVoucher_del?id="+delid,
				dataType:"json",
				success:function (data) {
					alert("成功")
				}
			})
			var sst=$("input[name^='bizClaimVoucherDetailsById']");


			var account = $("#account"+id).val();
			$("#myTable tr").eq(id+1).remove();
			var rowNumber=$("#rowNumber").val();
			for(var s=id+1;s<rowNumber;s++){
				alert(s);
				$("#bizClaimVoucherByMainId"+s).attr("name","bizClaimVoucherDetailsById["+(s-1)+"].bizClaimVoucherByMainId.id");
				$("#bizClaimVoucherByMainId"+s).attr("id","bizClaimVoucherByMainId"+(s-1));
				$("#bizClaimVoucherDetailsById"+s).attr("name","bizClaimVoucherDetailsById["+(s-1)+"].id");
				$("#bizClaimVoucherDetailsById"+s).attr("id","bizClaimVoucherDetailsById"+(s-1));
				$("#item"+s).attr("name","bizClaimVoucherDetailsById["+(s-1)+"].item");
				$("#item"+s).attr("id","item"+(s-1));
				$("#item"+s).attr("name","bizClaimVoucherDetailsById["+(s-1)+"].item");
				$("#item"+s).attr("id","item"+(s-1));
				$("#account"+s).attr("name","bizClaimVoucherDetailsById["+(s-1)+"].account");
				$("#account"+s).attr("id","account"+(s-1));
				$("#des"+s).attr("name","bizClaimVoucherDetailsById["+(s-1)+"].des");
				$("#des"+s).attr("id","des"+(s-1));
				var js="delRow("+(s-1)+");";
				var newclick=eval("(false||function (){"+js+"});");
				$("#DelRow"+s).unbind('click').removeAttr('onclick').click(newclick);
				$("#DelRow"+s).attr("id","DelRow"+(s-1));					
				}
			$("#rowNumber").attr("value",rowNumber-1);
			--i;
			totalAccount=parseFloat(totalAccount)-parseFloat(account);
			$("#totalAccount").attr("value",totalAccount);


		}
		function submitClaimVoucher(action){
			var str=$("#event").val();
			if(str.length<1){
				alert("事由不可为空")

			}else {
				if (!confirm("确定" + action + "报销单吗")) return;
				if (action == '保存') {
					//document.claimForm.status.value = "新创建";
				} else {
					document.claimForm.status.value = "已提交";
				}

				document.claimForm.submit();
			}
		 }
		</script>
		
		</head>
	<body>
	<jsp:include page="/jsp/common/indexTop.jsp"></jsp:include>
	<div class="main">
		<div class="global-width">

			<jsp:include page="/jsp/common/indexSidebar.jsp" />
			<div class="action  divaction">
				<div class="t">报销单更新</div>
				<div class="pages">
					<form method="post" id="sumb" action="${pageContext.request.contextPath}/claimVoucher/claimVoucher_Update" name="claimForm">

						<input type="hidden" id="rowNumber" name="rowNumber" value="${fn:length(claimVoucher.bizClaimVoucherDetailsById)}"/>
						<input type="hidden" id="claimId" name="id" value="${claimVoucher.id}"/>
						<table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
							<caption>基本信息</caption>
							<tr>
								<td >编&nbsp;&nbsp;号：${claimVoucher.id}</td>
								<td>填&nbsp;写&nbsp;人：${claimVoucher.sysEmployeeByCreateSn.name}</td>
								<td>部&nbsp;&nbsp;门：${claimVoucher.sysEmployeeByCreateSn.sysDepartmentByDepartmentId.name}</td>
								<td>职&nbsp;&nbsp;&nbsp;&nbsp;位：${claimVoucher.sysEmployeeByCreateSn.sysPositionByPositionId.nameCn}</td>

							</tr>
							<tr>
								<td>总金额：<input  id="totalAccount"readonly="readonly"  name="totalAccount" type="text" value="${claimVoucher.totalAccount}"/>

								<td>填报时间：${claimVoucher.createTime}</td>
								<td>状态：${claimVoucher.status}</td>
								<td>待处理人：${claimVoucher.sysEmployeeByNextDealSn.name}</td>
								<input type="hidden" name="status" value="${claimVoucher.status}"/>
							</tr>
							<tr>
								<td colspan="4"><p>-------------------------------------------------------------------------------</p></td>
							</tr>
						</table>
						<table id="myTable" width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
							<tr>
								<td width="30%">项目类别</td>
								<td width="30%">项目金额</td>
								<td width="30%">费用说明</td>
								<td width="10%">操作</td>
							</tr>
							<c:forEach items="${claimVoucher.bizClaimVoucherDetailsById}" varStatus="s" begin="0" end="${fn:length(claimVoucher.bizClaimVoucherDetailsById)}" var="claimDetail">

								<tr>
									<td>
										<input type="hidden" id="bizClaimVoucherByMainId${s.index}" name="bizClaimVoucherDetailsById[${s.index}].bizClaimVoucherByMainId.id" value='${claimVoucher.id}'/>
										<input type="hidden" id="bizClaimVoucherDetailsById${s.index}" name="bizClaimVoucherDetailsById[${s.index}].id" value="${claimDetail.id}"/>
										<input type="hidden" id="item${s.index}" name="bizClaimVoucherDetailsById[${s.index}].item" value="${claimDetail.item}"/>
											${s.index}${claimDetail.item}
										<%--<s:hidden id="id%{#s.index}" name="detailList[%{#s.index}].id" value="%{#claimDetail.id}"/>
										<s:hidden id="item%{#s.index}" name="detailList[%{#s.index}].item" value="%{#claimDetail.item}"/>
										<s:property value="#claimDetail.item"/>--%></td>
									<td>
										<input type="hidden" name="bizClaimVoucherDetailsById[${s.index}].account"id="account${s.index}" value="${claimDetail.account}"/>
											${claimDetail.account}
										<%--<s:hidden id="account%{#s.index}" name="detailList[%{#s.index}].account" value="%{#claimDetail.account}"/>
										<s:property value="#claimDetail.account"/>--%></td>
									<td>
										<input type="hidden" id="des${s.index}" name="bizClaimVoucherDetailsById[${s.index}].des" value="${claimDetail.des}"/>
										${claimDetail.des}
										<%--<s:hidden id="desc%{#s.index}" name="detailList[%{#s.index}].desc" value="%{#claimDetail.desc}"/>
										<s:property value="#claimDetail.desc"/>--%>
									</td>
									<td>
										<img src=${pageContext.request.contextPath}/images/delete.gif width=16 height=16 id=DelRow${s.index}
                                             onclick=delRow(${s.index}) />
									</td>
								</tr>
							</c:forEach>
						</table>
						<table id="detailTable" width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
							<tr>
								<td width="30%">
									<select name="claimVoucherDetail.item" id="item">
										<option value="城际交通费">城际交通费</option>
										<option value="市内交通费">市内交通费</option>
										<option value="通讯费">通讯费</option>
										<option value="礼品费">礼品费</option>
										<option value="办公费">办公费</option>
										<option value="交际餐费">交际餐费</option>
										<option value="餐补">餐补</option>
										<option value="住宿费">住宿费</option>
									</select>
								</td>
								<td width="30%"><input type="text"id="account" /><span class=notice>*</span></td>
								<td width="30%"><input type="text" id="des" /><span class=notice>*</span></td>
								<td width="10%"><img src="${pageContext.request.contextPath}/images/add.gif" width="16" height="16" id="AddRow"/></td>
							</tr>
						</table>
						<table>
							<tr>
								<td>*事由：</td>
								<td colspan="3">
									<textarea name="event" id="event" rows="5" cols="66">${claimVoucher.event}</textarea>
								</td>
							</tr>
							<tr align="center" colspan="4">
								<td>
									&nbsp;
								</td>
								<td >
									<input type="button" id="1" name="1" value="保存" onclick="submitClaimVoucher('保存')" class="submit_01"/>
									<input type="button" id="2" name="2" value="提交" class="submit_01"
										   onclick="submitClaimVoucher('提交')"/>
									<input type="button" value="返回" onclick="window.history.go(-1)" class="submit_01"/>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/jsp/common/indexBottom.jsp"></jsp:include>

	</body>
</html>
