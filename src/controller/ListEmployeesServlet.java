
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.Employees;
import services.EmployeesService;

@WebServlet(name = "ListEmployeesServlet" , urlPatterns = "/list-employees")
public class ListEmployeesServlet extends HttpServlet {

    EmployeesService employeesService = new EmployeesService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        try {
            List<Employees> list = employeesService.getAllEmployees();
            req.setAttribute("listemployees", list);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/nhan-vien.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(ListEmployeesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
