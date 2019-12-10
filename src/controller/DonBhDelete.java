/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.DonBhService;

/**
 *
 * @author dtl
 */
@WebServlet(name = "DonBhDelete", urlPatterns = "/donbh-delete")
public class DonBhDelete extends HttpServlet {
    DonBhService dao = new DonBhService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    int maDon =Integer.parseInt(request.getQueryString()) ;
        dao.delete(maDon);
        response.sendRedirect(request.getContextPath() + "/donbh-list"); // Xoa xong quay lai trang danh sach don bao hanh
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
