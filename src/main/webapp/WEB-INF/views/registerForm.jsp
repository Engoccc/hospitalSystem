<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/8
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registerForm</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/test.css"/> "/>
</head>
<body>
    <div align="center">
        <p>填写基本信息</p>
        <form name="input" action="/hospitalSystem/register/rstatus/submitUser" method="POST">
            姓名：<input type="text" name="name">
            性别：<input type="text" name="sex">
            设置密码：<input type="text" name="password">
            身份证号：<input type="text" name="uid">
            医保卡号：<input type="text" name="card">
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>
