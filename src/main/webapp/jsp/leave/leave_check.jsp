<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>北大青鸟办公自动化管理系统</title>
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function checkLeave(status){
		   		if(!confirm('确定'+status+'请假吗')) return;
		   		document.leaveForm.status.value = status;
		   		document.leaveForm.submit();
		   		
		   	}
		</script>
	</head>
	<body>
    <jsp:include page="/jsp/common/indexTop.jsp"></jsp:include>
    <div class="main">
        <div class="global-width">
            <jsp:include page="/jsp/common/indexSidebar.jsp" />
            <div class="action  divaction">
                <div class="t">
                    审批请假
                </div>
                <div class="pages">
                    <!--增加报销单 区域 开始-->
                    <table width="90%" border="0" cellspacing="0" cellpadding="0"
                           class="addform-base">
                        <caption>
                            基本信息
                        </caption>
                        <tr>
                            <td width="36%">
                                姓名：${leave.sysEmployeeByEmployeeSn.name}
                            </td>
                            <td width="64%">
                                部门：${leave.sysEmployeeByEmployeeSn.sysDepartmentByDepartmentId.name}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                开始时间：${leave.starttime}
                            </td>
                            <td>
                                结束时间：${leave.endtime}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                请假天数：${leave.leaveday}
                            </td>
                            <td>
                                休假类型：${leave.leavetype}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                请假事由：${leave.reason}
                            </td>
                            <td>
                                &nbsp;
                            </td>
                        </tr>
                    </table>
                    <p>
                        -------------------------------------------------------------------------------
                    </p>
                    <form action="${pageContext.request.contextPath}/leave/leave_update" name="leaveForm">
                        <table width="90%" border="0" cellspacing="0" cellpadding="0"
                               class="addform-base">
                            <tr>
                                <td>
                                    审批意见：
                                </td>
                            </tr>
                            <tr>
                                <td>
							<textarea name="approveOpinion" id="textarea" cols="45"
                                      rows="5"></textarea>
                                </td>
                            </tr>
                            <!--表单提交行-->
                            <tr>
                                <td colspan="4" class="submit">
                                    <input type="button" name="button"  value="审批通过"
                                           class="submit_01" onclick="checkLeave('已审批 ')" />
                                    <input type="hidden" id="leaveId" name="id" value="${leave.id}"/>
                                    <input type="hidden" id="status" name="status" value=""/>
                                    <input type="button" name="button" id="button" value="打回"
                                           class="submit_01" onclick="checkLeave('已打回 ')" />
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

	</body>
</html>