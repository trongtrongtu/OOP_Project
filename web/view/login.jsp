<%-- 
    Document   : login.jsp
    Created on : Dec 10, 2019, 2:47:52 AM
    Author     : Tu Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/form.css">
        <title>Đăng nhập</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            String error = "";
            if (request.getAttribute("error") != null) {
                error = (String) request.getAttribute("error");
            }
        %>


        <div class="container">
            <div class="row">
                <div class="col-md-6 center-block">
                    <form action="LoginServlet" method="post" class="billing-details">
                        <div style="text-align: center;">
                            <h1>Đăng Nhập</h1>
                        </div>

                        <div style="color: red; margin-left: 200px;"><%=error%></div>  


                        <div class="row">   
                            <div class="col-25">
                                <label for="TENTK">Tên Tài Khoản :</label>
                            </div>
                            <div class="col-75">
                                <input type="text" name="username" placeholder="Tên đăng nhập..">
                            </div>
                        </div>                 
                        <div class="row">          
                            <div class="col-25">
                                <label for="MatKhau">Mật Khẩu :</label>
                            </div>
                            <div class="col-75">
                                <input type="password" name="password" placeholder="Mật khẩu.." class="input" >
                            </div>
                        </div>

                        <div class="row">
                            <button type="submit" value="Đăng nhập">ĐĂNG NHẬP</button>
                        </div>
                    </form>

                </div>

            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
