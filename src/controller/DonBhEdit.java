/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import services.*;

/**
 *
 * @author dtl
 */
@WebServlet(name = "DonBhEdit", urlPatterns = "/donbh-edit")
public class DonBhEdit extends HttpServlet {

    DonBhService dao = new DonBhService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int maDon = Integer.parseInt(request.getQueryString());
        DonBh don = dao.get(maDon);
        try {
            Customer customer = new CustomerService().searchByMaKH(don.getMaKH());
            request.setAttribute("customer", customer);
            Employees employee = new EmployeesService().searchByMaNV(don.getMaNV());
            request.setAttribute("employee", employee);
        } catch (SQLException ex) {
            //Logger.getLogger(DonBhEdit.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect(request.getContextPath()+"/donbh-list");
        }
        Device device = new DeviceService().find(don.getMaLK());
        request.setAttribute("device", device);
        request.setAttribute("don", don);
        request.getRequestDispatcher("view/form-editDonBaoHanh.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DonBh don = new DonBh();
        String error = null;
        don.setMaDon(Integer.parseInt(request.getParameter("maDon")));
        don.setImei(request.getParameter("imei"));
        don.setGiaDon(Integer.parseInt(request.getParameter("giaDon")));
        don.setLoi(request.getParameter("moTaBenh"));
        don.setMaLK(Integer.parseInt(request.getParameter("maLK")));
        don.setMaNV(Integer.parseInt(request.getParameter("maNV")));
        don.setMaKH(Integer.parseInt(request.getParameter("maKH")));
        don.setTrangThai(request.getParameter("trangThai"));
        dao.edit(don);
        response.sendRedirect(request.getContextPath() + "/donbh-list"); // quay lai trang danh sach don bao hanh
        System.out.println("controller.DonBhEdit.doPost()");
        System.out.println("ma don " + request.getParameter("maDon"));
        System.out.println("imei " + request.getParameter("imei"));
        System.out.println("maLK " + request.getParameter("maLK"));
        System.out.println(request.getParameter("maKH"));
        System.out.println(request.getParameter("maNV"));

    }

}
