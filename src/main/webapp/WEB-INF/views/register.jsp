<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/5
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/test.css"/> "/>
</head>
<body>
    <div align="center">
    <p>用户注册</p>
    <form name="input" action="/hospitalSystem/register/rstatus" method="GET">
        手机号码: <input type="text" name="userPhone" value="${userPhone}">
        <input type="submit" value="获取验证码">
    </form>
    <% if (request.getSession().getAttribute("userPhone") != null) {%>
        <br>
        <form name="input" action="/hospitalSystem/register/rstatus" method="POST">
            验证码（测试期间验证码为5个1）: <input type="text" name="num">
            <input type="submit" value="提交">
        </form>

    <%}%>
    <br>
        <a href="/hospitalSystem/index" >返回主页</a>
    </div>
</body>
</html>
