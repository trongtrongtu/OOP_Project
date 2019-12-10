
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Device;
import services.DeviceService;

@WebServlet(name = "SearchDeviceByTenLKServlet" , urlPatterns = "/search-device")
public class SearchDeviceByTenLKServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String tenLK = req.getParameter("search-by-TenLK");
        DeviceService deviceService = new DeviceService();
        //dùng chung form view xem all list-device
        List<Device> list1 = deviceService.searchDevice(tenLK);
        
        req.setAttribute("listdevices", list1);
        req.getRequestDispatcher("view/linh-kien.jsp").forward(req,resp);
       
    }

}
