<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/25
  Time: 20:47
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
    <c:forEach items="${departmentList}" var = "department_name">
    <a href="/hospitalSystem/departments/${department_name}" >
            <c:out value="${department_name}" />
    </a>
        <p></p>
    </c:forEach>
</body>
</html>
