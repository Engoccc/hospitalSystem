<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/11/2
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<c:forEach items="${officeList}" var = "office">
    科室：<c:out value="${office.department_name}" />
    诊室：
    <a href="/hospitalSystem/offices/${office.office_name}" >
        <c:out value="${office.office_name}" />
    </a>
    <br>
</c:forEach>
</body>
</html>
