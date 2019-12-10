<%@page import="model.Employees"%>
<%@ page import="services.DonBhService" %>
<%@ page import="model.DonBh" %>
<%@ page import="services.*" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Device" %><%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/7/2019
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Update Status</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Add Customer</title>
        <link rel="stylesheet" href="view/css/style.css">
        <link rel="stylesheet" href="view/css/form.css">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <!--Form update status -->
        <div class="container">
            <h2 style="color: red; margin-left: 200px;">${mesErr}</h2>
            <form action="${pageContext.request.contextPath}/donbh-edit" method="POST">
                <h3>Thông tin đơn hàng.</h3>
                <div class="row">
                    <div class="col-25">
                        <label for="maDon">Mã đơn :</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="maDon" name="maDon" value="${don.maDon}" readonly>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="imei">Imei thiết bị :</label>
                    </div>
                    <div class="col-75">
                        <div class="form-group">
                            <input type="text" id="imei" name="imei" value="${don.imei}" placeholder="${don.imei}" readonly >
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="maKH">khách hàng :</label>
                    </div>
                    <div class="col-75">
                        <div class="form-group">
                            <input type="hidden" id="maKH" name="maKH" value="${don.maKH}">
                            <input type="text" value="${customer.tenKH}" readonly>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="maLK">Tên linh kiện thay thế :</label>
                    </div>
                    <div class="col-75">
                        <div class="form-group">
                            <select class="form-control" name="maLK" id="maLK">
                                <option selected value="${don.maLK}">${device.tenLK}-${device.nxs}</option>
                                <%
                                    DeviceService dvS = new DeviceService();
                                    List<Device> devices = dvS.getAllDevice();
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
                        <input  type="text" id="giaDon" name="giaDon" placeholder="Báo giá." required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="maNV"> nhân viên :</label>
                    </div>
                    <div class="col-75">
                        <div class="form-group">
                            <select class="form-control" name="maNV" id="maNV">
                                <option selected value="${don.maNV}">${employee.tenNV}</option>
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
                            <select required class="form-control" name="trangThai" id="trangThai" >
                                <option selected value="${don.trangThai}"></option>
                                <option value="xong" >xong</option>
                                <option value="dangSua">Đang sửa</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-25">
                    <label for="moTaBenh">Mô tả bệnh</label>
                </div>
                <div class="col-75">
                    <textarea id="subject" id="moTaBenh" name="moTaBenh" style="height:200px" required>${don.loi}</textarea>
                </div>

                <div class="row">
                    <input type="submit" value="Submit">
                </div>


            </form>
        </div>

        <%@include file="footer.jsp"%>
    </body>
</html>