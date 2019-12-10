/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Device;
import model.DonBh;
import model.Employees;
import model.Product;
import services.CustomerService;
import services.DeviceService;
import services.DonBhService;
import services.EmployeesService;
import services.ProductService;

/**
 *
 * @author DELL LATITUDE
 */
@WebServlet(name = "DonBhSearch", urlPatterns = "donbh-search")
public class DonBhSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String imei = request.getParameter("search-by-imei");
        DonBh don = new DonBh();
        don = new DonBhService().searchByImei(imei);
        try {
            Customer customer = new CustomerService().searchByMaKH(don.getMaKH());
            Employees employee = new EmployeesService().searchByMaNV(don.getMaNV());
            Product product = new ProductService().searchByImei(don.getImei());
            request.setAttribute("customer", customer);
            request.setAttribute("employee", employee);
            request.setAttribute("product", product);
        } catch (SQLException ex) {
                       //Logger.getLogger(DonBhSearch.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect(request.getContextPath()+"/donbh-list");
        }
        Device device = new DeviceService().find(don.getMaLK());
        request.setAttribute("device", device);
        request.setAttribute("searching_result", don);
        request.getRequestDispatcher("view/donbh_searchByImei.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
