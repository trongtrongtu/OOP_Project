<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 11/20/2019
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<!--Banner-->
<div class="banner">
    <div class="img_banner"><img src="img/logo.png" alt=""></div>
    <div class="text_banner"><h2>QUẢN LÝ BẢO HÀNH</h2></div>
</div>

<!--Menu-->
<div class="menu">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/donbh-list">TRANG CHỦ</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/list-product">SẢN PHẨM </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/list-customer">KHÁCH HÀNG</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/list-device">LINH KIỆN</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}">NHÂN VIÊN</a>
        </li>
        <li>
            <a href="#">THỐNG KÊ</a>
        </li>
    </ul>
</div>
</body>
</html>
