<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/5
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/test.css"/> "/>
</head>
<body>
    <div align="center">
        <p>用户注册</p>
        <form name="input" action="/hospitalSystem/register/rstatus" method="POST">
            验证码: <input type="text" name="num">
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>
