<%-- 
    Document   : linh-kien
    Created on : Dec 6, 2019, 11:35:36 AM
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
    <title>Linh Kiện</title>
    <link rel="stylesheet" href="view/css/style.css">
</head>

<body>
    <!--Banner-->
    <div class="banner">
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
    <!--Search by TENLK -->
    <div class="search">
        <div class="search_text">
            <p>Search by TÊN LK</p>
        </div>
        <div class="container">
            <form action="search-device" >
            <input type="search" class="search_input" name="search-by-TenLK" placeholder="Search...">
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

        th,
        td {
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
                <th>MÃ LK</th>
                <th>TÊN LK</th>
                <th>NSX</th>
                <th>GIÁ LK</th>

            </tr>
            <c:forEach var="device" items="${listdevices}" >
                <tr>
                    <td>${device.getMaLK()}</td>
                    <td>${device.getTenLK()}</td>
                    <td>${device.getNsx()}</td>
                    <td>${device.getGiaLK()}</td>
                    <td><a href="<c:url value="edit-device?${device.maLK}"/>">Sửa</a></td>
                    <td><a href="<c:url value="delete-device?${device.maLK}"/>" >Xóa</a></td>
                </tr>   
            </c:forEach>
        </table>
                
                
        <div class="content_themLK" style="margin: auto;padding-left: 400px; ">
            <button style="margin: auto;">
                <a href="add-device">Thêm Linh Kiện</a>
            </button>
        </div>
    </div>

    <!--fOOTER-->
     <!--Footer-->
     <div class="footer">
        <p>Copy right 2015 by Nhóm 9 Company</p>
        <p>Văn phòng tại Hà Nội</p>
        <p>Trụ sở: TC-206 Bách Khoa-Hà Nội</p>
        <p>Chi nhánh: 196 Lê Thanh Nghị-Hai Bà Trưng-Hà Nội</p>
    </div>
</body>

</html>