<%-- 
    Document   : form-editNV
    Created on : Dec 9, 2019, 12:42:55 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Form Chỉnh Sửa Nhân Viên</title>
    <link rel="stylesheet" href="view/css/style.css">
    <link rel="stylesheet" href="view/css/form.css">
</head>

<body>
    <!--Banner-->
    <div class=" banner">
        <div class="img_banner"><img src="img/logo.png" alt=""></div>
        <div class="text_banner">
            <h2>QUẢN LÝ BẢO HÀNH</h2>
        </div>
    </div>
    <!--Menu-->
    <div class="menu">
        <ul>
            <li>
                <a href="index.html">TRANG CHỦ</a>
            </li>
            <li>
                <a href="san-pham.html">SẢN PHẨM </a>
            </li>
            <li>
                <a href="khach-hang.html">KHÁCH HÀNG</a>
            </li>
            <li>
                <a href="list-device">LINH KIỆN</a>
            </li>
            <li>
                <a href="list-employees">NHÂN VIÊN</a>
            </li>
            <li>
                <a href="thong-ke.html">THỐNG KÊ</a>
            </li>
        </ul>
    </div>
    <!--Form Chỉnh Sửa Nhân Viên-->
    <div class="container">
        <h2 style="color: red; margin-left: 200px;">${mesErr}</h2>
        <form action="edit-employees" method="post">
            <input name="MANV" value="${MANV}" hidden="">
            <h3>Chỉnh Sửa Thông Tin Nhân Viên có Mã là ${MANV}</h3>
            <div class="row">
                <div class="col-25">
                    <label for="TENNV">Tên nhân viên :</label>
                </div>
                <div class="col-75">
                    <input type="text" id="TENNV" name="TENNV" value="" placeholder="Tên nhân viên..">
                </div>
            </div>

            <div class="row">
                <div class="col-25">
                    <label for="SDT">Số điện thoại :</label>
                </div>
                <div class="col-75">
                    <input type="text" id="SDT" name="SDT" value="" placeholder="Số điện thoại..">
                </div>
            </div>

            <div class="row">
                <div class="col-25">
                    <label for="EMAIL">Email :</label>
                </div>
                <div class="col-75">
                    <input type="text" id="EMAIL" name="EMAIL" value="" placeholder="Email..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="DCNV">Địa chỉ :</label>
                </div>
                <div class="col-75">
                    <input type="text" id="DCNV" name="DCNV" value="" placeholder="Địa chỉ..">
                </div>
            </div>

            <div class="row">
                <input type="submit" value="Update">
            </div>
        </form>


    </div>

    <!--Footder-->
    <div class="footer">
        <p>Copy right 2015 by Nhóm 9 Company</p>
        <p>Văn phòng tại Hà Nội</p>
        <p>Trụ sở: TC-206 Bách Khoa-Hà Nội</p>
        <p>Chi nhánh: 196 Lê Thanh Nghị-Hai Bà Trưng-Hà Nội</p>
    </div>
</body>

</html>