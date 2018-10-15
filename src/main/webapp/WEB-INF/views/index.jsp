<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %> <%-- 这一句必须加上--%>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/2
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/test.css"/> "/>
</head>
<body>
    <div align="center">
    <p>欢迎使用医院挂号系统！</p>

        <%  if(request.getSession().getAttribute("user") == null) { %>

        <a href="/hospitalSystem/register" > 用户注册 </a>
        <p></p>
        <a href="/hospitalSystem/login" > 用户登录 </a>
        <p>powered by piong</p>

        <%} else{ %>
        欢迎您，${user.phone}
        <a href="/hospitalSystem/userInfo" > 查看我的信息 </a>
        <p> </p>
        <a href="/hospitalSystem/logout" > 退出登录 </a>
        <p>powered by piong</p>

        <% } %>
    </div>

</body>
</html>0
