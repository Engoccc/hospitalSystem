<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/25
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %> <%-- 这一句必须加上--%>
<html>
<head>
    <title>选择科室</title>
</head>
<body>

<c:forEach items="${doctorList}" var = "doctor">
        姓名：<c:out value="${doctor.name}" />
        电话：<c:out value="${doctor.phone}" />
        科室：<c:out value="${doctor.office}" />
        等级：<c:out value="${doctor.ranks}" />
    <a href="/hospitalSystem/construction" > 预约挂号</a>
    <p></p>
</c:forEach>

</body>
</html>
