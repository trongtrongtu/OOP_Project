<%-- 
    Document   : nhan-vien
    Created on : Dec 8, 2019, 11:40:07 PM
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
    <title>Nhân Viên</title>
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
                <a href="list-employees">NHÂN VIÊN</a>
            </li>
            <li>
                <a href="thong-ke.html">THỐNG KÊ</a>
            </li>
        </ul>
    </div>
    <!--Search by imei -->
    <div class="search">
        <div class="search_text">
            <p>Search by Mã NV</p>
        </div>
        <div class="container">
            <form action="search-employees">
            <input type="search" class="search_input" name="search-by-MaNV" placeholder="Search...">
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
    <div style="overflow-x:auto;"></div>
        <table>
            <tr>
                <th>Mã NV</th>
                <th>TÊN NV</th>
                <th>SDT</th>
                <th>EMAIL</th>
                <th>ĐỊA CHỈ NV</th>
            </tr>
            <c:forEach var="employee" items="${listemployees}" >
                <tr>
                    <td>${employee.maNV}</td>
                    <td>${employee.tenNV}</td>
                    <td>${employee.sdt}</td>
                    <td>${employee.email}</td>
                    <td>${employee.dcNV}</td>
                    <td><a href="<c:url value="edit-employees?${employee.maNV}"/>">Sửa</a></td>
                    <td><a href="<c:url value="delete-employees?${employee.maNV}"/>" >Xóa</a></td>
                </tr>   
            </c:forEach>
        </table>
        <div class="content_themSP" style="margin: auto;padding-left: 400px; ">
            <button style="margin: auto;">
                <a href="add-employees">Thêm Nhân Viên</a>
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