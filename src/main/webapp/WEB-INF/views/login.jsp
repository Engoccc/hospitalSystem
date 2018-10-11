<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/12
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/test.css"/> "/>
</head>
<body>
<div align="center">
    <p>用户登录</p>
    <form name="input" action="/hospitalSystem/checkInfo" method="POST">
        手机号: <input type="text" name="phone">
        密码: <input type="text" name="password">
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
