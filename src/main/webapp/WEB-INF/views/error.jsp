<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/14
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>错误页</title>
</head>
<body>
<div align="center">
    <p>o(╥﹏╥)o</p>
    <p>非常抱歉，出现了错误</p>
    <br>
    <p>错误原因：<c:out value="${errMsg}" /></p>
    <a href="/hospitalSystem/index" > 返回主页 </a>
</div>
</body>
</html>
