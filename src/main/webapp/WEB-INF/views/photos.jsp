<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/16
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>私密照片</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/test.css"/> "/>
</head>
<body>
<p>帅照</p>
<%--
<img  src="<c:url value="image/lcl.png"/>" alt="handsome boy" width="304" height="228">
--%>
<img  src="/hospitalSystem/image/lcl.png" alt="handsome boy" width="304" height="228">

<%--
测试时该jsp url：http://localhost:8080/hospitalSystem/p/photos
正确访问的url，根据addResourceHandlers中的配置，应为: http://localhost:8080/hospitalSystem/image/photos
src=String s，s不以/开头的话，url会自动加上当前页面路径(src="image/lcl.png"  http://localhost:8080/hospitalSystem/p/image/lcl.png)；
                s以/开头的话，s就是实际的url(src="/image/lcl.png"  http://localhost:8080/image/lcl.png)
<c:url value=String s/>
s以/开头，自动加项目名 (value="/image/lcl.png" http://localhost:8080/hospitalSystem/image/lcl.png)
s不以/开头，加本页面url (value="image/lcl.png"  http://localhost:8080/hospitalSystem/p/image/lcl.png)

这里路径问题卡了很久，参考https://blog.csdn.net/baidu_37107022/article/details/72683359
链接加上"/projectname/" 当前页面url:http://localhost:8080/hospitalSystem/photos ；实际引用图片url: http://localhost:8080/hospitalSystem/image/lcl.png

当前页面的URL的最后带占位符
例如：当前页面URL为localhost:8080/Project/wecome/1，通过这个链接调转到当前页面，当你在当前页面中有个<a href=”admin/edit”></a>那么这个页面向后台请求的链接就为localhost:8080/Project/welcome/admin/edit。这和我们想要的链接可能不太一样。
当前页面的URL的以/结尾
当前页面URL为localhost:8080/Project/wecome/，通过这个链接调转到当前页面，当你在当前页面中有个<a href=”admin/edit”></a>那么这个页面向后台请求的链接就为localhost:8080/Project/welcome/admin/edit。
自己在项目中遇到url不对，这个问题只要把<a href=”admin/edit”></a>写成<a href=”/Project/admin/edit”></a>，得到的url就是localhost:8080/Project/admin/edit
原文：https://blog.csdn.net/include_cpp/article/details/82468072?utm_source=copy
--%>
</body>
</html>
