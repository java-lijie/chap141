<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%@ include file="../common/taglib.jsp"%>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function confirm(){
		if(isNaN(document.queryForm.startYear.value)){
			alert("输入的开始年份不合法！");
			return false;
		}
		if(isNaN(document.queryForm.endYear.value)){
			alert("输入的结束年份不合法！");
			return false;
		}
		return true;
	}
	
	function submitSearch(){
		if(confirm()){
			document.queryForm.submit();
		}
	}
</script>
<div class="action  divaction">
	<div class="t">年度统计列表</div>
	<div class="pages">
	     <s:form action="compYearStatistics_getList.action" name="queryForm">
	       		<%--@declare id="time"--%><label for="time">开始年份</label>
	       		<s:textfield name="startYear" id="startYear" cssClass="nwinput" value=""></s:textfield>
				 <%--@declare id="end-time"--%><label for="end-time">结束年份</label>
	       		<s:textfield name="endYear" id="endYear" cssClass="nwinput" value=""></s:textfield>
		        <%-- <s:submit cssClass="submit_01" value="查询"/> --%>
		        <input type="button" value="提交" class="submit_01"
								onclick="submitSearch()"/>
	     </s:form>
	    
		<table width="90%" border="0" cellspacing="0" cellpadding="0" class="list items">
	      <tr class="even">
	        <td>编号</td>
	        <td>总计</td>
	        <td>年份</td>
	       <!--  <td>月份</td> -->
	        <!-- <td>部门</td> -->
	        <td>操作</td>
	      </tr>
	      <s:iterator value="compYearList" id="claimVoucherStatistics" begin="0" status="s">
	      <tr>
	        <td><s:property value="#claimVoucherStatistics.id"/></td>
	        <td>￥<s:property value="#claimVoucherStatistics.totalCount"/></td>
	        <td><s:property value="#claimVoucherStatistics.year"/>年</td>
	        <td>
	        <a href="compYearStatistics_getDetail.action?currYear=<s:property value="#claimVoucherStatistics.year"/>">
	        <img src="${images}/search.gif" width="16" height="15" />
	        </a>
	        </td>
	      </tr>
	      </s:iterator>
	    </table>        
       </div>
      </div>