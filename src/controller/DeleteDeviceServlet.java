
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.DeviceService;

@WebServlet(name = "DeleteDeviceServlet" , urlPatterns = "/delete-device")
public class DeleteDeviceServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String maLK = req.getQueryString();
        DeviceService deviceService = new DeviceService();
        deviceService.deleteDevice(Integer.parseInt(maLK));
        
        resp.sendRedirect(req.getContextPath()+"/list-device");
    }

}
