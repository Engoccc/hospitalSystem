<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/25
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <%-- 这一句必须加上--%>
<html>
<head>
    <title>选择科室</title>
</head>
<body>
<c:forEach items="${officeList}" var = "office_name">
    <a href="/hospitalSystem/offices/${office_name}" >
        <c:out value="${office_name}" />
    </a>
    <br>
</c:forEach>
</body>
</html>
