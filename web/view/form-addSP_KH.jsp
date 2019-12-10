<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/8/2019
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/form.css">
</head>
<body>
<!--header -->
<%@include file="header.jsp"%>


<!--Form thêm sản phẩm-->
<div class="container">
    <h2 style="color: red; margin-left: 200px;">${mesErr}</h2>
    <form action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data" >
        <h3>Nhập thông tin khách hàng</h3>
        <div class="row">
            <div class="col-25">
                <label for="TENKH">Tên khách hàng :</label>
            </div>
            <div class="col-75">
                <input type="text" id="TENKH" name="TENKH" placeholder="Tên khách hàng..">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="DIENTHOAI">Số điện thoại :</label>
            </div>
            <div class="col-75">
                <input type="text" id="DIENTHOAI" name="DIENTHOAI" placeholder="Số điện thoại..">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="EMAIL">Email :</label>
            </div>
            <div class="col-75">
                <input type="text" id="EMAIL" name="EMAIL" placeholder="Email..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="DIACHI">Địa chỉ :</label>
            </div>
            <div class="col-75">
                <input type="text" id="DIACHI" name="DIACHI" placeholder="Địa chỉ..">
            </div>
        </div>

        <h3>Nhập thông tin sản phẩm</h3>

        <div class="row">
            <div class="col-25">
                <label for="IMEI">IMEI :</label>
            </div>
            <div class="col-75">
                <input type="text" id="IMEI" name="IMEI" placeholder="IMEI..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="TENSP">Tên Sản Phẩm :</label>
            </div>
            <div class="col-75">
                <input type="text" id="TENSP" name="TENSP" placeholder="Tên Sản Phẩm..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="NSX">Nhà Sản Xuất :</label>
            </div>
            <div class="col-75">
                <input type="text" id="NSX" name="NSX" placeholder="Nhà Sản Xuất..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="LOAISP">Loại SP :</label>
            </div>
            <div class="col-75">
                <input type="text" id="LOAISP" name="LOAISP" placeholder="Loại SP..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="THOIGIANBAOHANH">Thời gian bảo hành:</label>
            </div>
            <div class="col-75">
                <input type="text" id="THOIGIANBAOHANH" name="THOIGIANBAOHANH" placeholder="Thời gian bảo hành..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="HINHANHSP">Chọn Ảnh SP :</label>
            </div>
            <div class="col-75">
                <input type="file" id="HINHANHSP" name="HINHANHSP" placeholder="Chọn Ảnh SP..">
            </div>
        </div>
        <div class="col-25">
            <label for="THONGTINSP">Thông Tin SP</label>
        </div>
        <div class="col-75">
                <textarea id="subject" id="THONGTINSP" name="THONGTINSP" placeholder="Thông Tin SP.."
                          style="height:200px"></textarea>
        </div>

        <div class="row">
            <input type="submit" value="Submit">
        </div>


    </form>
</div>

<!--footer -->
<%@include file="footer.jsp"%>
</body>
</html>
