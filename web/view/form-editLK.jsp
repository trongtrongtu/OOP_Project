<%-- 
    Document   : form-editLK
    Created on : Dec 8, 2019, 9:40:43 AM
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
    <title>Form Chỉnh Sửa Linh Kiện</title>
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
                <a href="nhan-vien.html">NHÂN VIÊN</a>
            </li>
            <li>
                <a href="thong-ke.html">THỐNG KÊ</a>
            </li>
        </ul>
    </div>
    <!--Form Chỉnh Sửa Linh Kiện-->
    <div class="container">
        
        <form action="edit-device" method="post">
            <input name="MALK" value="${MALK}" hidden="">
            <h3>Chỉnh Sửa Thông Tin Linh Kiện có Mã là ${MALK} </h3>
            <div class="row">
                <div class="col-25">
                    <label for="TENLK">Tên linh kiện :</label>
                </div>
                <div class="col-75">
                    <input type="text" id="TENLK" name="TENLK" value="" placeholder="Tên linh kiện..">
                </div>
            </div>

            <div class="row">
                <div class="col-25">
                    <label for="NSX">Nhà sản xuất :</label>
                </div>
                <div class="col-75">
                    <input type="text" id="NSX" name="NSX" value="" placeholder="Nhà sản xuất..">
                </div>
            </div>

            <div class="row">
                <div class="col-25">
                    <label for="GIALK">Giá linh kiện :</label>
                </div>
                <div class="col-75">
                    <input type="text" id="GIALK" name="GIALK" value="" placeholder="Giá linh kiện..">
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