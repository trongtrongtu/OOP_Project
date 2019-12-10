/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Device;
import model.DonBh;
import model.Product;
import model.*;
import services.*;

/**
 *
 * @author dtl
 */
@WebServlet(name = "DonBhAdd", urlPatterns = "donbh-add")
public class DonBhAdd extends HttpServlet {

    DonBhService dao = new DonBhService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/form-AddDonBaoHanh.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DonBh don = new DonBh();
        String error = null;
        String imei = request.getParameter("imei");
        String giaDon = request.getParameter("giaDon");
        String moTaBenh = request.getParameter("moTaBenh");
        String maLK = request.getParameter("maLK");
        String maNV = request.getParameter("maNV");
        String maKH = request.getParameter("maKH");
        String trangThai = request.getParameter("trangThai");

        don.setImei(imei);
        don.setGiaDon(Integer.parseInt(giaDon));
        don.setLoi(moTaBenh);
        don.setMaLK(Integer.parseInt(maLK));
        don.setMaNV(Integer.parseInt(maNV));
        don.setMaKH(Integer.parseInt(maKH));
        don.setTrangThai(trangThai);
        dao.insert(don);
        response.sendRedirect(request.getContextPath() + "/donbh-list"); // quay lai trang danh sach don bao hanh
//        DonBh don = new DonBh();
//        don.setImei("1");
//        don.setMaKH(2);
//        don.setMaLK(2);
//        don.setGiaDon(200);
//        don.setLoi("hong man");
//        don.setTrangThai("dang sua");
//        don.setMaNV(1);
//        dao.insert(don);
//        response.sendRedirect(request.getContextPath() + "/donbh-list");
    }
}
