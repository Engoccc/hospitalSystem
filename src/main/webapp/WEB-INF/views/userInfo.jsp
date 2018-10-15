<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %> <%-- 这一句必须加上--%>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/12
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserInfo</title>
</head>
<body>
<div align="center">
    <p>手机号：${user.phone}</p>
    <p> 姓名：${user.name}</p>
    <p>性别：${user.sex}</p>
    <p>身份证号码：${user.sex}</p>
    <p><a href="/hospitalSystem/logout" >点此清除我的登录信息</a></p>
    <p><a href="/hospitalSystem/index" >点此返回主页</a></p>
</div>
</body>
</html>
