package controller;

import model.Customer;
import services.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/edit-customer")
public class EditCustomer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // Lay thong tin khach hang tu req
        String mesErr =null;
        String tenKH = req.getParameter("TENKH");
        String dienThoai =req.getParameter("DIENTHOAI");
        String email = req.getParameter("EMAIL");
        String diaChi = req.getParameter("DIACHI");
        String maKH = req.getParameter("MAKH");
        Customer customer = new Customer(Integer.parseInt(maKH),tenKH,dienThoai,email,diaChi);
        CustomerService customerService = new CustomerService();
        try {
            customerService.editCustomer(customer);
        } catch (SQLException e) {
            mesErr="Đã xảy ra lỗi, hãy thực hiện lại";
            e.printStackTrace();
        }
        if (mesErr==null){
            req.setAttribute("mesErr","Chỉnh sửa thành công.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/khach-hang.jsp");
            dispatcher.forward(req,resp);
        }else {
            req.setAttribute("mesErr",mesErr);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/from-editKH.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
