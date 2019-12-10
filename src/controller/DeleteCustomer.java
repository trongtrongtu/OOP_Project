package controller;

import services.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/delete-customer")
public class DeleteCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mesErr = null;
        String maKH = req.getParameter("maKH");
        CustomerService customerService = new CustomerService();
        try {
            customerService.deleteCustomer(maKH);
        } catch (SQLException e) {
            mesErr ="Đã có lỗi xảy ra, thực hiện lại";
            e.printStackTrace();
        }
        if (mesErr==null){
            req.setAttribute("mesErr","Xóa thành công");
        }else {
            req.setAttribute("mesErr",mesErr);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/khach-hang.jsp");
        dispatcher.forward(req,resp);
    }
}
