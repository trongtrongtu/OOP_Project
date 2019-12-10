
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Device;
import services.DeviceService;

@WebServlet(name = "ListDeviceServlet" , urlPatterns = "/list-device")
public class ListDeviceServlet extends HttpServlet {

    DeviceService deviceService = new DeviceService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Device> list = deviceService.getAllDevice();
        req.setAttribute("listdevices", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/linh-kien.jsp");
	dispatcher.forward(req, resp);
    }
    

}
