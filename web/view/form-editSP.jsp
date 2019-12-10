<%@ page import="model.Product" %>
<%@ page import="services.ProductService" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/7/2019
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<%@include file="header.jsp"%>

<!--Form Chỉnh Sửa Khác Hàng Và Sản Phẩm-->
<div class="container">
    <h2 style="color: red; margin-left: 200px;">${mesErr}</h2>
    <form action="${pageContext.request.contextPath}/add-Product">
        <h3>Chỉnh Sửa thông tin sản phẩm</h3>
    <%
            ProductService productService = new ProductService();
            String imei = request.getParameter("imei");
            try {
                Product product = productService.searchByImei(imei);
    %>

        <div class="row">
            <div class="col-25">
                <label for="IMEI">IMEI :</label>
            </div>
            <div class="col-75">
                <input type="text" id="IMEI" name="IMEI" value="<%=product.getImei()%>" placeholder="IMEI.." readonly >
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="TENSP">Tên Sản Phẩm :</label>
            </div>
            <div class="col-75">
                <input type="text" id="TENSP" name="TENSP" value="<%=product.getTenSP()%>" placeholder="Tên Sản Phẩm..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="NSX">Nhà Sản Xuất :</label>
            </div>
            <div class="col-75">
                <input type="text" id="NSX" name="NSX" value="<%=product.getNxs()%>" placeholder="Nhà Sản Xuất..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="LOAISP">Loại SP :</label>
            </div>
            <div class="col-75">
                <input type="text" id="LOAISP" name="LOAISP" value="<%=product.getLoaiSP()%>" placeholder="Loại SP..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="THOIGIANBAOHANH">Thời gian bảo hành:</label>
            </div>
            <div class="col-75">
                <input type="text" id="THOIGIANBAOHANH" name="THOIGIANBAOHANH" value="<%=product.getHanBaoHanh()%>" placeholder="Thời gian bảo hành..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="HINHANHSP">Chọn Ảnh SP :</label>
            </div>
            <div class="col-75">
                <input type="file" id="HINHANHSP" name="HINHANHSP" value="" placeholder="Chọn Ảnh SP..">
            </div>
        </div>
        <div class="col-25">
            <label for="THONGTINSP">Thông Tin SP</label>
        </div>
        <div class="col-75">
                <textarea id="THONGTINSP" id="THONGTINSP" name="THONGTINSP" value="<%=product.getThongTinSP()%>" placeholder="Thông Tin SP.."
                          style="height:200px"></textarea>
        </div>

        <div class="row">
            <input type="submit" value="Update">
        </div>

        <%
        } catch (SQLException e) {
        e.printStackTrace();
        }

        %>
    </form>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
