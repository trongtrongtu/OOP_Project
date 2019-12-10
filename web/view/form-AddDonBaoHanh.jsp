<%@page import="model.Employees"%>
<%@ page import="java.util.List" %>

<%@ page import="model.Product" %>
<%@ page import="services.ProductService" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="services.CustomerService" %>
<%@ page import="model.Customer" %>
<%@ page import="services.*" %>
<%@page import="services.EmployeesService" %>
<%@ page import="model.Device" %><%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/7/2019
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Add Don Bao Hanh</title>
        <link rel="stylesheet" href="view/css/style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="view/css/form.css">
    </head>
    <body>
        <%@include file="header.jsp" %>

        <!--form add DBH -->
        <div class="container">
            <h2 style="color: red; margin-left: 200px;">${error}</h2>
            <form action="${pageContext.request.contextPath}/donbh-add"  method="POST">
                <h3>Nhập thông tin đơn hàng.</h3>
                <div class="row">
                    <div class="col-25">
                        <label for="maDH">Mã đơn :</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="maDH" name="maDH" placeholder="123" readonly>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="imei">Imei thiết bị :</label>
                    </div>
                    <div class="col-75">
                        <div class="form-group">
                            <select required class="form-control" name="imei" id="imei">


                                <%
                                    ProductService productService = new ProductService();
                                    try {
                                        List<Product> products = productService.getAllProduct();
                                        String name = "Chon san pham";
                                        String value = null;
                                        if (request.getParameter("imei") != null) {
                                            name = request.getParameter("imei");
                                            value = name;
                                        }
                                %>
                                <option value=""><%=name%>.</option>
                                <%
                                    for (Product product : products) {
                                %>
                                <option value="<%=product.getImei()%>"><%=product.getImei()%>
                                </option>

                                <%
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="maKH">khách hàng :</label>
                    </div>
                    <div class="col-75">
                        <div class="form-group">
                            <select required class="form-control" name="maKH" id="maKH">
                                <%
                                    CustomerService customerService = new CustomerService();
                                    String name = "Chon ten khach hang.";
                                    String value = null;
                                    if (request.getParameter("maKH") != null) {
                                        name = request.getParameter("maKH");
                                        value = name;   
                                    }
                                    try {
                                        List<Customer> customerList = customerService.getAllCustomer();
                                %>
                                <option selected value=""><%=name%></option>
                                <%
                                    for (Customer customer : customerList) {
                                %>

                                <option value="<%=customer.getMaKH()%>"><%=customer.getTenKH()%>-<%=customer.getDienThoai()%></option>

                                <%
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="maLK">Tên linh kiện thay thế :</label>
                    </div>
                    <div class="col-75">
                        <div class="form-group">
                            <select required class="form-control" name="maLK" id="maLK">
                                <option selected>Chọn linh kiện sữa chữa</option>
                                <%
                                    DeviceService deviceService = new DeviceService();
                                    List<Device> devices = deviceService.getAllDevice();
                                    for (Device device : devices) {
                                %>
                                <option value="<%=device.getMaLK()%>"><%=device.getTenLK()%>-<%=device.getNxs()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="giaDon">Báo giá :</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="giaDon" name="giaDon" placeholder="Báo giá." required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="maNV"> nhân viên :</label>
                    </div>
                    <div class="col-75">
                        <div class="form-group">
                            <select required class="form-control" name="maNV" id="maNV">
                                <option selected>Chọn nhân viên</option>
                                <%
                                    EmployeesService employeesService = new EmployeesService();
                                    List<Employees> employees = employeesService.getAllEmployees();
                                    for (Employees employee : employees) {
                                %>
                                <option value="<%=employee.getMaNV()%>"><%=employee.getTenNV()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="trangThai">Trạng thái:</label>
                    </div>
                    <div class="col-75">
                        <div class="form-group">
                            <select required class="form-control" name="trangThai" id="trangThai">
                                <option selected value=""></option>
                                <option value="xong">xong</option>
                                <option value="dangSua">Đang sửa</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-25">
                    <label for="moTaBenh">Mô tả bệnh</label>
                </div>
                <div class="col-75">
                    <textarea id="subject" id="moTaBenh" name="moTaBenh" placeholder="Mô tả bệnh.."
                              style="height:200px" required></textarea>
                </div>

                <div class="row">
                    <input type="submit" value="Submit">
                </div>


            </form>
        </div>

        <%@include file="footer.jsp" %>
    </body>
</html>