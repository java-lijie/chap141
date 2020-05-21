<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/10
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />

  </head>
  <body>

  <jsp:include page="/jsp/common/indexTop.jsp"></jsp:include>
  <div class="main">
    <div class="global-width">
      <jsp:include page="/jsp/common/indexSidebar.jsp" />
      <jsp:include page="/jsp/common/indexRightbar.jsp" />
    </div>
  </div>

  <jsp:include page="/jsp/common/indexBottom.jsp"></jsp:include>
  </body>
</html>
