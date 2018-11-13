<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
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
            手机号：<input type="text" name="phone" value=${phone} readonly ><br>
            姓名(20字符内）：<input type="text" name="name"><br>
            性别：
            <input type="radio" name="sex" value="男">男
            <input type="radio" name="sex" value="女">女<br>
            设置密码(20字符内)：<input type="text" name="password"><br>
            身份证号(18位)：<input type="text" name="uid"><br>
            医保卡号(9位)：<input type="text" name="card"><br>
            <input type="submit" value="提交">
        </form>
        <br>
        <a href="/hospitalSystem/index" >返回主页</a>
    </div>
</body>
</html>
