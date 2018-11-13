<%@ page import="web.example.users.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Piong
  Date: 2018/11/1
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <%-- 这一句必须加上--%>
<html>
<head>
    <title>您的挂号单</title>
</head>
<body>
<%
    List<Order> ol = (List<Order>)request.getAttribute("orderList");
    if(ol != null){ //这里必须用null，不能用isEmpty,在此ol为空。
        for(Order o : ol){
        %>
        姓名：<%=o.getUser_name() %>
        电话：<%=o.getUser_phone() %>
        挂号医生：<%=o.getDoctor_name() %>
        挂号科室：<%=o.getOffice_name() %>
    <%
        Date currentTime = o.getUser_order_time();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
    %>
        挂号时间：<%=dateString %>
        挂号费用：<%=o.getUser_order_price() %>
    <%
        String pay_state;
        if(o.getPay_state() == 0)
            pay_state = "未支付";
        else
            pay_state = "已支付";
    %>
        支付状态：<%=pay_state %>
        <br>
        <% }%>
    <% }else{%>
        <script>
            window.alert("没有订单!");
        </script>
    <%}%>
    <br>
    <a href="/hospitalSystem/index"> 返回主页 </a>
</body>
</html>
