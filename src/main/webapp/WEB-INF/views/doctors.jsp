<%@ page import="web.example.users.Doctor" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/10/25
  Time: 20:32
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
<%
    List<Doctor> dl= (List<Doctor>)request.getAttribute("doctorList");
    if(dl!=null){%>

<c:forEach items="${doctorList}" var = "doctor">
        姓名：<c:out value="${doctor.name}" />
        电话：<c:out value="${doctor.phone}" />
        科室：<c:out value="${doctor.office}" />
        等级：<c:out value="${doctor.ranks}" />
        挂号费用：<c:out value="${doctor.doctor_price}" />
    <a href="/hospitalSystem/mkOrder" onclick="myFunction()">  预约挂号 </a>
    <script>
        function myFunction() {
            <c:set var = "did" scope="session" value = "${doctor.did}"  />

            <c:set var = "price" scope="session" value = "${doctor.doctor_price}"  />
        }
    </script>
    <br>
</c:forEach>
    <% }else { %>
        <script>
            window.alert("该诊室暂时没有医生!");
        </script>
    <%}%>
    <a href="/hospitalSystem/index"> 返回主页 </a>
</body>
</html>
