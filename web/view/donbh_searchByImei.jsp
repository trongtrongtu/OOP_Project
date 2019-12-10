<%@page import="services.EmployeesService"%>
<%@page import="model.Employees"%>
<%@page import="services.ProductService"%>
<%@page import="model.Product"%>
<%@page import="services.CustomerService"%>
<%@page import="model.Customer"%>
<%@page import="services.DonBhService"%>
<%@page import="model.DonBh"%>
<%@page import="services.DeviceService"%>
<%@page import="services.DeviceService"%>
<%@page import="model.Device"%>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Home</title>

        <link rel="stylesheet" href="view/css/style.css">
    </head>
    <body>

        <!--Banner-->
        <div class="banner">
            <div class="img_banner"><img src="img/logo.png" alt=""></div>
            <div class="text_banner"><h2>QU?N LÝ B?O HÀNH</h2></div>
        </div>

        <!--Menu-->
        <div class="menu">
            <ul>
                <li>
                    <a href="#">TRANG CH?</a>
                </li>
                <li>
                    <a href="#">S?N PH?M </a>
                </li>
                <li>
                    <a href="#">KHÁCH HÀNG</a>
                </li>
                <li>
                    <a href="#">LINH KI?N</a>
                </li>
                <li>
                    <a href="#">NHÂN VIÊN</a>
                </li>
                <li>
                    <a href="#">TH?NG KÊ</a>
                </li>
            </ul>
        </div>
        <!--Search by imei -->
        <div class="search">
            <div class="search_text">
                <p>Search by imei</p>
            </div>
            <div class="container">
                <form action="donbh-search" method="get">
                    <input type="search" class="search_input" name="search-by-imei" placeholder="Search...">
                    <input type="submit" class="submit" value="Search">
                </form>
            </div>
        </div>
        <!--Content-->
        <div class="content">
            <style>
                table {
                    border-collapse: collapse;
                    border-spacing: 0;
                    width: 100%;
                    border: 1px solid #ddd;
                }

                th, td {
                    text-align: center;
                    padding: 8px;
                }

                tr:nth-child(even){background-color: #f2f2f2}
            </style>
            <div style="overflow-x:auto;">
                <table>
                    <tr>
                        <th>MÃ B?O HÀNH</th>
                        <th>MÃ S?N PH?M</th>
                        <th>TÊN S?N PH?M</th>
                        <th>KHÁCH HÀNG</th>
                        <th>?I?N THO?I</th>
                        <th>L?I</th>
                        <th>LINH KIEN THAY THE</th>
                        <th>BÁO GIÁ</th>
                        <th>KTV</th>
                        <th>TÌNH TR?NG B?O HÀNH</th>
                        <th>NGÀY T?O ??N</th>
                    </tr>
                    <tr>
                        <td>${searching_result.getMaDon()}</td>
                        <td>${searching_result.imei}</td>
                        <td>${product.tenSP}</td>
                        <td>${customer.tenKH}</td>
                        <td>${customer.dienThoai}</td>
                        <td>${searching_result.loi}</td>
                        <td>${device.tenLK}</td>
                        <td>${searching_result.giaDon}</td>
                        <td>${employee.tenNV}</td>
                        <td>${searching_result.trangThai}</td>
                        <td>${searching_result.date}</td>
                        <td><a href="<c:url value="donbh-edit?${searching_result.maDon}"/>">S?a</a></td>
                        <td><a href="<c:url value="donbh-delete?${searching_result.maDon}"/>">Xóa</a></td>
                    </tr>
                </table>

                <div class="content_themSP" style="margin: auto;padding-left: 400px; ">
                    <button style="margin: auto;">
                        <a href="/donbh-add">Tao DON BAO HANH moi</a>
                    </button>
                </div>
            </div>

        </div>

        <!--Footer-->
        <div class="footer">
            <p>Copy right 2019 by Nhóm 9 Company</p>
            <p>V?n phòng t?i Hà N?i</p>
            <p>Tr? s?: TC-206 Bách Khoa-Hà N?i</p>
            <p>Chi nhánh: 196 Lê Thanh Ngh?-Hai Bà Tr?ng-Hà N?i</p>
        </div>


    </body>
</html>