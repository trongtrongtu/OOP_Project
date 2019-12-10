<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/3/2019
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<%@include file="header.jsp" %>

<!--Search by imei -->
<div class="search">
    <div class="search_text">
        <p>Search by imei</p>
    </div>
    <div class="container">

        <form action="${pageContext.request.contextPath}/search-product">
            <input type="search" class="search_input" name="imei" placeholder="Search...">
            <input type="submit" class="submit" value="Search">
        </form>

    </div>
</div>

<!--Content-->
<style>
    table {
        border-collapse: collapse;
        border-spacing: 0;
        width: 100%;
        border: 1px solid #ddd;
    }

    th,td {
        text-align: center;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2
    }
</style>
<div style="overflow-x:auto;">
    <table>
        <tr>
            <th>IMEI</th>
            <th>TÊN SP</th>
            <th>LOẠI SP</th>
            <th>NSX</th>
            <th>THỜI GIAN BH</th>
            <th>MÃ KHÁCH HÀNG</th>
            <th>Thông tin Sp</th>

        </tr>
        <c:forEach var="product" items="products" >
            <tr>
                <td>${product.imei}</td>
                <td>${product.tenSP}</td>
                <td>${product.loaiSP}</td>
                <td>${product.nxs}</td>
                <td>${product.hanBaoHanh}</td>
                <td>${product.maKH}</td>
                <td>${product.thongTinSP}</td>
                <td><a href="${pageContext.request.contextPath}/view/form-editSP.html">Sửa</a></td>
                <td><a href="${pageContext.request.contextPath}/delete-product?imei=${product.imei}">Xóa</a></td>
            </tr>
        </c:forEach>

    </table>
    <div class="content_themSP" style="margin: auto;padding-left: 400px; ">
        <button style="margin: auto;">
            <a href="${pageContext.request.contextPath}/add-Product">Thêm Sản phẩm</a>
        </button>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
